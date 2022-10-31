package Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;
public class ValidatePlayers {
	@Test
	public void getPlayers() {
		RestAssured.baseURI="";

		 String res=
		given().
		when().body(CricketAPI_Testdata.getPlayersDetails()).
		then().statusCode(200).expect().toString();

		JsonPath jpath = new JsonPath(res);
		int roleCount=jpath.getInt("player.role");
		int countFP=0;
		for(int i=0; i<=roleCount; i++)
		{
		if(jpath.getString("player.country")!="India")
		{
		 countFP++;
		}
		}

		Assert.assertEquals(countFP,4);
		
	}
	
}
