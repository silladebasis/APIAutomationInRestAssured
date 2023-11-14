package org.restAssured.tests;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.Response;
import org.restAssured.base.BaseTest;
import org.restAssured.endpoints.APIConstants;
import org.restAssured.payloads.response.BookingResponse;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class TC_CreateBooking extends BaseTest {
    @Owner("Debasis")
    @Description("Create Booking and generate the booking id")
    @Severity(SeverityLevel.CRITICAL)
    @Test(groups = {"stage"})
    public void testCreateBooking() throws IOException {
        requestSpecification.basePath(APIConstants.CREATE_BOOKING);
        Response response = given().spec(requestSpecification).when().body(payloadManager.createPayload()).post().then().log().all().extract().response();
        BookingResponse bookingResponse = objectMapper.readValue(response.asString(), BookingResponse.class);
        System.out.println(bookingResponse.getBookingid());
        System.out.println(bookingResponse.getBooking().getFirstname());
    }
}
