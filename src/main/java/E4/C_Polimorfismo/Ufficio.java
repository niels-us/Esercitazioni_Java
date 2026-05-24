package E4.C_Polimorfismo;

public class Ufficio {
    // Questo metodo accetta la superclasse Impiegato come parametro.
    // Funzionerà con oggetti Impiegato, Manager e qualsiasi altra sottoclasse.
    public void stampaSalario(Impiegato e) {
        System.out.println("UFFICIO -> Elaborazione payroll per: " + e.getNome());

        double salarioCalcolato = e.getSalary();

        System.out.println("Stipendio erogato: " + salarioCalcolato + "€");
        System.out.println("----------------------------------------");
    }
}
