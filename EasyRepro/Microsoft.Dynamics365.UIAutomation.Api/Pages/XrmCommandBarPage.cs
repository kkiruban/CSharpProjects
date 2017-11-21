﻿// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT license.

using Microsoft.Dynamics365.UIAutomation.Browser;
using OpenQA.Selenium;
using System;
using System.Collections.ObjectModel;
using System.Linq;

namespace Microsoft.Dynamics365.UIAutomation.Api
{
    public class XrmCommandBarItem
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public string Title { get; set; }
    }

    /// <summary>
    /// Command bar page.
    /// </summary>
    public class XrmCommandBarPage : XrmPage
    {
        /// <summary>
        /// Initializes a new instance of the <see cref="XrmCommandBarPage"/> class.
        /// </summary>
        /// <param name="browser">The browser.</param>
        public XrmCommandBarPage(InteractiveBrowser browser)
            : base(browser)
        {
            SwitchToDefault();
        }


        /// <summary>
        /// Gets the Commands
        /// </summary>
        /// <param name="moreCommands">The MoreCommands</param>
        /// <example></example>
        private BrowserCommandResult<ReadOnlyCollection<IWebElement>> GetCommands(bool moreCommands = false)
        {
            return this.Execute("Get Command Bar Buttons", driver =>
            {
                driver.WaitUntilAvailable(By.XPath(Elements.Xpath[Reference.CommandBar.RibbonManager]),new TimeSpan(0,0,5));

                IWebElement ribbon = null;
                if (moreCommands)
                    ribbon = driver.FindElement(By.XPath(Elements.Xpath[Reference.CommandBar.List]));
                else
                    ribbon = driver.FindElement(By.XPath(Elements.Xpath[Reference.CommandBar.RibbonManager]));

                var items = ribbon.FindElements(By.TagName("span"));

                return items;//.Where(item => item.Text.Length > 0).ToDictionary(item => item.Text, item => item.GetAttribute("id"));
            });
        }

        /// <summary>
        /// Clicks the  Command
        /// </summary>
        /// <param name="name">The Name of the command</param>
        /// <param name="subName">The SubName</param>
        /// <param name="moreCommands">The MoreCommands</param>
        /// <param name="thinkTime">Used to simulate a wait time between human interactions. The Default is 2 seconds.</param>
        /// <example>xrmBrowser.CommandBar.ClickCommand("New");</example>
        public BrowserCommandResult<bool> ClickCommand(string name, string subName = "", bool moreCommands = false, int thinkTime = Constants.DefaultThinkTime)
        {
            Browser.ThinkTime(thinkTime);

            return this.Execute(GetOptions("Click Command"), driver => 
            {
                if (moreCommands)
                    driver.ClickWhenAvailable(By.XPath(Elements.Xpath[Reference.CommandBar.MoreCommands]));

                var buttons = GetCommands(moreCommands).Value;
                var button = buttons.FirstOrDefault(x => x.Text.ToLowerString() == name.ToLowerString());

                if (string.IsNullOrEmpty(subName))
                {
                    if (button != null)
                    {
                        button.Click();
                    }
                    else
                    {
                        throw new InvalidOperationException($"No command with the name '{name}' exists inside of Commandbar.");
                    }
                }
                    
                else
                {

                    button.FindElement(By.ClassName(Elements.CssClass[Reference.CommandBar.FlyoutAnchorArrow])).Click();

                    var subButtons = driver.FindElements(By.ClassName("ms-crm-Menu-Label"));
                    var item = subButtons.FirstOrDefault(x => x.Text.ToLowerString() == subName.ToLowerString());
                    if(item == null) { throw new InvalidOperationException($"The sub menu item '{subName}' is not found."); }

                    item.Click();
                }
                
                driver.WaitForPageToLoad();
                 return true;
            });
        }      
    }
}
