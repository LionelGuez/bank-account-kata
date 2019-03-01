package guez.lionel.xebia.kata.bank.cucumber;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import guez.lionel.xebia.kata.bank.domain.account.Account;
import guez.lionel.xebia.kata.bank.domain.account.Operation;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BankAccountStepDef {
    Account account;

    @Given("^An account created$")
    public void an_account_created() throws Exception {
        account = new Account("someId");
    }

    @When("^I deposit (\\d+) euros in this account(?: on (.*))?$")
    public void i_deposit_euros_in_this_account_the(double amount, String dateStr) throws Exception {
        if (dateStr == null) {
            account.deposit(amount);
        } else {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date date = format.parse(dateStr);
            account.deposit(amount, date);
        }
    }

    @When("^I withdraw (\\d+) euros in this account(?: on (.*))?$")
    public void i_withdraw_euros_in_this_account_the(double amount, String dateStr) throws Exception {
        if (dateStr == null) {
            account.withdraw(amount);
        } else {
            SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
            Date date = format.parse(dateStr);
            account.withdraw(amount, date);
        }
    }

    @Then("^By consulting my history, I should see (\\d+) operation$")
    public void in_consulting_my_history_I_should_see_two_operation(int nbOperations) throws Exception {
        assertThat(account.getOperations().size()).isEqualTo(nbOperations);
    }

    @Then("^I should have (\\d+) euros in this account$")
    public void i_should_have_euros_in_this_account(double balance) throws Exception {
        assertThat(balance).isEqualTo(account.getBalance());
    }

    @Then("^My history should be :$")
    public void my_history_should_be(DataTable dataTable) throws Exception {
        List<Operation> operations = dataTable.asList(Operation.class);
        assertThat(operations).isEqualTo(account.getOperations());
    }

}
