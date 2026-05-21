package E2_1;

import java.util.Scanner;

public class Cicli_for {
    public static void main() {
        System.out.println("Usa un ciclo for per stampare tutti i numeri da 1 a 20.");
        for (int X = 1; X < 21; X++) System.out.println(X);

        System.out.println("Modifica il ciclo for in modo da stampare solo i numeri pari tra 2 e 50.");
        for (int X = 0; X < 51; X = X + 2) System.out.println(X);

        System.out.println("Usa un ciclo for per calcolare e stampare la somma di tutti i numeri da 1 a 100.");
        int count = 0;
        for (int X = 1; X < 101; X++) {
            count = count + X;
            System.out.println(count);
        }

        System.out.println("Chiedi all’utente un numero n tramite Scanner.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Inserisce un numero:");
        int scelta = scanner.nextInt();
        for (int X = 0; X < scelta; X++) System.out.println("Tramite N°: " + (X + 1));
       // scanner.close();

        System.out.println("Stampa la tabellina di n da 1 a 10 usando un ciclo for.");
        for (int X = 1; X < 11; X++) {
            System.out.println("tabellina di " + X);
            for (int Y = 1; Y < 11; Y++) {
                System.out.println(X + "X" + Y + "=" + (X * Y));
            }
        }
        System.out.println("Chiedi un numero m all’utente.\n");
        System.out.println("Usa un ciclo for per stampare tutti i numeri da 1 a 100 divisibili per m");
        scanner = new Scanner(System.in);
        System.out.println("Inserisce un numero:");
        scelta = scanner.nextInt();
        for (int X = 1; X < 101; X++) {
            if (X % scelta == 0) System.out.println("numeri divisibili per N°: " + scelta + " e " + X);
        }
        scanner.close();


    }
}
