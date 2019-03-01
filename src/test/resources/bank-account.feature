Feature: Very simplified version of a bank account

  Scenario: As a customer, I want to create an account and make a deposit of 10 euros
    Given An account created
    When I deposit 10 euros in this account
    Then I should have 10 euros in this account

  Scenario: As a customer, I want to create an account and make two deposits of 15 euros
    Given An account created
    When I deposit 15 euros in this account
    And I deposit 15 euros in this account
    Then I should have 30 euros in this account

  Scenario: As a customer, I want to create an account and make one deposit then one withdrawal
    Given An account created
    When I deposit 15 euros in this account
    And I withdraw 10 euros in this account
    Then I should have 5 euros in this account

  Scenario: As a customer, I want to make several operation and consult my history
    Given An account created
    When I deposit 15 euros in this account on 02/10/2019
    And I withdraw 10 euros in this account on 02/11/2019
    Then By consulting my history, I should see 2 operation
    And My history should be :
      | Nature     | Date       | Amount | Balance |
      | DEPOSIT    | 02/10/2019 |   15   |  15     |
      | WITHDRAWAL | 02/11/2019 |   10   |   5     |