package testng;

import org.testng.annotations.Test;

import com.att.selng.SelngEg;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class TestNGsample {
	
	private SelngEg selNg;
  @Test
  public void testSearchProduct() {
	  selNg.searchProduct("MacBook Pro");
  }
  @BeforeMethod
  public void beforeMethod() {
	  
	  selNg = new SelngEg();
  }

  @AfterMethod
  public void afterMethod() {
  }

}
