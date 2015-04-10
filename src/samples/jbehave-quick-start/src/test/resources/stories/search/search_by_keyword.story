!-- tag::header[]
Searching by keyword

Meta:
@tag product:search

Narrative:
  In order to find items that I would like to purchase
  As a potential buyer
  I want to be able to search for items containing certain words

!-- end::header[]
!-- tag::woolscenario[]
Scenario: Should list items related to a specified keyword
Given I want to buy a wool scarf
When I search for items containing 'wool'
Then I should only see items related to 'wool'
!-- end::woolscenario[]
