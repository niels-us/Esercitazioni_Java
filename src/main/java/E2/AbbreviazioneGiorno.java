package E2;

import java.util.Scanner;

public class AbbreviazioneGiorno {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci il giorno in minuscolo (es. lunedì): ");
        String giorno = scanner.next();

        switch (giorno) {
            case "lunedì" -> System.out.println("Lun");
            case "martedì" -> System.out.println("Mar");
            case "mercoledì" -> System.out.println("Mer");
            case "giovedì" -> System.out.println("Gio");
            case "venerdì" -> System.out.println("Ven");
            case "sabato" -> System.out.println("Sab");
            case "domenica" -> System.out.println("Dom");
            default -> System.out.println("Giorno non riconosciuto.");
        }
    }
}
