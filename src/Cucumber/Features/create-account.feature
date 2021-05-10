Feature: create an account

  Scenario Outline: create an account with new email
    Given user is on user is on gloaApps site
    When user inputs email <email> address into CREATE AN ACCOUNT section
    And user clicks Create an account button
    And user inputs name <name> surname <surname> password <password>
    And user selects the gender by <name>
    And user clicks Register
    Then user closes browser

  Examples:
   |email                 |name     |surname      |password     |
   |jankowalski@vp.pl     |Jan      |Kowalski     |6434737235   |
   |monikaszyja@vp.pl     |Monika   |Szyja        |3773655      |
   |leonzawodowiec@vp.pl  |Leon     |Zawodowiec   |6736734748   |
   |olagac@vp.pl          |Ola      |Gac          |6373884      |
   |grzegorztrabka@vp.pl  |Grzegorz |Trabka       |73483494590  |

