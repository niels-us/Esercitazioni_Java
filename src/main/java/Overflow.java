public class Overflow {
    public static void main(String[] args) {
        byte b = 127;
        b = (byte)(b + 1);
        System.out.println("Risultato: " + b); // Output: -128
    }
}
/*
 L'overflow si verifica quando un calcolo supera il valore massimo
 rappresentabile dal tipo. In Java, il valore "ruota" ricominciando dal limite minimo.
*/