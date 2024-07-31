public interface PaymentProcessor {
    void processPayment(double amount);
}

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

