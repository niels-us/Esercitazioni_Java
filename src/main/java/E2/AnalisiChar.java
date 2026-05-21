package E2;
import java.util.Scanner;
public class AnalisiChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un singolo carattere: ");
        char carattere = scanner.next().charAt(0);

        int unicode = (int) carattere;
        System.out.println("Il valore Unicode di '" + carattere + "' è: " + unicode);
    }
}
