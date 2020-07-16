package com.student.tests;

import com.student.requests.RequestFactory;
import com.student.specs.SpecificationFactory;
import io.qameta.allure.Step;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import java.util.List;

public class CrudTest extends  TestBase {
    RequestFactory request = new RequestFactory();

    @Story("This is get student testing story")
    @Step("get the student details")
    @Test(description = "get the student list")
    public void getResult() {
        request.getStudentDetails().then().log().all();
    }

    @Story("This is create testing story")
    @Step("create new student")
    @Test(dataProvider = "studentdata", dataProviderClass = DataProviderTest.class)
    public void createNewStudent(String firstName, String lastName,String email, String programme, List<String> course) {
        request.createNewStudent("", firstName, lastName, email, programme, course)
                .then()
                .spec(SpecificationFactory.getGenericResponse());
    }
}
