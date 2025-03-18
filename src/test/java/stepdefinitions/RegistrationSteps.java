package stepdefinitions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.RegistrationPage;
import utils.DriverFactory;

public class RegistrationSteps {
	private WebDriver driver = DriverFactory.getDriver();
	private RegistrationPage registrationPage;

	WebDriverWait wait;

	@Before("@RegistrationTest")
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		registrationPage = new RegistrationPage(driver);
	}

	@Given("User is on the signup page")
	public void user_is_on_signup_page() {
		driver.get("https://www.bookswagon.com/login?q=signup");    
	}

	@When("User enters name {string} and mobile number {string}")
	public void user_enters_name_and_mobile_number(String name, String mobile) {
		registrationPage.enterName(name);
		registrationPage.enterMobileNumber(mobile);
	}

	@And("User completes the CAPTCHA manually")
	public void user_completes_captcha_manually() {
		try {
			driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'recaptcha')]")));

			WebElement captchaCheckbox = new WebDriverWait(driver, Duration.ofSeconds(10))
					.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div.recaptcha-checkbox-border")));
			captchaCheckbox.click();

			driver.switchTo().defaultContent();

			System.out.println("Please complete the CAPTCHA manually within 30 seconds...");
			Thread.sleep(30000);

		} catch (Exception e) {
			System.out.println("Unable to interact with CAPTCHA. Please solve it manually if visible.");
			try {
				Thread.sleep(30000); // Extra wait for manual handling if the automated step fails
			} catch (InterruptedException ex) {
				ex.printStackTrace();
			}
		}
	}

	@And("Clicks on the continue button")
	public void clicks_on_continue_button() {
		registrationPage.clickContinue();
	}

	@And("User manually enters OTP and submits")
	public void user_manually_enters_otp() {
		System.out.println("Please enter the OTP manually within 30 seconds...");
		try {
			Thread.sleep(30000); // Pause for manual OTP entry
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Then("User should be registered successfully")
	public void user_should_be_registered_successfully() {
		Assert.assertTrue(driver.getPageSource().contains("Welcome"), 
				"Registration was not successful.");
	}

	@After("@RegistrationTest")
	public void tearDown() {
		driver.quit();
	}
}
