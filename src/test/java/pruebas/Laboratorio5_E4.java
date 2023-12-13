package pruebas;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Laboratorio5_E4 {
	
	WebDriver driver;

	String URL="https://demo.guru99.com/test/table.html";
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
	public void verCelda() {
		
		WebElement verCelda=driver.findElement(By.xpath("//tbody/tr[4]/td[3]"));
		Assert.assertEquals(verCelda.getText(),"8");
		
	}

}
