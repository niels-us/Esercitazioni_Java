package E4.E_Astrazione;

public class TestVeicolo {
    public static void main() {
        Veicolo mioVeicolo1 = new Auto();
        Veicolo mioVeicolo2 = new Bicicletta();
        //Veicolo mioVeicolo3 = new Veicolo(); //E4.E_Astrazione.Veicolo is abstract; cannot be instantiated

        System.out.println("--- Test Movimento ---");
        mioVeicolo1.muovi(); // Esegue la versione di Auto
        mioVeicolo2.muovi(); // Esegue la versione di Bicicletta

        System.out.println("\n--- Test Metodo Concreto ---");
        mioVeicolo1.accendiFari(); // I metodi ereditati normalmente funzionano senza problemi
        mioVeicolo1.accendiMotori(); // I metodi ereditati normalmente funzionano senza problemi

        //24. Polimorfismo con astratti
        Veicolo[] mioVeicolo3 = new Veicolo[2];

        mioVeicolo3[0] = new Auto();
        mioVeicolo3[1] = new Bicicletta();

        for (Veicolo veicolo : mioVeicolo3) {
            System.out.println(veicolo.muovi());
        }

        testVeicolo(mioVeicolo3[0]);
        testVeicolo(mioVeicolo3[1]);

    }

    public static void testVeicolo(Veicolo v) {
        System.out.println("Analisi del veicolo di tipo: " + v.getClass().getSimpleName());
        v.muovi();
        System.out.println("----------------------------------------");
    }
}
