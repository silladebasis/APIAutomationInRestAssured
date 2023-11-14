package org.restAssured.payloads.response;

import org.restAssured.payloads.requests.Booking;

public class BookingResponse {
    private String bookingid;
    private Booking booking;

    public String getBookingid() {
        return bookingid;
    }

    public void setBookingid(String bookingid) {
        this.bookingid = bookingid;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }
}
