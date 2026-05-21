package E2;

import java.util.Scanner;

public class Profilo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Età: ");
        int eta = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Città: ");
        String citta = scanner.nextLine();
        System.out.print("Ami Java? (true/false): ");
        boolean amaJava = scanner.nextBoolean();

        String rispJava = amaJava ? "ama" : "non ama";
        System.out.println(nome + " di " + eta + " anni vive a " + citta + " e " + rispJava + " Java.");
    }
}
