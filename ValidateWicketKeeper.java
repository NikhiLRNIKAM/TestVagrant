package Test;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static io.restassured.RestAssured.*;

public class ValidateWicketKeeper {
	@Test
	public void getKeeper() {
		RestAssured.baseURI="";

		String response=
		given().
		when().body(CricketAPI_Testdata.getPlayersDetails()).
		then().statusCode(200).expect().toString();

		JsonPath jpath = new JsonPath(response);
		int roleCount=jpath.getInt("player.role");

		for(int i=0; i<=roleCount; i++)
		{
		if(jpath.getString("player.role").equalsIgnoreCase("Wicket-keeper")){
			System.out.println("Wicket-keeper found");
			break;
		}
		}

		Assert.assertEquals(roleCount,"WiketKeeper");
		
	}
	
}
