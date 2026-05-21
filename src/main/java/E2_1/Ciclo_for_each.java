package E2_1;

import java.util.Scanner;

public class Ciclo_for_each {
    public static void main() {
        int[] numeri = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.print("Elementi dell'array: ");
        for (int num : numeri) {
            System.out.println(num + " ");
        }

        System.out.println("Somma array: ");
        int count = 0;
        for (int num : numeri) {
            count = count + num;
            System.out.println(count + " ");
        }
        System.out.println("Somma tutti e " + count);

        System.out.print("Elementi pari di un array: ");
        for (int num : numeri) {
            if (num % 2 == 0) System.out.println(num + " ");
        }

        System.out.println(" Ricerca di un elemento ");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Inserisci un numero: ");
        int numero = scanner.nextInt();
        for (int num : numeri) {
            if (num == numero) {
                System.out.println(num + " Excelent si trovo il numero");
            } else {
                System.out.println(numero + " Non si trovo il numero in il array");
                break;
            }
        }

        System.out.println(" Concatena stringhe ");
        String[] parole = {"ciao ", "a ", "tutti", "."};
        StringBuilder TuttiParole = new StringBuilder();
        for (String prl : parole) {
            System.out.println(prl);
            TuttiParole.append(" ").append(prl);
        }
        System.out.println(TuttiParole);
    }
}
