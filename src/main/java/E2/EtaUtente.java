package E2;

import java.util.Scanner;

public class EtaUtente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la tua età: ");
        int eta = scanner.nextInt();

        if (eta >= 18) {
            System.out.println("Sei maggiorenne.");
        } else {
            System.out.println("Sei minorenne.");
        }
    }
}
