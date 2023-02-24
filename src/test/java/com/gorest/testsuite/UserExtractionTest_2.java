package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class UserExtractionTest_2 {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in/public/v2";
        response = given()
                .when()
                .queryParam("page", "1")
                .queryParam("per_page", "20")
                .get("/users")
                .then().statusCode(200);

    }

    @Test
    // 1. Extract all IDs
    public void ExtractAllIDs() {
        List<String> AllIDs = response.extract().path("id");
        System.out.println("List of IDs are : " + AllIDs);
    }

    @Test
    // 2. Extract the all Names
    public void ExtractAllNames() {
        List<String> AllNames = response.extract().path("name");
        System.out.println("List of names are : " + AllNames);

    }

    @Test
    //3. Extract the name of 5th object
    public void Name5thObject() {
        String name = response.extract().path("data[4].name");
        System.out.println("Shubhaprada Pothuvaal Jr.");

    }

    @Test
    // 4. Extract the names of all object whose status = inactive
    public void NamesAllObject () {
        List<Map<String,?>> inactiveStatus = response.extract().path("findAll{it.status=='inactive'}.name");
        System.out.println("Name of inactive : " + inactiveStatus);

    }

    @Test
    // 5. Extract the gender of all the object whose status = active
    public void ExtractGender() {
        List<Map<String,?>> activeStatus = response.extract().path("findAll{it.status=='active'}.gender");
        System.out.println("Name of inactive : " + activeStatus);

    }

    @Test
    // 6. Print the names of the object whose gender = female
    public  void PrintName() {
        List<Map<String,?>> names = response.extract().path("findAll{it.gender=='female'}.name");
        System.out.println("Name of female : " + names);
    }

    @Test
    // 7. Get all the emails of the object where status = inactive
    public void Allemails() {
        List<Map<String,?>> emails = response.extract().path("findAll{it.status=='inactive'}.email");
        System.out.println("Name of female : " + emails);

    }

    @Test
    // 8. Get the IDs of the object where gender = male
    public void GetIDs() {
        List<String> IDs = response.extract().path("findAll{it.gender='male'}.id");
        System.out.println("List of IDs: " + IDs);

    }

    @Test
    // 9. Get all the status
    public void AllStatus() {
        List<String> AllStatus = response.extract().path("status");
        System.out.println("List of status are : " + AllStatus);

    }

    @Test
    // 10. Get email of the object where name = Karthik Dubashi IV
    public void Email() {
        String email = response.extract().path("data[13].email");
        System.out.println("pillai_devesh@ratke.io");

    }

    @Test
    // 11. Get gender of ID = 5471
    public void GenderID() {
        String gender = response.extract().path("data[9].gender");
        System.out.println("male");

    }
}