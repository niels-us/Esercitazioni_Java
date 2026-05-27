package E6.H_Progetti_relazionali_integrati;

public class DataBaseMySql {
    static void main() {
        /* 36. Schema “Blog”
        CREATE TABLE autori (
            autore_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE
         );
        CREATE TABLE articoli (
            articolo_id INT PRIMARY KEY,
            titolo VARCHAR(150) NOT NULL,
            contenuto TEXT NOT NULL,
            data_pubblicazione DATETIME DEFAULT CURRENT_TIMESTAMP,
            autore_fk INT,
            FOREIGN KEY (autore_fk) REFERENCES autori(autore_id)
         );
        */
        /* 37. Schema “Università”
         CREATE TABLE docenti (
            docente_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE
         );

        CREATE TABLE corsi (
            corso_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            docente_id INT,
            FOREIGN KEY (docente_id) REFERENCES docenti(docente_id)
        );

        CREATE TABLE studenti (
            studente_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE
        );

        CREATE TABLE iscrizioni (
            studente_id INT,
            corso_id INT,
            data_iscrizione DATE DEFAULT CURRENT_DATE,
            PRIMARY KEY (studente_id, corso_id),
            FOREIGN KEY (studente_id) REFERENCES studenti(studente_id),
            FOREIGN KEY (corso_id) REFERENCES corsi(corso_id)
        );

        */
        /* 38. Schema “Biblioteca”
         CREATE TABLE autori (
            autori_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE
         );

        CREATE TABLE libri (
            libri_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            autori_id INT,
            FOREIGN KEY (autori_id) REFERENCES autori(autori_id)
        );

        CREATE TABLE prestiti (
            studente_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE,
            libri_id INT,
            FOREIGN KEY (libri_id) REFERENCES libri(libri_id)
        );
         */
       /* 39. Schema “Negozio online”
         CREATE TABLE clienti (
            clienti_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE
         );

        CREATE TABLE ordini (
            ordini_id INT PRIMARY KEY,
            data_ordine DATETIME DEFAULT CURRENT_TIMESTAMP,,
            clienti_id INT NOT NULL,
            FOREIGN KEY (clienti_id) REFERENCES clienti(clienti_id)
        );

        CREATE TABLE prodotti (
            prodotti_id INT PRIMARY KEY,
            nome VARCHAR(100) NOT NULL,
            prezzo DECIMAL(10,2) NOT NULL
        );

        CREATE TABLE dettagli_ordine (
            dettagli_ordine_id INT,
            prodotti_id INT,
            quantita INT NOT NULL,
            prezzo_unitario DECIMAL(10,2) NOT NULL,
            PRIMARY KEY (dettagli_ordine_id, prodotti_id),
            FOREIGN KEY (dettagli_ordine_id) REFERENCES ordini(dettagli_ordine_id),
            FOREIGN KEY (prodotti_id) REFERENCES prodotti(prodotti_id)
        );
       */
        /* 40. Verifica finale – integrità e coerenza
            La chiave primaria identifica in modo univoco ogni record.
            La chiave esterna collega tabelle diverse e la FOREIGN KEY evita riferimenti inesistenti.
            I vincoli servono a mantenere i dati corretti e coerenti.
        */
    }
}
