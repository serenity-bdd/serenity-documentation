Narrative:
In order to provide assistance to customers more quickly
As a financial adviser
I want to be able to locate a customer using a variety of different criteria

Scenario: Search for customer by name
Given I am logged into the application
And the following customers exist:
| id  | first name | last name | type                                 |
| 100 | Sarah-Jane | Smith     | Personal / Sole Trader / Partnership |
| 101 | Sarah      | Smith     | Personal / Sole Trader / Partnership |
When I search for a customer using the following search criteria:
| name | Sarah-Jane Smith |
Then I should display the customer details for customer 100

Scenario: Search for customer by name and date of birth
Given I am logged into the application
And the following customers exist:
| id  | first name | last name | date of birth | type                                 |
| 101 | Sarah      | Smith     | 10-May-1980   | Personal / Sole Trader / Partnership |
| 102 | Sarah      | Smith     | 21-May-1950   | Personal / Sole Trader / Partnership |
When I search for a Personal / Sole Trader / Partnership customer using the following search criteria:
| name          | Sarah-Jane Smith |
| date of birth | 10-May-1980      |
Then I should display the customer details for customer 100
