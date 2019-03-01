package guez.lionel.xebia.kata.bank.domain.repository;

import guez.lionel.xebia.kata.bank.domain.account.Account;

/**
 * Repository for accounts
 */
public interface AccountRepository {

    Account getAccountByClientId(String clientId);

    void saveAccount(Account account);

}
