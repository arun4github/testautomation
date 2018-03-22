package testng;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.att.selng.SelngEg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;

@Test
public class TestNGsample {
	
	 SelngEg selNg;
	
	@BeforeTest
	public void beforeTest()
	{
		 selNg = new SelngEg();
	}
	@Test
  public void loadURLTest() {
	  String finalurl=selNg.getPageUrl("https://www.amazon.com");
	  assertEquals(finalurl, "https://www.amazon.com/");
  }
	@Test
  public void clickedContentTrue() {
	  try {
		boolean value=selNg.searchProduct("https://www.amazon.com","macbookPro");
		assertEquals(value, true);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

  }
  
  
  @AfterTest
  public void afterMethod() throws InterruptedException {
	  Thread.sleep(10000);
  selNg.quitDriver();
  }

}
