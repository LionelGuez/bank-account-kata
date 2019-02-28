package guez.lionel.xebia.kata.bank;

import guez.lionel.xebia.kata.bank.domain.Account;
import guez.lionel.xebia.kata.bank.domain.Operation;

import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        Account account = new Account();
        while (true) {
            boolean leave = false;
            System.out.println("Un compte a été ouvert");
            System.out.println(" Que voulez-vous faire ?");
            System.out.println("   Faire un retrait : Taper R");
            System.out.println("   Faire un dépôt : Taper D");
            System.out.println("   Consulter le solde : Taper S");
            System.out.println("   Consulter l'historique : Taper H");
            System.out.println("   Pour quitter : Taper Q");
            String order = input.nextLine().trim();
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
                    System.out.println("Ordre non reconnu");
            }
            if (leave) {
                break;
            }


        }

    }

    private static void printSolde(Account account) {
        System.out.println(String.format("    Vous disposer de %f euros",account.getBalance()));
    }

    private static void printHistory(Account account){
        System.out.println("| Nature     | Date       | Amount | Balance     |");
        for(Operation operation : account.getHistory().getOperations()){
            System.out.print("|");
            System.out.print(operation.getNature().toString());
            System.out.print("|");
            System.out.print(operation.getDate());
            System.out.print("|");
            System.out.print(operation.getAmount());
            System.out.print("|");
            System.out.print(operation.getBalance());
            System.out.println("|");
        }
        System.out.println();
    }

    private static void retrieve(Account account) {
        System.out.println("    Quelle somme voulez-vous retirer ?");
        double d = input.nextDouble();
        account.withdraw(d);
    }

    private static void deposit(Account account) {
        System.out.println("    Quelle somme voulez-vous déposer ?");
        double d = input.nextDouble();
        account.deposit(d);
    }
}
