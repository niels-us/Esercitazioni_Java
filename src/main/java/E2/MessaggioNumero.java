package E2;

import java.util.Scanner;

public class MessaggioNumero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il nome: ");
        String nome = scanner.nextLine();
        System.out.print("Inserisci il primo numero: ");
        int n1 = scanner.nextInt();
        System.out.print("Inserisci il secondo numero: ");
        int n2 = scanner.nextInt();

        System.out.println("Ciao, " + nome + ". La somma dei numeri che hai scelto è " + (n1 + n2) + ".");
    }
}
