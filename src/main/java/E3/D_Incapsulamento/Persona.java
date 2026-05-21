package E3.D_Incapsulamento;

public class Persona {
    private String nome;
    private int eta;

    // COSTRUTTORE 1 DI BASE (PARAMETRIZZATO)
    public Persona(String nome, int eta) {
        this.nome = nome; // Assegna il parametro 'nome' al campo 'this.nome'
        this.eta = eta;   // Assegna il parametro 'eta' al campo 'this.eta'
    }

    // COSTRUTTORE 1 DI BASE (NON PARAMETRIZZATO)
    public Persona() {
        this.nome = "Sconosciuto";
        this.eta = 0;
    }

    // METODO SETTER: Permette di modificare il campo privato 'eta' in sicurezza
    public void setEta(int nuovaEta) {
        if (nuovaEta < 0) {
            System.out.println("No poso esere un numero negativo(" + nuovaEta + ")!");
            return;
        }
        this.eta = nuovaEta; // Assegna il valore ricevuto come parametro al campo dell'oggetto
    }

    public int getEta() {
        return this.eta; // Assegna il valore ricevuto come parametro al campo dell'oggetto
    }

    public void setNome(String nuovaNome) {
        this.nome = nuovaNome; // Assegna il valore ricevuto come parametro al campo dell'oggetto
    }

    public String getNome() {
        return this.nome; // Assegna il valore ricevuto come parametro al campo dell'oggetto
    }

    public void saluta() {
        System.out.println("Ciao, il mio nome è " + this.nome + " e ho " + this.eta + " anni.");
    }
}
