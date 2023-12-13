package paginas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    private By usernameTextbox = By.id("username");
    private By passwordTextbox = By.id("password");
    private By loginButton = By.xpath("//i[contains(text(),'Login')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String username, String password) {
        enterText(usernameTextbox, username);
        enterText(passwordTextbox, password);
        click(loginButton);
    }

    private void enterText(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.sendKeys(text);
    }

    private void click(By locator) {
        WebElement element = driver.findElement(locator);
        element.click();
    }
}


