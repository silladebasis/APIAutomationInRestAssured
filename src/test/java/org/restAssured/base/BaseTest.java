package org.restAssured.base;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import org.restAssured.Actions.AssertActions;
import org.restAssured.endpoints.APIConstants;
import org.restAssured.modules.PayloadManager;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected RequestSpecBuilder specBuilder;
    protected RequestSpecification requestSpecification;
    protected AssertActions assertActions;
    protected PayloadManager payloadManager;
    protected JsonPath jsonPath;
    protected ObjectMapper objectMapper;
    @BeforeMethod
    public void setUp(){
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        objectMapper = new ObjectMapper();
        requestSpecification = RestAssured.given().baseUri(APIConstants.BASE_URL).contentType(ContentType.JSON);
        //specBuilder = new RequestSpecBuilder().setBaseUri(APIConstants.BASE_URL).setContentType(ContentType.JSON);
    }
}
