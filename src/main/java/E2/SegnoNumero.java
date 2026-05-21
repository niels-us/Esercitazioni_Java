package E2;

import java.util.Scanner;

public class SegnoNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero intero: ");
        int numero = scanner.nextInt();

        if (numero > 0) {
            System.out.println("Il numero è positivo.");
        } else if (numero < 0) {
            System.out.println("Il numero è negativo.");
        } else {
            System.out.println("Il numero è uguale a zero.");
        }
    }
}
