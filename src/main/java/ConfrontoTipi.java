public class ConfrontoTipi {
    public static void main(String[] args) {
        int x = 5;
        String y = "5";
        System.out.println("int: " + x);
        System.out.println("String: " + y);
    }
}
/*
 'int x' è un tipo primitivo (salva direttamente il valore puro nello stack,
 occupa meno memoria e non ha metodi). 'String y' è un oggetto/riferimento (punta a
 un'area di memoria nell'heap, ha metodi complessi ed è gestito come classe).
*/
