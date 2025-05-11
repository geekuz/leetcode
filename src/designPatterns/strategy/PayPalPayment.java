package designPatterns.strategy;

public class PayPalPayment implements PaymentStrategy{
    @Override
    public void pay(int amount) {
        System.out.println("Paid "+ amount + " with PayPal");
    }
}
