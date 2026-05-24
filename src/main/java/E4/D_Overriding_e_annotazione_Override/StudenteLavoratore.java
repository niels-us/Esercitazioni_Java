package E4.D_Overriding_e_annotazione_Override;

public class StudenteLavoratore extends Studente {
    private double stipendio;

    public StudenteLavoratore(String nome, int eta, String corsoDiStudio, double stipendio) {
        super(nome, eta, corsoDiStudio);
        this.stipendio = stipendio;
        System.out.println("Costructore StudenteLavoratore");
    }

    public double getStipendio() {
        return this.stipendio;
    }

    public void lavora() {
        System.out.println(getNome() + " sta lavorando e guadagna " + stipendio + " euro.");
    }
}
