Feature: To validate url automationpractice.com
  
  As a User 
  I want to validate automayionpractisr.com
  In Order to ensure the requirements

  @AccountCreationwithValidEmail  @scenario1
  Scenario Outline: To verify Email Signup
  Given Open the browser<Browsertype>
  And Launch the AUT
  When Click on SignIn button
  And Enter email address<email>
  And Click on Create Account button
  And User is navigated to User details page
  And User is able to fill all mandatory fields
  And Click on Register button
  Then User created account successfully 
  And Close the browser
  
  Examples:
  | Browsertype | email            |
  | "chrome"    | "Gina.brown@gmail.com" |
  
  @InvalidEmailVerification
  Scenario Outline: To verify invalid Email Signup
    Given Open the browser<Browsertype>
    And Launch the AUT
    When Click on SignIn button
    And Enter email address<email>
    And Click on Create Account button
    Then Appropriate error message is displayed
    And Close the browser

    Examples: 
      | Browsertype | email  |
      | "chrome"    | "ddd" |

   @VerifyingMegamenu
  Scenario Outline: To verify Megamenu 
    Given Open the browser<Browsertype>
    And Launch the AUT
    When Click on Dresses
    And Click on Summer Dresses
    Then User is navigated to Summer Dresses page 
    And Close the browser

    Examples: 
      | Browsertype |    Dresses      | 
      | "chrome"    | "Summer Dresses"| 
      
      
      @ValidatingPriceSort
  Scenario Outline: To verify product grid price sort
    Given Open the browser<Browsertype>
    And Launch the AUT
    When Click on Dresses
    And Click on Summer Dresses
    And User is navigated to Summer Dresses page
    Then Validate product grid sort
    And Close the browser

    Examples: 
      | Browsertype | 
      | "chrome"    | 
      
         @ValidatingCartSummary
  Scenario Outline: To validate product chosen in cart summary page
    Given Open the browser<Browsertype>
   And Launch the AUT
    When Click on Dresses
    And Click on Summer Dresses
   And Click the product and change it to blue color
    Then Validate Product name,Quantity and color in the cart summary
    And Close the browser

    Examples: 
      | Browsertype |    
      | "chrome"    |