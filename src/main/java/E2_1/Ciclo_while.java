package E2_1;

import java.util.Scanner;

public class Ciclo_while {
    public static void main() {
        System.out.println("Stampa numeri da 10 a 1");
        byte Count = 11;
        while (Count >= 2) {
            Count--;
            System.out.println(Count);
        }

        System.out.println("Somma numeri finché l’utente vuole");
        boolean A = true;
        int numero;
        int totale = 0;
        while (A) {
            System.out.println("Somma i numeri inseriti finché l’utente non inserisce 0");
            Scanner scanner = new Scanner(System.in);
            System.out.println("inseriti numeri");
            numero = scanner.nextInt();
            if (numero == 0) A = false;
            totale = totale + numero;
            System.out.println("Somma totale: " + totale);
        }

        System.out.println("Indovina il numero");
        byte min = 1, max = 50;
        int Rango = (int) (Math.random() * (max - min + 1)) + min;  // Entre 10 y 20
        System.out.println("il numero " + Rango);
        A = true;
        while (A) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inseriti numeri");
            numero = scanner.nextInt();
            if (numero == Rango) A = false;
        }

        System.out.println("Validazione input positivo");
        A = true;
        while (A) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("inseriti numeri");
            numero = scanner.nextInt();
            if (numero > 0) {
                A = false;
                System.out.println("Excelent");
            }
        }

        Scanner scanner = new Scanner(System.in);
        int contatoreNegativi = 0;
        int i = 0;

        System.out.println("Dovrai inserire 10 numeri.");
        // Chiedi all’utente 10 numeri tramite Scanner ed esegui con ciclo while.
        while (i < 10) {
            System.out.print("Inserisci il numero " + (i + 1) + ": ");
            numero = scanner.nextInt();
            if (numero < 0) {
                contatoreNegativi++;
            }
            i++;
        }
        System.out.println("Hai inserito " + contatoreNegativi + " numeri negativi.");
        scanner.close();
    }
}
