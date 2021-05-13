Feature: Add new user address

  Scenario: Change user address
    Given User is logged in to shop
    When User goes to Address page
    And User inputs address, postcode, city
    And User selects country
    And User saves new address
    Then User see Address successfully added!
    And User deletes address, and removes the address and logs out of the account
