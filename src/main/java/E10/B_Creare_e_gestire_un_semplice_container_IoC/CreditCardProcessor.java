package E10.B_Creare_e_gestire_un_semplice_container_IoC;

public class CreditCardProcessor implements IPaymentProcessor {
    public void processPayment(double amount){
        System.out.println("Addebito di " + amount + " EUR su carta di credito");

    }
}
