package E4.A_Fondamenti_dellEreditarieta;

public class Persona {
    protected String nome;
    protected int eta;

    //Costructor
    public Persona(String nome, int eta) {
        this.nome= nome;
        this.eta=eta;
    }

    public String getNome() {
        return this.nome;
    }

    public int getEta() {
        return this.eta;

    }

    public void presentati() {
        System.out.println("Ciao, sono " + nome + ", ho " + eta + " anni.");
    }
}
