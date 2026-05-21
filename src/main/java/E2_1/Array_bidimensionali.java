package E2_1;

import java.util.Scanner;

public class Array_bidimensionali {
    public static void main() {
        System.out.println("Chiedi all’utente di inserire i valori di una matrice 3x3.");
        Scanner scanner = new Scanner(System.in);
        int[][] matrice = new int[4][4];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                System.out.print("Inserisci valore per posizione [" + r + "][" + c + "]: ");
                matrice[r][c] = scanner.nextInt();
            }
        }
        System.out.println("La matrice 4x4 inserita:");
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                System.out.print(matrice[r][c] + "\t");
            }
            System.out.println();
        }

        System.out.println("Somma totale matrice:");
        int somma = 0;
        for (int r = 0; r < matrice.length; r++) {
            for (int c = 0; c < matrice[r].length; c++) {
                somma += matrice[r][c];
            }
        }
        System.out.println("La somma di tutti gli elementi della matrice è: " + somma);

        System.out.print("Elementi della diagonale principale: ");
        for (int i = 0; i < 4; i++) {
            System.out.print(matrice[i][i] + " ");
        }
        System.out.println();

        System.out.println(("Trasposizione di matrice: "));
        scanner = new Scanner(System.in);
        int[][] origine = new int[2][3];
        int[][] trasposta = new int[3][2];

        System.out.println("Inserimento elementi matrice 2x3:");
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print("Posizione [" + r + "][" + c + "]: ");
                origine[r][c] = scanner.nextInt();
            }
        }
        // Stampa matrice 2x3
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                System.out.print(origine[r][c] + "\t");
            }
            System.out.println();
        }
        // Esecuzione trasposizione: Crea la matrice trasposta (3x2).
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 3; c++) {
                trasposta[c][r] = origine[r][c];
            }
        }
        // Stampa trasposta.
        System.out.println("Matrice trasposta risultante (3x2):");
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 2; c++) {
                System.out.print(trasposta[r][c] + "\t");
            }
            System.out.println();
        }

        System.out.println("Massimo in matrice: ");
        int max = matrice[0][0];
        for (int r = 0; r < 4; r++) {
            for (int c = 0; c < 4; c++) {
                if (matrice[r][c] > max) {
                    max = matrice[r][c];
                }
            }
        }

        System.out.println("Il valore massimo presente nella matrice è: " + max);
        scanner.close();
    }
}
