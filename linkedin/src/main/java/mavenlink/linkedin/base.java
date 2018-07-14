package mavenlink.linkedin;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class base {

public WebDriver driver;	
public Properties prop= new Properties();
	public WebDriver initiliazedriver() throws IOException
	{
		
		
/*		FileInputStream FIS = new FileInputStream("C:\\MAVENLINKED\\linkedin\\src\\data.properties");
				prop.load(FIS);*/
			
				prop.load(getClass().getResourceAsStream("data.properties"));
		String browsername= prop.getProperty("browser");
		String urlname = prop.getProperty("URL");
		
		if (browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\drawat2\\Downloads\\chromedriver_win32\\chromedriver.exe");
			 driver = new ChromeDriver();
		}
		else if (browsername.equals("firefox"))
		{
			//firefox
		}
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		return driver;
}
	
	
	
}