package E2;

import java.util.Scanner;

public class ContaLettere {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una parola: ");
        String parola = scanner.next();

        System.out.println("La parola contiene " + parola.length() + " caratteri.");
    }
}
