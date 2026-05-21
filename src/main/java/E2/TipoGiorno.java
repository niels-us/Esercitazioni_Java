package E2;

import java.util.Scanner;

public class TipoGiorno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero da 1 a 7: ");
        int giorno = scanner.nextInt();

        switch (giorno) {
            case 1, 2, 3, 4, 5 -> System.out.println("Giorno lavorativo");
            case 6, 7 -> System.out.println("Weekend");
            default -> System.out.println("Valore inserito errato.");
        }
    }
}
