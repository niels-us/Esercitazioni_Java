package E1;

public class StringConfronto {
    public static void main(String[] args) {
        String a = "Java";
        String c = "Java";
        String b = new String("Java");
        System.out.println(a==c);
        System.out.println(a == b);       // Output: false
        System.out.println(a.equals(b));  // Output: true
    }
}
/*
 L'operatore '==' confronta l'indirizzo di memoria (riferimento) dei due oggetti.
 Il metodo '.equals()' confronta invece il valore effettivo (contenuto) del testo.
*/