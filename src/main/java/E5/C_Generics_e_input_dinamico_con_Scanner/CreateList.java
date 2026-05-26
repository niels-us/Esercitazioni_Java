package E5.C_Generics_e_input_dinamico_con_Scanner;

import java.util.*;

public class CreateList {


    public static void main() {
        System.out.println("11. Inserimento dinamico di nomi -------------------");
        List<String> nomi = new ArrayList<>();
        String nome = "";
        while (!nome.equals("stop")) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisce un nome: ");
            nome = scanner.nextLine();
            if (!nome.equals("stop")) nomi.add(nome);
        }
        Schermo(nomi);
        System.out.println("12. Media di numeri inseriti dall’utente ------------");
        List<Integer> numeri = new ArrayList<>();
        int numero = 1;
        while (numero > 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Inserisce un numero: ");
            numero = scanner.nextInt();
            if (numero > 0) numeri.add(numero);
        }
        Schermo(numeri);
        MediaNum(numeri);
        System.out.println("13. Duplicati ammessi -------------------------------");
        System.out.println("14. Ricerca di un elemento --------------------------");
        if (nomi.contains("Juan")) System.out.println("Juan ce lo " + nomi.contains("Juan"));
        System.out.println("15. Conversione da array a lista ---------------------");
        String[] Arrayfrutti = {"Mela", "Banana", "Pera"};
        System.out.println("Array: ");
        ArraySchermo(Arrayfrutti);
        System.out.println("List: ");
        List<String> listaFrutti = Arrays.asList(Arrayfrutti);
        Schermo(listaFrutti);
    }

    public static <T> void Schermo(List<T> Lista) {
        for (T elemento : Lista) {
            System.out.println(elemento);
        }
    }

    public static void ArraySchermo(String[] Lista) {
        for (String elemento : Lista) {
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
        int somma=0;
        for (int X = 0; X < Lista.size(); X++) {
            somma+=Lista.get(X);
        }
        System.out.println("Le Medie: " +  somma/Lista.size());
    }
}
