package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetReq {
    String baseURI="http://www.omdbapi.com/?apikey=79a4a58e";

    @Test(priority=1)
    public void validateImdbid(){
        Response r=Test1.getResponseParameters("&i=tt0499549");
        r.then().assertThat().body("Title",equalTo("Avatar"));
    }

    @Test(priority=6)
    public void validateInvalidImdbid(){
        Response r=Test1.getResponseParameters("&i=tt049954");
        r.then().assertThat().body("Error",equalToIgnoringCase("Incorrect IMDb ID."));
       }

    @Test(priority=2)
    public void validateMovieTitle(){
        Response r=Test1.getResponseParameters("&t=Avatar");
        r.then().assertThat().body("Title",equalTo("Avatar"));
    }

    @Test(priority=3)
    public void validateMovieTitle_Imdb(){
        Response r=Test1.getResponseParameters("&t=Avatar");
        r.then().assertThat().body("Title",equalTo("Avatar"));
    }

    @Test(priority=4)
    public void validateImdbIdAndType(){
        Response r=Test1.getResponseParameters("&i=tt0096895&type=movie");
        r.then().assertThat().body("Title",equalTo("Batman"));
    }
    @Test(priority=5)
    public void validateTitleAndType(){
        Response r=Test1.getResponseParameters("&t=Avatar&type=movie");
        r.then().assertThat().body("Title",equalTo("Avatar"));
    }

    @Test(priority=7)
    public void validateImdbIdAndYear(){
        Response r=Test1.getResponseParameters("&i=tt0499549&year=2009");
        r.then().assertThat().body("Title",equalTo("Avatar"));
    }

    @Test(priority=8)
    public void validateTitleAndYear(){
        Response r=Test1.getResponseParameters("&t=Avatar&year=2009");
        r.then().assertThat().body("Title",equalTo("Avatar"));
    }

    @Test(priority=9)
    public void validateSearch(){
        Response r=Test1.getResponseSearch("&s=Avatar");
        r.then().assertThat().body("Search.Title",hasItems("Avatar"));
    }

    @Test(priority=10)
    public void validateSearchAndType(){
        Response r=Test1.getResponseSearch("&s=Avatar&type=movie");
        r.then().assertThat().body("Search.Title",hasItems("Avatar"));
    }

    @Test(priority=11)
    public void validateSearchAndInvalidType(){
        Response r=Test1.getResponseSearch("&s=Avatar&type=cdscds");
        r.then().assertThat().body("Error",equalTo("Movie not found!"));
}

    @Test(priority=12)
    public void validateSearchAndITypeAndYear(){
        Response r=Test1.getResponseSearch("&s=Avatar&year=2009");
        r.then().assertThat().body("Search.Title",hasItems("Avatar"));


    }



}
