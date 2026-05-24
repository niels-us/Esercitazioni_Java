package E4.A_Fondamenti_dellEreditarieta;

public class TestPersona {
    public static void main() {
        Persona persona = new Persona("Mario",20);
        Studente studente = new Studente("Valerio",18, "Math");
        StudenteLavoratore studenteLavoratore = new StudenteLavoratore("Percy",25, "Len", 1500.00);
        persona.presentati();
        studente.studia();
        studenteLavoratore.lavora();
    }
}