using Selenium_SpecFlow.Support;
using Spec_Flow_Sample_Project_One.Utils;
using System;
using TechTalk.SpecFlow;
using TechTalk.SpecFlow.Assist;

namespace Spec_Flow_Sample_Project_One.Steps
{
    [Binding]
    public class CreateAccountSteps : SeleniumStepsBase
	{
        [When(@"I fill login form for salesforce application")]
        public void WhenIFillLoginFormForSalesforceApplication(Table table)
        {
			selenium.Manage().Window.Maximize();

			//With this, one can use the multiple Data sets for the same step.
			var credentials = table.CreateSet<Credentials>();
			foreach (var userData in credentials)
			{
			selenium.SetTextBoxValue("username", userData.Username);
			selenium.SetTextBoxValue("password", userData.Password);
			selenium.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(20));
			}
			//With this, multiple Data sets can not be used for the same step.
			//var credentials = table.CreateInstance<Credentials>();
			//selenium.SetTextBoxValue("username", credentials.Username);
			//selenium.SetTextBoxValue("password", credentials.Password);
			//selenium.Manage().Timeouts().ImplicitlyWait(TimeSpan.FromSeconds(20));
		}

		[When(@"I click on ""(.*)"" button")]
        public void WhenIClickOnButton(string field)
        {
			selenium.ClickButton(field);
		}
    }
}
