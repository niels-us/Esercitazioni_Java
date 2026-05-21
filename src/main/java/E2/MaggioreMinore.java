package E2;

import java.util.Scanner;

public class MaggioreMinore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        int n1 = scanner.nextInt();
        System.out.print("Inserisci il secondo numero: ");
        int n2 = scanner.nextInt();

        if (n1 > n2) {
            System.out.println(n1 + " è maggiore di " + n2);
        } else if (n1 < n2) {
            System.out.println(n2 + " è maggiore di " + n1);
        } else {
            System.out.println("I numeri sono uguali.");
        }
    }
}
