package Lession3_Page;

import org.openqa.selenium.WebDriver;

import Lession3SeleniumWebPackage.CommonBase;

public class TVPage extends CommonBase {

	public TVPage(WebDriver driver) {
		super(driver);
	}

	public static int soLuong = 4;

	// locator
	public static String quantityLocator = "id=qty";
	public static String productLocator = "xpath=.//*[@id='product-collection-image-4']";
	public static String addToCartLocator = "xpath=.//*[@title='Add to Cart']";

	// Choose product
	public void chooseProduct() throws InterruptedException {
		click(productLocator);
		Thread.sleep(3000);
	}

	// Input number product want to buy
	public void inputQuantity(String locator, int quantity) {
		clear(locator); // clear old quantity
		sendKeys(locator, String.valueOf(quantity));// input new quantity
	}

	// Input product
	public void inputNumberQuantity() {
		inputQuantity(quantityLocator, soLuong);
	}

	// click add to cart
	public void clickAddToCart() {
		click(addToCartLocator);
	}

	// Input info after click add to cart
	public void addToCart() throws InterruptedException {
		try {
			// go to tv page
			navigateURL(HomePage.homePage + HomePage.tvPage);
			Thread.sleep(3000);

			// choose product
			chooseProduct();
			Thread.sleep(3000);

			// Input number of product
			inputNumberQuantity();

			// click add to cart
			clickAddToCart();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
