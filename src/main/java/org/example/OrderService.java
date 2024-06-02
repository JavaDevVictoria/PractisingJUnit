package org.example;

public class OrderService {

    private PaymentService paymentService;

    public OrderService(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    public boolean placeOrder(String accountNumber, double amount) {
        return paymentService.processPayment(accountNumber, amount);
    }
}

