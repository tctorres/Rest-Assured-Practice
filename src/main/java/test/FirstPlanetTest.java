package test;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import entity.PlanetsPOJO;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static lib.Constant.API_URL;
import static lib.Constant.PLANETS_API_ENDPOINT;

public class FirstPlanetTest {
    private final int id = 1;
    private final String expectedGravity = "1 standard";
    private final String expectedTerrain = "desert";
    private PlanetsPOJO planetsPOJO;
    private PlanetsPOJO secondPlanetsPOJO;
    private ObjectMapper objectMapper = new ObjectMapper();

    @AfterTest
    public void tearDownModule(){
    try{
        objectMapper.writeValue(new File("planet.json"), this.secondPlanetsPOJO);
    }catch(IOException e){
        e.printStackTrace();
    }
    }
    @Test(description = "Check gravity and terrains")
    public void firstPlanetTest() throws IOException {
        String endpoint = API_URL + PLANETS_API_ENDPOINT + id;
        Response response = given().when().get(endpoint);
        this.planetsPOJO = response.as(PlanetsPOJO.class);
        Assert.assertEquals(planetsPOJO.getGravity(), expectedGravity);
        Assert.assertEquals(planetsPOJO.getTerrain(), expectedTerrain);
    }

    @Test(description = "grab url element on the planet response and request it")
    public void validateResponse() throws IOException{
    String endpoint = API_URL + PLANETS_API_ENDPOINT + id;
    Response response = given().when().get(endpoint);
    this.secondPlanetsPOJO = response.as(PlanetsPOJO.class);
    Assert.assertEquals(this.secondPlanetsPOJO.getGravity(), this.planetsPOJO.getGravity());
    Assert.assertEquals(this.secondPlanetsPOJO.getTerrain(), this.planetsPOJO.getTerrain());

}
}