package E2;

import java.util.Scanner;

public class Media {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo numero: ");
        double n1 = scanner.nextDouble();
        System.out.print("Inserisci il secondo numero: ");
        double n2 = scanner.nextDouble();

        double media = (n1 + n2) / 2;
        System.out.println("La media aritmetica dei due numeri è: " + media);
    }
}
