package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.ChangePasswordPage;
import pages.LoginPage;
import utils.DriverFactory;
import utils.ScreenshotUtil;

public class ChangePasswordSteps {

	private WebDriver driver;
	private LoginPage loginPage;
	private ChangePasswordPage changePasswordPage;

	@Before
	public void setUp() {
		driver = DriverFactory.initializeDriver();  // Use existing WebDriver instance
		driver.manage().window().maximize();
		loginPage = new LoginPage(driver);
		changePasswordPage = new ChangePasswordPage(driver);
	}

	@Given("User is logged in with email {string} and password {string}")
	public void userIsLoggedInWithEmailAndPassword(String email, String password) {
		driver.get("https://www.bookswagon.com");

		ScreenshotUtil.captureScreenshot(driver, "Before_Login");

		if (!loginPage.isUserLoggedIn()) {
			loginPage.enterEmail(email);
			loginPage.enterPassword(password);
			loginPage.clickLogin();
		}

		ScreenshotUtil.captureScreenshot(driver, "After_Login");
		Assert.assertTrue(loginPage.isUserLoggedIn(), "User login failed.");
	}

	@Given("User navigates to the Change Password page")
	public void user_navigates_to_the_change_password_page() {
		Assert.assertTrue(loginPage.isUserLoggedIn(), "User must be logged in before navigating to Change Password.");
		changePasswordPage.navigateToChangePassword();
		ScreenshotUtil.captureScreenshot(driver, "Navigate_ChangePassword");
	}

	@When("User enters current password {string}, new password {string}, and confirms password {string}")
	public void user_enters_current_password_new_password_and_confirms_password(String currentPassword, String newPassword, String confirmPassword) {
		changePasswordPage.enterCurrentPassword(currentPassword);
		changePasswordPage.enterNewPassword(newPassword);
		changePasswordPage.enterConfirmPassword(confirmPassword);
		changePasswordPage.clickChangePassword();
		ScreenshotUtil.captureScreenshot(driver, "After_ChangePassword");
	}

	@Then("Password change success message is displayed")
	public void passwordChangeSuccessMessageIsDisplayed() {
		Assert.assertTrue(changePasswordPage.isPasswordChangedSuccessfully(), "Password change message was not displayed.");
		ScreenshotUtil.captureScreenshot(driver, "Success_Message");
	}

	@After
	public void tearDown() {
		DriverFactory.quitDriver();
	}
}






//package stepdefinitions;
//
//import io.cucumber.java.After;
//import io.cucumber.java.Before;
//import io.cucumber.java.en.*;
//import org.openqa.selenium.WebDriver;
//import org.testng.Assert;
//import pages.ChangePasswordPage;
//import pages.HomePage;
//import pages.LoginPage;
//import utils.DriverFactory;
//import utils.ScreenshotUtil;
//
//import java.time.Duration;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class ChangePasswordSteps {
//
//	private LoginPage loginPage;
//	private ChangePasswordPage changePasswordPage;
//	WebDriver driver;
//	WebDriverWait wait;
//
//	//    @Before
//	//    public void setUp() {
//	//        driver = DriverFactory.getDriver();
//	//        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//	//        loginPage = new LoginPage(driver);
//	//        changePasswordPage = new ChangePasswordPage(driver);
//	//    }
//	@Before
//	public void setUp() {
//		driver = DriverFactory.initializeDriver();
//		driver.manage().window().maximize();
//		loginPage = new LoginPage(driver);
//		changePasswordPage = new ChangePasswordPage(driver);
//	}
//
//	@Given("User is logged in with email {string} and password {string}")
//	public void userIsLoggedInWithEmailAndPassword(String email, String password) {
//		driver.get("https://www.bookswagon.com"); 
//
//		ScreenshotUtil.captureScreenshot(driver, "Before_Login");
////
////		loginPage.enterEmail(email);
////		loginPage.enterPassword(password);
////		loginPage.clickLogin();
//	    if (!loginPage.isUserLoggedIn()) {
//	        loginPage.enterEmail(email);
//	        loginPage.enterPassword(password);
//	        loginPage.clickLogin();
//	    }
//	    
//
//		ScreenshotUtil.captureScreenshot(driver, "After_Login");
//
//		Assert.assertTrue(loginPage.isUserLoggedIn(), "User login failed.");
//	}
//
////	@When("User navigates to Change Password page")
////	public void userNavigatesToChangePasswordPage() {
////		changePasswordPage.navigateToChangePassword();
////		ScreenshotUtil.captureScreenshot(driver, "Navigate_ChangePassword");
////	}
//	@Given("User navigates to the Change Password page")
//    public void user_navigates_to_the_change_password_page() {
//        // Ensure user is logged in before changing password
//        if (!loginPage.isUserLoggedIn()) {
//            loginPage.enterEmail("testuser@example.com");
//            loginPage.enterPassword("Test@123");
//            loginPage.clickLogin();
//            ScreenshotUtil.captureScreenshot(driver, "Navigate_ChangePassword");
//        }
//
//        changePasswordPage.navigateToChangePassword();
//    }
//
//	@When("User enters current password {string}, new password {string}, and confirms password {string}")
//	public void user_enters_current_password_new_password_and_confirms_password(String currentPassword, String newPassword, String confirmPassword) {
//	    changePasswordPage.enterCurrentPassword(currentPassword);
//	    changePasswordPage.enterNewPassword(newPassword);
//	    changePasswordPage.enterConfirmPassword(confirmPassword);
//	    changePasswordPage.clickChangePassword();
//	    ScreenshotUtil.captureScreenshot(driver, "After_ChangePassword");
//	}
//
//	
//	@Then("Password change success message is displayed")
//	public void passwordChangeSuccessMessageIsDisplayed() {
//		Assert.assertTrue(changePasswordPage.isPasswordChangedSuccessfully(), "Password change message was not displayed.");
//		ScreenshotUtil.captureScreenshot(driver, "Success_Message");
//	}
//
//	@After
//	public void tearDown() {
//		DriverFactory.quitDriver();
//	}
//}
