Feature: Tests BBC
  As a user I want to check some functionality

  Scenario Outline: Checks the name of the head line article
    Given User opens news page '<homePage>'
    Then User checks the '<titleHeadLine>' name of the article

    Examples:
      | homePage            | titleHeadLine                               |
      | https://www.bbc.com | Diplomats hasten exit as Taliban near Kabul |


  Scenario Outline: Checks the name of secondary article titles
    Given User opens news page '<homePage>'
    Then User checks the name of secondary article titles:
      | Fearing the Taliban, Kabul's young women plead for help |
      | UK gunman's mother among five victims named             |
      | BBC condemns expulsion of journalist from Russia        |
      | ‘World silently watches this war against women’         |
      | July was Earth's hottest month ever - US agency         |

    Examples:
      | homePage            |
      | https://www.bbc.com |


  Scenario Outline: Check search by keyword of category link
    Given User opens news page '<homePage>'
    And User submitted to the search field the category link from the first article
    Then User checks that the header of the first article contains searched keyword

    Examples:
      | homePage            |
      | https://www.bbc.com |


  Scenario Outline: Verifies that user can submit story with empty name field
    Given User opens page contains form'<homePage>'
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
    Given User opens page contains form'<homePage>'
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
    Given User opens page contains form'<homePage>'
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








