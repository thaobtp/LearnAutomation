package Lession3_Page;

import org.openqa.selenium.WebDriver;

import Lession3SeleniumWebPackage.CommonBase;

public class AccountPage extends CommonBase {

	public AccountPage(WebDriver driver) {
		super(driver);
	}

	public String accountUrl = "http://live.guru99.com/index.php/customer/account/";
	public String accountInfoUrl = "http://live.guru99.com/index.php/customer/account/index/";
	public static String createAccountUrl = "http://live.guru99.com/index.php/customer/account/create/";
	
	// Chuyển sang trang login
	public void goToLoginPage()
	{		
		LoginPage loginPage = new LoginPage(_driver);
		navigateURL(loginPage.loginUrl);
	}
}
