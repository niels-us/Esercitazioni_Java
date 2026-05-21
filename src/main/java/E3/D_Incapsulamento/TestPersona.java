package E3.D_Incapsulamento;

public class TestPersona {
    public static void main() {
        System.out.println("--- Creazione oggetto con Costruttore Parametrizzato ---");
        E3.D_Incapsulamento.Persona obj1 = new Persona("Paolo Rossi 1", 10);
        E3.D_Incapsulamento.Persona obj2 = new Persona();

        System.out.println("--- Stato iniziale dell'oggetto ---");
        obj1.saluta();

        System.out.println("--- Modifica dell'età tramite il metodo setEta() ---");
        obj1.setEta(-25);

        System.out.println("--- Verifichiamo se l'età è cambiata richiamando saluta() ---");
        obj1.saluta();

        // CORRETTO: Recuperiamo i valori in modo protetto tramite i Getter
        String nomeP1 = obj1.getNome();
        int etaP1 = obj1.getEta();

        System.out.println("Dati di p1 estratti singolarmente:");
        System.out.println("-> Nome: " + nomeP1);
        System.out.println("-> Età: " + etaP1);

        // Stampa diretta combinata per il secondo oggetto
        System.out.println("Dati di p2 stampati direttamente:");
        System.out.println("Il secondo oggetto si chiama " + obj1.getNome() + " e ha " + obj1.getEta() + " anni.");

        /* * PERCHÉ QUESTO PROTEGGE LO STATO DELL'OGGETTO?
         * * Se provassimo a scrivere:
         * p.eta = -50;
         * oppure
         * System.out.println(p.nome);
         * * Il compilatore Java bloccherebbe il programma con un errore: "eta has private access in Persona".
         * * Di conseguenza, l'oggetto non può subire modifiche arbitrarie o dannose dall'esterno.
         * Qualsiasi cambio di stato deve passare per il Setter, che fa da "buttafuori" e valida i dati.
         */
    }
}