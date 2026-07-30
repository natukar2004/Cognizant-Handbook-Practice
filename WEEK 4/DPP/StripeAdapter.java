public class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        int amountInCents = (int) Math.round(amount * 100);
        stripeGateway.charge(amountInCents);
    }
}
