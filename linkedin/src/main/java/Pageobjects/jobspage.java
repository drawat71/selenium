package Pageobjects;

import java.awt.AWTException;
import java.awt.Desktop.Action;
import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.swing.text.Document;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jobspage {

	WebDriver driver;
	
	public jobspage(WebDriver driver) {
		super();
		this.driver = driver;
	}



	By Seachjobs = By.xpath("//div[@class='jobs-search-box__input jobs-search-box__input--keyword']");
	By searchlocation= By.xpath("//div[@class='jobs-search-box__input jobs-search-box__input--location ']");
	By searchbutton = By.xpath("//button[@class='jobs-search-box__submit-button button-secondary-large-inverse']");
	By Linkedfeatures = By.xpath("//h3[text()='LinkedIn Features']");	
	By easeaply= By.xpath("//span[text()='Easy Apply']");
	By Easeaplybutn =By.xpath("//fieldset[@class='search-s-facet__values search-s-facet__values--is-floating search-s-facet__values--f_LF']//button[text()='Apply']");
	By Javadevlink= By.xpath("//h3[@class='job-card-search__title lt-line-clamp lt-line-clamp--multi-line ember-view']");
	By SplitView = By.xpath("//p[text()='Split View']");
	By classicview = By.xpath("//button[text()='Classic View']");
	 
	public WebElement searchjob()
	{
				return driver.findElement(Seachjobs);
	
	}
	
public WebElement location()
{
	return driver.findElement(searchlocation) ;
}
	
public WebElement searchbuton()
{
return driver.findElement(searchbutton);
	
}

public void enterjobname()
{
Actions action= new Actions(driver);
action.moveToElement(driver.findElement(By.xpath("//div[@class='jobs-search-box__input jobs-search-box__input--keyword']")));
action.click();
action.sendKeys("java");
action.build().perform();
}

public void enterjoblocation()
{
Actions action= new Actions(driver);
action.moveToElement(driver.findElement(By.xpath("//div[@class='jobs-search-box__input jobs-search-box__input--location ']")));
action.click();
action.sendKeys("London");
action.build().perform();
}


public  void linkfeatures()
{
	driver.findElement(Linkedfeatures).click();
	driver.findElement(easeaply).click();
	driver.findElement(Easeaplybutn).click();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	driver.findElement(SplitView).click();
	driver.findElement(classicview).click();
	
}

public void developerlinkclick() throws InterruptedException, AWTException
{
	
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	List<WebElement> joblist=driver.findElements(By.xpath("//h3[@class='job-card-search__title lt-line-clamp lt-line-clamp--multi-line ember-view']"));
	int length = joblist.size();
	System.out.println("lengthsize " + length);
	driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
	 
	for (int i=0 ; i< length ;i++)
		{
		try {
			
			
			joblist.get(i).click();
			if(!driver.findElements(By.xpath("//button[@class='jobs-s-apply__button js-apply-button']")).isEmpty())
				
			{
				driver.findElement(By.xpath("//button[@class='jobs-s-apply__button js-apply-button']")).click();//THEN CLICK ON THE apply BUTTON
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement upload	=driver.findElement(By.xpath("//span[text()='Choose a recent resume or upload a new one']"));
				upload.click(); //click file upload
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				WebElement newresume=driver.findElement(By.xpath("//input[@class='jobs-apply-form__resume-file-input']"));
				newresume.click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				//newresume.sendKeys("C:\\Users\\drawat2\\Downloads\\jayas\\Jayashree Resume.pdf");
				newresume.sendKeys("C:\\Users\\Administrator\\Jayashree Resume.pdf");
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				// pressing keys with the help of keyPress and keyRelease events
				Robot robot =new Robot();
				robot.keyPress(KeyEvent.VK_ALT);
				robot.keyPress(KeyEvent.VK_F4);
				robot.keyRelease(KeyEvent.VK_ALT);
				driver.findElement(By.id("apply-form-phone-input")).sendKeys("+917022224853");
				driver.findElement(By.xpath("//button[text()='Submit application']")).click();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				islaertpresent();
				driver.navigate().back();
				driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
				scrollloop();
				joblist=driver.findElements(By.xpath("//h3[@class='job-card-search__title lt-line-clamp lt-line-clamp--multi-line ember-view']"));
				System.out.println("newlenght" + joblist);
			}
				else
				{
					driver.navigate().back(); //DO SOMETHING ELSE AS SUBMIT BUTTON IS NOT THERE
					driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
					scrollloop();
					joblist=driver.findElements(By.xpath("//h3[@class='job-card-search__title lt-line-clamp lt-line-clamp--multi-line ember-view']"));
					System.out.println("newlenght" + joblist);	
				}
		}
		finally 
		{
		}
		}}

public void islaertpresent()
{

		if(driver.findElement(By.xpath("//h3[text()='Your application has been submitted!']")) != null)
		{
	    System.out.println("alert was present");
	   driver.findElement(By.xpath("//button[@class='artdeco-dismiss']")).click();
		}
	    else
	    {System.out.println("alert was not present");
	}}
		public void scrollloop() throws InterruptedException
		{
			((JavascriptExecutor) driver).executeScript("scroll(0,2300)");
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0,3400)");
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0,2300)");
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0,1000)");
			Thread.sleep(1000);
			((JavascriptExecutor) driver).executeScript("scroll(0,100)");
		}
}
	




