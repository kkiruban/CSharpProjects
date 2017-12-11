Then(/^I should see total contracts count in Pipeline Chart Contracts$/) do
  if page.has_xpath?(".//div[@class='pipeline-section bg-1']")
    puts "total contracts count in Pipeline Chart Contracts is visible"
  else
    writeFailure "total contracts count in Pipeline Chart Contracts is not visible"
  end
end

Then(/^I should see total expired contracts count in Pipeline Chart Contracts$/) do
  if page.has_xpath?(".//div[@class='pipeline-section bg-3']")
    puts "total expired contracts count in Pipeline Chart Contracts is visible"
  else
    writeFailure "total expired contracts count in Pipeline Chart Contracts is not visible"
  end
end

Then(/^I should see list of recent opportunities in a grid$/) do
  if page.has_xpath?(".//*[@id='tablebodymyopportunitiestbl']")
    puts "list of recent opportunities in a grid is visible in a dashboard page under recent opportunity section"
  else
    writeFailure "list of recent opportunities in a grid is not visible in a dashboard page under recent opportunity section"
  end
end

Then(/^I should see list of recent contracts in a grid$/) do
 if page.has_xpath?("//*[@id='tablebodymycontractstbl']")
    puts "list of recent contracts in a grid is visible in a dashboard page under recent contracts section"
  else
    writeFailure "list of recent contracts in a grid is not visible in a dash board under recent contracts section"
  end
end

Then(/^I should see Pipeline Chart Contracts in a dashboard page$/) do
 if page.has_xpath?("//span[contains(.,'Pipeline Chart-Contracts')]")
    puts "Pipeline Chart Contracts is visible in a dashboard page under recent contracts section"
  else
    writeFailure "Pipeline Chart Contracts is not visible in a dash board under recent contracts section"
  end
end

Then(/^I should see Sorted by option under recent Contracts section$/) do
  if page.has_xpath?("//div[@class='md-select-trigger']")
    puts "Sorted by option under recent Contracts section is visible in a dashboard page"
  else
    writeFailure "Sorted by option under recent Contracts section is not visible in a dash board"
  end
end

Then(/^I should see search box under recent Contracts section$/) do
 if page.has_xpath?("//input[@class='search-box']")
    puts "search box under recent Contracts section is visible in a dashboard page "
  else
    writeFailure "search box under recent Contracts section is not visible in a dashboard page"
  end
end

Then(/^I should see contract page icon in dashboard page$/) do
 if page.has_xpath?("//span[@class='contractpageicon align-middle']")
    puts "contract page icon is visible in a dashboard page "
  else
    writeFailure "contract page icon is not visible in a dashboard page"
  end
end


When(/^I click account button in a dashboard page$/) do
  if page.has_xpath?("//button[@ng-reflect-message='Account']")
    find(:xpath,"//button[@ng-reflect-message='Account']").click
    sleep 20
  else
    writeFailure "account button is not visible in a dash board"
  end
end

When(/^I click on logout link in a dashboard page$/) do
  if page.has_xpath?("//a[contains(text(),'Logout')]")
    find(:xpath,"//a[contains(text(),'Logout')]").click
    sleep 20
  else
    writeFailure "logout button is not visible in a dash board"
  end
end

Then(/^I should see login form title$/) do
  if page.has_content?('LOG IN')
    puts "logout successfully"
  else
    writeFailure "logout button is not visible in a dash board"
  end
end


Then(/^I should see total Opportunities count in Pipeline Chart$/) do
  if page.has_xpath?("//div[@class='pipeline-section bg-1']")
    puts "total Opportunities count is visible in Pipeline Chart"
  else
    writeFailure "total Opportunities count is not visible in a Pipeline Chart"
  end
end

Then(/^I should see total unquoted count in Pipeline Chart$/) do
  if page.has_xpath?("//div[@class='pipeline-section bg-5']")
    puts "total unquoted count is visible in Pipeline Chart"
  else
    writeFailure "total unquoted count is not visible in a Pipeline Chart"
  end
end

Then(/^I should see total quoted count in Pipeline Chart$/) do
  if page.has_xpath?("//div[@class='pipeline-section bg-3']")
    puts "total quoted count is visible in Pipeline Chart"
  else
    writeFailure "total quoted count is not visible in a Pipeline Chart"
  end
end


Given(/^I should navigate to response CPQ application$/) do
  value = getCredentialInfo
  visit get_url
  sleep 30
  fill_in('md-input-0', :with => value["Username"])
  fill_in('md-input-1', :with => value["Password"])
  click_on 'Log In'
  sleep 30
