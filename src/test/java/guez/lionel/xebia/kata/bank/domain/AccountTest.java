package guez.lionel.xebia.kata.bank.domain;

import guez.lionel.xebia.kata.bank.domain.account.Account;
import guez.lionel.xebia.kata.bank.domain.account.Operation;
import guez.lionel.xebia.kata.bank.domain.exception.NegativeAmountException;
import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static guez.lionel.xebia.kata.bank.domain.account.OperationType.DEPOSIT;
import static guez.lionel.xebia.kata.bank.domain.account.OperationType.WITHDRAWAL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class AccountTest {

    private Account createSimpleAccount() {
        return new Account("someId");
    }

    @Test
    public void a_deposit_should_increase_the_balance_of_the_account() {
        // GIVEN
        Account account = createSimpleAccount();

        // WHEN
        account.deposit(30);

        // THEN
        assertThat(account.getBalance()).isEqualTo(30);
    }

    @Test
    public void a_withdrawal_should_decrease_the_balance_of_the_account() {
        // GIVEN
        Account account = createSimpleAccount();
        account.deposit(30);

        // WHEN
        account.withdraw(10);

        // THEN
        assertThat(account.getBalance()).isEqualTo(20);
    }

    @Test
    public void should_return_history_of_the_operations() {
        // GIVEN
        Account account = createSimpleAccount();
        Date firstOperationDate = localDateToDate(LocalDate.of(2019, 02, 10));
        Date secondOperationDate = localDateToDate(LocalDate.of(2019, 02, 11));

        // WHEN
        account.deposit(30, firstOperationDate);
        account.withdraw(10, secondOperationDate);

        // Then
        List<Operation> history = account.getOperations();
        assertThat(history.get(0).getNature()).isEqualTo(DEPOSIT);
        assertThat(history.get(0).getDate()).isEqualTo(firstOperationDate);
        assertThat(history.get(0).getAmount()).isEqualTo(30);
        assertThat(history.get(0).getBalance()).isEqualTo(30);

        assertThat(history.get(1).getNature()).isEqualTo(WITHDRAWAL);
        assertThat(history.get(1).getDate()).isEqualTo(secondOperationDate);
        assertThat(history.get(1).getAmount()).isEqualTo(10);
        assertThat(history.get(1).getBalance()).isEqualTo(20);


    }

    @Test
    public void should_send_an_exception_if_we_want_to_deposit_or_withdraw_negative_amount() {
        // GIVEN
        Account account = createSimpleAccount();

        //WHEN & THEN
        assertThatThrownBy(() -> account.deposit(-10)).isOfAnyClassIn(NegativeAmountException.class);
        assertThatThrownBy(() -> account.withdraw(-10)).isOfAnyClassIn(NegativeAmountException.class);
    }

    private Date localDateToDate(LocalDate localDate) {
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}