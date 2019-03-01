package guez.lionel.xebia.kata.bank;

import guez.lionel.xebia.kata.bank.example.InMemoryAccountRepository;
import guez.lionel.xebia.kata.bank.example.MiniApp;


public class Main {

    public static void main(String[] args) {
        MiniApp miniApp = new MiniApp(System.in, System.out, new InMemoryAccountRepository());
        miniApp.run();
    }
}
