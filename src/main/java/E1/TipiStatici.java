package E1;

public class TipiStatici {

    public static void main(String[] args) {
        int numero = 10;
        String parola = "test";

        // LINEE ERRONEE (Decommentare per vedere l'errore del compilatore):
         //numero = "venti"; // Errore: Tipi incompatibili. String non può essere convertito in int.
         //parola = 15;      // Errore: Tipi incompatibili. int non può essere convertito in String.
    }
}
/*
 "Tipizzazione statica" significa che il tipo di una variabile viene
 determinato e verificato a tempo di compilazione (compile-time) e non può cambiare.
*/