package E2;

public class Costante {
    public static void main(String[] args) {
        final double PI = 3.14159;
        // Errore di compilazione se decommentato:
        // PI = 3.14;

        /*
         * ERRORE DEL COMPILATORE:
         * "error: java: cannot assign a value to final variable PI"
         *
         * SPIEGAZIONE:
         * La parola chiave 'final' rende la variabile una costante. Una volta assegnato
         * il valore iniziale, questo non può più essere sovrascritto o modificato.
         */
        System.out.println("Il valore di PI è: " + PI);
    }
}
