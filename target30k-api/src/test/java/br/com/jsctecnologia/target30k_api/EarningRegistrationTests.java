package br.com.jsctecnologia.target30k_api;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class EarningRegistrationTests {

    @Test
    public void deveCadastrarNovoGanhoComSucesso() { // Remova o 'RequestSpecification given' daqui
        RestAssured.baseURI = "http://localhost:8080/api/earnings";

        String novoFreela = "{\"description\": \"Primeiro Freela React\", \"value\": 1500.0, \"date\": \"2025-12-30\"}";

        given() // O 'given' aqui já funciona direto por causa do import static lá no topo
                .contentType(ContentType.JSON)
                .body(novoFreela)
                .when()
                .post()
                .then()
                .statusCode(200)
                .body("description", is("Primeiro Freela React"))
                .body("value", is(1500.0f));
    }
}