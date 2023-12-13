package EduIT;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class TryCatch {
	@Test
	public void testSeleniumExample() {
		WebDriver driver = null;
		String URL="http://www.automationpractice.pl/index.php?controller=authentication&back=my-account";
		String PATH="..\\EduIT\\Drivers\\chromedriver.exe";
        
		By searchqueryLocator=By.cssSelector("input[placeholder='Search']");
		
        try {

			System.setProperty("webdriver.chrome.driver", PATH);
			ChromeOptions options=new ChromeOptions();
			options.addArguments("remote-allow-origins=*");
			driver= new ChromeDriver(options);
			
			driver.get(URL);
			driver.manage().window().maximize();

			WebElement txtBuscador=driver.findElement(searchqueryLocator);

			txtBuscador.clear();

			txtBuscador.sendKeys("Blouse");

			txtBuscador.sendKeys(Keys.ENTER);


		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (driver != null) {
				driver.close();
			}
		}
	}
}