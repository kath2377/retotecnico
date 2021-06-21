Feature: Login

Scenario: Successful login

Given user is on the Login page
When user fills in email with "kjav2377@hotmail.com"
And user fills in password with "testing123"
And user presses Submit
Then user should be on his profile page

Scenario: Login with invalid email

Given user is on the Login page
When user fills in email with "abc123nonvalid@hotmail.com"
And user tries to fill in password
Then an error message should be displayed


