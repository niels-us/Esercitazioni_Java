package E2;

import java.util.Scanner;

public class ValoreAssoluto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int numero = scanner.nextInt();

        int assoluto = numero;
        if (numero < 0) {
            assoluto = -numero;
        }

        System.out.println("Il valore assoluto è: " + assoluto);
    }
}
