package E2_1;

import java.util.Arrays;
import java.util.Scanner;

public class Array_monodimensionali {
    public static void main() {
        System.out.println(" Inserimento numeri con Scanner");
        Scanner scanner = new Scanner(System.in);
        int[] numeri = new int[5];
        for (int i = 0; i < numeri.length; i++) {
            System.out.print("Inserisci il valore per la posizione [" + i + "]: ");
            numeri[i] = scanner.nextInt();
        }
        System.out.print("Valori memorizzati nell'array: ");
        for (int i = 0; i < numeri.length; i++) {
            System.out.print(numeri[i] + " ");
        }

        System.out.println(" Massimo e minimo in array");
        int max = numeri[0];
        int min = numeri[0];
        for (int i = 1; i < numeri.length; i++) {
            if (numeri[i] > max) max = numeri[i];
            if (numeri[i] < min) min = numeri[i];
        }
        System.out.println("Valore massimo: " + max);
        System.out.println("Valore minimo: " + min);

        System.out.println("Media dei numeri");
        int somma = 0;
        for (int i = 0; i < numeri.length; i++) {
            somma += numeri[i];
        }
        System.out.println("Valore Media: " + (somma/numeri.length));

        System.out.println("Conta quanti numeri sono maggiori di 10");
        int count = 0;
        for (int i = 0; i < numeri.length; i++) {
            if (numeri[i]>10) count++;
        }
        System.out.println("numeri maggiori di 10: " + count);

        System.out.println("Invertire un array");
        System.out.println("Originale ");
        for (int i = 0; i < numeri.length; i++) {
            System.out.print(numeri[i] + " ");
        }
        System.out.println();
        System.out.println("Invertire ");
        for (int i = numeri.length - 1; i >= 0; i--) {
            System.out.print(numeri[i] + " ");
        }
    }
}
