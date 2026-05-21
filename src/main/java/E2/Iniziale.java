package E2;

import java.util.Scanner;

public class Iniziale {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome: ");
        String nome = scanner.next();
        System.out.print("Inserisci il cognome: ");
        String cognome = scanner.next();

        char inizialeCognome = cognome.charAt(0);
        System.out.println(nome + " " + inizialeCognome + ".");
    }
}
