package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class PostsExtractionTest_4 {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIT() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/posts")
                .then().statusCode(200);
    }

    @Test
    // 1. Extract the title
    public void Title() {
        List<String> title = response.extract().path("title");
        System.out.println("List of title are : " + title);

    }

    @Test
    // 2. Extract the total number of record
    public void TotalRecord() {
        int record = response.extract().path("record.size");
        System.out.println("Total number of record is : " + record);

    }

    @Test
    // 3. Extract the body of 15th record
    public void Body15thRecord() {
        String rec15th = response.extract().path("[14].body");
        System.out.println("The body of 15th record is : " + rec15th);

    }

    @Test
    // 4. Extract the user_ID of all the records
    public void UserID() {
        List<Integer> ID = response.extract().path("id");
        System.out.println("The user_ID of all the records are : " + ID);
    }

    @Test
    // 5. Extract the title of all the records
    public void TitleAllRecords() {
        List<String> recordTitles = response.extract().path("title");
        System.out.println("The title of all records are : " + recordTitles);
    }

    @Test
    // 6. Extract the title of all records whose user_id = 5456
    public void TitleUserID() {
        List<?>titleAllRecord = response.extract().path("findAll{it.user_id = 5456}.title");
        System.out.println("Title of all records are : " + titleAllRecord);

    }

    @Test
    // 7. Extract the body of all records whose id = 2671
    public void TitleofRecords() {
        List<String> titleAllBody = response.extract().path("findAll{it.id = 2671}.body");
        System.out.println("List of title are : " + titleAllBody);

    }

}
