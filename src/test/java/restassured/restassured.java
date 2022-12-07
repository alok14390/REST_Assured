package restassured;


import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.util.JSONPObject;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.*;
import static io.restassured.RestAssured.*;
import io.restassured.path.json.JsonPath;
import static org.hamcrest.Matchers.*;

import org.json.simple.JSONObject;

public class restassured {
	
	
	public String url="https://reqres.in/api/users?page=2";
	
//	@Test
//	public void test()
//	{
//		Response res=RestAssured.get(url);
//		int actual=res.statusCode();
//		Assert.assertEquals(actual,200);
//		
//		
//	}
	@Test(enabled=false)
	public void getallusers()
	{
		
		
		given().get("https://reqres.in/api/users?page=2").then().statusCode(200).log().all();
		
		
		
		
		
	}
	@Test(enabled=false)
	public void singleuser()
	{
		
		
		given().get("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		
		
		
		
	}
	@Test(enabled=false)
	public void singleusernotfound()
	{
		
		
		given().get("https://reqres.in/api/users/23").then().statusCode(404).log().all();
		
		
		
		

	}
	@Test(enabled=false)
	public void list_resource()
	{
		
		
		given().get("https://reqres.in/api/unknown").then().statusCode(200).log().all();
		
		
		
		

	}
	@Test(enabled=false)
	public void single_resource()
	{
		
		
		given().get("https://reqres.in/api/unknown/2").then().statusCode(200).log().all();
		
		
		
		

	}
	@Test(enabled=false)
	public void single_resourcenot_found()
	{
		
		
		given().get("https://reqres.in/api/unknown/23").then().statusCode(404).log().all();
		
		
		
		

	}
	@Test(enabled=true)
	public void create()
	{
		
		
		
		JSONObject js= new JSONObject();
		js.put("name", "alok");
		js.put("job", "tester");
		given().body(js).when().post("https://reqres.in/api/users").then().statusCode(201).log().all();
		
		
		

	}
	
	@Test(enabled=false)
	public void update()
	{
		
		
		
		JSONObject js= new JSONObject();
		js.put("name", "alok1");
		js.put("job", "tester");
		given().body(js.toJSONString()).when().put("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		
		

	}
	
	@Test(enabled=false)
	public void patch()
	{
		
		
		
		JSONObject js= new JSONObject();
		js.put("name", "alok12");
		js.put("job", "tester");
		given().body(js).when().patch("https://reqres.in/api/users/2").then().statusCode(200).log().all();
		
		

	}
	@Test(enabled=false)
	public void register()
	{
		JSONObject js= new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "pistol");
		
//		 Response alok=given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/register");
//		 alok.prettyPrint();
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/register").then().statusCode(200).log().all();
	}
	
	@Test(enabled=false)
	public void register_notsuccess()
	{
		JSONObject js= new JSONObject();
		js.put("email", "sydney@fife");
		
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/register").then().statusCode(400).log().all();
	}
	@Test(enabled=false)
	public void login()
	{
		JSONObject js= new JSONObject();
		js.put("email", "eve.holt@reqres.in");
		js.put("password", "cityslicka");
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/login").then().statusCode(200).log().all();
		
		
		
		
	}
	@Test(enabled=false)
	public void login_notsuccess()
	{
		JSONObject js= new JSONObject();
		js.put("email", "peter@klaven");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js).post("https://reqres.in/api/login").then().statusCode(400).log().all();
		
		
		
		
	}
	
	@Test(enabled=false)
	public void delayedres()
	{
		JSONObject js= new JSONObject();
		js.put("email", "peter@klaven");
		
		given().contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString()).post("https://reqres.in/api/users?delay=3").then().statusCode(200).log().all();
		
		
		
		
	}
}
