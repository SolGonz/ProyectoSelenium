package pruebas;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserTest {
	WebDriver driver;
	String urlSite = "http://www.automationpractice.pl/index.php";
	String pathDriverChrome = "..\\EduIT\\Drivers\\chromedriver.exe";
	String pathDriverFirefox = "..\\EduIT\\Drivers\\geckodriver.exe";
	
	
	@BeforeMethod
	@Parameters("navegador")
	public void setup(String navegador) {
		
		if(navegador.equalsIgnoreCase("chrome")) {
		
			System.setProperty("webdriver.chrome.driver", pathDriverChrome);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver= new ChromeDriver(options);	
			
		}
		
		else {
			
			System.setProperty("webdriver.gecko.driver", pathDriverFirefox);
			driver = new FirefoxDriver();
			
		}
		
		driver.get(urlSite);
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void buscarPalabra( ) {
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		txtBuscador.sendKeys("Blouse");
		txtBuscador.sendKeys(Keys.ENTER);
	}
	
	
	@AfterMethod
	public void cierraNavegador() {
		driver.close();
	}
	
}
