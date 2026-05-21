package E2;

import java.util.Scanner;

public class OperatoriConfronto {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Primo numero: ");
        int a = scanner.nextInt();
        System.out.print("Secondo numero: ");
        int b = scanner.nextInt();

        System.out.println("a > b  : " + (a > b));
        System.out.println("a < b  : " + (a < b));
        System.out.println("a >= b : " + (a >= b));
        System.out.println("a <= b : " + (a <= b));
        System.out.println("a == b : " + (a == b));
        System.out.println("a != b : " + (a != b));
    }
}
