package paginas;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class paginaLogin {

	@FindBy(id="email")
	WebElement txtEmail;
	
	@FindBy(id="passwd")
	WebElement txtPassword;
	
	@FindBy(id="SubmitLogin")
	WebElement btnLogin;
	
    @FindBy(xpath="//h1[contains(text(),'Authentication')]")
    WebElement titleForm;
	
    
	public paginaLogin(WebDriver driver) {
		
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,20),this);
		
	}
	
    public void ingresoDatos(String email,String password) {
        txtEmail.clear();
        txtEmail.sendKeys(email);
        txtPassword.clear();
        txtPassword.sendKeys(password);
        btnLogin.click();

    }
    
    public String getTextTitleForm() {

        return titleForm.getText();

    }
	
	
}
