
When(/^I search "([^"]*)" contract in a search box$/) do |value|
  find(:xpath,"//md-card[@id='cardmycontractstbl']//*[@class='search-box']").set(value)
  sleep 10
  find(:xpath,"//span[@class='search-image']").click
  sleep 100
end

When(/^I click on "([^"]*)" contract$/) do |value|
  click_on value
  sleep 30
end

When(/^I click on contract icon button in dashboard page$/) do
  sleep 25
  find(:xpath,"//span[@class='contractpageicon align-middle']").click
  sleep 25
end


Then(/^I should see list of existing contract under contract grid section$/) do
  if page.has_xpath?(".//*[@id='tablebodymycontractstbl']")
    puts "list of existing contract is visible under contract section"
  else
    writeFailure "list of existing contract is not visible under contract section"
  end
end

Then(/^I should see grid pagination in contract page$/) do
  "grid pagination in contract page is visible"
end

Then(/^I should see sort by name downdrop in contract page$/) do
  if page.has_xpath?("//span[@class='sorted-by']")
    puts "sort by name downdrop is visible "
  else
    writeFailure "sort by name downdrop is not visible"
  end
end

Then(/^I should see contract grid search option in contract page$/) do
  if page.has_xpath?("//input[@class='search-box']")
    puts "contract grid search option in contract page is visible "
  else
    writeFailure "contract grid search option in contract page is not visible"
  end
end
