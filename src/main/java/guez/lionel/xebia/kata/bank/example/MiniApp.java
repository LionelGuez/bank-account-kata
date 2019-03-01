package guez.lionel.xebia.kata.bank.example;

import guez.lionel.xebia.kata.bank.domain.account.Account;
import guez.lionel.xebia.kata.bank.domain.account.Operation;
import guez.lionel.xebia.kata.bank.domain.repository.AccountRepository;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

/**
 * This is a 'toy' application which is here only to make the project executable
 */
public class MiniApp {

    Scanner scanner;
    PrintStream out;
    AccountRepository accountRepository;

    public MiniApp(InputStream in, PrintStream out, AccountRepository accountRepository) {
        this.scanner = new Scanner(in);
        this.out = out;
        this.accountRepository = accountRepository;
    }

    public void run() {
        Account account = loginAccount();
        while (true) {
            boolean leave = false;
            out.println("Votre compte a été ouvert");
            out.println(" Que voulez-vous faire ?");
            out.println("   Faire un retrait : Tapez R");
            out.println("   Faire un dépôt : Tapez D");
            out.println("   Consulter le solde : Tapez S");
            out.println("   Consulter l'historique : Tapez H");
            out.println("   Vous déconnecter de votre compte : Tapez X");
            out.println("   Pour quitter : Taper Q");
            String order = scanner.nextLine().trim();
            switch (order) {
                case "R":
                    retrieve(account);
                    break;
                case "D":
                    deposit(account);
                    break;
                case "S":
                    printSolde(account);
                    break;
                case "H":
                    printHistory(account);
                    break;
                case "X":
                    saveAccount(account);
                    account = loginAccount();
                    break;
                case "Q":
                    leave = true;
                    break;
                default:
                    out.println("Ordre non reconnu");
            }
            if (leave) {
                break;
            }
        }

    }

    private void saveAccount(Account account) {
        accountRepository.saveAccount(account);
        out.println("Au revoir");
        out.println("");
        out.println("");
    }

    private Account loginAccount() {
        out.println("Bonjour");
        out.println("Quel est l'id de votre compte ?");
        String clientId = scanner.nextLine();
        Account account = accountRepository.getAccountByClientId(clientId);
        if(account == null){
            out.println("Ce compte n'existant pas, nous allons le créer");
            return new Account(clientId);
        }
        return account;
    }

    private void printSolde(Account account) {
        System.out.println(String.format("    Vous disposez de %f euros", account.getBalance()));
    }

    private void printHistory(Account account) {
        out.println("| Type | Date | Amount | Balance |");
        for (Operation operation : account.getOperations()) {
            out.print("| ");
            out.print(operation.getNature().toString());
            out.print(" | ");
            out.print(operation.getDate());
            out.print(" | ");
            out.print(operation.getAmount());
            out.print(" | ");
            out.print(operation.getBalance());
            out.println(" |");
        }
        out.println();
    }

    private void retrieve(Account account) {
        out.println("    Quelle somme voulez-vous retirer ?");
        double d = scanner.nextDouble();
        account.withdraw(d);
    }

    private void deposit(Account account) {
        out.println("    Quelle somme voulez-vous déposer ?");
        double d = scanner.nextDouble();
        account.deposit(d);
    }
}