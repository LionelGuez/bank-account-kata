# Bank account kata
Think of your personal bank account experience When in doubt, go for the simplest solution

## Requirements
- Deposit and Withdrawal
- Account statement (date, amount, balance)
- Statement printing
 
## User Stories
##### US 1:
**In order to** save money  
**As a** bank client  
**I want to** make a deposit in my account  
 
##### US 2: 
**In order to** retrieve some or all of my savings  
**As a** bank client  
**I want to** make a withdrawal from my account  
 
##### US 3: 
**In order to** check my operations  
**As a** bank client  
**I want to** see the history (operation, date, amount, balance)  of my operations  

# Architecture

This is a minimalist implementation.
- The domain objects are in the package **guez.lionel.xebia.kata.bank.domain**
- There is a toy application that illustrate the kata in the package **guez.lionel.xebia.kata.bank.example**
- There is two kinds of tests : unit tests and behavior tests (via Cucumber/Gherkin)

# Launch project
- To compile, package, download dependencies, run the tests, install the project : **_mvn clean install_**
- To run tests only : **_mvn test_**
- To execute the 'toy' application : **_mvn exec:java_**