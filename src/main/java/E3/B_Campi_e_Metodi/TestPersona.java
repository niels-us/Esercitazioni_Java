package E3.B_Campi_e_Metodi;

public class TestPersona {
    public static void main() {
        Persona obj1 = new Persona();
        Persona obj2 = new Persona();

        obj1.nome = "Paolo Rossi"; obj1.eta = 20;
        obj2.nome = "Mario Rossi"; obj2.eta = 30;

        System.out.println("--- Dati Oggetto 1 (obj1) ---");
        System.out.println("Nome: " + obj1.nome);
        System.out.println("Età: " + obj1.eta);

        System.out.println("--- Dati Oggetto 2 (obj2) ---");
        System.out.println("Nome: " + obj2.nome);
        System.out.println("Età: " + obj2.eta);

        System.out.println("--- Età iniziali ---");
        System.out.println(obj1.nome + " ha " + obj1.eta + " anni.");
        System.out.println(obj2.nome + " ha " + obj2.eta + " anni.");

        System.out.println("--- Invocazione dei metodi ---");
        obj1.invecchia();

        System.out.println("--- Dopo aver chiamato invecchia() su " + obj1.nome + " ---");
        System.out.println(obj1.nome + " ha ora " + obj1.eta + " anni.");
        System.out.println(obj2.nome + " ha ancora " + obj2.eta + " anni.");

        obj1.saluta();
        obj2.saluta();

        /*
         * * 1. VARIABILE LOCALE (es. String nome = "Mario Locale";):
         * - Viene dichiarata ALL'INTERNO di un metodo.
         * - Esiste e inietta memoria solo durante l'esecuzione di quel metodo (ha "scope" locale).
         * - Non appartiene all'oggetto, ma solo al blocco di codice in cui si trova.
         * - Se ha lo stesso nome di un campo, lo "nasconde" (shadowing).
         * * 2. CAMPO DELL'OGGETTO / VARIABILE DI ISTANZA (es. this.nome):
         * - Viene dichiarato all'interno della classe ma FUORI dai metodi.
         * - Rappresenta lo stato o una caratteristica permanente dell'oggetto.
         * - Vive in memoria finché l'oggetto stesso esiste nell'Heap.
         * - Per accedervi esplicitamente quando c'è un conflitto di nomi, si usa 'this.nome',
         * dove 'this' indica l'istanza corrente che ha invocato il metodo.
         */
    }
}
