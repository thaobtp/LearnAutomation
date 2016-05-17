package Lession3_Page;

import org.openqa.selenium.WebDriver;

import Lession3SeleniumWebPackage.CommonBase;

public class CheckoutPage extends CommonBase {
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	// choose country, province
	public static String country = "Vietnam";
	public static String province = "HaNoi";

	// Locator proceed to checkout page
	public static String countryLocator = "xpath=.//*[@id='country']";
	public static String provinceLocator = "xpath=.//*[@id='region']";
	public static String processBtnLocator = "xpath=.//div[3]/div/ul/li[1]/button[@title='Proceed to Checkout']";
	public static String checkOutRbtLocator = "xpath=.//*[contains(text(), 'Checkout as Guest')]";
	public static String continueBtnChkOutLocator = "id=onepage-guest-register-button";

	// Value for input to form Billing Information
	public static String blFristName = "first name";
	public static String blLastName = "last name";
	public static String blCompany = "company";
	public static String blEmail = "email@gmail.com";
	public static String blAddress = "address";
	public static String blStAddress = "street address 2";
	public static String blCity = "city";
	public static String blProvince = "Alaska";
	public static String blZip = "zip";
	public static String blCountry = "Vietnam";
	public static String blTel = "telephone";
	public static String blFax = "fax";

	// Locator billing information
	public static String blFristNameLocator = "xpath=.//*[@id='billing:firstname']";
	public static String blLastNameLocator = "xpath=.//*[@id='billing:lastname']";
	public static String blCompanyLocator = "xpath=.//*[@id='billing:company']";
	public static String blEmailLocator = "xpath=.//*[@id='billing:email']";
	public static String blAddressLocator = "xpath=.//*[@id='billing:street1']";
	public static String blStAddressLocator = "xpath=.//*[@id='billing:street2']";
	public static String blCityLocator = "xpath=.//*[@id='billing:city']";
	public static String blProvinceLocator = "xpath=.//*[@id='billing:region_id']";
	public static String blZipLocator = "xpath=.//*[@id='billing:postcode']";
	public static String blCountryLocator = "xpath=.//*[@id='billing:country_id']";
	public static String blTelLocator = "xpath=.//*[@id='billing:telephone']";
	public static String blFaxLocator = "xpath=.//*[@id='billing:fax']";

	// Locator of confirm button and payment
	public static String continueBtnChkOutLocator2 = "xpath=.//*[@id='billing-buttons-container']/button";
	public static String continueBtnChkOutLocator3 = "xpath=.//*[@id='shipping-method-buttons-container']/button";
	public static String paymentMoneyRbtLocator = "xpath=.//*[@id='checkout-payment-method-load']/dt[1]/label";
	public static String continueBtnChkOutLocator4 = "xpath=.//*[@id='payment-buttons-container']/button";
	public static String placeOrderBtnLocator = "xpath=.//*[@id='review-buttons-container']/button";
	public static String pageTitleLocator = "xpath=.//*[@class='page-title']";

	// Choose country
	public void chooseCountry() {
		chooseItem(countryLocator, country);
	}

	// Choose province
	public void chooseProvince() {
		sendKeys(provinceLocator, province);
	}

	// click proceed to checkout
	public void clickProceedToCheckout() {
		click(processBtnLocator);
	}

	// Choose checkout as Guest
	public void chooseCheckoutAsGuest() {
		click(checkOutRbtLocator);
	}

	// click continue
	public void clickContinue() throws InterruptedException {
		click(continueBtnChkOutLocator);
		Thread.sleep(3000);
	}

	// input info
	public void inputBillingInfo() {
		sendKeys(blFristNameLocator, blFristName);
		sendKeys(blLastNameLocator, blLastName);
		sendKeys(blCompanyLocator, blCompany);
		sendKeys(blEmailLocator, blEmail);
		sendKeys(blAddressLocator, blAddress);
		sendKeys(blStAddressLocator, blStAddress);
		sendKeys(blCityLocator, blCity);
		chooseItem(blProvinceLocator, blProvince);
		sendKeys(blZipLocator, blZip);
		chooseItem(blCountryLocator, blCountry);
		sendKeys(blTelLocator, blTel);
		sendKeys(blFaxLocator, blFax);
	}

	// click continue 2
	public void clickContinue2() throws InterruptedException {
		click(continueBtnChkOutLocator2);
		Thread.sleep(5000);
	}

	// click continue 3
	public void clickContinue3() throws InterruptedException {
		click(continueBtnChkOutLocator3);
		Thread.sleep(5000);
	}

	// Choose payment type
	public void chooseMoneyPaymentType() {
		// choose money
		click(paymentMoneyRbtLocator);
	}

	// click continue 4
	public void clickContinue4() throws InterruptedException {
		click(continueBtnChkOutLocator4);
		Thread.sleep(5000);
	}

	// click place order
	public void clickPlaceOrder() throws InterruptedException {
		click(placeOrderBtnLocator);
		Thread.sleep(5000);
	}

	// Input info after click proceed to check Out
	public void proceedToCheckOut() {
		try {
			// choose country
			chooseCountry();

			// choose province
			chooseProvince();

			// click proceed to checkout
			clickProceedToCheckout();
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Input billing info after click CheckOut
	public void billingInforCheckOut() {
		try {
			// Choose checkout as Guest
			chooseCheckoutAsGuest();

			// click continue
			clickContinue();

			// input info
			inputBillingInfo();

			// click continue
			clickContinue2();

			// click continue next
			clickContinue3();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Choose payment type
	public void choosePaymentType() throws InterruptedException {
		try {
			// choose money payment
			chooseMoneyPaymentType();

			// click continue
			clickContinue4();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Confirm order
	public void placeOrder() throws InterruptedException {
		try {
			// click place order
			clickPlaceOrder();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
