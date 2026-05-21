package E2;
//import java.util.Scanner;
import java.util.Scanner;
public record MainStructure() {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il tuo nome: ");
        String nome = scanner.nextLine();
        System.out.println("Ciao, " + nome + "! Benvenuto in Java.");
    }
}
