package E3.E_Combinare_costruttore_e_incapsulamento;

public class TestPersona {
    public static void main() {
        System.out.println("--- Creazione oggetto con Costruttore Parametrizzato ---");
        E3.E_Combinare_costruttore_e_incapsulamento.Persona obj1 = new Persona("Pietro Rossi 1", -10, true);
        E3.E_Combinare_costruttore_e_incapsulamento.Persona obj2 = new Persona("Marco Rossi 2", 10, true);

        System.out.println("--- Verifichiamo se l'età è cambiata richiamando saluta() ---");
        obj1.saluta();
        obj2.saluta();

        obj1.setIsOnline(false);
    }
}