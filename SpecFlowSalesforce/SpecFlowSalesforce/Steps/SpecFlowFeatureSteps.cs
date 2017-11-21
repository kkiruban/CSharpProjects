using Selenium_SpecFlow.Support;
using System;
using TechTalk.SpecFlow;
using NUnit.Framework;


namespace SpecFlowSalesforce.Steps
{
    [Binding]
    public class SpecFlowFeatureSteps : SeleniumStepsBase
	{

		[Given(@"I should navigate to salesforce application")]
		public void GivenIShouldNavigateToSalesforceApplication()
		{
			selenium.NavigateTo(String.Empty);
		}


		[When(@"I fill ""(.*)"" as ""(.*)""")]
        public void WhenIFillAs(string field, string value)
        {
			selenium.Manage().Window.Maximize();
			selenium.SetTextBoxValue(field,value);
			selenium.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(20);
		}
        
        [When(@"I click on submit button")]
        public void WhenIClickOnSubmitButton()
        {
			selenium.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(20);
			selenium.ClickButton("Login");
			selenium.Manage().Timeouts().ImplicitWait = TimeSpan.FromSeconds(40);

		}
        
        [Then(@"I should see salesforce home page successfully")]
        public void ThenIShouldSeeSalesforceHomePageSuccessfully()
        {
			String currenturl=selenium.Url;
			Console.WriteLine(currenturl);
			String currenttitle = selenium.Title;
			Console.WriteLine(currenttitle);
			if (currenttitle.Equals("Login | Salesforce")){
				Console.WriteLine("title is matched");
			} else{
				Console.WriteLine("title is not matched");
			}
		}
    }
}
