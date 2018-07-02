package Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class landingpage {
	
	public WebDriver driver;
	By email=By.xpath("//input[@class='login-email']");
	By password=By.xpath("//input[@class='login-password']");
	By submit =By.xpath("//input[@id='login-submit']");
	By jobs= By.linkText("Jobs");
	By Seachjobs = By.xpath("//div[@class='jobs-search-box__input jobs-search-box__input--keyword']");
	
public landingpage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
	
	this.driver =driver2; // this means the variable of the class is asigned to other variable 
	}

public WebElement getemail()
{
	return driver.findElement(email);
}

public WebElement password()
{
	return driver.findElement(password);
}

public WebElement submit()
{
	return driver.findElement(submit);
}

public WebElement jobtitle()
{
return driver.findElement(jobs);
}


}