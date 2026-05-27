package E6.A_Comprendere_il_modello_relazionale;

public class DataBaseMySql {
    static void main() {
        /* 1. Persistenza dei dati
         * dati in RAM sono temporanei: restano disponibili solo mentre il programma
         * è in esecuzione e si perdono quando il programma si chiude o il computer si spegne.
         * dati in un database sono persistenti: vengono salvati su disco e restano
         * disponibili anche dopo la chiusura del programma. In più, un database permette di
         * gestire grandi quantità di dati in modo più strutturato e sicuro.
         * /

        /*2. Rappresentare un’entità reale
         * Dominio: biblioteca
         * Tabella significativa: Libro
         * Attributi: id_libro  titolo  autore  isbn anno_pubblicazione genere copie_disponibili
         * Questa tabella rappresenta un’entità reale centrale in una biblioteca, perché contiene
         * i dati essenziali per identificare e gestire ogni libro.
         */

        /* 3. Identificare chiavi e attributi
         * Per la tabella Libro, la colonna più adatta come chiave primaria è id_libro.
         * Perché identifica ogni libro in modo univoco, non si ripete tra record diversi
         * è stabile e non cambia nel tempo, a differenza di campi come titolo o autore
         * L’ISBN potrebbe anche sembrare un buon candidato, ma id_libro è in genere migliore
         *  perché è un identificatore interno, sempre sotto controllo del database.
         */

       /* 4. Tabella concettuale
        Ecco una rappresentazione schematica della tabella Libro:
        TABella: Libro

                +----------------------+---------------+
                | Colonna              | Tipo di dato  |
        +----------------------+---------------+
                | id_libro             | INT           |
                | titolo               | VARCHAR(100)  |
                | autore               | VARCHAR(100)  |
                | isbn                 | VARCHAR(20)   |
                | anno_pubblicazione   | INT           |
                | genere               | VARCHAR(50)   |
                | copie_disponibili    | INT           |
                +----------------------+---------------+
                Se vuoi, posso anche trasformarla in un vero schema SQL CREATE TABLE.
        */

        /*  5. Riflessione sui vincoli
        I vincoli servono a impedire l’inserimento di dati errati o incoerenti.•
        NOT NULL: obbliga un campo ad avere sempre un valore, quindi evita record incompleti.
        UNIQUE: impedisce duplicati in una colonna, utile per dati che devono essere distinti
                come un codice o un’email.
        PRIMARY KEY: identifica in modo univoco ogni record e combina unicità e assenza di valori nulli.
        Insieme, questi vincoli migliorano la qualità dei dati perché rendono il database più affidabile,
                 riducono gli errori e mantengono le informazioni coerenti.
        */


    }
}
