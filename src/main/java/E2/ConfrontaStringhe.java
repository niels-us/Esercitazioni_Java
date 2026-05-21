package E2;
import java.util.Scanner;
public class ConfrontaStringhe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci la prima parola: ");
        String s1 = scanner.next();
        System.out.print("Inserisci la seconda parola: ");
        String s2 = scanner.next();

        boolean confrontoRiferimento = (s1 == s2);
        boolean confrontoContenuto = s1.equals(s2);

        System.out.println("Risultato con == : " + confrontoRiferimento);
        System.out.println("Risultato con .equals() : " + confrontoContenuto);

        /*
         * L'operatore '==' confronta i riferimenti di memoria (se sono lo stesso oggetto).
         * Il metodo '.equals()' confronta l'effettivo contenuto testuale dei due oggetti String.
         */
    }
}
