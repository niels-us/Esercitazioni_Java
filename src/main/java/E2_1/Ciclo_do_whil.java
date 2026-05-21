package E2_1;

import java.util.Scanner;

public class Ciclo_do_whil {
    public static void main(){
        Scanner scanner = new Scanner(System.in);
        String nome;
        do {
            System.out.print("Inserisci il tuo nome (almeno 4 caratteri): ");
            nome = scanner.nextLine();
        } while (nome.length() <= 3);
        System.out.println("Benvenuto, " + nome);

        scanner = new Scanner(System.in);
        int somma = 0;
        do {
            System.out.print("Inserisci un numero da sommare: ");
            somma += scanner.nextInt();
            System.out.println("Somma corrente: " + somma);
        } while (somma <= 100);
        System.out.println("La somma ha superato 100! Totale finale: " + somma);

        scanner = new Scanner(System.in);
        char risposta;
        // Continua a chiedere finché non risponde 's'.
        do {
            System.out.print("Vuoi uscire dal programma? (s/n): ");
            risposta = scanner.next().charAt(0);
        } while (risposta != 's' && risposta != 'S');
        System.out.println("Arrivederci!");

        scanner = new Scanner(System.in);
        int numero;
        // Continua con do-while finché non inserisce un numero negativo.
        do {
            System.out.print("Inserisci un numero positivo (negativo per fermare): ");
            numero = scanner.nextInt();
        } while (numero >= 0);
        System.out.println("Ciclo interrotto. Hai inserito un numero negativo.");

        scanner = new Scanner(System.in);
        int scelta;
        // Usa do-while per continuare a mostrare il menu finché l’utente non sceglie 0.
        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Opzione 1");
            System.out.println("2. Opzione 2");
            System.out.println("3. Opzione 3");
            System.out.println("0. Esci");
            System.out.print("Scegli un'opzione: ");
            scelta = scanner.nextInt();
            switch (scelta) {
                case 1 -> System.out.println("Hai scelto l'Opzione 1.");
                case 2 -> System.out.println("Hai scelto l'Opzione 2.");
                case 3 -> System.out.println("Hai scelto l'Opzione 3.");
                case 0 -> System.out.println("Uscita in corso...");
                default -> System.out.println("Scelta non valida! Riprova.");
            }
        } while (scelta != 0);
        scanner.close();

    }
}
