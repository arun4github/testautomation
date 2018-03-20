package com.att.selng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelngEg {
	
	public String searchProduct(String keyword)
	{
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\ar7117.ITSERVICES\\Documents\\Softwares\\webdrivers\\chromedriver.exe");
		System.setProperty("webdriver.chrome.driver", "/Users/arunrajrajendran/Applications/chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Macbook pro");
		driver.findElement(By.xpath(".//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.xpath(".//*[@id=\"result_0\"]/div/div/div/div[2]/div[1]/div[1]/a/h2")).click();
		driver.findElement(By.id("add-to-cart-button")).click();
		driver.findElement(By.id("hlb-ptc-btn-native")).click();
		
		
		return null;
	}
	
	public static void main(String ar[])
	{
		SelngEg selEg= new SelngEg();
		selEg.searchProduct("macbook pro");
	}

}
