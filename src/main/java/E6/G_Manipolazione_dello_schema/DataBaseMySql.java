package E6.G_Manipolazione_dello_schema;

public class DataBaseMySql {
    static void main() {
        /* 31. Aggiungere una colonna
         ALTER TABLE studenti
            ADD telefono VARCHAR(20);
        */
        /* 32. Rimuovere una colonna
         ALTER TABLE studenti
            DROP telefono VARCHAR(20);
        */
        /* 33. Aggiungere un vincolo dopo la creazione
         ALTER TABLE prodotti
            ADD CONSTRAINT fk_prodotti_categorie
            FOREIGN KEY (categoria_id) REFERENCES categorie(categoria_id);
         */
       /* 34. Rimuovere un vincolo
           ALTER TABLE prodotti
            DROP FOREIGN KEY fk_prodotti_categorie;
       */
        /* 35. Rinominare una tabella
         ALTER TABLE clienti
            RENAME TO persone;
        */
    }
}
