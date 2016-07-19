package Lession3SeleniumWebPackage;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Verify, click, type on element of
 * http://only-testing-blog.blogspot.in/2013/09/test.html
 * 
 * @author ThaoBTP
 *
 */
public class verifyElement {
	public static String url = "http://only-testing-blog.blogspot.in/2013/09/test.html";
	public static String filePath = "C:\\Users\\ThaoBTP\\Desktop\\Image\\IMG_04032016_164458.png";

	public static void main(String[] args) throws IOException {

		// Init driver
		WebDriver driver = new FirefoxDriver();
		CommonBase common = new CommonBase(driver);

		// Open firefox browser
		common.openBrowser(url);

		// send keys first name
		common.sendKeysJS("name=fname", "Enter here", 0);

		// click button
		common.click("name=img");// browser
		// uploadFileUsingRobot(filePath);//upload file using Robot

		uploadFileUsingAutoIt();// upload file using autoIt

		common.sendKeys("xpath=.//*[@type='file']", filePath);//upload file using selenium webdriver
		

		common.click("id=submitButton");// submitQuery
		common.click("xpath=.//*[contains(text(),'Get')]");// getConfirmation
		String alertMessage = "";
		common.click("xpath=.//*[@value='Show Me Alert']");
		alertMessage = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		common.printLn(alertMessage);

		common.click("xpath=.//*[@class='post-share-buttons goog-inline-block']//*[@title='Email This']");// gmail
		common.click("xpath=.//*[@class='post-share-buttons goog-inline-block']//*[@title='BlogThis!']");// blog
		common.click("xpath=.//*[@class='post-share-buttons goog-inline-block']//*[@title='Share to Twitter']");// twitter
		common.click("xpath=.//*[@class='post-share-buttons goog-inline-block']//*[@title='Share to Facebook']");// facebook
		common.click("xpath=.//*[@class='post-share-buttons goog-inline-block']//*[@title='Share to Pinterest']");// printerest
		common.click("xpath=.//*[@class='g7Rvaf']//*[@guidedhelpid='circlepicker_button']");// addToCircles
		common.click("id=Image1_img");// browserStack

		// Select checkbox/radio button
		common.click("xpath=.//*[@value='Bike']");// bikeChk
		common.click("xpath=.//*[@value='Car']");// carChk
		common.click("xpath=.//*[@value='Boat']");// boatChk
		common.click("xpath=.//*[@value='male'");// male
		common.click("xpath=.//*[@value='female'");// female

		// select box
		Select selectBox = new Select(
				driver.findElement(By
						.xpath(".//*[@id='post-body-6522850981930750493']/div[1]/select")));
		selectBox.selectByVisibleText("");

		// Click link
		common.click("link=Facebook");// fbLink
		common.click("xpath=.//*[@class='T8b']//*[@href='https://plus.google.com/105713709239976679085']");// aravind1
		common.click("xpath=.//*[@id='Profile1']/div/dl/dt/a");// aravind2
		common.click("link=View all");// viewAll
		common.click("link=BLOG");// blogLink
		common.click("link=PAGE");// pageLink
		common.click("link=View my complete profile");// viewProfile
		common.click("link=Newer Post");// newerPost
		common.click("link=Home");// home
		common.click("link=Blogger");// blogger

		// Back page
		driver.navigate().back();
		// Verify an element in table
		List<WebElement> testTable = driver
				.findElements(By
						.xpath("xpath=.//*[@id='post-body-6522850981930750493']//*//tr[1]/td[1]"));
		int numbers = testTable.size();
		// testTable.
		if (numbers != 0) {
			for (WebElement e : testTable) {
				if (e.getText() == "11") {
					common.printLn(e.getText());
				}
			}
		}

		// close browser
		common.closeBrowser();
	}

	public static void uploadFileUsingRobot(String filePath) {
		try {
			StringSelection stringSelection = new StringSelection(filePath);
			Toolkit.getDefaultToolkit().getSystemClipboard()
					.setContents(stringSelection, null);
			Robot robot = new Robot();

			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			exp.printStackTrace();
		}
	}

	public static void uploadFileUsingAutoIt() throws IOException {
		// Cài đặt toll autoIt ở link bên dưới sau đó install autoIt tool
		// https://www.autoitscript.com/site/autoit/downloads/
		// Tạo script và save file với phần mở rộng là .au3 với nội dung như
		// sau:
		/*
		 * WinWaitActive("File Upload")
		 * Send("C:\Users\ThaoBTP\Desktop\Image\IMG_04032016_164458.png")
		 * Send("{ENTER}")
		 */
		// Compile file .au3 vừa tạo sang thành dạng file .exe bằng cách
		// 1. Click chuột phải vào file muốn compile --> Chọn run script
		// 2. Click chuột phải vào file muốn compile --> Chọn compile script
		// AutoIt sẽ tự động compile ra 1 file exe để thực hiện upload
		Runtime.getRuntime().exec("C:/Users/ThaoBTP/Desktop/script.exe");
	}
}
