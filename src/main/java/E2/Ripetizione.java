package E2;

import java.util.Scanner;

public class Ripetizione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un nome: ");
        String nome = scanner.next();
        System.out.print("Inserisci quante volte ripeterlo (visto il codice statico, inserisci 3): ");
        int volte = scanner.nextInt();

        // Ripetizione manuale senza cicli (mostra i limiti della programmazione puramente statica)
        System.out.println("Ciao, " + nome + "!");
        System.out.println("Ciao, " + nome + "!");
        System.out.println("Ciao, " + nome + "!");
        // Testing For
        for (int x = 0; x < volte; x++) {
            System.out.println("Ciao, " + nome + "!");
        }
    }
}
