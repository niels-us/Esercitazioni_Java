package E2;

import java.util.Date;
import java.util.Scanner;

public class MenuInterattivo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Dire ciao");
        System.out.println("2. Mostrare la data corrente");
        System.out.println("3. Calcolare la somma di due numeri");
        System.out.println("4. Uscire");
        System.out.print("Fai la tua scelta: ");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1:
                System.out.println("Ciao utente!");
                break;
            case 2:
                System.out.println("Data attuale: " + new Date());
                break;
            case 3:
                System.out.print("Inserisci primo numero: ");
                int n1 = scanner.nextInt();
                System.out.print("Inserisci secondo numero: ");
                int n2 = scanner.nextInt();
                System.out.println("Somma: " + (n1 + n2));
                break;
            case 4:
                System.out.println("Programma terminato.");
                break;
            default:
                System.out.println("Scelta non valida.");
        }
    }
}
