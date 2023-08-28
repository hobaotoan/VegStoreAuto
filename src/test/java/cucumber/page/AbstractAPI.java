package cucumber.page;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.IOException;

import cucumber.data.provider.DataProviderPath;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AbstractAPI {
	
	  public RequestSpecification generateBearerToken(String uri, String tokenTypeUser) throws IOException {
	    	baseURI = uri;
	    	
	    	RequestSpecification request = given();
	    	request.header("Content-Type", "application/json");
	    	String filePayLoad = new DataProviderPath().getPropertiesFileJson(tokenTypeUser);
	    	
	    	File jsonDataFile = new File(filePayLoad);
	    	
	    	Response responseToken = request.body(jsonDataFile).post("/Account/v1/GenerateToken");
	    	responseToken.prettyPrint();
	    	
	    	String jsonToken = responseToken.getBody().asString();
	    	String tokenGenerated = JsonPath.from(jsonToken).get("token");
	    	request.header("Authorization","Bearer "+tokenGenerated)
				   .header("Content-Type","application/json");
	    	
			RestAssured.config=RestAssuredConfig.config()
	                .httpClient(HttpClientConfig.httpClientConfig()
	                        .setParam("http.socket.timeout",2000)
	                        .setParam("http.connection.timeout", 2000));
	    	return request;
		}

}
