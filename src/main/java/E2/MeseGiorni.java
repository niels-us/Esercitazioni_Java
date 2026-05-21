package E2;

import java.util.Scanner;

public class MeseGiorni {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il numero del mese (1-12): ");
        int mese = scanner.nextInt();

        switch (mese) {
            case 1: System.out.println("Gennaio ha 31 giorni."); break;
            case 2: System.out.println("Febbraio ha 28 giorni."); break;
            case 3: System.out.println("Marzo ha 31 giorni."); break;
            case 4: System.out.println("Aprile ha 30 giorni."); break;
            case 5: System.out.println("Maggio ha 31 giorni."); break;
            case 6: System.out.println("Giugno ha 30 giorni."); break;
            case 7: System.out.println("Luglio ha 31 giorni."); break;
            case 8: System.out.println("Agosto ha 31 giorni."); break;
            case 9: System.out.println("Settembre ha 30 giorni."); break;
            case 10: System.out.println("Ottobre ha 31 giorni."); break;
            case 11: System.out.println("Novembre ha 30 giorni."); break;
            case 12: System.out.println("Dicembre ha 31 giorni."); break;
            default: System.out.println("Mese non valido.");
        }
    }
}
