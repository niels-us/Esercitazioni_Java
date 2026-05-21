package E3.C_Costruttori;

public class Persona {
    public String nome;
    public int eta;

    // COSTRUTTORE 1 DI BASE (PARAMETRIZZATO)
    public Persona(String nome, int eta) {
        this.nome = nome; // Assegna il parametro 'nome' al campo 'this.nome'
        this.eta = eta;   // Assegna il parametro 'eta' al campo 'this.eta'
        saluta(); // INVOCAZIONE AUTOMATICA: L'oggetto saluta appena viene creato
    }

    // COSTRUTTORE 1 DI BASE (NON PARAMETRIZZATO)
    public Persona() {
        this.nome = "Sconosciuto";
        this.eta = 0;
    }

    public void saluta() {
        System.out.println("Ciao, il mio nome è " + this.nome + " e ho " + this.eta + " anni.");
    }
}
