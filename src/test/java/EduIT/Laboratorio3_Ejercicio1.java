package EduIT;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Laboratorio3_Ejercicio1 {
	
	WebDriver driver;
	String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
	String PATH="..\\EduIT\\Drivers\\chromedriver.exe";
	
	@BeforeSuite
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", PATH);
		ChromeOptions options=new ChromeOptions();
		options.addArguments("remote-allow-origins=*");
		driver= new ChromeDriver(options);	
	}
	
	@BeforeTest
	public void irUrl( ) {
		
		driver.get(URL);	
	}
	
	@BeforeClass
	public void maxVentana() {

		driver.manage().window().maximize();
	}
	
	@Test(priority=1,description="TestCreat Account")
	public void registrarCuenta() {

		//Campo correo
		WebElement txtEmail = driver.findElement(By.id("email_create"));
		txtEmail.sendKeys("micorreo"+Math.random()+"@correo.com");
		
		
		//Boton crear una cuenta
		WebElement btnCreate = driver.findElement(By.name("SubmitCreate"));
		btnCreate.click();
		
		//Espera hasta que el radio sea clickeable
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
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
		
		Assert.assertEquals("http://www.automationpractice.pl/index.php?controller=my-account", driver.getCurrentUrl());
	} 
	
	@Test(enabled=false)
	public void dummyTest() {
		assertTrue(true);
	}
	
	@AfterMethod
	public void CapturaPantalla() throws Exception {
		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screen, new File("..\\EduIT\\Evidencias\\pantalla.png"));
	}
	
	
	@AfterClass
	public void finPrueba() {
		
		System.out.println("Fin de prueba");
	}
	
	@AfterTest
	public void cierraNavegador() {
		
		driver.close();
	}
	
	@AfterSuite
	public void finSuite() {
		
		System.out.println("cierre");
	}
	
	
}
