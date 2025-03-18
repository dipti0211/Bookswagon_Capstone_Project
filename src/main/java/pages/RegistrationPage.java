package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPage {
	private WebDriver driver;

	private By nameInput = By.id("ctl00_phBody_SignUp_txtName");
	private By mobileInput = By.id("ctl00_phBody_SignUp_txtEmail");
	private By captchaCheckbox = By.xpath("//*[@id=\"recaptcha-anchor\"]/div[2]");
	private By continueButton = By.id("ctl00_phBody_SignUp_btnContinue");

	public RegistrationPage(WebDriver driver) {
		this.driver = driver;
	}

	public void enterName(String name) {
		driver.findElement(nameInput).sendKeys(name);
	}

	public void enterMobileNumber(String mobile) {
		driver.findElement(mobileInput).sendKeys(mobile);
	}

	public void clickContinue() {
		driver.findElement(continueButton).click();
	}

	public void focusOnCaptcha() {
		driver.findElement(captchaCheckbox).click();
	}
}
