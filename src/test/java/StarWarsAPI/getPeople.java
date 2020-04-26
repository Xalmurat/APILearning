package StarWarsAPI;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class getPeople {

    @BeforeClass
    public void setup(){
        RestAssured.baseURI = "https://swapi.py4e.com/api/";


    }



    @Test
    public void test1() {

        Response response = RestAssured.get("/people/");
        response.body().prettyPrint();
        JsonPath js = response.jsonPath();
        String FirstPeople = js.getString("1");
        System.out.println(FirstPeople);


    }

}
