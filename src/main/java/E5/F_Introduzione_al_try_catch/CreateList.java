package E5.F_Introduzione_al_try_catch;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class CreateList {
    public static void main() {
        System.out.println("26. Gestione della divisione per zero ------------------------");
        Set<Integer> numeri = new HashSet<>();
        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        numeri.add(4);
        System.out.println(numeri);
        numeri.removeIf(n -> n < 5);
        System.out.println(numeri);
        System.out.println("22. Set di parole uniche --------------------------------");
        Set<String> nomi = new HashSet<>();
        String nome = "";
        while (!nome.equals("fine")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisce un nome o fine per uscire: ");
            nome = scanner.nextLine();
            if (!nome.equals("fine")) nomi.add(nome);
        }
        System.out.println(nomi.size());
        System.out.println("23. Intersezione tra Set --------------------------------");
        Set<Integer> numeriA = new HashSet<>();
        numeriA.add(1);
        numeriA.add(2);
        Set<Integer> numeriB = new HashSet<>();
        numeriB.add(1);
        numeriB.add(2);
        Set<Integer> comuniA = new HashSet<>(numeriA);
        comuniA.retainAll(numeriB);
        System.out.println(comuniA);
        System.out.println("24. Unione di Set ---------------------------------------");
        Set<String> nomeA = new HashSet<>();
        nomeA.add("Juan");
        nomeA.add("Pedro");
        Set<String> nomeB = new HashSet<>();
        nomeB.add("Juan");
        nomeB.add("Pedro");
        Set<String> comuniB = new HashSet<>(nomeA);
        comuniB.addAll(nomeB);
        System.out.println(comuniB);
        System.out.println("25. Differenza tra Set ---------------------------------");
        //Usare due set di interi numeriA e numeriB
        System.out.println(numeriA);
        System.out.println(numeriB);
        numeriA.removeAll(numeriB);
        System.out.println(numeriA);









    }

    public static <T> void Schermo(List<T> Lista) {
        for (T elemento : Lista) {
            System.out.println(elemento);
        }
    }

    public static int SommaTutti(List<Integer> Lista) {
        int accu = 0;
        for (int elemento : Lista) {
            accu += elemento;
        }
        return accu;
    }

    public static void RemovePar(List<Integer> Lista) {
        for (int X = 0; X < Lista.size(); X++) {
            if (Lista.get(X) % 2 != 0) {
                Lista.remove(X);
            }
        }
    }

    public static void MediaNum(List<Integer> Lista) {
        int somma = 0;
        for (int X = 0; X < Lista.size(); X++) {
            somma += Lista.get(X);
        }
        System.out.println("Le Medie: " + somma / Lista.size());
    }
}
