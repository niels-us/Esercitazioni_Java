package E5.G_finally_e_try_with_resources;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateList {
    public static void main() {
        System.out.println("31. Uso del blocco finally -----------------------------------");
        try {
            File file = new File("C:/Users/ruti_/OneDrive/Escritorio/Listbox para cargar nuevos filtros.txt");
            Scanner scannerFile = new Scanner(file);
            while (scannerFile.hasNextLine()) {
                System.out.println(scannerFile.nextLine());
            }
            scannerFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("Errore: il file non è stato trovato.");
        }finally {
            System.out.println("Chiusura risorse completata.");
        }
        System.out.println("32. Chiusura manuale delle risorse ----------------------------");
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(new File("C:/Users/ruti_/OneDrive/Escritorio/Listbox para cargar nuevos filtros.txt"));
            while (fileScanner.hasNextLine()) {
                System.out.println(fileScanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Errore: file non trovato.");
        } finally {
            if (fileScanner != null) {
                fileScanner.close();
            }
        }
        System.out.println("33. Gestione automatica con try-with-resources ----------------");

    }
}
