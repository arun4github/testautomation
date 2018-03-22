package com.att.selng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SelngEg {
	
	WebDriver driver;
	
	public SelngEg()
	{
		System.setProperty("webdriver.chrome.driver", "/Users/arunrajrajendran/Applications/chromedriver");
		 driver = new ChromeDriver();
	}
	
	public String getPageUrl(String url)
	{
		
		String loadedUrl="";
		driver.get(url);
		loadedUrl=driver.getCurrentUrl();

		return loadedUrl;
	}
	
	
	
	public boolean searchProduct(String url,String keyword) throws InterruptedException
	{
		driver.get(url);
		Thread.sleep(2000);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(keyword);
		
		driver.findElement(By.xpath(".//*[@id=\"nav-search\"]/form/div[2]/div/input")).click();
		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//		System.out.println(driver.findElement(By.xpath(".//*[@id=\\\"result_1\\\"]/div/div/div/div[2]/div[1]/div[1]/a")).getText());
//		//driver.findElement(By.xpath(".//*[@id=\"result_1\"]/div/div/div/div[2]/div[1]/div[1]/a")).click();

		return driver.getCurrentUrl().contains(keyword);
	}
	
	public void quitDriver()
	{
		
		driver.quit();
	}
}
