describe('to test cpq response application', function() {
  it('login to application', function() {
    browser.get('https://responsecpq.positiveedge.net/Login.aspx');
	browser.driver.manage().window().maximize();
	browser.waitForAngular(); // If your test is outrunning the browser.
	browser.ignoreSynchronization = true; // If true, Protractor will not attempt to synchronize with the page before performing actions
	browser.sleep(10000); // if your test is outrunning the browser
	element(by.id('md-input-0')).isDisplayed()
	element(by.id('md-input-0')).sendKeys("salesonemanager@positiveedgedemo01.onmicrosoft.com");
	element(by.id('md-input-1')).isDisplayed()
	element(by.id('md-input-1')).sendKeys('pass@word1');
	browser.sleep(10000);
  });
});