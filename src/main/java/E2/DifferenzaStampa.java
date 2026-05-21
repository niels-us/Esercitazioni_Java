package E2;

public class DifferenzaStampa {
    public static void main(String[] args) {
        // System.out.print() non va a capo a fine messaggio
        System.out.print("Messaggio A - ");
        System.out.print("Messaggio B ");

        // System.out.println() va a capo dopo aver stampato
        System.out.println("[Fine prima riga]");
        System.out.println("Messaggio C (Nuova riga)");
        System.out.println("Messaggio D (Altra riga)");
    }
}
