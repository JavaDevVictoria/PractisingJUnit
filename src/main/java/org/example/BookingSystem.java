package org.example;

import java.util.ArrayList;
import java.util.List;

public class BookingSystem {

    private List<Integer> bookedHours = new ArrayList<>();
    public BookingSystem() {
    }

    public boolean bookHour(int hourOfDayToBook) {
        if (hourOfDayToBook < 8 || hourOfDayToBook > 17) {
            return false; // invalid hours
        }
        if (bookedHours.contains(hourOfDayToBook)) {
            return false; // already booked
        }
        bookedHours.add(hourOfDayToBook);
        return true;
    }

    public List<Integer> getBookedHours() {
        return new ArrayList<>(bookedHours); // return a copy to avoid modification
    }
}
