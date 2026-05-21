package E2;
import java.util.Scanner;
public class Operazioni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo intero: ");
        int n1 = scanner.nextInt();
        System.out.print("Inserisci il secondo intero: ");
        int n2 = scanner.nextInt();

        System.out.println("La somma è: " + (n1 + n2));
        System.out.println("La differenza è: " + (n1 - n2));
        System.out.println("Il prodotto è: " + (n1 * n2));
        System.out.println("La divisione intera è: " + (n1 / n2));
        System.out.println("Il resto della divisione è: " + (n1 % n2));
    }
}
