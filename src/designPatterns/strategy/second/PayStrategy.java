package designPatterns.strategy.second;

public interface PayStrategy {
    boolean pay(int paymentAmount);
    void collectPaymentDetails();
}
