public class MetodoMain {
    public static void main(String[] args) {
        System.out.println("Esecuzione avviata");
        Inizia();
    }

    public static void Inizia(){
        System.out.println("Inizio de Sistemi");
    }
}

/*
 'static' significa che il metodo appartiene alla classe e non a una sua
 istanza. È necessario nel main perché la JVM deve poter avviare il programma
 senza dover prima creare un oggetto della classe.
*/