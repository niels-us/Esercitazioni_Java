package E2;

public class TipiFissi {
    public static void main(String[] args) {
        int numero = 10;
        // Errore di compilazione se decommentato:
         //numero = "Ciao";

        /*
         * MESSAGGIO D'ERRORE TIPICO DEL COMPILATORE:
         * "java: incompatible types: java.lang.String cannot be converted to int"
         *
         * SPIEGAZIONE TIPIZZAZIONE STATICA:
         * Java è un linguaggio a tipizzazione statica. Significa che il tipo di una variabile
         * viene determinato al momento della compilazione e non può cambiare durante l'esecuzione.
         * Una variabile dichiarata come int potrà memorizzare SOLO numeri interi.
         */
    }
}
