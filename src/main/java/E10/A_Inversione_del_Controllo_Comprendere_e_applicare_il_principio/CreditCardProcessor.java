package E10.A_Inversione_del_Controllo_Comprendere_e_applicare_il_principio;

public class CreditCardProcessor implements IPaymentProcessor {
    public void processPayment(double amount){
        System.out.println("Addebito di " + amount + " EUR su carta di credito");

    }
}
