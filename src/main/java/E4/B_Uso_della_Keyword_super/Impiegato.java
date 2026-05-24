package E4.B_Uso_della_Keyword_super;

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
}
