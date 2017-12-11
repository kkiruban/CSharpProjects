When(/^I click on quote icon in dashboard page$/) do
  find(:xpath,"//span[@class='edit-image align-middle']").click
  sleep 20
end

When(/^I click on any existing quote link under draft quotes section$/) do
  find(:xpath,"//*[@id='Name0myquotestbl']/div/div/p/*").click
  sleep 20
end

When(/^I click copy button in edit quote page$/) do
  find(:xpath,".//button[@class='copy-image']").click
  sleep 20
end

When(/^I click on cancel button in edit quote page$/) do
  click_on "Cancel"
  sleep 20
end

When(/^I click on "([^"]*)" button in edit quote page$/) do |button_name|
  click_on button_name
  sleep 20
end

Then(/^I should see copy button in edit quote page$/) do
  if page.has_xpath?("//button[@class='copy-image']")
    puts "copy button in edit quote page is visible"
  else
    writeFailure "copy button in edit quote page is not visible"
  end
end

When(/^I click on submit button$/) do
  find(:xpath,"//button[@class='secondary-btn sub-header-submit-btn']").click
  sleep 20
end

When(/^I get the status for the respective draft quote$/) do
  status=find(:xpath,"//div[@class='rating-sort tomato-text']").value
  puts "#{status}"
end

When(/^I click on roll back button in edit quote page$/) do
  find(:xpath,"//button[@class='primary-invert-btn sub-header-cancel-btn']").click
  sleep 10
end

When(/^I click on YES button to roll back changes$/) do
  click_on "Yes"
  sleep 10
end

Then(/^I click on NO button to roll back changes$/) do
  click_on "No"
  sleep 10
end


Then(/^I click on NO button to carry over unsaved changes$/) do
  click_on "No"
  sleep 10
end

Then(/^I click on YES button to carry over unsaved changes$/) do
  click_on "Yes"
  sleep 10
end

Then(/^I should see form disabled$/) do
  element = page.find(:xpath,"//div[@class='rating-sort tomato-text']")
  page.driver.browser.mouse.double_click(element.native)
  if page.has_xpath?("//div[contains(text(),'Form is Disabled')]")
    puts "all fields are read only permission"
  else
    writeFailure "all fields with read and write permission"
  end
end

When(/^I change the address street two$/) do
  $randomstreetno= "street" + Random.new.rand(0001..10000).to_s
  puts $randomstreetno
  fill_in('md-input-4', :with => $randomstreetno)
  sleep 10
end

When(/^I change the address street two and click on save button$/) do
  $randomstreetno= "street" + Random.new.rand(0001..10000).to_s
  puts $randomstreetno
  fill_in('md-input-4', :with => $randomstreetno)
  sleep 10
  find(:xpath,"//button[@class='save-image']").click
  sleep 20
end

When(/^I get address street two from the current page$/) do
  changedaddress=find(:xpath,".//*[@id='md-input-4']").value
  puts "#{changedaddress} address changed successfully"
end

When(/^I click on quote icon$/) do
  find(:xpath,"//span[@class='edit-image align-middle']").click
  sleep 20
end

Then(/^I should see all the Quotes in the Quote grid view$/) do
  if page.has_xpath?(".//*[@id='tablebodymyquotestbl']")
    puts "all the Quotes in the Quote grid view is visible"
  else
    writeFailure "all the Quotes in the Quote grid view is not visible"
  end
end


When(/^I select quote info details and click on next button$/) do
  click_on "Next"
  sleep 20
end

When(/^I select the price list from the displayed list and click on submit$/) do
  find(:xpath,".//*[@id='tablebodylkp_PriceLists_PricelistLookUp_PriceList__grid']/ng2-md-datatable-row[1]//label/div").click
  sleep 20
  click_on "Submit"
  sleep 40
end

When(/^I should get message from the current page$/) do
  quotemessage=find(:xpath,"//*[@id='message']/div/div[3]").text
  puts quotemessage

  if quotemessage == "Failed to create Quote."
    puts "failed to create quote"
  else
    puts "quote created successfully"
  end
end

Then(/^I should see "([^"]*)"$/) do |content|
  if page.has_content? content
    puts "#{content} content is present"
  else
    writeFailure "#{content} content is not visible"
  end
end


When(/^I click on ok button$/) do
  click_on "OK"
  sleep 10
end


Then(/^I should see rollback button in edit quote page$/) do
  if page.has_xpath?("//button[@class='primary-invert-btn sub-header-cancel-btn']")
    puts "rollback button in edit quote page is visible"
  else
    writeFailure "rollback button in edit quote page is not visible"
  end
end

Then(/^I should see re\-compute icon in edit quote page$/) do
  if page.has_xpath?("//button[@class='calculator-image']")
    puts "re\-compute icon in edit quote page is visible"
  else
    writeFailure "re\-compute icon in edit quote page is not visible"
  end
end

When(/^I click on re\-compute icon button in edit quote page$/) do
  find(:xpath,"//button[@class='calculator-image']").click
  sleep 20
end

Then(/^I should see show exceptions icon button in edit quote page$/) do
  if page.has_xpath?("//button[@class='exclame-image exclame-image-red']")
    puts "show exceptions icon button in edit quote page is visible"
  else
    writeFailure "show exceptions icon button in edit quote page is not visible"
  end
end

When(/^I click on show exceptions icon button in edit quote page$/) do
  find(:xpath,"//button[@class='exclame-image exclame-image-red']").click
  sleep 20
end

When(/^I close window pop up$/) do
  find(:xpath,"//div[@class='dialog-close-image inline-block']").click
  sleep 10
end

Then(/^I should see Show logs icon button in edit quote page$/) do
  if page.has_xpath?("//button[@ng-reflect-message='Show Logs']")
    puts "Show logs icon button in edit quote page is visible"
  else
    writeFailure "Show logs icon button in edit quote page is not visible"
  end
end


When(/^I click on Show logs icon button in edit quote page$/) do
  find(:xpath,"//button[@ng-reflect-message='Show Logs']").click
  sleep 20
end

Then(/^I should see Refresh icon button in edit quote page$/) do
  if page.has_xpath?("//button[@class='refresh-image']")
    puts "Refresh icon button in edit quote page is visible"
  else
    writeFailure "Refresh icon button in edit quote page is not visible"
  end
end

When(/^I click on Refresh icon button in edit quote page$/) do
    find(:xpath,"//button[@ng-reflect-message='Refresh']",match: :first).click
    sleep 10
end
