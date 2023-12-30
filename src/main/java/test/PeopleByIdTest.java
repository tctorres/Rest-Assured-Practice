package test;

import io.restassured.response.Response;
import org.testng.Assert;
import static io.restassured.RestAssured.given;
import org.testng.annotations.Test;
import entity.PeoplePOJO;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static lib.Constant.*;

public class PeopleByIdTest {
    private final int id = 2;
    private final String expectedColor = "gold";
    private final int expectedAmmountFilms = 6;
    @Test(description = "Check success response, skin color, and films of people/2/")
    public void peopleTest() throws IOException {
        String endpoint = API_URL + PEOPLE_API_ENDPOINT + id;
        Response response = given().when().get(endpoint);
        PeoplePOJO peopleResponse = response.as(PeoplePOJO.class);
        Assert.assertEquals(response.statusCode(), SUCCESS_GET_STATUS_CODE);
        Assert.assertEquals(peopleResponse.getSkin_color(), expectedColor);
        Assert.assertEquals(peopleResponse.getFilms().size(), expectedAmmountFilms);
    }
}

