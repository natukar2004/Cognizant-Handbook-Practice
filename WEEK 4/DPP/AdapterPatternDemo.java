import java.util.ArrayList;
import java.util.List;

public class AdapterPatternDemo {
    public static void main(String[] args) {
        List<PaymentProcessor> processors = new ArrayList<>();

        // Wrap each gateway's own object inside its adapter
        processors.add(new PayPalAdapter(new PayPalGateway()));
        processors.add(new StripeAdapter(new StripeGateway()));
        processors.add(new RazorpayAdapter(new RazorpayGateway()));

        
        for (PaymentProcessor processor : processors) {
            processor.processPayment(49.99, "USD");
            System.out.println("--------------------------------------------------");
        }
    }
}