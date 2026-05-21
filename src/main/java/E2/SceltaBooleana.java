package E2;

import java.util.Scanner;

public class SceltaBooleana {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digita true o false: ");
        boolean scelta = scanner.nextBoolean();

        if (scelta) {
            System.out.println("Hai scelto il percorso della Verità (true)!");
        } else {
            System.out.println("Hai scelto l'alternativa (false)!");
        }
    }
}
