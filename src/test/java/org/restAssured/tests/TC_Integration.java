package org.restAssured.tests;

import com.fasterxml.jackson.core.JsonProcessingException;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.restAssured.base.BaseTest;
import org.restAssured.endpoints.APIConstants;
import org.restAssured.payloads.requests.Booking;
import org.restAssured.payloads.response.BookingResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;

public class TC_Integration extends BaseTest {
    //1. Get A Token
    //2. Create a booking
    //3. Update booking with token id
    //4. Delete the booking
    String access_token;
    String booking_id;
    @Test(groups = {"stage"})
    public void testCreateBooking() throws IOException {
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        Response response = given().spec(requestSpecification).
                when().body(payloadManager.createPayload()).post().
                then().log().all().extract().response();
        BookingResponse bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        booking_id = bookingResponse.getBookingid();
    }
    @Test(dependsOnMethods = {"testCreateBooking"})
    public void updateBookingDetails() throws JsonProcessingException {
        access_token = getAccessToken();
        requestSpecification.basePath(APIConstants.UPDATE_BOOKING + "/" +booking_id);
        Response response = given().spec(requestSpecification).cookie("token",access_token).
                when().body(payloadManager.updatePayload()).put().
                then().log().all().extract().response();
        Booking booking = objectMapper.readValue(response.asString(),Booking.class);
        assertThat(booking.getAdditionalneeds()).isEqualTo("Dinner");
    }
    @Test(dependsOnMethods = {"updateBookingDetails"})
    public void testDeleteBooking() throws JsonProcessingException {
        access_token = getAccessToken();
        requestSpecification.basePath(APIConstants.DELETE_BOOKING+booking_id);
        given().spec(requestSpecification).cookie("token",access_token).
                when().delete().
                then().log().all().
                assertThat().statusCode(201);
    }
}
