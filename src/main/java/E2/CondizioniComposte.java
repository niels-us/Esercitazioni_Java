package E2;

import java.util.Scanner;

public class CondizioniComposte {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        int n1 = scanner.nextInt();
        System.out.print("Inserisci il secondo numero: ");
        int n2 = scanner.nextInt();

        if (n1 > 0 && n2 > 0) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
