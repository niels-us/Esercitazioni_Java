package E2;

import java.util.Scanner;

public class GiornoSwitch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero da 1 a 7: ");
        int giorno = scanner.nextInt();

        switch (giorno) {
            case 1: System.out.println("Lunedì"); break;
            case 2: System.out.println("Martedì"); break;
            case 3: System.out.println("Mercoledì"); break;
            case 4: System.out.println("Giovedì"); break;
            case 5: System.out.println("Venerdì"); break;
            case 6: System.out.println("Sabato"); break;
            case 7: System.out.println("Domenica"); break;
            default: System.out.println("Numero non valido.");
        }
    }
}
