package E2;
import java.util.Scanner;
public class MaiuscoloMinuscolo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci una parola: ");
        String parola = scanner.next();

        System.out.println("In maiuscolo: " + parola.toUpperCase());
        System.out.println("In minuscolo: " + parola.toLowerCase());
    }
}
