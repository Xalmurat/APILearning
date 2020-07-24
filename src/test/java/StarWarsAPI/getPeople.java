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

    @Test
    public void test02_validate_average_height_for_people() {

        Response response = RestAssured.get("/people");
        JsonPath js = response.jsonPath();

        int sum = 0;
        for (int i = 0; i < 10 ; i++) {
            System.out.println((i+1)+" person height : " + js.getString("results["+i+"].height"));
            sum += Integer.parseInt(js.getString("results["+i+"].height"));
        }
        System.out.println("The average height will be "+sum/10);

    }


}
