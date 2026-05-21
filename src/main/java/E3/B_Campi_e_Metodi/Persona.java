package E3.B_Campi_e_Metodi;

public class Persona {
    public String nome;
    public int eta;

    public void saluta() {
        String nome = "Mario Local";
        System.out.println("Variabile locale 'nome': " + nome);
        System.out.println("Campo dell'oggetto 'this.nome': " + this.nome);
    }

    public void invecchia() {
        eta++;
    }
}
