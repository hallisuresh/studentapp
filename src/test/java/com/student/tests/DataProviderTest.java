package com.student.tests;

import com.github.javafaker.Faker;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.List;

public class DataProviderTest {

    @DataProvider(name="studentdata")
    public Object[][] StudentData()
    {
        Faker faker=new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        String email = faker.internet().emailAddress();
        String programme = "computer science";
        List<String> course = new ArrayList<>();
        course.add("CS");
        course.add("JAVA");

        Object[][] object = {
                {firstName,lastName,email,programme,course}
        };

        return object;
    }
}
