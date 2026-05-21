package E1;

public class Concatenazione {
    int numero=15;
    public static void main(String[] args) {
        String prima = "Programmare ";
        String seconda = "in Java 2026";
        String risultato = prima + seconda;
        System.out.println(risultato);
    }
}
/*
 L'operatore '+' applicato alle stringhe genera un nuovo oggetto in memoria
 (dietro le quinte Java ottimizza questo processo usando internamente StringBuilder).
*/