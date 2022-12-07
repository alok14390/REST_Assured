package restassured;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
public class googlemaps{
	
	
	public static String Addurl="http://216.10.245.166";///maps/api/place/add/json?key= qaclick123";
	
	public static String delurl="http://216.10.245.166";///maps/api/place/delete/json?key=qaclick123";
	
//	@Test
//	public void srinath()
//	{
//		
//		Response res=RestAssured.get(Addurl);
//	}
	public String str;
	@Test(enabled=true)
	public void add()
	{
   	JSONArray ja=new JSONArray();	
	JSONObject js=new JSONObject();
	JSONObject jy=new JSONObject();
	
	    ja.add(jy);
		jy.put("lat", 38.383494);
		jy.put("lng", 38.383494);
		js.put("location",jy);
		js.put("accuracy", 50);
		js.put("name", "Frontline house");
		js.put("phone_number", "983 893 3937");
		js.put("address", "29, side layout, cohen 09");
		js.put("types", "shoe park");
		js.put("website", "http://google.com");
		js.put("language", "French-IN");
		given().queryParam("key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js.toJSONString())
		.when().post("http://216.10.245.166/maps/api/place/add/json/").then().statusCode(200).log().all();
		 str=js.toString();
		JsonPath jt=new JsonPath(str);
		jt.get("place_id");
		
		System.out.println(js);		
	}
	
	@Test(enabled=false)
	public void delete()
	{
		
	JSONObject js=new JSONObject();
	
		js.put("place_id", "ae0c0633f5e9acca75518a62c6ee3baf");
		
		given().queryParam("key","qaclick123").contentType(ContentType.JSON).accept(ContentType.JSON).body(js)
		.when().post("http://216.10.245.166/maps/api/place/delete/json/").then().statusCode(200).log().all();
		
		System.out.println(js);		
	}
	
	
	
	
	
	
	
	
	
	
	
}