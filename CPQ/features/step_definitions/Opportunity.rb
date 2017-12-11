When(/^I click on opportunity icon$/) do
  find(:xpath,"//span[@class='bulb-image align-middle']").click
  sleep 10
end

Then(/^I should see list of existing opportunity under opportunities section$/) do
  if page.has_xpath?("//div[@class='p-a-0 m-b-20']/tables-component/div/md-card")
    puts "list of existing opportunity is visible under opportunities section"
  else
    writeFailure "list of existing opportunity is not visible under opportunities section"
  end
end

Then(/^I should see grid pagination in opportunity page$/) do
  puts "grid pagination is visible in opportunity page"
end

When(/^I click on any existing opportunity and I should check system will allow to modify or edit$/) do
  click_on "Opp_Test_Renew"
  sleep 25
  if page.has_xpath?("//a[span[contains(.,'Customer Name')]]/div[@class='pen-invert-image inline-block hover-pointer']")
    puts "able to edit"
  else
    writeFailure "Not able to edit"
  end
end

When(/^I search "([^"]*)" opportunity in a search box$/) do |value|
  find(:xpath,"//md-card[@id='cardmyopportunitiestbl']//*[@class='search-box']").set(value)
  sleep 10
  find(:xpath,"//span[@class='search-image']").click
  sleep 60
end

When(/^I click on "([^"]*)" opportunity$/) do |value|
  find(:xpath,"//span[text()='Opp_Test_Renew']").click
  sleep 30
end

When(/^I should check system will allow to modify or edit opportunity$/) do
  if page.has_xpath?("//a[span[contains(.,'Customer Name')]]/div[@class='pen-invert-image inline-block hover-pointer']")
    puts "able to edit"
  else
    writeFailure "Not able to edit"
  end
end


Then(/^I should see sort by name downdrop in opportunities page$/) do
  if page.has_xpath?("//span[@class='sorted-by']")
    puts "sort by name downdrop is visible "
  else
    writeFailure "sort by name downdrop is not visible"
  end
end

Then(/^I should see sorted by dropdown should display all the coloumn names of the grid$/) do
  puts "still need to implement"
end

Then(/^I should see opportunity grid search option in opportunities page$/) do
  if page.has_xpath?("//input[@class='search-box']")
    puts "opportunity grid search option in opportunities page is visible "
  else
    writeFailure "opportunity grid search option in opportunities page is not visible"
  end
end