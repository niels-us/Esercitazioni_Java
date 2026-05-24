package E4.B_Uso_della_Keyword_super;

public class TestPersona {
    public static void main() {
        Persona persona = new Persona("Mario",20);
        Studente studente1 = new Studente("Valerio",18, "Math");
        StudenteLavoratore studenteLavoratore = new StudenteLavoratore("Percy",25, "Len", 1500.00);
        Studente studente2 = new Studente("Jose",18, "Inf");
        Impiegato impiegato = new Impiegato("Juan",26,1500);
        Manager manager = new Manager("Luis",35,1500,500);

        persona.presentati();
        studente1.studia();
        studenteLavoratore.lavora();
        studente2.presentati();

        System.out.println("Impiegato Salary: " + impiegato.getSalary());
        System.out.println("Manager Salary + Bonnus: " + manager.getSalary());

    }
}