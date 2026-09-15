Feature: Bank Testing

  Background:
    Given go to "https://parabank.parasoft.com/parabank/index.htm"
  Scenario: Login to Bank Account
    When Click the register button
    And Signing up with FirstName "ABBASS", LastName "BAHAE", Address "25 rue de paris", city "clichy", state "ile-de-france", zipcode "92000", phone "0749654681", SSN "123456789", Username "bea27", password "acab1312"
    And Click submit register
    And Verify the welcome message
    And Click LogOut
    And Verify title login "Customer Login"
    And Enter Username "bea27" and password "acab1312"
    Then Verify title "Accounts Overview"