Feature: Tests Lorem ipsum
  As a user I want to check some functionality

  Scenario Outline: Check contains keyword in first paragraph
    Given User switch to Russian language on the home page
    Then User verifies that the text contains <keyword>
    Examples:
      | keyword |
      | рыба    |


  Scenario Outline: User verifies that default setting result in text
    Given User generate lorem ipsum
    Then User verifies that the text contains <expectedText>

    Examples:
      | expectedText                                            |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit |


  Scenario Outline: User verifies that words is generated with correct size:
    Given User generates <amount> of words on the home page
    Then User verifies <amount> of words is generated

    Examples:
      | amount |
      | 10     |
      | 5      |
      | 20     |


  Scenario Outline: User verifies that bytes is generated with correct size:
    Given User generates <amount> of bytes on the home page
    Then User verifies <amount> of bytes is generated

    Examples:
      | amount |
      | 3      |
      | 32     |

  Scenario Outline: User verifies that words for generate couldn't be less one:
    Given User generates <amount> of words on the home page
    Then User verifies that <amount> of words is generated is not correct size

    Examples:
      | amount |
      | -1     |
      | 0      |


  Scenario Outline: User verifies that bytes for generate couldn't be less two:
    Given User generates <amount> of bytes on the home page
    Then User verifies that <amount> of bytes is generated is not correct size

    Examples:
      | amount |
      | 1      |
      | 2      |


  Scenario: User verifies the checkbox:
    Given User uncheck to start with Lorem Ipsum and generates text
    Then User verifies that the text not contains Lorem Ipsum


  Scenario Outline: User checks that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%:
    Given User generate lorem ipsum
    Then User  generates <times> times and checks the average number of the word lorem in paragraphs

    Examples:
      | times |
      | 10    |



