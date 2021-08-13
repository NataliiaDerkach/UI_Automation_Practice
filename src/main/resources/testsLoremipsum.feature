Feature: Tests Lorem ipsum
  As a user I want to check some functionality

  Scenario Outline: Check contains keyword in first paragraph
    Given User switch to Russian language on the home page
    Then User verifies that the text of the first paragraph, contains '<keyword>'

    Examples:
      | keyword |
      | рыба    |


  Scenario Outline: User verifies that default setting result in text
    Given User generate lorem ipsum
    Then User verifies that generated text contains '<expectedText>'

    Examples:
      | expectedText                                            |
      | Lorem ipsum dolor sit amet, consectetur adipiscing elit |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User generates '<amount1>' of words'<button>' on the home page
    Then User verifies amount words is generated with correct size'<amount1>','<button>'

    Examples:
      | amount1 | button |
      | 10      | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User generates '<amount2>' of words'<button>' on the home page
    Then User verifies amount words is generated with correct size'<amount2>','<button>'

    Examples:
      | amount2 | button |
      | 5       | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User generates '<amount3>' of words'<button>' on the home page
    Then User verifies amount words is generated with correct size'<amount3>','<button>'

    Examples:
      | amount3 | button |
      | 20      | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User generates '<amountChars1>' of words'<button>' on the home page
    Then User verifies amount words is generated with correct size'<amountChars1>','<button>'

    Examples:
      | amountChars1 | button |
      | 3            | bytes  |


  Scenario Outline: User verifies that Lorem Ipsum is generated with correct size:
    Given User generates '<amountChars2>' of words'<button>' on the home page
    Then User verifies amount words is generated with correct size'<amountChars2>','<button>'

    Examples:
      | amountChars2 | button |
      | 32           | bytes  |


  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User generates '<amount1>' of words'<button>' on the home page
    Then User verifies amount words is generated is not correct size'<amount1>','<button>'

    Examples:
       | amount1 | button |
     | -1      | words  |

  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User generates '<amount2>' of words'<button>' on the home page
    Then User verifies amount words is generated is not correct size'<amount2>','<button>'

    Examples:
      | amount2 | button |
      | 0       | words  |


  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User generates '<amount3>' of words'<button>' on the home page
    Then User verifies amount words is generated is not correct size'<amount3>','<button>'

    Examples:
      | amount3 | button |
      | 2       | bytes  |


  Scenario Outline: User verifies that Lorem Ipsum is generated is not correct size:
    Given User generates '<amount4>' of words'<button>' on the home page
    Then User verifies amount words is generated is not correct size'<amount4>','<button>'

    Examples:
      | amount4 | button |
      | 1       | bytes  |


  Scenario Outline: User verifies the checkbox:
    Given User uncheck start with Lorem Ipsum '<radioButton>' and generate text
    Then User verifies that the text of the first paragraph, not contains '<keyword>'

    Examples:
      | radioButton | keyword     |
      | start    | Lorem Ipsum |


  Scenario Outline:User checks that randomly generated text paragraphs contain the word "lorem" with probability of more than 40%:
    Given User generate lorem ipsum
    Then User runs the generation ten times and checks the average number of paragraphs containing the word lorem

    Examples:
      | homePage            |
      | https://lipsum.com/ |