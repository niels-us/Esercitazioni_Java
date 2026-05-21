package E2;

import java.util.Scanner;

public class CarattereIndex {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una parola: ");
        String parola = scanner.next();
        System.out.print("Inserisci un indice intero: ");
        int indice = scanner.nextInt();

        System.out.println("Il carattere alla posizione " + indice + " è: " + parola.charAt(indice));
    }
}
