package E1;

public class Conversioni {
    public static void main(String[] args) {
        int a = 5;
        double b = a; // Implicita (widening)

        int c = (int) b; // Esplicita (narrowing cast)

        System.out.println("int a: " + a);
        System.out.println("double b (da int): " + b);
        System.out.println("int c (da double): " + c);
    }
}
/*
 La conversione implicita avviene automaticamente da un tipo più piccolo
 a uno più grande senza perdita di dati. Quella esplicita richiede il cast manuale
 perché potrebbe causare perdita di precisione (troncamento dei decimali).
*/
