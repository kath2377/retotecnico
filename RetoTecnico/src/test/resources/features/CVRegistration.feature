Feature: CV Registration

Scenario: Successful CV Registration

Given the user is on the main page
When the user goes to the section to register CV
And he fills in <firstName>, <lastName>, <email> and <phone>
And he submits
Then the manual registration page is displayed