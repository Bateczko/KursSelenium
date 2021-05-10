Feature: create an account

  Scenario Outline: create an account with new email
    Given user is on user is on gloaApps site
    When user inputs email address into CREATE AN ACCOUNT section
    And user clicks Create an account button
    And user inputs name <name> surname <surname> password <password>
    And user selects the gender by <name>
    And user clicks Register
    Then user closes browser

  Examples:
   |name     |surname      |password     |
   |Jan      |Kowalski     |6434737235   |
   |Monika   |Noga         |3778558      |
   |Leon     |Zawodowiec   |7484954      |
   |Jadwiga  |Wilk         |74383489     |


