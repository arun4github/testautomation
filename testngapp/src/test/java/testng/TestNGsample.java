package testng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.att.selng.RestClient;
import com.att.selng.SelngEg;
import com.att.selng.Userdata;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.Assert;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Test
public class TestNGsample {
	
	 SelngEg selNg;
	  String getEPurl=null;
	  RestClient restClient;
	String finalUrl;
	@BeforeTest(groups= {"seltest"})
	public void beforeTest()
	{
		 selNg = new SelngEg();
		  
		  getEPurl="https://reqres.in";
		  restClient = new RestClient();
	}
	@Test
  public void loadURLTest() {
		
	  String finalurl=selNg.getPageUrl("https://www.amazon.com");
	  assertEquals(finalurl, "https://www.amazon.com/");
  }
	@Test(dependsOnMethods= {"loadURLTest"})
  public void clickedContentTrue() {
	  try {
		  
		boolean value=selNg.searchProduct("https://www.amazon.com","macbookPro");
		assertEquals(value, true);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
	
	//@Test(groups= {"apitest"})
	  public void getStatusCodeTestPass() throws ClientProtocolException, IOException {
		  finalUrl=getEPurl+"/api/users/2";
		  CloseableHttpResponse getResponse=restClient.getRequest(finalUrl);
		  int statusCode=getResponse.getStatusLine().getStatusCode();
		  Assert.assertEquals(200, statusCode);
		  finalUrl=null;
		 
	  }
	  
	//@Test(groups= {"apitest"})
	  public void getStatusCodeTestFailure() throws ClientProtocolException, IOException {
		  finalUrl=getEPurl+"/api/users/245535";
		  CloseableHttpResponse getResponse=restClient.getRequest(finalUrl);
		  int statusCode=getResponse.getStatusLine().getStatusCode();
		  
		  Assert.assertEquals(404, statusCode);
		  finalUrl=null;
	  }
	  
	  
	  
//	@Test(groups= {"apitest"})
	  public void post_user_data_test_pass() throws JsonGenerationException, JsonMappingException, IOException
	  {
		  finalUrl= getEPurl+"/api/users";
		HashMap<String,String> userMap= new HashMap<String,String>();
		userMap.put("Content-Type", "application/json");
		//jackson API:
				ObjectMapper mapper = new ObjectMapper();
				Userdata userdata = new Userdata();
				userdata.setName("black panther");
				userdata.setJob("Guard humans");
				mapper.writeValue(new File("/Users/arunrajrajendran/git/testngapp/src/main/java/com/att/selng/userdata.json"), userdata);
				String usersJsonString = mapper.writeValueAsString(userdata);
				System.out.println(usersJsonString);
				CloseableHttpResponse postResponse=restClient.postRequest(finalUrl, usersJsonString, userMap);
				int statusCode=postResponse.getStatusLine().getStatusCode();
				System.out.println("statusCode--"+statusCode);
				assertEquals(statusCode, 201);
		
	  }
  
  
  /*@AfterTest
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(3000);
  selNg.quitDriver();
  }*/

}
