package ch.zli.m223;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.Test;

import ch.zli.m223.application_user.ApplicationUser;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class EntryResourceTest {

    @Test
    public void testIndexEndpoint() {
        given()
        .when().get("/entries")
        .then()
        .statusCode(200)
        .body(is("[]"));
    }

    @Test
    public void testCreateEndpoint() {
        

        System.out.println("TEST is empty?" + given().when().get("/entries").then().statusCode(200).body(is("[]")));
        var applicationuser = new ApplicationUser();
        applicationuser.setVorname("Joe");
        applicationuser.setNachname("Biden");
        applicationuser.setEmail("joe.biden@pres.gov");
        applicationuser.setPassword("hello");


        var createResponse = given()
            .contentType(ContentType.JSON)
            .body(applicationuser)
            .when().post("/entries");
    }

    @Test
    public void testDeleteEndpoint() {
        var applicationuser = new ApplicationUser();
        applicationuser.setVorname("Joe");
        applicationuser.setNachname("Biden");
        applicationuser.setEmail("joe.bidens@husband.gov");
        applicationuser.setPassword("hello");

        var createResponse = given()
            .contentType(ContentType.JSON)
            .body(applicationuser)
            .when().post("/entries");

        given()
            .when().delete("/entries/" + createResponse.jsonPath().get("id"))
            .then()
            .statusCode(204);
    }

    @Test
    public void testUpdateEndpoint() {
        var applicationuser = new ApplicationUser();
        applicationuser.setVorname("Joe");
        applicationuser.setNachname("Biden");
        applicationuser.setEmail("joe.bidens@husband.gov");
        applicationuser.setPassword("hello");

        var createResponse = given()
            .contentType(ContentType.JSON)
            .body(applicationuser)
            .when().post("/entries");


        var updatedApplicationUser = new ApplicationUser();
        updatedApplicationUser.setVorname("Boe");
        updatedApplicationUser.setNachname("Jiden");
        updatedApplicationUser.setEmail("boe.jidens@husband.gov");
        updatedApplicationUser.setPassword("hello");
        // updatedApplicationUser.setId(createResponse.jsonPath().get("id"));

        given()
            .contentType(ContentType.JSON)
            .body(updatedApplicationUser)
            .when().put("/entries/" + createResponse.jsonPath().get("id"))
            .then()
            .statusCode(200)
            .body("email", is("boe.jidens@husband.gov"));
    }

}