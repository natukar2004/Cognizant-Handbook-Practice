


public class RazorpayAdapter implements PaymentProcessor {
    private final RazorpayGateway razorpayGateway;

    RazorpayAdapter(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    @Override
    public void processPayment(double amount, String currency) {
        razorpayGateway.pay(amount, currency);
    }
}
