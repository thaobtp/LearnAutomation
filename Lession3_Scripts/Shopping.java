package Lession3SeleniumWebPackage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Lession3_Page.CheckoutPage;
import Lession3_Page.HomePage;
import Lession3_Page.TVPage;

/**
 * Choose product and order buy
 * 
 * @author ThaoBTP
 *
 */
public class Shopping {
	public static WebDriver driver = new FirefoxDriver();

	public Shopping() {
		driver = new FirefoxDriver();
	}

	public static String accountPage = "http://live.guru99.com/index.php/checkout/onepage/success/";

	CommonBase common = new CommonBase(driver);
	CheckoutPage checkoutPage = new CheckoutPage(driver);
	TVPage tvPage = new TVPage(driver);

	// Order
	@Test
	public void orderProduct() throws InterruptedException {
		try {
			// Choose product to add to cart
			tvPage.addToCart();

			// Input info after choose proceed to checkout
			checkoutPage.proceedToCheckOut();

			// Input billing info
			checkoutPage.billingInforCheckOut();

			// Choose payment type
			checkoutPage.choosePaymentType();

			// Order
			checkoutPage.placeOrder();

			// get info message
			String currentPage = driver.getCurrentUrl();
			String pageTitle = common.getText(CheckoutPage.pageTitleLocator);
			// Verify order successful			
			Assert.assertEquals(currentPage, pageTitle);
		} catch (Exception e) {
			common.printLn(e.toString());
		}
	}

	// open fire fox browser
	@BeforeMethod
	public void openHomePage() {
		common.openBrowser(HomePage.homePage);
	}

	// Close browser
	@AfterMethod
	public void closeBrowser() {
		common.closeBrowser();
	}

	/*
	 * public static void main(String[] args) throws InterruptedException {
	 * driver = new FirefoxDriver(); CommonBase common = new CommonBase(driver);
	 * 
	 * // open fire fox browser common.openBrowser(HomePage.homePage);
	 * 
	 * // Order boolean order = orderProduct(); if (order) {
	 * common.printLn("Đặt hàng thành công"); } else {
	 * common.printLn("Đặt hàng fail"); } // Close browser
	 * common.closeBrowser(); }
	 */
}
