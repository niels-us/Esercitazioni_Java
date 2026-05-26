package E5.B_Operazioni_comuni_sulle_liste;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CreateList {
    public static void main() {
        List<String> nomi = new ArrayList<>();
        nomi.add("Niels1");
        nomi.add("Juan");
        nomi.add("Niels3");
        nomi.add("Niels4");
        Schermo(nomi);

        System.out.println("6. Verifica della presenza di un elemento. ------------");
        if (nomi.contains("Juan")) {
            System.out.println("si cel lo ");
        } else {
            System.out.println("non cel lo ");
        }

        System.out.println("7. Inserimento in posizione specifica ------------------");
        nomi.add(2, "Mario");
        Schermo(nomi);

        System.out.println("8. Lista di numeri interi ------------------------------");
        List<Integer> numeri = new ArrayList<>();
        numeri.add(1);
        numeri.add(2);
        numeri.add(3);
        numeri.add(4);
        Schermo(numeri);
        System.out.println("Somma Totale: " + SommaTutti(numeri));

        System.out.println("9. Rimozione condizionale ------------------------------");
        RemovePar(numeri);
        Schermo(numeri);

        System.out.println("10. Ordinamento della lista ----------------------------");
        numeri.add(0,1);
        numeri.add(2,3);
        Schermo(numeri);
        System.out.println("Ordinamento reverse ");
        Collections.reverse(numeri);
        Schermo(numeri);
        System.out.println("Ordinamento sort ");
        Collections.sort(numeri);
        Schermo(numeri);


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
}
