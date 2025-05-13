package designPatterns.strategy.first;

public class Demo {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext(new CreditCardPayment());
        context.payAmount(100); // Paid 100 via Credit Card

        context.setStrategy(new PayPalPayment());
        context.payAmount(200); // Paid 200 via PayPal
    }
}
