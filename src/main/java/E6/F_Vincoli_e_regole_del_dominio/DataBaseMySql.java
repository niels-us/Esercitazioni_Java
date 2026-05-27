package E6.F_Vincoli_e_regole_del_dominio;

public class DataBaseMySql {
    static void main() {
        /* 26. Vincolo NOT NULL
          CREATE TABLE dipendenti (
            nome VARCHAR(50) NOT NULL,
            cognome VARCHAR(50) NOT NULL
           );
        */
        /* 27. Vincolo UNIQUE multiplo
          CREATE TABLE fornitori   (
            fornitore_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            citta VARCHAR(50) NOT NULL,
            UNIQUE (nome, citta)
           );
        */
        /* 28. Vincolo CHECK
          CREATE TABLE stipendi  (
            stipendio_id INT PRIMARY KEY,
            importo DECIMAL(10,2) NOT NULL,
            CHECK (importo > 1000)
           );
         */

       /* 29. Vincolo DEFAULT su testo
           CREATE TABLE utenti_registrati (
            stato VARCHAR(20),
            DEFAULT (attivo)
           );
       */

        /* 25. Tipi di dato misti
          CREATE TABLE utenti_registrati (
            utente_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            stato VARCHAR(20) DEFAULT 'attivo'
          );
        */

        /* 30. Vincoli combinati
        CREATE TABLE prenotazioni (
            prenotazione_id INT PRIMARY KEY,
            cliente VARCHAR(50) NOT NULL,
            data_prenotazione DATE NOT NULL,
            stato VARCHAR(20) DEFAULT 'in attesa',
            numero_persone INT CHECK (numero_persone > 0)
        );
        */
    }
}
