package E4.C_Polimorfismo;

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
