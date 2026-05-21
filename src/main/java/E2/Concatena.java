package E2;
import java.util.Scanner;
public class Concatena {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la prima parola: ");
        String p1 = scanner.next();
        System.out.print("Inserisci la seconda parola: ");
        String p2 = scanner.next();

        System.out.println(p1 + " + " + p2 + " = " + (p1 + p2));
    }
}
