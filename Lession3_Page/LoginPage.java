package Lession3_Page;

import org.openqa.selenium.WebDriver;

import Lession3SeleniumWebPackage.CommonBase;

public class LoginPage extends CommonBase {

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public String loginUrl = "http://live.guru99.com/index.php/customer/account/login/";

	// Data input
	public String validEmail = "name@gmail.com";
	public String invalidEmail = "123@abc.com";
	public String passWord = "123456";
	public String expectedPageTitleMessage = "My Dashboard";
	public String expectedErrorMessage = "Invalid login or password.";

	// Locator of elements on page
	public String emailLocator = "id=email";
	public String passLocator = "id=pass";
	public String loginBtnLocator = "id=send2";
	public String pageTitleLocator = "xpath=.//*[@class='page-title']";
	public String errorMessageLocator = "xpath=.//*[@class='error-msg']";
	public static String accountLocator = "link=ACCOUNT";
	public static String logoutLocator = "xpath=.//*[@title='Log Out']";

	// Input email into email field
	public void inputEmail(String email) {
		clear(emailLocator);
		sendKeys(emailLocator, email);

		// Có thể dùng senkeys theo cách thứ 2
		/*
		 * common.sendKeysJS("id=email", email, 0);
		 * common.sendKeysJS("name=login[username]", email, 0);
		 * common.sendKeysJS ("class=input-text required-entry validate-email",
		 * email, 0); common.sendKeysJS("tag=input", email, 2);
		 */
	}

	// Input passWord into passWord field
	public void inputPassWord(String pass) {
		clear(passLocator);
		sendKeys(passLocator, pass);
	}

	// Click to login button to login into system
	public void clickLoginBtn() {
		click(loginBtnLocator);
	}

	// Get message when login successful
	public String getMessageLoginSuccess() {
		return getText(pageTitleLocator);
	}

	// Get message when login fail
	public String getMessageLoginFail() {
		return getText(errorMessageLocator);
	}

	// Click link account
	public void clickAccountLink() {
		click(accountLocator);
	}

	// Click on link logOut
	public void clickLogoutLink() {
		click(logoutLocator);
	}

	// Login to system
	public void login(String email, String passWord) {
		try {
			inputEmail(email);
			inputPassWord(passWord);
			// click login
			clickLoginBtn();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
