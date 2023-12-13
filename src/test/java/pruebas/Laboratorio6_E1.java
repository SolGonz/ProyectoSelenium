package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;



public class Laboratorio6_E1 {

	WebDriver driver;


	String driverPath="..\\EduIT\\Drivers\\chromedriver.exe";
	String url="http://automationpractice.pl/index.php";

	@BeforeSuite
	public void setUp() {

		System.setProperty("webdriver.chrome.driver",driverPath);
		
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		options.addArguments("headless");		  
		
		driver= new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.get(url);

	}



	@Test
	public void verNavegador_headless() {

		WebElement txtBuscar=driver.findElement(By.cssSelector("#search_query_top"));

		txtBuscar.clear();

		txtBuscar.sendKeys("Blouse");

		txtBuscar.sendKeys(Keys.ENTER);

	}

	@AfterSuite
	public void cerrar() {
		driver.close();
	}


}
