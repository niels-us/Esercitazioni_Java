package E4.C_Polimorfismo;

public class Persona {
    protected String nome;
    protected int eta;

    //Costructor
    public Persona(String nome, int eta) {
        this.nome= nome;
        this.eta=eta;
        System.out.println("Costructore Persona");
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
    public void studia() { System.out.println(nome + " sta imparando qualcosa di nuovo."); }
}
