package E4.D_Overriding_e_annotazione_Override;

public class Impiegato extends Persona {
    private double stipendioBase;

    // Costruttore
    public Impiegato(String nome, int eta, double stipendioBase) {
        super(nome, eta);
        this.stipendioBase = stipendioBase;
    }

    // Getter per il nome
    public String getNome() {
        return nome;
    }

    public double getSalary() {
        return this.stipendioBase;
    }

    public Boolean approveExpense(){
        return true;
    }
}
