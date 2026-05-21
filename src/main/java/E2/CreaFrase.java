package E2;
import java.util.Scanner;
public class CreaFrase {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un soggetto: ");
        String soggetto = scanner.nextLine();
        System.out.print("Inserisci un verbo: ");
        String verbo = scanner.nextLine();
        System.out.print("Inserisci un complemento: ");
        String complemento = scanner.nextLine();

        System.out.println("Frase risultante: " + soggetto + " " + verbo + " " + complemento + ".");
    }
}
