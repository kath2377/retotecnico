Feature: CV Registration

Scenario Outline: Successful CV Registration

Given the user is on the main page
When the user goes to the section to register CV
And fills in "<firstName>", "<lastName>", "<email>" and "<phone>"
And submits
Then the manual registration page is displayed
 
Examples:
| firstName | lastName | email | phone |
| Juan | Alarcon | tortugavelozflash@gmail.com | 987787787 |

Scenario Outline: Wrong CV Registration

Given the user is on the main page
When the user goes to the section to register CV
And fills in "<firstName>", "<lastName>", "<email>" and "<phone>"
And submits
Then an error alert should be dispayed
 
Examples:
| firstName | lastName | email | phone |
| Juan | Meza | ajh | 987787787 |