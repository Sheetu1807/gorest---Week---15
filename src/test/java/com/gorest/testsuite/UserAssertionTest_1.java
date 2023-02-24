package com.gorest.testsuite;

import io.restassured.RestAssured;
import io.restassured.response.ValidatableResponse;
import org.junit.BeforeClass;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.*;

public class UserAssertionTest_1 {

    static ValidatableResponse response;

    @BeforeClass
    public static void inIt() {
        RestAssured.baseURI = "https://gorest.co.in";
        RestAssured.basePath = "public/v2";
        response = given()
                .queryParam("page", 1)
                .queryParam("per_page", 20)
                .when()
                .get("/users")
                .then().statusCode(200);
    }

    @Test
    // 1. Verify if the total record is 20
    public void VerifyTotal() {
       response.body("size()", equalTo(20));
    }

    @Test
    // 2. Verify if the name of ID = 5487 is equal to ”Hamsini Trivedi”
    public void VerifyNameID() {
        response.body("[1].name", equalTo("Devvrat Verma"));

    }

    @Test
    // 3. Check the single ‘Name’ in the Array list (Subhashini Talwar)
    public void CheckSingleName() {
        response.body("[5].name", equalTo("Lakshminath Deshpande MD"));
    }

    @Test
    // 4. Check the multiple ‘Names’ in the ArrayList (Mrs. Menaka Bharadwaj, Msgr. Bodhan Guha, Karthik Dubashi IV)
    public void CheckMultipleNames() {
        response.body("name", hasItems("Fr. Gita Dhawan", "Devvrat Verma", "Chatur Mehrotra"));
    }

    @Test
    // 5. Verify the email of user ID = 5471 is equal “adiga_aanjaneya_rep@jast.org”
    public void VerifyEmailID() {
        response.body("[3].email", equalTo("dhawan_chidananda@schiller.com"));
    }

    @Test
    // 6. Verify the status is “Active” of username is “Shanti Bhat V”
    public void VerifyStatus() {
        response.body("[2].status", equalTo("inactive"));
    }

    @Test
    // 7. Verify the Gender = male of username is “Niro Prajapat”
    public void VerifyGender() {
        response.body("[2].gender", equalTo("male"));
    }

}
