package guez.lionel.xebia.kata.bank.domain;

import org.junit.Test;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static guez.lionel.xebia.kata.bank.domain.OperationType.DEPOSIT;
import static guez.lionel.xebia.kata.bank.domain.OperationType.WITHDRAWAL;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AccountTest {

    @Test
    public void a_deposit_should_increase_the_balance_of_the_account() {
        // GIVEN
        Account account = new Account();

        // WHEN
        account.deposit(30);

        // THEN
        assertThat(account.getBalance()).isEqualTo(30);
    }

    @Test
    public void a_withdrawal_should_decrease_the_balance_of_the_account() {
        // GIVEN
        Account account = new Account();
        account.deposit(30);

        // WHEN
        account.withdraw(10);

        // THEN
        assertThat(account.getBalance()).isEqualTo(20);
    }

    @Test
    public void should_return_history_of_the_operations(){
        // GIVEN
        Account account = new Account();
        Date firstOperationDate = localDateToDate(LocalDate.of(2019, 02, 10));
        Date secondOperationDate = localDateToDate(LocalDate.of(2019, 02, 11));

        // WHEN
        account.deposit(30, firstOperationDate);
        account.withdraw(10, secondOperationDate);

        // Then
        List<Operation> history = account.getHistory().getOperations();
        assertThat(history.get(0).getNature()).isEqualTo(DEPOSIT);
        assertThat(history.get(0).getDate()).isEqualTo(firstOperationDate);
        assertThat(history.get(0).getAmount()).isEqualTo(30);
        assertThat(history.get(0).getBalance()).isEqualTo(30);

        assertThat(history.get(1).getNature()).isEqualTo(WITHDRAWAL);
        assertThat(history.get(1).getDate()).isEqualTo(secondOperationDate);
        assertThat(history.get(1).getAmount()).isEqualTo(10);
        assertThat(history.get(1).getBalance()).isEqualTo(20);


    }

    private Date localDateToDate(LocalDate localDate){
        return Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
    }
}