package E2;

import java.util.Scanner;

public class Lingua {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il codice lingua (it, en, fr, es): ");
        String lingua = scanner.next();

        switch (lingua.toLowerCase()) {
            case "it" -> System.out.println("Ciao");
            case "en" -> System.out.println("Hello");
            case "fr" -> System.out.println("Bonjour");
            case "es" -> System.out.println("Hola");
            default   -> System.out.println("Lingua non supportata.");
        }
    }
}
