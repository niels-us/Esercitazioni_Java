package E2;

import java.util.Scanner;

public class NumeroMediano {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci tre numeri interi (separati da spazio): ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();

        int mediano;
        if ((a >= b && a <= c) || (a <= b && a >= c)) {
            mediano = a;
        } else if ((b >= a && b <= c) || (b <= a && b >= c)) {
            mediano = b;
        } else {
            mediano = c;
        }

        System.out.println("Il numero intermedio è: " + mediano);
    }
}
