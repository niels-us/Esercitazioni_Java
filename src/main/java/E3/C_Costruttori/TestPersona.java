package E3.C_Costruttori;

public class TestPersona {
    public static void main() {
        System.out.println("--- Creazione oggetto con Costruttore Parametrizzato ---");
        // Creazione e inizializzazione immediata in una sola riga!
        Persona obj1 = new Persona("Paolo Rossi 1", 10);
        Persona obj2 = new Persona();

        // Stampa dei campi per verificare che l'inizializzazione sia avvenuta correttamente
        System.out.println("Oggetto creato correttamente:");
        System.out.println("Nome: " + obj1.nome);
        System.out.println("Età: " + obj1.eta);

        // Verifica del funzionamento del metodo saluta() con il nuovo oggetto
        System.out.println("Oggetto p1 (Costruttore parametrizzato):");
        obj1.saluta();
        System.out.println("Oggetto p2 (Costruttore senza parametri):");
        obj2.saluta();

        /*
          COMMENTO SULLA DIFFERENZA (Overloading):
          * 1. Il compilatore Java capisce quale costruttore richiamare tramite la "firma"
          del costruttore (cioè il numero e il tipo di argomenti passati).
          * 2. Con 'new Persona("Paolo Rossi", 20)', indichiamo a Java di mappare i dati
          personalizzati direttamente dentro i campi dell'oggetto 'p1' al momento della nascita.
          * 3. Con 'new Persona()', sfruttiamo l'overloading per creare l'oggetto 'p2' in uno
          stato iniziale sicuro e predefinito ("Sconosciuto", 0), utile quando non conosciamo
          ancora i dettagli della persona ma abbiamo comunque bisogno di generare l'istanza.
         */

        /*java: constructor Persona in class E3.C_Costruttori.Persona cannot be applied to given types;
        required: java.lang.String,int
        found:    no arguments
        reason: actual and formal argument lists differ in length*/
    }
}
