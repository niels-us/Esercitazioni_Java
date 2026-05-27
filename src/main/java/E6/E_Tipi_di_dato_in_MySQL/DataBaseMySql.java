package E6.E_Tipi_di_dato_in_MySQL;

public class DataBaseMySql {
    static void main() {
        /* 21. Tipi numerici
          CREATE TABLE magazzino (
            quantita int,
            peso DECIMAL(6,2),
            codice BIGINT
           );
        */
        /* 22. Tipi stringa
          CREATE TABLE utenti  (
            nome VARCHAR(50),
            descrizione TEXT
           );
        */
        /* 23. Tipi data e ora
          CREATE TABLE eventi (
            data_evento DATE,
            ora_inizio TIME
           );
         */

       /* 24. Timestamp automatico
           CREATE TABLE log_accessi(
            log_accessi_id INT PRIMARY KEY,
            timestamp_evento TIMESTAMP DEFAULT CURRENT_TIMESTAMP
           );
       */

        /* 25. Tipi di dato misti
          CREATE TABLE fatture (
            prodotti_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            prezzo DECIMAL(10,2) NOT NULL,
            timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP
           );
        */
    }
}
