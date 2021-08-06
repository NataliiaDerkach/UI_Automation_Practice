Feature: Tests Lorem ipsum
  As a user I want to check some functionality

  Scenario Outline: Check contains keyword in first paragraph
    Given User opens '<homePage>' page
    And User switch to Russian language
    Then User verifies that the text of the first paragraph, contains '<keyword>'

    Examples:
      | homePage            | keyword |
      | https://lipsum.com/ | рыба    |


  Scenario Outline: User verifies that default setting result in text
    Given User opens '<homePage>' page
    And User generate lorem ipsum
    Then User verifies that default setting result in text contains '<expectedText>'

    Examples:
      | homePage            | expectedText                                            |
      | https://lipsum.com/ | Lorem ipsum dolor sit amet, consectetur adipiscing elit |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User opens '<homePage>' page
    And User generates '<amount1>' of words'<button>'
    Then User verifies amount words is generated with correct size'<amount1>','<button>'

    Examples:
      | homePage            | amount1 | button |
      | https://lipsum.com/ | 10      | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User opens '<homePage>' page
    And User generates '<amount2>' of words'<button>'
    Then User verifies amount words is generated with correct size'<amount2>','<button>'

    Examples:
      | homePage            | amount2 | button |
      | https://lipsum.com/ | 5       | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User opens '<homePage>' page
    And User generates '<amount3>' of words'<button>'
    Then User verifies amount words is generated with correct size'<amount3>','<button>'

    Examples:
      | homePage            | amount3 | button |
      | https://lipsum.com/ | 20      | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User opens '<homePage>' page
    And User generates '<amountChars1>' of words'<button>'
    Then User verifies amount words is generated with correct size'<amountChars1>','<button>'

    Examples:
      | homePage            | amountChars1 | button |
      | https://lipsum.com/ | 3            | bytes  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User opens '<homePage>' page
    And User generates '<amountChars2>' of words'<button>'
    Then User verifies amount words is generated with correct size'<amountChars2>','<button>'

    Examples:
      | homePage            | amountChars2 | button |
      | https://lipsum.com/ | 32           | bytes  |


  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User opens '<homePage>' page
    And User generates '<amount1>' of words'<button>'
    Then User verifies amount words is generated is not correct size'<amount1>','<button>'

    Examples:
      | homePage            | amount1 | button |
      | https://lipsum.com/ | -1      | words  |

  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User opens '<homePage>' page
    And User generates '<amount2>' of words'<button>'
    Then User verifies amount words is generated is not correct size'<amount2>','<button>'

    Examples:
      | homePage            | amount2 | button |
      | https://lipsum.com/ | 0       | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User opens '<homePage>' page
    And User generates '<amount3>' of words'<button>'
    Then User verifies amount words is generated is not correct size'<amount3>','<button>'

    Examples:
      | homePage            | amount3 | button |
      | https://lipsum.com/ | 2       | bytes  |


  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User opens '<homePage>' page
    And User generates '<amount4>' of words'<button>'
    Then User verifies amount words is generated is not correct size'<amount4>','<button>'

    Examples:
      | homePage            | amount4 | button |
      | https://lipsum.com/ | 1       | bytes  |


  Scenario Outline: User verifies the checkbox:
    Given User opens '<homePage>' page
    And User uncheck start with Lorem Ipsum checkbox
    And User generate lorem ipsum
    Then User verifies that the text of the first paragraph, not contains '<keyword>'

    Examples:
      | homePage            | keyword     |
      | https://lipsum.com/ | Lorem Ipsum |


    Scenario Outline:User checks that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%:
      Given User opens '<homePage>' page
      And User generate lorem ipsum
      Then User runs the generation ten times and checks the average number of paragraphs containing the word lorem

      Examples:
        | homePage            |
        | https://lipsum.com/ |