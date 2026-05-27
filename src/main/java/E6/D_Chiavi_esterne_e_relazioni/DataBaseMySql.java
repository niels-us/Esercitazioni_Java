package E6.D_Chiavi_esterne_e_relazioni;

public class DataBaseMySql {
    static void main() {
        /* 16. Relazione uno-a-molti
          CREATE TABLE categorie(
            categorie_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL
           );
          CREATE TABLE prodotti(
            prodotti_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            prezzo DECIMAL(10,2) NOT NULL,
            categorie_id INT,
            FOREIGN KEY (categorie_id) REFERENCES categorie(categorie_id)
           );
        */
        /* 17. Inserimento incoerente
          INSERT INTO prodotti (prodotti_id, nome, prezzo, categoria_id) VALUES (1, 'Mouse', 19.99, 99);
            Error
            consulta SQL: Copiar
            MySQL ha dicho: Documentación
            #1054 - La columna 'categoria_id' en field list es desconocida
        */
        /* 18. Integrità referenziale
            L’integrità referenziale è la regola che garantisce che un valore di chiave esterna (FOREIGN KEY)
                esista davvero nella tabella a cui fa riferimento.
            In pratica, evita dati incoerenti tra tabelle collegate: non puoi inserire un record che punti a
                un record inesistente.
         */

       /* 19. Cancellazione vietata
          CREATE TABLE categorie_vietata(
            categorie_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL
           );
          CREATE TABLE prodotti_vietata(
            prodotti_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            prezzo DECIMAL(10,2) NOT NULL,
            categorie_id INT,
            FOREIGN KEY (categorie_id) REFERENCES categorie(categorie_id) ON DELETE RESTRICT
           );
       */

        /* 20. Cancellazione a cascata
          CREATE TABLE categorie_cascata(
            categorie_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL
           );
          CREATE TABLE prodotti_cascata(
            prodotti_id INT PRIMARY KEY,
            nome VARCHAR(50) NOT NULL,
            prezzo DECIMAL(10,2) NOT NULL,
            categorie_id INT,
            FOREIGN KEY (categorie_id) REFERENCES categorie(categorie_id) ON DELETE CASCADE
           );
        */
    }
}
