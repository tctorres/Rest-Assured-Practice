package test;

import entity.FilmsPOJO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static lib.Constant.API_URL;
import static lib.Constant.FILMS_API_ENDPOINT;

public class SecondMovieTest {
    private final int id = 2;
    @Test(description = "Request endpoint of the second movie of people/2/")
    public void secondMovieTest() throws IOException{
        String endpoint = API_URL + FILMS_API_ENDPOINT + id;
        Response response = given().when().get(endpoint);
        FilmsPOJO filmsResponse = response.as(FilmsPOJO.class);
        Assert.assertFalse(filmsResponse.getCharacters().isEmpty());
        Assert.assertFalse(filmsResponse.getPlanets().isEmpty());
        Assert.assertFalse(filmsResponse.getStarships().isEmpty());
        Assert.assertFalse(filmsResponse.getVehicles().isEmpty());
        Assert.assertFalse(filmsResponse.getSpecies().isEmpty());
    }
}
