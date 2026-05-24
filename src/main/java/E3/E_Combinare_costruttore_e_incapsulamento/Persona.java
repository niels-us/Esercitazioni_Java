package E3.E_Combinare_costruttore_e_incapsulamento;

public class Persona {
    private String nome;
    private int eta;
    private boolean isOnline;

    // COSTRUTTORE 1 DI BASE (PARAMETRIZZATO)
    public Persona(String nome, int eta, boolean isOnline) {
        setNome(nome); setEta(eta); setIsOnline(isOnline);
    }

    public void setEta(int Eta) { if (Eta < 0) { System.out.println("No poso esere un numero negativo(" + Eta + ")!"); return;} else {this.eta = Eta;}}
    public int getEta() { return this.eta; }

    public void setNome(String Nome) { this.nome = Nome; }
    public String getNome() { return this.nome; }

    public void setIsOnline(boolean IsOnline) { this.isOnline = IsOnline; }
    public boolean getIsOnline() { return this.isOnline; }

    public void login(){ setIsOnline(true); }
    public void logout(){ setIsOnline(false); }

    public void saluta() { System.out.println("Ciao, il mio nome è " + this.nome + " e ho " + this.eta + " anni. su stato di coneccione " + this.isOnline); }
}
