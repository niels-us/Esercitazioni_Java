package E6.B_Creare_e_definire_tabelle;

public class DataBaseMySql {
    static void main() {
        /* 6. Creazione di una tabella base
         CREATE TABLE studenti(
          studente_id INT PRIMARY KEY,
          nome VARCHAR(50),
          email VARCHAR(100)
          );
         * /

        /*7. Imporre la non nullità
          CREATE TABLE studenti(
          studente_id INT PRIMARY KEY,
          nome VARCHAR(50) NOT NULL,
          email VARCHAR(100) NOT NULL
          );
         */

        /* 8. Vincolo UNIQUE
          CREATE TABLE studenti(
          studente_id INT PRIMARY KEY,
          nome VARCHAR(50) NOT NULL,
          email VARCHAR(100) NOT NULL UNIQUE
          );
         */

       /* 9. Tipi di dato appropriati
          CREATE TABLE prodotti (
          id INT PRIMARY KEY,
          nome VARCHAR(50) NOT NULL,
          prezzo DECIMAL(10,2) NOT NULL,
          descrizione VARCHAR(100)
          );
        */

        /*  10. Valori di default
          CREATE TABLE ordini (
          id INT PRIMARY KEY,
          data_ordine DATETIME,
          nome VARCHAR(50) NOT NULL,
          prezzo DECIMAL(10,2) NOT NULL,
          descrizione VARCHAR(100)
          );
        */


    }
}
