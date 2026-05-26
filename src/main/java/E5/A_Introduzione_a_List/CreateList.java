package E5.A_Introduzione_a_List;

import java.util.ArrayList;
import java.util.List;

public class CreateList {
    public static void main() {
        System.out.println("1. Creazione di una lista di stringhe. ----------------");
        List<String> nomi = new ArrayList<>();
        nomi.add("Niels1");
        nomi.add("Niels2");
        nomi.add("Niels3");
        nomi.add("Niels4");
        Schermo(nomi);
        System.out.println("2. Accesso tramite indice");
        if (nomi.size() > 2){
            System.out.println(nomi.get(3));
        }else {
            System.out.println("La lista non contiene almeno tre elementi.");
        }
        System.out.println("3. Modifica di un elemento. ---------------------------");
        nomi.set(1,"Juan");
        Schermo(nomi);
        System.out.println("4. Rimozione di un elemento. --------------------------");
        nomi.remove(nomi.size()-1);
        Schermo(nomi);

        System.out.println("5. System.out.println ---------------------------------");
        System.out.println("La lista contiene " + nomi.size() + " elementi.");
    }

    public static void Schermo(List<String> nomi){
        for (String nome : nomi) {
            System.out.println(nome);
        }
    }
}
