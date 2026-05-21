package E2;

import java.util.Scanner;

public class UltimoCarattere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una parola: ");
        String parola = scanner.next();

        char ultimo = parola.charAt(parola.length() - 1);
        System.out.println("L'ultimo carattere è: " + ultimo);
    }
}
