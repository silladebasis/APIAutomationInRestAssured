package org.restAssured.tests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.restAssured.utils.ExcelReader;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class DemoTest {
    RequestSpecification requestSpecification;

    @BeforeTest
    public void setUp(){
        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com").basePath("/auth").contentType(ContentType.JSON);
    }
    String payload = "{\n" +
            "    \"username\" : \"admin\",\n" +
            "    \"password\" : \"password123\"\n" +
            "}";
    @Test
    public void createToken(){
        given().spec(requestSpecification).
                body(payload).
                when().
                post().
                then().log().all().statusCode(200);
    }
    @Test(dataProvider = "getData",dataProviderClass = ExcelReader.class)
    public void testDemoExcelRead(String baseURL,String createBooking){
        System.out.println("Base URL is : " + baseURL);
        System.out.println("Create Booking path is : " + createBooking);
    }
}
