package E2;
import java.util.Scanner;
public class Conversione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero decimale: ");
        double decimale = scanner.nextDouble();

        int intero = (int) decimale; // Cast esplicito (tronca la parte decimale)

        System.out.println("Valore double originale: " + decimale);
        System.out.println("Valore int convertito: " + intero);
    }
}
