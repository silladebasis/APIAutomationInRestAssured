package org.restAssured.modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.restAssured.payloads.requests.Booking;
import org.restAssured.payloads.requests.BookingDates;
import org.restAssured.utils.FakerUtil;

public class PayloadManager {
    ObjectMapper objectMapper;
    public String createPayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        BookingDates bookingDates = new BookingDates();
        booking.setFirstname(FakerUtil.getFirstName());
        booking.setLastname(FakerUtil.getLastName());
        booking.setTotalprice(500);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Lunch");
        bookingDates.setCheckin("2024-01-01");
        bookingDates.setCheckout("2024-01-05");
        booking.setBookingdates(bookingDates);

        String payload = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
        return payload;
    }
}
