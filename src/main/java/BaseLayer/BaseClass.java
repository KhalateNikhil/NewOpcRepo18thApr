package BaseLayer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	//create constructor of BaseClass
	protected static Properties prop;
	protected static WebDriver driver;
	public BaseClass()
	{
		//create object of file and check file is present or not in desired location
		
		File f= new File(System.getProperty("user.dir")+"\\src\\main\\java\\ConfigurationLayer\\opc.properties");
		//read the file
		
		try {
			FileInputStream fis= new FileInputStream(f);
			
			//create object properties class
			 prop= new Properties();
			 
			 //load the properties file in current class
			 
			 prop.load(fis);
			 
	} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static void initialization()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\AllDriversFolder\\chromedriver.exe");
		 driver= new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
		 driver.manage().deleteAllCookies();
		 
		 //call url from properties class using getproperty method
		String url= prop.getProperty("Url");
		driver.get(url);
	}
	
	
	
	
	
	
	
}
