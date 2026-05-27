package E5.F_Introduzione_al_try_catch;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class CreateList {
    public static void main() {
        System.out.println("26. Gestione della divisione per zero ------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisce un numerador A: ");
        int A = scanner.nextInt();
        System.out.print("Inserisce un denominador B: ");
        int B = scanner.nextInt();
        try {
            double result = A / B;
            System.out.println("result: " + A + "/" + B + "=" + result);
        } catch (ArithmeticException e) {
            System.out.println("Errore: impossibile dividere per zero.");
        }
        System.out.println("27. Conversione di input errato ------------------------------");
        try {
            System.out.print("Inserisce un numero: ");
            int C = scanner.nextInt();
            System.out.println(C);
        } catch (InputMismatchException e) {
            System.out.println("Errore: impossibile inserisce un String.");
        }
        System.out.println("28. Accesso a indice non valido -------------------------------");
        try {
            String[] nomi = new String[3];
            nomi[0] = "Juan";
            nomi[1] = "Juan";
            nomi[2] = "Juan";
            System.out.print("Inserisce un Indice del array: ");
            int C = scanner.nextInt();
            System.out.println("Il Array contenuto e " + nomi[C]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Errore: Indice di Array non essiste.");
        }
        System.out.println("29. File non trovato ------------------------------------------");
        try {
            File file = new File("C:/Users/ruti_/OneDrive/Escritorio/Listbox para cargar nuevos filtros.txt");
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine()) {
                System.out.println(scannerFile.nextLine());
            }
            scannerFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: il file non è stato trovato.");
        }
        System.out.println("30. Blocco multiplo di catch ----------------------------------");
        try {
            Scanner fileScanner = new Scanner(new File("C:/Users/ruti_/OneDrive/Escritorio/Listbox para cargar nuevos filtros.txt"));
            int numero = fileScanner.nextInt();
            System.out.println("Numero letto: " + numero);
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: il file non è stato trovato.");
        } catch (InputMismatchException e) {
            System.out.println("Errore: nel file non c'è un numero valido.");
        }
    }
}
