package testPack;

import static io.restassured.RestAssured.given;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class VarifyPositiveAndNegativeSenarioGetRequestGroupId {
	


/*
 	1.	Verify get method by passing valid URL/URI Expected Status code =200 ok
	2.	Verify get method by passing wrong URL/URI Expected Status code=404-Not found
	3.	Verify by changing method types (GET->POST) EC=405-Method Not Allowed
	4.	Verify get method by passing valid Token EC=200 ok
	5.	Verify get method by passing invalid Token Expected Status code =403 Forbidden
	6.	Verify get method by passing Null Token Expected Status code =403 Forbidden
	7.	Verify get method by without passing authorization header Token Expected result "NullPointerException"
	8.	Varify response and data count of get request
	9.	Varify Attributes present in response
	10.	varify response time for get request
 */
	
	@Test(dataProvider="dataProvider")
	public void getRequestToGetGroupId(String token ){
		
		String response=given().log().all().header("Content-Type" , "application/json").
		header("Authorization", token)
		.when().get("https://api-ssl.bitly.com/v4/groups")
		.then().log().all().extract().asString();
		
		JsonPath jsonpath= new JsonPath(response);
		String groupId=jsonpath.get("groups[0].guid");
		System.out.println(groupId);
	}
	
	@DataProvider(name="dataProvider")	
	String[] dataProviderMethod() {
		String[] requestPara= { "be7b0442a32b9da8e4eab237361235ffea4e5d52", "ae7b0442a32b9da8e4eab237361235ffea4e5d52", ""};
	return requestPara;
	}
}
