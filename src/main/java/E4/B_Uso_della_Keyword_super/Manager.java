package E4.B_Uso_della_Keyword_super;

public class Manager extends Impiegato{
    private double bonus;

    // Il costruttore richiede i dati per la superclasse + il bonus specifico
    public Manager(String nome, int eta, double stipendioBase, double bonus) {
        super(nome, eta, stipendioBase); // Passa nome e stipendio base a Impiegato
        this.bonus = bonus;
    }

    // Setter per aggiornare il bonus in base alle performance
    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    // SOVRASCRITTURA PARZIALE: Estendiamo il calcolo dello stipendio
    @Override
    public double getSalary() {
        return super.getSalary() + this.bonus;
    }
}
