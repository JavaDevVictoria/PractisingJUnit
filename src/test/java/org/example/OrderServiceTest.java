package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private PaymentService mockedPaymentService;
    private OrderService orderService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderService = new OrderService(mockedPaymentService);
    }

    @Test
    void testPaymentIsSuccessful() {
        String accountNumber = "12345";
        double amount = 100.0;

        when(mockedPaymentService.processPayment(accountNumber, amount)).thenReturn(true);

        boolean result = orderService.placeOrder(accountNumber, amount);

        assertTrue(result);
        verify(mockedPaymentService, times(1)).processPayment(accountNumber, amount);
    }

    @Test
    void testPaymentIsFailed() {
        String accountNumber = "12346";
        double amount = 100.50;

        when(mockedPaymentService.processPayment(accountNumber, amount)).thenReturn(false);

        boolean result = orderService.placeOrder(accountNumber, amount);

        assertFalse(result);
        verify(mockedPaymentService, times(1)).processPayment(accountNumber, amount);
    }


}