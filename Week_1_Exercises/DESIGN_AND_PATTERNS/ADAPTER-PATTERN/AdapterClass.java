// GatewayAAdapter.java
public class GatewayAAdapter implements PaymentProcessor {
    private GatewayA gatewayA;

    public GatewayAAdapter(GatewayA gatewayA) {
        this.gatewayA = gatewayA;
    }

    @Override
    public void processPayment(double amount) {
        gatewayA.makePayment(amount);
    }
}

// GatewayBAdapter.java
public class GatewayBAdapter implements PaymentProcessor {
    private GatewayB gatewayB;

    public GatewayBAdapter(GatewayB gatewayB) {
        this.gatewayB = gatewayB;
    }

    @Override
    public void processPayment(double amount) {
        gatewayB.executePayment(amount);
    }
}


public class PaymentProcessorTest {
    public static void main(String[] args) {
        // Using GatewayA through its adapter
        PaymentProcessor gatewayAAdapter = new GatewayAAdapter(new GatewayA());
        gatewayAAdapter.processPayment(100.0);

        // Using GatewayB through its adapter
        PaymentProcessor gatewayBAdapter = new GatewayBAdapter(new GatewayB());
        gatewayBAdapter.processPayment(200.0);
    }
}