end

Then(/^I should see Dashboard page succesfully$/) do
  title = page.driver.browser.title
  puts title
  if title == "Quotedge Portal"
    puts "succesfully landed on dashboard page"
  else
    writeFailure "Not landed on dashboard page"
  end
end

When(/^I click on plus icon in dashboard page$/) do
  find(:xpath,"//div[@class='plus-image']").click
  sleep 50
end

When(/^I select any one opportunity and click on next button$/) do
  find(:xpath,".//*[*[@id='name0lkp_Opportunities_OpportunityLookUp_Opportunity__grid']]/td[1]//label/div").click
  sleep 20
  click_on "Next"
  sleep 20
end

Then(/^I should see Performance Chart$/) do
  if page.has_xpath?(".//md-card[@class='radial-card relative']")
    puts "Performance Chart visible succesfully"
  else
    writeFailure "Performance Chart not visible succesfully"
  end
end

Then(/^I should see Pipeline Chart$/) do
  if page.has_xpath?(".//md-card[@class='pipeline-card relative']")
    puts "Performance Chart visible succesfully"
  else
    writeFailure "Performance Chart not visible succesfully"
  end
end


Then(/^I should see Current Month inside performace chart$/) do
  if page.has_content?('Current Month')
    puts "Current Month is visible inside performance chart"
  else
    writeFailure "Current Month is not visible inside performance chart"
  end
end

Then(/^I should see Last Month inside performace chart$/) do
  if page.has_content?('Last Month')
    puts "Last Month is visible inside performance chart"
  else
    writeFailure "Last Month is not visible inside performance chart"
  end
end

Then(/^I should see Current Year inside performace chart$/) do
  if page.has_content?('Current Year')
    puts "Current Year is visible inside performance chart"
  else
    writeFailure "Current Year is not visible inside performance chart"
  end
end

Then(/^I should see "([^"]*)" section header$/) do |header|
  if page.has_content?(header)
    puts "#{header} section is present"
  else
    writeFailure "#{header} section is not present"
  end
end

Then(/^I should see "([^"]*)" link in pending drafts section$/) do |link|
  if page.has_xpath?("//div[div[@class='m-b-10 clearfix']/span[text()='Pending Drafts']]/div/span[@class='view-all']")
    puts "#{link} link is visible"
  else
    writeFailure "#{link} link is not visible"
  end
end

Then(/^I should see "([^"]*)" link in Recent Quotes section$/) do |link|
  if page.has_xpath?("//div[div[@class='m-b-10 clearfix']/span[text()='Recent Quotes']]/div/span[@class='view-all']")
    puts "#{link} link is visible"
  else
    writeFailure "#{link} link is not visible"
  end
end

Then(/^I should see Sorted by option under recent opportunities section$/) do
  if page.has_xpath?("//div[div[*[contains(.,'Recent Opportunities')]]]/div[3]//span[@class='sorted-by']")
    puts "Sorted by option is visible"
  else
    writeFailure "Sorted by option is not visible"
  end
end


Then(/^I should see search box under recent opportunities section$/) do
  if page.has_xpath?("//md-card[@id='cardmyopportunitiestbl']//*[@class='search-box']")
    puts "search box is visible for recent oportunity section"
  else
    writeFailure "search box is not visible for recent oportunity section"
  end
end

Then(/^I should see opportunity bulb image in dashboard page$/) do
  if page.has_xpath?("//span[@class='bulb-image align-middle']")
    puts "opportunity bulb image is visible in dashboard page"
  else
    writeFailure "opportunity bulb image is not visible in dashboard page"
  end
end

Then(/^I should see contract page icon image in dashboard page$/) do
  if page.has_xpath?("//span[@class='contractpageicon align-middle']")
    puts "contract page icon image is visible in dashboard page"
  else
    writeFailure "contract page icon image is not visible in dashboard page"
  end
end

Then(/^I should see Quote image in dashboard page$/) do
  if page.has_xpath?(".//span[@class='edit-image align-middle']")
    puts "Quote image is visible in dashboard page"
  else
    writeFailure "Quote image is not visible in dashboard page"
  end
end

Then(/^I should see search box under my contracts section$/) do
  if page.has_xpath?(".//*[@id='cardmycontractstbl']//div//span/span[@class='search-bar table-search-bar relative']")
    puts "search box is visible under my contracts section"
  else
    writeFailure "search box is not visible under my contracts section"
  end
end
