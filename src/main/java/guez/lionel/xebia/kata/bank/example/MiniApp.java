package guez.lionel.xebia.kata.bank.example;

import guez.lionel.xebia.kata.bank.domain.Account;
import guez.lionel.xebia.kata.bank.domain.Operation;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class MiniApp {

    Scanner scanner;
    PrintStream out;

    public MiniApp(InputStream in, PrintStream out) {
        this.scanner = new Scanner(in);
        this.out = out;
    }

    public void run() {
        Account account = new Account();
        while (true) {
            boolean leave = false;
            out.println("Un compte a été ouvert");
            out.println(" Que voulez-vous faire ?");
            out.println("   Faire un retrait : Taper R");
            out.println("   Faire un dépôt : Taper D");
            out.println("   Consulter le solde : Taper S");
            out.println("   Consulter l'historique : Taper H");
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

    private void printSolde(Account account) {
        System.out.println(String.format("    Vous disposer de %f euros", account.getBalance()));
    }

    private void printHistory(Account account) {
        out.println("| Type | Date | Amount | Balance |");
        for (Operation operation : account.getOperations()) {
            out.print(" | ");
            out.print(operation.getNature().toString());
            out.print(" | ");
            out.print(operation.getDate());
            out.print(" | ");
            out.print(operation.getAmount());
            out.print(" | ");
            out.print(operation.getBalance());
            out.println(" | ");
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