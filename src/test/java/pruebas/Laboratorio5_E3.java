package pruebas;



import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;


public class Laboratorio5_E3 {
	
	WebDriver driver;

	String URL="https://demoqa.com/alerts";
	String PATH="..\\EduIT\\Drivers\\chromedriver.exe";

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);
		driver.get(URL);
		driver.manage().window().maximize();


	}

	@AfterSuite
	public void cierreNavegador() 
    {

		driver.close();

	}
	
	@Test
	public void popUp() throws InterruptedException{
		
		WebElement btnAlert=driver.findElement(By.id("alertButton"));
		btnAlert.click();
		
		Thread.sleep(2000);
		
		Alert popUp=driver.switchTo().alert();
		
		popUp.accept();
		

	}
	
}
