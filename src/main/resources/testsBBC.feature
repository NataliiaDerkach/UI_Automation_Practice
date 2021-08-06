Feature: Tests BBC
  As a user I want to check some functionality

  Scenario Outline: Checks the name of the head line article
    Given User opens '<homePage>' page
    When User opens news page
    And User checks the name '<titleHeadLine>' of the article


    Examples:
      | homePage            | titleHeadLine                                     |
      | https://www.bbc.com | Belarus athlete told by grandmother not to return |


  Scenario Outline: Checks the name of secondary article titles
    Given User opens '<homePage>' page
    When User opens news page
    Then User checks the name of secondary article titles:
      | Chronic illness influencers accused of faking it   |
      | Ethiopian rebels take Unesco world heritage town   |
      | Turkish influencer prosecuted 'for sex-toy photos' |
      | What is Fox host Tucker Carlson doing in Hungary?  |
      | Lionel Messi will not stay at Barcelona            |

    Examples:
      | homePage            |
      | https://www.bbc.com |


  Scenario Outline: Check search by keyword of category link
    Given User opens '<homePage>' page
    When User opens news page
    And User submitted to the search field the category link from the first article
    Then User checks that the header of the first article contains searched keyword

    Examples:
      | homePage            |
      | https://www.bbc.com |


  Scenario Outline: Verifies that user can submit story with empty name field
    Given User opens '<homePage>' page
    When User opens news page
    And User opens coronavirus page
    And User opens your coronavirus stories page
    And User choose link of how to share with BBC
    And User fills out the form field:
      | story    | Healthy GRATE |
      | Contact  | 05362977888   |
      | Location | Ukraine       |
      | checkbox | checkbox      |
    Then User checks error message in form'<errorMessage>'

    Examples:
      | homePage            | errorMessage         |
      | https://www.bbc.com | Name can\'t be blank |


  Scenario Outline: Verifies that user can submit story without choose checkbox
    Given User opens '<homePage>' page
    When User opens news page
    And User opens coronavirus page
    And User opens your coronavirus stories page
    And User choose link of how to share with BBC
    And User fills out the form field:
      | story    | Healthy GRATE |
      | Name     | Olga          |
      | Contact  | 05362977888   |
      | Location | Ukraine       |
    Then User checks error message in form'<errorMessage>'

    Examples:
      | homePage            | errorMessage     |
      | https://www.bbc.com | must be accepted |


  Scenario Outline: Verifies that user can submit story with not valid email address
    Given User opens '<homePage>' page
    When User opens news page
    And User opens coronavirus page
    And User opens your coronavirus stories page
    And User choose link of how to share with BBC
    And User fills out the form field:
      | story    | Healthy GRATE            |
      | Name     | Olga                     |
      | Email    | iamstudinginepamgmailcom |
      | Contact  | 05362977888              |
      | Location | Ukraine                  |
      | checkbox | checkbox                 |
    Then User checks error message in form'<errorMessage>'

    Examples:
      | homePage            | errorMessage             |
      | https://www.bbc.com | Email address is invalid |








