package E4.E_Astrazione;

public abstract class Veicolo {
    public abstract boolean muovi();
    public void accendiFari() {
        System.out.println("Fari accesi.");
    }
    public void accendiMotori() {
        System.out.println("Motori accesi.");
    }
}
