package E2;

import java.util.Scanner;

public class IdentificatoreValido {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un potenziale nome di variabile: ");
        String input = scanner.nextLine();

        System.out.println("Hai verificato l'identificatore: " + input);

        /*
         * REGLE DI VALIDITÀ NEI COMMENTI:
         * 1. Non può iniziare con un numero (es. '1variabile' non è valido).
         * 2. Non può contenere spazi bianchi (es. 'mia variabile' non è valido).
         * 3. Non può coincidere con parole chiave di Java (es. 'int', 'class', 'final').
         * 4. Può contenere lettere, numeri (non all'inizio), underscore (_) e il simbolo del dollaro ($).
         */
    }
}
