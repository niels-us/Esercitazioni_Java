package E10.C_Dependency_Injection_Modalita_e_applicazioni;

public class CreditCardProcessor implements IPaymentProcessor {
    public void processPayment(double amount){
        System.out.println("Addebito di " + amount + " EUR su carta di credito");

    }
}
