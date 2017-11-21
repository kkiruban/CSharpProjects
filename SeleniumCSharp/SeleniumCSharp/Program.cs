﻿using OpenQA.Selenium;
using OpenQA.Selenium.Chrome;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace SeleniumCSharp
{
	class Program
	{
		static void Main(string[] args)

		{
			IWebDriver driver = new ChromeDriver();
			driver.Navigate().GoToUrl("https://test.salesforce.com/");
			driver.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(30);
			driver.Close();

		}
	}
}
