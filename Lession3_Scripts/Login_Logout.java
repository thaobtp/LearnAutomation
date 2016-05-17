package Lession3SeleniumWebPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Lession3_Page.AccountPage;
import Lession3_Page.LoginPage;

/**
 * Login with account valid
 * 
 * @date 16/6/2016
 * @author ThaoBTP
 *
 */

public class Login_Logout {

	WebDriver driver = new FirefoxDriver();
	CommonBase common = new CommonBase(driver);
	LoginPage loginPage = new LoginPage(driver);
	AccountPage accountPage = new AccountPage(driver);

	String excelFilePath = "C:\\Users\\ThaoBTP\\Desktop\\CSV\\username.xlsx";
	String sheetName = "Sheet1";
	String userName = "";
	String passWord = "";
	
	public Login_Logout() {
		driver = new FirefoxDriver();
	}

	// Login to system successful
	@Test
	public void loginSuccess() {
		try {						
			userName = common.getDataFromExcel(excelFilePath, sheetName, 1, 0);
			passWord = common.getDataFromExcel(excelFilePath, sheetName, 1, 1);
			
			// login with email, passWord valid
			loginPage.login(userName, passWord);			
			// loginPage.login(loginPage.validEmail, loginPage.passWord);

			// get info messag1
			String currentPage = common.getCurrentPage();
			String pageTitle = loginPage.getMessageLoginSuccess();

			// Verify login successful
			boolean isSuccessMessage = common.CompareString(pageTitle,
					loginPage.expectedPageTitleMessage);
			boolean isSuccessLoginPage = common.CompareString(currentPage,
					accountPage.accountUrl);

			if (isSuccessMessage && isSuccessLoginPage) {
				common.printLn("Login thành công");
			}
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Login to system fail
	@Test
	public void loginFail() {
		try {
			
			userName = common.getDataFromExcel(excelFilePath, sheetName, 2, 0);
			passWord = common.getDataFromExcel(excelFilePath, sheetName, 2, 1);
			
			// login with account which not exists in the system
			loginPage.login(userName, passWord);
			//loginPage.login(loginPage.invalidEmail, loginPage.passWord);

			// get info message
			String currentPage = common.getCurrentPage();
			String errorMessage = loginPage.getMessageLoginFail();

			// Verify login fail
			boolean isErrorMessage = common.CompareString(errorMessage,
					loginPage.expectedErrorMessage);
			boolean isFailLoginPage = common.CompareString(currentPage,
					loginPage.loginUrl);

			if (isErrorMessage && isFailLoginPage) {
				common.printLn("Login fail");
			}
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// Open fire fox browser
	@BeforeClass
	public void openLoginPage() {
		common.openBrowser(loginPage.loginUrl);
	}

	// close browser
	@AfterClass
	public void closeBrowser() {
		common.closeBrowser();
	}

	/*
	 * public static void main(String[] args) { driver = new FirefoxDriver();
	 * 
	 * CommonBase common = new CommonBase(driver); LoginPage loginPage = new
	 * LoginPage(driver); AccountPage accountPage = new AccountPage(driver);
	 * 
	 * // Open fire fox browser common.openBrowser(loginPage.loginUrl);
	 * 
	 * // Check login success loginSuccess();
	 * 
	 * // logout logout();
	 * 
	 * // Navigate to loginPage accountPage.goToLoginPage();
	 * 
	 * // Check login fail loginFail();
	 * 
	 * // close browser common.closeBrowser(); }
	 */
}
