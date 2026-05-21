package E2;

import java.util.Scanner;

public class Valutazione {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un voto da 1 a 10: ");
        int voto = scanner.nextInt();

        switch (voto) {
            case 10 -> System.out.println("Eccellente");
            case 8, 9 -> System.out.println("Ottimo");
            case 6, 7 -> System.out.println("Sufficiente");
            case 1, 2, 3, 4, 5 -> System.out.println("Insufficiente");
            default -> System.out.println("Voto non contemplato.");
        }
    }
}
