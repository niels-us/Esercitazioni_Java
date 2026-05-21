package E3.A_Classe_base;

public class TestPersona {
    public static void main() {
        Persona obj1 = new Persona();
        Persona obj2 = new Persona();

        obj1.nome = "Paolo Rossi"; obj1.eta = 20;
        obj2.nome = "Mario Rossi"; obj2.eta = 30;

        System.out.println("--- Dati Oggetto 1 (obj1) ---");
        System.out.println("Nome: " + obj1.nome);
        System.out.println("Età: " + obj1.eta);

        System.out.println("--- Dati Oggetto 2 (obj2) ---");
        System.out.println("Nome: " + obj2.nome);
        System.out.println("Età: " + obj2.eta);

        obj1.saluta();
        obj2.saluta();
    }
}
