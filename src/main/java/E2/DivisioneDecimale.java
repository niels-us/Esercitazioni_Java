package E2;
import java.util.Scanner;
public class DivisioneDecimale {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il primo intero: ");
        int n1 = scanner.nextInt();
        System.out.print("Inserisci il secondo intero: ");
        int n2 = scanner.nextInt();

        /* Effettuando il cast esplicito (double) su n1,
         * forziamo Java a eseguire una divisione decimale (floating-point)
         * invece di una divisione intera troncata.
         */
        double risultato = (double) n1 / n2;
        System.out.println("Il risultato decimale della divisione è: " + risultato);
    }
}
