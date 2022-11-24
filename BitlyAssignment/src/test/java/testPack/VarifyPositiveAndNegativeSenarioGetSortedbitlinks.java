package testPack;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class VarifyPositiveAndNegativeSenarioGetSortedbitlinks {
	
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
	11. Varify post request by passing invalid unit_reference Expected Status code=400 bad request
	12. Varify post request by passing valid guid=BmbnfxwTjfI Expected Status code=403 Forbidden
	13. Varify post request by passing invalid guid=abdgfjj Expected Status code=403 Forbidden
*/
	
	@Test
	public void getSortedBitlinksForGroups() {
		String response=given().log().all().header("Content-Type" , "application/json").
				header("Authorization", "be7b0442a32b9da8e4eab237361235ffea4e5d52")
				.when().get("https://api-ssl.bitly.com/v4/groups/BmbnfxwTjfI/bitlinks/clicks?unit=day&units=30&unit_reference=2022-11-24T07%3A48%3A45%2B0000&size=10")
				.then().log().all().assertThat().extract().asString();
	}
}
