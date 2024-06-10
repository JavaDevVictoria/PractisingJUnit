package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookingSystemTest {

    private BookingSystem bookingSystem;

    @BeforeEach
    void setUp() {
        bookingSystem = new BookingSystem();
    }

    @Test
    void testSingleBooking() {
        int hourOfDayToBook = 9;
        assertTrue(bookingSystem.bookHour(hourOfDayToBook),"Should be able to book an available hour");
        assertEquals(1, bookingSystem.getBookedHours().size(), "One hour should be booked");
        assertTrue(bookingSystem.getBookedHours().contains(hourOfDayToBook), "The booked hour should be 9");
    }

    @Test
    void testDoubleBooking() {
        int hourOfDayToBook = 10;
        assertTrue(bookingSystem.bookHour(hourOfDayToBook), "Should be able to book an available hour");
        assertFalse(bookingSystem.bookHour(hourOfDayToBook), "Should not be able to double book the same hour");
        assertEquals(1, bookingSystem.getBookedHours().size(), "Only one hour should be booked");
        assertTrue(bookingSystem.getBookedHours().contains(hourOfDayToBook), "The booked hour should be 10");
    }

    @Test
    void testIllegalValues() {
        assertFalse(bookingSystem.bookHour(7), "Should not be able to book an hour before 8");
        assertFalse(bookingSystem.bookHour(18), "Should not be able to book an hour after 17");
        assertEquals(0, bookingSystem.getBookedHours().size(), "No hours should be booked with illegal values");
    }

    @Test
    void testMultipleBookings() {
        assertTrue(bookingSystem.bookHour(9), "Should be able to book an available hour");
        assertTrue(bookingSystem.bookHour(10), "Should be able to book another available hour");
        assertEquals(2, bookingSystem.getBookedHours().size(), "Two hours should be booked");
        assertTrue(bookingSystem.getBookedHours().contains(9), "The booked hour should be 9");
        assertTrue(bookingSystem.getBookedHours().contains(10), "The booked hour should be 10");
    }

}
