package E2;

import java.util.Scanner;

public class testingNiels {
    public static void main() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("qui Hacienda es dueña de:?");
        System.out.println("Inserici 1: GPT");
        System.out.println("Inserici 2: Gemini");
        System.out.println("Inserici 3: Cloude");
        int scelta = scanner.nextInt();

        switch (scelta) {
            case 1 -> System.out.println("e OpenIA");
            case 2 -> System.out.println("e Google");
            case 3 -> System.out.println("e Antropic");
        }

        System.out.println("Buona scelta");
        System.out.println("Inizia a creare il codice");
        System.out.println("-------------------------");
    }


}