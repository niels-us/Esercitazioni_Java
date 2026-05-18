public class TipiPrimitivi {
    public static void main(String[] args) {
        byte b = 100;          // 1 byte (8 bit)    | Da -128 a 127
        short s = 20000;       // 2 bytes (16 bit)  | Da -32.768 a 32.767
        int i = 100000;        // 4 bytes (32 bit)  | Da -2 miliardi a ~2 miliardi
        long l = 5000000000L;  // 8 bytes (64 bit)  | Numeri interi molto grandi
        float f = 5.75f;       // 4 bytes (32 bit)  | Decimali a singola precisione
        double d = 19.99;      // 8 bytes (64 bit)  | Decimali a doppia precisione
        char c = 'A';          // 2 bytes (16 bit)  | Singolo carattere/Unicode
        boolean bool = true;   // 1 bit (virtuale)  | true o false

        System.out.println("Il valore di byte è: " + b);
        System.out.println("Il valore di short è: " + s);
        System.out.println("Il valore di int è: " + i);
        System.out.println("Il valore di long è: " + l);
        System.out.println("Il valore di float è: " + f);
        System.out.println("Il valore di double è: " + d);
        System.out.println("Il valore di char è: " + c);
        System.out.println("Il valore di boolean è: " + bool);
    }
}
