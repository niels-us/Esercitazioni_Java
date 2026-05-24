package E4.A_Fondamenti_dellEreditarieta;

public class Studente extends Persona {
    private String corsoDiStudio;

    public Studente(String nome, int eta, String corsoDiStudio) { //Costructor
        super(nome, eta); //Riuso del costruttore della superclasse
        this.corsoDiStudio = corsoDiStudio;
    }

    public void studia() {
        System.out.println( getNome() + " sta studiando " + corsoDiStudio + ".");
    }
}
