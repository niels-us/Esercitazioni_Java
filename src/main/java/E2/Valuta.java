package E2;

import java.util.Scanner;

public class Valuta {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci l'importo in Euro: ");
        double euro = scanner.nextDouble();

        final double TASSO_CAMBIO = 1.10;
        double dollari = euro * TASSO_CAMBIO;

        System.out.println(euro + " € corrispondono a " + dollari + " $.");
    }
}
