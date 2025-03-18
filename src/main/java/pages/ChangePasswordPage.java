package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ChangePasswordPage {
	private WebDriver driver;
	private WebDriverWait wait;

	private By accountDropdown = By.id("ctl00_lblUser");
	private By changePasswordLink = By.xpath("//*[@id=\"aspnetForm\"]/header/div[2]/div/div[3]/ul/li[1]/div/div/ul/li[7]/a");
	private By currentPasswordField = By.id("ctl00_phBody_ChangePassword_txtCurPwd");
	private By newPasswordField = By.id("ctl00_phBody_ChangePassword_txtNewPassword");
	private By confirmPasswordField = By.id("ctl00_phBody_ChangePassword_txtConfirmPwd");
	private By changePasswordButton = By.id("ctl00_phBody_ChangePassword_imgSubmit");
	private By successMessage = By.id("ctl00_phBody_ChangePassword_lblmsg");


	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	public void navigateToChangePassword() {

		wait.until(ExpectedConditions.elementToBeClickable(accountDropdown)).click();
		wait.until(ExpectedConditions.elementToBeClickable(changePasswordLink)).click();
	}

	public void enterCurrentPassword(String currentPassword) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(currentPasswordField)).sendKeys(currentPassword);
	}

	public void enterNewPassword(String newPassword) {
		driver.findElement(newPasswordField).sendKeys(newPassword);
	}

	public void enterConfirmPassword(String confirmPassword) {
		driver.findElement(confirmPasswordField).sendKeys(confirmPassword);
	}

	public void clickChangePassword() {
		driver.findElement(changePasswordButton).click();
	}

	public boolean isPasswordChangedSuccessfully() {
		try {
			return wait.until(ExpectedConditions.visibilityOfElementLocated(successMessage)).isDisplayed();
		} catch (Exception e) {
			System.out.println("Password change success message not displayed. Error: " + e.getMessage());
			return false;
		}
	}
}
