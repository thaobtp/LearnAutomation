package Lession3_Page;

import org.openqa.selenium.WebDriver;

import Lession3SeleniumWebPackage.CommonBase;

public class HomePage extends CommonBase {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public static String homePage = "http://live.guru99.com/";
	public static String tvPage = "index.php/tv.html";

	// Open home page
	public void openHomePage() {
		openBrowser(homePage);
	}

	// Open TV item
	public void openTVPage() {
		openBrowser(tvPage);
	}
}
