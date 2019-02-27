package guez.lionel.xebia.kata.bank.domain;


import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTest {

    @Test
    public void a_deposit_should_increase_the_balance_of_the_account() {
        Account account = new Account();
        account.deposit(30);
        assertThat(account.getBalance()).isEqualTo(30);
    }

    @Test
    public void a_withdrawal_should_decrease_the_balance_of_the_account() {
        Account account = new Account();
        account.deposit(30);
        account.withdraw(10);
        assertThat(account.getBalance()).isEqualTo(20);
    }
}