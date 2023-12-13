package EduIT;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class Laboratorio1 {
	
	@Test @Ignore
	public void lab1_test() {
		
		System.out.println("Hola mundo de Automatización");
	}
	
	@Test @Ignore
	public void lab1_e1() {
		
		System.setProperty("webdriver.chrome.driver","..\\EduIT\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php");
	}
	
	@Test
	public void lab1_e2() {
		
		System.setProperty("webdriver.gecko.driver","..\\EduIT\\Drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		driver.get("http://www.automationpractice.pl/index.php");
	}
	@Test @Ignore
	public void lab1_e3() {
		System.setProperty("webdriver.chrome.driver","..\\EduIT\\Drivers\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://www.automationpractice.pl/index.php");
		
		driver.manage().window().maximize();
		
		WebElement txtBuscador = driver.findElement(By.id("search_query_top"));
		
		txtBuscador.sendKeys("Blouse");
		
		txtBuscador.sendKeys(Keys.ENTER);
		
	}
}
