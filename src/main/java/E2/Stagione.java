package E2;

import java.util.Scanner;

public class Stagione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero del mese (1-12): ");
        int mese = scanner.nextInt();

        switch (mese) {
            case 12, 1, 2 -> System.out.println("Inverno");
            case 3, 4, 5   -> System.out.println("Primavera");
            case 6, 7, 8   -> System.out.println("Estate");
            case 9, 10, 11 -> System.out.println("Autunno");
            default        -> System.out.println("Mese non esistente.");
        }
    }
}
