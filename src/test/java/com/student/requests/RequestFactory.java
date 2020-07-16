package com.student.requests;

import com.github.javafaker.Faker;
import com.student.pojo.StudentPojo;
import com.student.tests.TestBase;
import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class RequestFactory extends TestBase {
    RestClient restClient=new RestClient();
    Faker faker=new Faker();
    @Step("Get all students list")
    public Response getStudentDetails(){
       Response response= restClient.doGetRequest("/list");
       return response;
    }

    @Step("Create new students")
    public Response createNewStudent(String url, String firstName, String lastName, String emailaddress, String programme, List<String> courses){
        StudentPojo body=new StudentPojo();
        body.setFirstName(firstName);
        body.setLastName(lastName);
        body.setEmail(emailaddress);
        body.setProgramme(programme);
        body.setCourses(courses);
        return restClient.doPostRequest(url,body);
    }
}
