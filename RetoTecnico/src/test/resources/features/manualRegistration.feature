Feature: Manual User Registration

Scenario: Successful Registration

Given user is on the main page
When user goes to Register option
And user fills in his data
Then his profile page should be displayed

Scenario: Registration with invalid email

Given user is on the main page
When user goes to Register option
And user enters an invalid email
Then an invalid error message should be displayed