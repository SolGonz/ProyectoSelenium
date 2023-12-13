package EduIT;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Laboratorio2 {
	
	@Test
	public void lab2_E1Test() {
		
		String url = "http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		
		System.setProperty("webdriver.chrome.driver","..\\EduIT\\Drivers\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		
		//Campo correo
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo"+Math.random()+"@correo.com");
		
		
		//Boton crear una cuenta
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		//Espera hasta que el radio sea clickeable
		WebDriverWait mywait = new WebDriverWait(driver,10);
		mywait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@id,'id_gender1')]")));
        
		//Radio gender
        WebElement radioGender = driver.findElement(By.id("id_gender1"));
        radioGender.click();
		
		//First name
		WebElement txtFirstName = driver.findElement(By.id("customer_firstname"));
		txtFirstName.sendKeys("Pepe");
		
		//Last name
		WebElement txtLastName = driver.findElement(By.id("customer_lastname"));
		txtLastName.sendKeys("Palos");
		
		
		//Password
		WebElement txtPassword = driver.findElement(By.id("passwd"));
		txtPassword.sendKeys("123456");
		
		//drop day
		Select drpDay = new Select(driver.findElement(By.id("days")));
		drpDay.selectByValue("15");
		
		//drop month
		Select drpMonth = new Select(driver.findElement(By.id("months")));
		drpMonth.selectByValue("4");
		
		//drop year
		Select drpYear = new Select(driver.findElement(By.id("years")));
		drpYear.selectByValue("1992");
		
		//Boton registro
		WebElement btnRegister = driver.findElement(By.id("submitAccount"));
		btnRegister.click();
		
		driver.quit();
		
	
	}
	
}
