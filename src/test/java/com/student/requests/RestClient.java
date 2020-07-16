package com.student.requests;

import com.student.specs.SpecificationFactory;
import com.student.tests.TestBase;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient extends TestBase {
    public Response doGetRequest(String requestPath){
        return RestAssured.given()
                          .contentType(ContentType.JSON)
                           .when().get(requestPath);
    }

    public Response doPostRequest(String uri, Object body){
        Response response=RestAssured.given()
                          .contentType(ContentType.JSON)
                          .spec(SpecificationFactory.logPayloadResponseInfo())
                          .when()
                          .body(body)
                          .post(uri);
        return response;
    }

    public Response doPutRequest(String uri, Object body){
        Response response=RestAssured.given()
                          .contentType(ContentType.JSON)
                          .when()
                          .body(body)
                           .put(uri);
        return response;
    }

    public  Response doDeleteRequest(String uri){
        Response response=RestAssured.given()
                           .when()
                           .delete(uri);
        return response;
    }
}
