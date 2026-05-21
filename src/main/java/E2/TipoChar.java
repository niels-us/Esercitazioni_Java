package E2;

import java.util.Scanner;

public class TipoChar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un carattere: ");
        char ch = scanner.next().charAt(0);

        if (Character.isLetter(ch)) {
            System.out.println("È una lettera.");
        } else if (Character.isDigit(ch)) {
            System.out.println("È una cifra.");
        } else {
            System.out.println("È un altro simbolo.");
        }
    }
}
