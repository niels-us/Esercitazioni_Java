package E2;

import java.util.Scanner;

public class Calcolatrice {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        double n1 = scanner.nextDouble();
        System.out.print("Inserisci il secondo numero: ");
        double n2 = scanner.nextDouble();

        System.out.println("Menu:");
        System.out.println("1. Somma\n2. Differenza\n3. Moltiplicazione\n4. Divisione");
        System.out.print("Scegli un'opzione: ");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1: System.out.println("Risultato: " + (n1 + n2)); break;
            case 2: System.out.println("Risultato: " + (n1 - n2)); break;
            case 3: System.out.println("Risultato: " + (n1 * n2)); break;
            case 4:
                if (n2 != 0) System.out.println("Risultato: " + (n1 / n2));
                else System.out.println("Errore: Divisione per zero!");
                break;
            default: System.out.println("Scelta non valida.");
        }
    }
}
