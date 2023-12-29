package test;

import io.restassured.response.Response;
import lib.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class CheckSuccessResponseOfPeopleTest extends BaseTest {

    @Test(description = "Add a movie from top top list to a personal list")
    public void addMovieToAList() throws IOException {
        Response response = callPeopleAPI();
        String actualSkinColor = getSkinColor(response);
        Assert.assertEquals(actualSkinColor, this.expectedSkinColor);
    }
}
