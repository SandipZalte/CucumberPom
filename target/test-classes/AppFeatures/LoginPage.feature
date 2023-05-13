@All
Feature: Login Page
Background:

	 Given User is on login Page
  Scenario: Login page title
   
    When User gets the title of the page
    Then Title of the page should be "Login - My Store"
    
  Scenario: Forgot password link

    Then Forgot password link should display

  Scenario: User enter the valid Credintals

    When User enter the username "dec2020secondbatch@gmail.com"
    And User enter the password "Selenium@12345"
    And User click on login button
    Then User gets the title of the page
    And Title of the page should be "My account - My Store"

  #Scenario: User enter the  invalid creditals
   #
    #When User enter the username "dec20secondbatch@gmail.com"
    #And User enter the password "selenium@12345"
    #And User click on login button
    #Then display the warning message
    #And Title of the page should be "Login - My Store"
    
