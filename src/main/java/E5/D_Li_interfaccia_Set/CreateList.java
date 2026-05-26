package E5.D_Li_interfaccia_Set;

import java.util.*;

public class CreateList {
    public static void main() {
        System.out.println("16. Creazione di un HashSet ------------------------------");
        Set<Integer> numeri = new HashSet<>();
        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        numeri.add(3);
        System.out.println(numeri);
        System.out.println("17. Verifica della presenza di un elemento nel Set -------");
        if (numeri.contains(4)) {
            System.out.println("Si ce lo");
        } else {
            System.out.println("Non ce lo");
        }
        System.out.println("18. Iterazione su un Set --------------------------------");
        for(Integer numero:numeri) System.out.println(numero);
        System.out.println("19. Conversione Set in List -----------------------------");
        List<Integer> lista = new ArrayList<>(numeri);
        Schermo(lista);
        System.out.println("20. Differenza tra HashSet e TreeSet --------------------");
        Set<Integer> hashSet = new HashSet<>();
        Set<Integer> treeSet = new TreeSet<>();

        int[] valori = {5, 12, 8, 3, 12, 5, 9, 1};

        for (int valore : valori) {
            hashSet.add(valore);
            treeSet.add(valore);
        }

        System.out.println("HashSet: " + hashSet);
        System.out.println("TreeSet: " + treeSet);


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
