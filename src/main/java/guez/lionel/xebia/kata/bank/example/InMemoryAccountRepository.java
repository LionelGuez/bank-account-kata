package guez.lionel.xebia.kata.bank.example;

import guez.lionel.xebia.kata.bank.domain.account.Account;
import guez.lionel.xebia.kata.bank.domain.repository.AccountRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryAccountRepository implements AccountRepository {

    Map<String, Account> accountByClientId;

    public InMemoryAccountRepository() {
        accountByClientId = new HashMap<>();
    }

    @Override
    public Account getAccountByClientId(String clientId) {
        return accountByClientId.get(clientId);
    }

    @Override
    public void saveAccount(Account account) {
        accountByClientId.put(account.getClientId(), account);
    }
}
