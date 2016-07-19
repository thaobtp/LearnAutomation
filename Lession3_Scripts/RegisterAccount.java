package Lession3SeleniumWebPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Lession3_Page.AccountPage;
import Lession3_Page.RegisterPage;

/**
 * Create new account to access to the system
 * 
 * @author ThaoBTP
 *
 */
public class RegisterAccount {

	WebDriver driver = new FirefoxDriver();;
	CommonBase common = new CommonBase(driver);
	RegisterPage registerPage = new RegisterPage(driver);
	AccountPage accountPage = new AccountPage(driver);

	// Lưu email which exists in the system
	public static String existsEmail = "name@gmail.com";

	public RegisterAccount() {
		driver = new FirefoxDriver();
	}

	// Input account info and click register
	public void registerAccount(String firstName, String lastName,
			String emailAddress, String passWord, String confirmPassWord) {
		try {
			registerPage.inputFirstName(firstName);
			registerPage.inputLastName(lastName);
			registerPage.inputEmailAddress(emailAddress);
			registerPage.inputPassWord(passWord);
			registerPage.inputconfirmPassWord(confirmPassWord);
			registerPage.clickRegisterBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Register account successful
	@Test
	public void registerSuccess() {
		try {
			// random Email
			registerPage.emailAddress = common
					.randomEmail(registerPage.emailAddress);

			// Input account
			registerAccount(registerPage.fristName, registerPage.lastName,
					registerPage.emailAddress, registerPage.passWord,
					registerPage.confirmPassWord);

			// check register successful
			// get info message
			String currentPage = common.getCurrentPage();
			Assert.assertEquals(currentPage, accountPage.accountInfoUrl);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Register account fail
	@Test
	public void registerFail() {
		try {
			// Input account
			registerAccount(registerPage.fristName, registerPage.lastName,
					existsEmail, registerPage.passWord,
					registerPage.confirmPassWord);

			// Check register fail
			String errorMessage = registerPage.registerFail();
			Assert.assertEquals(errorMessage, registerPage.errorExpectedMessage);			
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Open create page
	@BeforeTest
	public void openRegisterPage() {
		common.openBrowser(RegisterPage.createPage);
	}

	// close browser
	@AfterTest
	public void closeBrowser() {
		common.closeBrowser();
	}

	/*
	 * public static void main(String[] args) {
	 * 
	 * driver = new FirefoxDriver(); CommonBase common = new CommonBase(driver);
	 * 
	 * // Open create page common.openBrowser(RegisterPage.createPage);
	 * 
	 * // register successful registerSuccess();
	 * 
	 * // logout common.click(LoginPage.accountLocator);
	 * common.click(LoginPage.logoutLocator);
	 * 
	 * // Chuyển sang trang register gotoRegisterPage();
	 * 
	 * // Đăng ký fail registerFail();
	 * 
	 * // close browser common.closeBrowser(); }
	 */
}
