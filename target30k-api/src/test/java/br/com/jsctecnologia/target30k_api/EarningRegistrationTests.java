package br.com.jsctecnologia.target30k_api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class EarningRegistrationTests {

    @Test
    public void deveCadastrarNovoGanhoComSucesso() {
        RestAssured.baseURI = "http://localhost:8080/api/earnings";

        // Agora usamos o valor sem o 'f' no JSON para bater com o BigDecimal
        String novoFreela = "{\"description\": \"Primeiro Freela React\", \"value\": 1500.00, \"date\": \"2025-12-30\"}";

        given()
                .contentType(ContentType.JSON)
                .body(novoFreela)
                .when()
                .post()
                .then()
                .statusCode(200) // Se você não mudou no Controller para 201, mantenha 200 por enquanto
                .body("description", is("Primeiro Freela React"))
                // Usamos o matcher 'comparesEqualTo' ou garantimos que o valor seja tratado como número
                .body("value", is(1500.0f));
    }
}