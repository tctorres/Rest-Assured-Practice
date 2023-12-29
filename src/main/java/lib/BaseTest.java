package lib;


import entity.People;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

import static io.restassured.RestAssured.given;
import static lib.Constant.*;

public class BaseTest {
    protected Response callPeopleAPI() {
    String endpoint = API_URL + PEOPLE_2_ENDPOINT;
    Response peopleResponse = given().when().get(endpoint);
    validateStatusCode(SUCCESS_GET_STATUS_CODE, peopleResponse.getStatusCode());
    return peopleResponse;
    }

    protected String getSkinColor(Response peopleResponse){
        JsonPath js = deserializeResponse(peopleResponse);
        String skinColor = js.get("skin_color");
        System.out.println("Skin color is: " + skinColor);
        Assert.assertEquals(skinColor, "gold");
        return skinColor;
    }

    private void validateStatusCode(int expectedStatusCode, int statusCode) {
        Assert.assertEquals(statusCode, expectedStatusCode);
    }
    protected JsonPath deserializeResponse(Response response){
        String responseAsString = response.asString();
        return new JsonPath(responseAsString);
    }

}
