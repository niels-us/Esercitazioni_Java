package E4.D_Overriding_e_annotazione_Override;

public class Director extends Manager {
    private double bonnusDirector;

    public Director(String nome, int eta, double stipendioBase, double bonus, double bonnusDirector) {
        super(nome, eta, stipendioBase, bonus);
        this.bonnusDirector = bonnusDirector;
    }

    // SOVRASCRITTURA MULTIPLA: Estendiamo ulteriormente il calcolo
    @Override
    public double getSalary() {
        double salarioManager = super.getSalary();
        System.out.println("salarioManager " + salarioManager);
        return super.getSalary() + this.bonnusDirector + salarioManager;
    }
}
