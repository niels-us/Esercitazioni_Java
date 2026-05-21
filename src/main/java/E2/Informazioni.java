package E2;
import java.util.Scanner;
public class Informazioni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci l'età: ");
        int eta = scanner.nextInt();
        scanner.nextLine(); // Pulisce il buffer
        System.out.print("Inserisci la città di residenza: ");
        String citta = scanner.nextLine();

        System.out.println("Mi chiamo " + nome + ", ho " + eta + " anni e vivo a " + citta + ".");
    }
}
