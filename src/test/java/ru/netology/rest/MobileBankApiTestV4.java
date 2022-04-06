package ru.netology.rest;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.module.jsv.JsonSchemaValidator.*;
import static io.restassured.module.jsv.JsonSchemaValidatorSettings.settings;


class MobileBankApiTestV4 {
    @Test
    void shouldReturnDemoAccounts() {

        given()
                .baseUri("http://localhost:9999/api/v1")

                .when()
                .get("/demo/accounts")

                .then().assertThat()
                .statusCode(200)
                .body(matchesJsonSchemaInClasspath("accounts.schema.json").using(settings().with().checkedValidation(false)))

        ;
    }
}
