package cucumber.API;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

import cucumber.page.AbstractAPI;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class simpleApiTC extends AbstractAPI{

	@Test
	public void checkGetStatusApi() {
		baseURI = "https://petstore.swagger.io";

    	RequestSpecification request = given();
    	request.header("Content-Type", "application/json");

		RestAssured.config=RestAssuredConfig.config()
                .httpClient(HttpClientConfig.httpClientConfig()
                        .setParam("http.socket.timeout",2000)
                        .setParam("http.connection.timeout", 2000));
		
    	Response repon = request.get("/v2/pet/findByStatus?status=pending");
    	repon.prettyPrint();
    	
    	ValidatableResponse validRespon = repon.then();
    	
    	validRespon.body("tags[0].any {it.containsKey('id')}", is(true));
    	
    	validRespon.body("status", is(not(blankOrNullString())));
    	
    	validRespon.body("status", hasItems("pending"));
    	
    	validRespon.body("tags.id", is(not(blankOrNullString())));
    	    
	}

}
