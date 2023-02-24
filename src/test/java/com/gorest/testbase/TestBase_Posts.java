package com.gorest.testbase;

import io.restassured.RestAssured;
import org.junit.BeforeClass;

public class TestBase_Posts {


    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "/public/v2/users?page=1&per_page=20";
    }

}