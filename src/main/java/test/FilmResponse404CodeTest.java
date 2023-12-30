package test;

import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static lib.Constant.*;

public class FilmResponse404CodeTest {
    private final int id = 7;
@Test(description = "Check response having a 404 code")
    public void filmResponse404CodeTest() throws IOException {
    String endpoint = API_URL + FILMS_API_ENDPOINT + id;
    Response response = given().when().get(endpoint);
    Assert.assertEquals(response.getStatusCode(), NOT_FOUND_STATUS_CODE);
}
}
