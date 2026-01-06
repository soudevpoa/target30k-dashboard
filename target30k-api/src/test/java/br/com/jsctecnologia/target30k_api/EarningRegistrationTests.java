package br.com.jsctecnologia.target30k_api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.comparesEqualTo;
import static org.hamcrest.Matchers.is;

public class EarningRegistrationTests {

    @Test
    public void deveCadastrarNovoGanhoComSucesso() {
        RestAssured.baseURI = "http://localhost:8080/api/earnings";

        // Enviamos o valor como número direto
        String novoFreela = "{\"description\": \"Primeiro Freela React\", \"value\": 1500.0, \"date\": \"2025-12-30\"}";

        given()
                .contentType(ContentType.JSON)
                .body(novoFreela)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("description", is("Primeiro Freela React"))
                // Usamos o matcher correto para números decimais
                .body("value", comparesEqualTo(1500.0f));
    }
}