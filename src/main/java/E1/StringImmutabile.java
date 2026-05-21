package E1;

public class StringImmutabile {
    public static void main(String[] args) {
        String original = "Ciao";
        String modificata = original + " Mondo";
        System.out.println(modificata);
    }
}
/*
 Le stringhe in Java sono immutabili. Quando facciamo 'saluto + " Mondo"',
 l'oggetto "Ciao" originale rimane intatto in memoria; viene creato un oggetto
 String completamente nuovo con il valore combinato.
*/