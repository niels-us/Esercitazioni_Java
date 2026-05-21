package E2;

import java.util.Scanner;

public class VotoIntervallo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un voto (0-100): ");
        int voto = scanner.nextInt();

        if (voto < 0 || voto > 100) {
            System.out.println("Voto non valido.");
        } else {
            switch (voto / 10) {
                case 10: // Gestisce il voto esatto di 100
                case 9:  System.out.println("Lettera: A"); break;
                case 8:  System.out.println("Lettera: B"); break;
                case 7:  System.out.println("Lettera: C"); break;
                case 6:  System.out.println("Lettera: D"); break;
                default: System.out.println("Lettera: F"); break;
            }
        }
    }
}
