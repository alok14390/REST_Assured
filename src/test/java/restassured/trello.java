package restassured;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

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

public class trello {
	
	public static String baseuri="https://api.trello.com";
	public String id;
	
	@Test(enabled=true)
	public void createBoard()
	{
	   
		
		baseURI=baseuri;
		given().queryParam("name","success")
		.queryParam("key","29650a81efbd9758aa17f5b32af1e28f")
.queryParam("token","fba0ea5bfc2e10ae0b9aa0a5a6bd89c79a07eb75b3c65392320f00001c1ffa83")
.when()
.contentType(ContentType.JSON).accept(ContentType.JSON)
.post("/1/boards/").then().statusCode(200).log().all();
		Response res=given().queryParam("name","success")
				.queryParam("key","29650a81efbd9758aa17f5b32af1e28f")
		.queryParam("token","fba0ea5bfc2e10ae0b9aa0a5a6bd89c79a07eb75b3c65392320f00001c1ffa83")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.post("/1/boards/").then().extract().response();
		String s=res.asString();
		JsonPath jt=new JsonPath(s);
		id=jt.get("id");
		System.out.println(id);
		
		
	}
	
	
	@Test(enabled=false)
	public void updateboard()
	{
	   
		
		baseURI=baseuri;
		//JSONObject js=new JSONObject();
		//js.put("name", "Testing");
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.put("/1/boards/"+id).then().log().all();
		
	}
	
	
	@Test(enabled=false)
	public void deleteBoard()
	{
	   
		
		baseURI=baseuri;
		//JSONObject js=new JSONObject();
		//js.put("name", "Testing");
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.delete("/1/boards/"+id).then().log().all();
		
	}
	@Test(enabled=false)
	public void getallboards()
	{
	   
		
		baseURI=baseuri;
		//JSONObject js=new JSONObject();
		//js.put("name", "Testing");
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.get("/1/members/me/boards").then().log().all();
		
	}
	
	
	@Test(enabled=true)
	public void getaboard()
	{
	   
		
		baseURI=baseuri;
		//JSONObject js=new JSONObject();
		//js.put("name", "Testing");
		
		given().queryParam("key","d82314f6caf0c20a8fc504bd95dbb372")
		.queryParam("token","6ee9cda44a7520df4cd5236ac30ea3cb679165de225ef3bbc9c272ff84b3d531")
		.when()
		.contentType(ContentType.JSON).accept(ContentType.JSON)
		.get("/1/boards/"+id).then().log().all();
		
	}
		
		
	}
	
	
	
	