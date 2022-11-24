package testPack;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class VarifyPositiveAndNegativeSenarioPostRequest {
	
/*	1.	Verify post method by passing valid URL/URI Expected Status code =200 ok
	2.	Verify post method by passing wrong URL/URI Expected Status code=404-Not found
	3.	Verify post changing method types (POST --> get) EC=405-Method Not Allowed
	4.	Verify post method by passing valid Token EC=200 ok
	5.	Verify post method by passing invalid Token Expected Status code =403 Forbidden
	6.	Verify post method by passing Null Token Expected Status code =403 Forbidden
	7.	Verify post method by without passing authorization header Token Expected result "NullPointerException"
	8.	Varify response and data count of post request
	9.	Varify Attributes present in response
	10.	varify response time for post request
	11. Verify post method by passing Null id Expected Status code =422 Unprocessable Entity
	11. Verify post method by passing valid deeplinks Expected Status code = 402Payment Required 
	 */

	
	@Test
	public void postRequestBitLinks() {

		String response=given().log().all().header("Content-Type" , "application/json").
				header("Authorization", "be7b0442a32b9da8e4eab237361235ffea4e5d52").body("{\r\n"
						+ "    \"created_at\": \"2022-11-23T16:29:08+0000\",\r\n"
						+ "    \"id\": \"bitly.is/3tVWkng\",\r\n"
						+ "    \"link\": \"https://bitly.is/3tVWkng\",\r\n"
						+ "    \"custom_bitlinks\": [\r\n"
						+ "        \r\n"
						+ "    ],\r\n"
						+ "    \"long_url\": \"https://dev.bitly.com/\",\r\n"
						+ "    \"archived\": false,\r\n"
						+ "    \"tags\":[\r\n"
						+ "    \"bitly\",\r\n"
						+ "    \"api\"\r\n"
						+ "  ],\r\n"
						+ "    \"deeplinks\": [\r\n"
						
						+ "        \r\n"
						+ "    ],\r\n"
						+ "    \"references\": {\r\n"
						+ "        \"group\": \"https://api-ssl.bitly.com/v4/groups/BmbnfxwTjfI\"\r\n"
						+ "    }\r\n"
						+ "}")
				.when().post("https://api-ssl.bitly.com/v4/bitlinks")
				.then().log().all().assertThat().statusCode(200).extract().asString();
	}
}
