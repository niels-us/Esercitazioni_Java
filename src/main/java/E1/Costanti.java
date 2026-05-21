package E1;

public class Costanti {
    public static void main(String[] args) {
        final double PI = 3.14159;
        // LINEA ERRONEA (Decommentare per vedere l'errore del compilatore):
        //PI = 3.14; // Errore: impossibile assegnare un valore a una variabile finale
    }
}
/*
 java: cannot assign a value to final variable PI
 La parola chiave 'final' rende la variabile una costante. Una volta
 assegnato il primo valore, questo non può più essere modificato durante l'esecuzione.
*/
