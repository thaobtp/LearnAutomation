package Lession3_Page;

import org.openqa.selenium.WebDriver;

import Lession3SeleniumWebPackage.CommonBase;

public class RegisterPage extends CommonBase {
	
	// Account info
	public String fristName = "Bui Thi";
	public String lastName = "Phuong Thao";
	public String emailAddress = "name@gmail.com";
	public String passWord = "123456";
	public String confirmPassWord = "123456";
	
	public static String accountPage = "http://live.guru99.com/index.php/customer/account/index/";
	public static String createPage = "http://live.guru99.com/index.php/customer/account/create/";
	public String errorExpectedMessage = "There is already an account with this email address. If you are sure that it is your email address, click here to get your password and access your account.";

	// Locator of account information
	public String firstNameLocator = "id=firstname";
	public String lastNameLocator = "id=lastname";
	public String emailAddressLocator = "id=email_address";
	public String passWordLocator = "id=password";
	public String confirmPassWordLocator = "id=confirmation";
	public String registerBtnLocator = "xpath=.//*[@id='form-validate']/div[2]/button";
	public String errorMessageLocator = "xpath=.//*[@class='error-msg']";

	CommonBase common = new CommonBase(_driver);
	LoginPage loginPage = new LoginPage(_driver);

	public RegisterPage(WebDriver driver) {
		super(driver);
	}

	// logOut from registerPage
	public void logOut() {
		common.click(LoginPage.accountLocator);
		common.click(LoginPage.logoutLocator);
	}

	// Input first name
	public void inputFirstName(String firstName) {

		try {
			common.sendKeys(firstNameLocator, firstName);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Input last name
	public void inputLastName(String lastName) {
		try {
			common.sendKeys(lastNameLocator, lastName);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Input emailAdress
	public void inputEmailAddress(String emailAddress) {
		try {
			common.sendKeys(emailAddressLocator, emailAddress);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Input passWord
	public void inputPassWord(String passWord) {
		try {
			common.sendKeys(passWordLocator, passWord);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Input confirmPassWord
	public void inputconfirmPassWord(String confirmPassWord) {
		try {
			common.sendKeys(confirmPassWordLocator, confirmPassWord);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Click register button
	public void clickRegisterBtn() {
		try {
			common.click(registerBtnLocator);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Get error message when register fail
	public String registerFail() {
		return common.getText(errorMessageLocator);
	}

	public void gotoRegisterPage() {
		common.navigateURL(createPage);
	}

}
