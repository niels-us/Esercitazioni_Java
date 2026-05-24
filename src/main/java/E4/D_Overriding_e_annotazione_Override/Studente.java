package E4.D_Overriding_e_annotazione_Override;

public class Studente extends Persona {
    private String corsoDiStudio;
    private String nome;

    public Studente(String nome, int eta, String corsoDiStudio) { //Costructor
        super(nome, eta); //Riuso del costruttore della superclasse
        this.corsoDiStudio = corsoDiStudio;
        this.nome= super.nome;
        System.out.println("Costructore Studente");
    }

    @Override
    public void presentati() {
        super.presentati();
        System.out.println( "Ciao, sono " + nome + ", ho " + eta + " anni." + " sta studiando " + corsoDiStudio + ".");

    }

    public void studia() {
        super.studia();
        System.out.println("Nello specifico, si sta concentrando su: " + corsoDiStudio + ".");
        //System.out.println(getNome() + " sta studiando " + corsoDiStudio + ".");
    }
}
