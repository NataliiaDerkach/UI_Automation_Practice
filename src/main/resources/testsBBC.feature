Feature: Tests BBC
  As a user I want to check some functionality

  Scenario Outline: Checks the name of the head line article
    Given User opens news page
    Then User checks the <titleHeadLine> name of the article

    Examples:
      | titleHeadLine                             |
      | Taliban are ruthless, top US general says |


  Scenario: Checks the name of secondary article titles
    Given User opens news page
    Then User checks the name of secondary article titles:
      | Father of eight among those killed in Kabul airport attack |
      | Final UK flight for civilians leaves Kabul                 |
      | Thousands flee as hurricane closes in on Gulf Coast        |
      | Woman arrested over jewellery thefts from coffins          |
      | Afghan fleeing to UK gives birth at 30,000 feet            |


  Scenario: Check search by keyword of category link
    Given User opens news page
    And User submitted to the search field the category link from the first article
    Then User checks that the header of the first article contains searched keyword


  Scenario Outline: Verifies that user can submit story with empty name field
    Given User fills out the form field:
      | story    | Healthy GRATE |
      | Contact  | 05362977888   |
      | Location | Ukraine       |
      | checkbox | checkbox      |
    Then User checks error message in form'<errorMessage>'

    Examples:
      | errorMessage         |
      | Name can\'t be blank |


  Scenario Outline: Verifies that user can submit story without choose checkbox
    Given User fills out the form field:
      | story    | Healthy GRATE |
      | Name     | Olga          |
      | Contact  | 05362977888   |
      | Location | Ukraine       |
    Then User checks error message in form'<errorMessage>'

    Examples:
      | errorMessage     |
      | must be accepted |


  Scenario Outline: Verifies that user can submit story with not valid email address
    Given User fills out the form field:
      | story    | Healthy GRATE            |
      | Name     | Olga                     |
      | Email    | iamstudinginepamgmailcom |
      | Contact  | 05362977888              |
      | Location | Ukraine                  |
      | checkbox | checkbox                 |
    Then User checks error message in form'<errorMessage>'

    Examples:
      | errorMessage             |
      | Email address is invalid |








