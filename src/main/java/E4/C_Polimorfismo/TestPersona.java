package E4.C_Polimorfismo;

public class TestPersona {
    public static void main() {
        Persona persona = new Persona("Mario", 20);
        Studente studente1 = new Studente("Valerio", 18, "Math");
        StudenteLavoratore studenteLavoratore = new StudenteLavoratore("Percy", 25, "Len", 1500.00);
        Studente studente2 = new Studente("Jose", 18, "Inf");
        Impiegato impiegato = new Impiegato("Juan", 26, 1500);
        Manager manager = new Manager("Luis", 35, 1500, 500);
        Impiegato emp = new Manager("Martin", 30, 1400, 400);

        persona.presentati();
        studente1.studia();
        studenteLavoratore.lavora();
        studente2.presentati();

        System.out.println("Impiegato Salary: " + impiegato.getSalary());
        System.out.println("Manager Salary + Bonnus: " + manager.getSalary());
        System.out.println("Manager Salary + Bonnus: " + emp.getSalary());

        //12. Array polimorfico

        Impiegato[] staff = new Impiegato[3];
        // Popoliamo l'array con tipi di oggetto misti
        staff[0] = new Impiegato("Mario Rossi", 25, 1500.0);
        staff[1] = new Manager("Niels Salvador", 30, 2800.0, 700.0); // Manager con 700€ di bonus
        staff[2] = new Impiegato("Elena Bianchi", 40, 1600.0);

        System.out.println("--- Resoconto Stipendi Staff ---");
        for (Impiegato empi : staff) {
            System.out.println("Dipendente: " + empi.getNome() + " | Stipendio: " + empi.getSalary() + "€");
        }

        //13. Metodo che accetta la superclasse

        Ufficio ufficio = new Ufficio();
        Impiegato impiegatoSemplice = new Impiegato("Alice Rossi", 20, 1400.0);
        Manager managerAzienda = new Manager("Niels Salvador", 35, 3000.0, 1200.0);

        ufficio.stampaSalario(impiegatoSemplice);
        ufficio.stampaSalario(managerAzienda);

        //14. Assegnazione polimorfica
        Impiegato impiegatoApproveExpense = new Manager("Niels", 40, 2000.0, 258);
        System.out.println("impiegatoApproveExpense.approveExpense: " + impiegatoApproveExpense.approveExpense());

        Impiegato emp1 = new Manager("Niels Salvador", 35, 3200.0, 1200.0);
        Impiegato emp2 = new Impiegato("Mario Rossi", 45, 1500.0);

        //15. Downcasting con controllo

        System.out.println("--- Tentativo di verifica su emp1 ---");
        if (emp1 instanceof Manager) {
            System.out.println(emp.getNome() + " è un Manager. Procedo con il cast. " + "approveExpense " + emp1.approveExpense());
        } else {
            System.out.println(emp.getNome() + " NON è un Manager. Non ha i permessi per approvare spese.");
        }

    }
}

/*
 * SPIEGAZIONE NEI COMMENTI (Cosa succede qui?):
 *
 * 1. Quale versione di getSalary() viene eseguita?
 *    Viene eseguita la versione della SOTTOCLASSE (ovvero quella di Manager).
 *    L'output stamperà 4000.0€ (3000 base + 1000 bonus) e NON 3000.0€.
 *
 * 2. Perché succede questo? (Late Binding / Dynamic Binding)
 *    In Java, il compilatore controlla il tipo della VARIABILE (Impiegato) per verificare
 *    se il metodo getSalary() esiste. Siccome esiste in Impiegato, il codice è valido e compila.
 *
 *    Tuttavia, a tempo di esecuzione (Runtime), la Java Virtual Machine (JVM) guarda il tipo
 *    dell'OGGETTO REALE presente in memoria (Manager). Se la sottoclasse ha sovrascritto
 *    quel metodo (@Override), la JVM eseguirà SEMPRE la versione sovrascritta del Manager.
 *
 * 3. Un limite importante da ricordare:
 *    Usando il riferimento "emp" di tipo Impiegato, puoi invocare solo i metodi che sono
 *    dichiarati nella classe Impiegato. Se in Manager avessi aggiunto un metodo unico come
 *    "setBonus()", non potresti chiamarlo direttamente tramite "emp.setBonus()", perché
 *    il compilatore "vede" emp solo come un normale impiegato.
 *    Per farlo, dovresti fare un cast esplicito: ((Manager) emp).setBonus(1200.0);
 */