@tag
Feature: My Account Page Feature
  i Want use this Account Page Feature File to validate the Accounpage

  Background: 
    Given User is already logged in the application
      | username                     | password       |
      | dec2020secondbatch@gmail.com | Selenium@12345 |

  Scenario: Account page title
    Given User is on account page
    When User gets the title of the page
    Then Title of the page should be "My account - My Store"

  Scenario: account section count
    Given User is on account page
    Then User get the account section List
      # in the form od data table
      | ADD MY FIRST ADDRESS      |
      | ORDER HISTORY AND DETAILS |
      | MY CREDIT SLIPS           |
      | MY ADDRESSES              |
      | MY PERSONAL INFORMATION   |
      | Home                      |
    And Account section count should be 6


    