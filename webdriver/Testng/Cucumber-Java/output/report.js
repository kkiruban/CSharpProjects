$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("StepDefinition/dailyroutine.feature");
formatter.feature({
  "line": 1,
  "name": "Life of king",
  "description": "In order to go office\r\nAs a working guy\r\nI want to wish people",
  "id": "life-of-king",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 7,
  "name": "Test Case one",
  "description": "",
  "id": "life-of-king;test-case-one",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 6,
      "name": "@tester"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "I should navigate to google site",
  "keyword": "Given "
});
formatter.match({
  "location": "Sample.i_should_navigate_to_google_site()"
});
formatter.result({
  "duration": 29551923602,
  "status": "passed"
});
});