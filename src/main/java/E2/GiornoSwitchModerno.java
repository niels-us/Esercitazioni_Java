package E2;

import java.util.Scanner;

public class GiornoSwitchModerno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero da 1 a 7: ");
        int giorno = scanner.nextInt();

        switch (giorno) {
            case 1 -> System.out.println("Lunedì");
            case 2 -> System.out.println("Martedì");
            case 3 -> System.out.println("Mercoledì");
            case 4 -> System.out.println("Giovedì");
            case 5 -> System.out.println("Venerdì");
            case 6 -> System.out.println("Sabato");
            case 7 -> System.out.println("Domenica");
            default -> System.out.println("Numero non valido.");
        }
    }
}
