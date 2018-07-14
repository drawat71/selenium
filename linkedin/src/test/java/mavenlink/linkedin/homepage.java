package mavenlink.linkedin;


import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.beust.testng.TestNG;

import Pageobjects.jobspage;
import Pageobjects.landingpage;


public class homepage extends base{
	@Test(dataProvider="getdata")
	
	public void basepagenavigation(String username ,String password) 
	
	{
		try {
			initiliazedriver();
		
		 //returning base driver
		driver.manage().window().maximize();
		driver.get(prop.getProperty("URL"));
		landingpage l =new landingpage(driver); // calling features of other class by creating object .
	jobspage JP= new jobspage(driver);
	l.getemail().sendKeys(username);
	l.password().sendKeys(password);
	l.submit().click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	Assert.assertEquals(l.jobtitle().getText(),"Jobs");
	l.jobtitle().click();
	System.out.println("searchlink" + JP.searchjob());
	//JP.searchjob().click();
	//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	JP.enterjobname();
	JP.enterjoblocation();
	JP.searchbuton().click();
	JP.linkfeatures();
	driver.manage().timeouts().implicitlyWait(90,TimeUnit.SECONDS);
	Thread.sleep(1000);
	//js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
	((JavascriptExecutor) driver).executeScript("scroll(0,2300)");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,3400)");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,2300)");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
	Thread.sleep(1000);
	((JavascriptExecutor) driver).executeScript("scroll(0,100)");
	JP.developerlinkclick();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	@DataProvider
	public Object[][] getdata()
	{
		//row stands for how many different data test should run 
		//columns stand for how many values for each test
		//0 row
		Object[][] data = new Object[1][2];
		data[0][0]="it.jjayashree@gmail.com";
		data[0][1]="1transaction";
		
		//data[1][0]="it.dishantrawat@gmail.com";
		//data[1][1]="Sunday1!";
		
		
		return data;
		
		
	
}}