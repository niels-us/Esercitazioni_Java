package E6.C_Chiavi_primarie_e_identitA;

public class DataBaseMySql {
    static void main() {
        /* 11. Chiave primaria surrogata
         CREATE TABLE clienti (
            id INT AUTO_INCREMENT PRIMARY KEY,
         );
         * /

        /* 12. Chiave naturale
          CREATE TABLE libri (
            ISBN (VARCHAR(13)) PRIMARY KEY,
          );
         */

        /* 13. Chiave composta
          CREATE TABLE iscrizioni (
            studente_id INT,
            corso_id INT,
            PRIMARY KEY (studente_id, corso_id),
            FOREIGN KEY (studente_id) REFERENCES studenti(studente_id),
            FOREIGN KEY (corso_id) REFERENCES corsi(corso_id)
           );
         */

       /* 14. Confronto tra chiavi
          La chiave primaria surrogata è un ID creato dal database, senza significato reale, come AUTO_INCREMENT.
          La chiave naturale è un dato reale già esistente, come codice fiscale o ISBN.
          Di solito si usa la surrogata perché è più stabile e semplice da gestire. La naturale si usa solo se il
            dato è davvero unico e non cambia nel tempo.
       */

        /* 15. Test di unicità
          CREATE TABLE studenti(
            studente_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            email VARCHAR(100) NOT NULL UNIQUE
           );
          INSERT INTO studenti (studente_id, nome, email) VALUES (1, 'Anna', 'anna@mail.com');
          INSERT INTO studenti (studente_id, nome, email) VALUES (1, 'Luca', 'luca@mail.com');
          Error
            consulta SQL: Copiar
            INSERT INTO studenti (studente_id, nome, email)
            VALUES (1, 'Luca', 'luca@mail.com');
            MySQL ha dicho: Documentación
            #1062 - Entrada duplicada '1' para la clave 'PRIMARY'
        */
    }
}
