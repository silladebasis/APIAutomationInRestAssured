package org.restAssured.modules;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.restAssured.payloads.requests.Auth;
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

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
    }
    public String createAuthPayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(auth);
    }

    public String updatePayload() throws JsonProcessingException {
        objectMapper = new ObjectMapper();
        Booking booking = new Booking();
        BookingDates bookingDates = new BookingDates();
        booking.setFirstname(FakerUtil.getFirstName());
        booking.setLastname(FakerUtil.getLastName());
        booking.setTotalprice(500);
        booking.setDepositpaid(true);
        booking.setAdditionalneeds("Dinner");
        bookingDates.setCheckin("2024-01-01");
        bookingDates.setCheckout("2024-01-05");
        booking.setBookingdates(bookingDates);

        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(booking);
    }
}
