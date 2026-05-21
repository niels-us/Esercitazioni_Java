package E2;

import java.util.Scanner;

public class StringaImmutabile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la prima parola: ");
        String originale = scanner.next();
        System.out.print("Inserisci la parola da concatenare: ");
        String daAggiungere = scanner.next();

        String modificata = originale.concat(daAggiungere);

        System.out.println("Stringa originale: " + originale);
        System.out.println("Stringa modificata: " + modificata);

        /*
         * Le Stringhe in Java sono immutabili.
         * Quando eseguiamo una concatenazione, l'oggetto 'originale' non subisce modifiche.
         * Viene allocata una nuova porzione di memoria per contenere il nuovo testo generato.
         */
    }
}
