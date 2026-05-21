package E2;

import java.util.Scanner;

public class OperatoriLogici {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo valore booleano (true/false): ");
        boolean b1 = scanner.nextBoolean();
        System.out.print("Inserisci il secondo valore booleano (true/false): ");
        boolean b2 = scanner.nextBoolean();

        System.out.println("Risultato di b1 && b2 (AND): " + (b1 && b2));
        System.out.println("Risultato di b1 || b2 (OR): " + (b1 || b2));
        System.out.println("Risultato di !b1 (NOT b1): " + (!b1));
    }
}
