package E4.A_Fondamenti_dellEreditarieta;

public class StudenteLavoratore extends Studente {
    private double stipendio;

    public StudenteLavoratore(String nome, int eta, String corsoDiStudio, double stipendio) {
        super(nome, eta, corsoDiStudio);
        this.stipendio = stipendio;
    }

    public double getStipendio() {
        return this.stipendio;
    }

    public void lavora() {
        System.out.println(getNome() + " sta lavorando e guadagna " + stipendio + " euro.");
    }
}
