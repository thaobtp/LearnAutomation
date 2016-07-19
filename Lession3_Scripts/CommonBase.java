package Lession3SeleniumWebPackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Random;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * @date 06/06/2016
 * @author ThaoBTP
 * @purpose This class contains common function which call to use multiple times
 */
public class CommonBase {
	protected static WebDriver _driver;

	public CommonBase(WebDriver driver) {
		CommonBase._driver = driver;
	}

	// Get 1 đối tượng kiểu WebElement từ locator
	public WebElement getObject(String locator) {
		WebElement elements = null;
		try {
			if (locator.startsWith("id=")) {
				locator = locator.substring(3);
				elements = _driver.findElement(By.id(locator));

			} else if (locator.startsWith("name=")) {

				locator = locator.substring(5);
				elements = _driver.findElement(By.name(locator));

			} else if (locator.startsWith("css=")) {
				locator = locator.substring(4);
				elements = _driver.findElement(By.cssSelector(locator));

			} else if (locator.startsWith("link=")) {

				locator = locator.substring(5);
				elements = _driver.findElement(By.linkText(locator));

			} else if (locator.startsWith("xpath=")) {
				locator = locator.substring(6);
				elements = _driver.findElement(By.xpath(locator));
			}

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return elements;
	}

	// Click vào element trên site
	public void click(String locator) {
		try {
			getObject(locator).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	// Clear giá trị của element trên site
	public void clear(String locator) {
		try {
			getObject(locator).clear();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	// Nhập giá trị vào element
	public void sendKeys(String locator, String value) {
		try {
			WebElement elements = getObject(locator);
			elements.sendKeys(value);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	// input value sử dụng javascript
	public void sendKeysJS(String locator, String value, int index) {
		try {
			String elementsValue = "";
			if (locator.startsWith("id=")) {
				locator = locator.substring(3);
				elementsValue = "document.getElementById('" + locator
						+ "').value='" + value + "'";
			} else if (locator.startsWith("name=")) {
				locator = locator.substring(5);
				elementsValue = "document.getElementsByName('" + locator
						+ "')[" + index + "].value='" + value + "'";

			} else if (locator.startsWith("class=")) {
				locator = locator.substring(6);
				elementsValue = "document.getElementsByClassName('" + locator
						+ "')[" + index + "].value='" + value + "'";

			} else if (locator.startsWith("tag=")) {

				locator = locator.substring(4);
				elementsValue = "document.getElementsByTagName('" + locator
						+ "')[" + index + "].value='" + value + "'";

			}
			JavascriptExecutor executor = (JavascriptExecutor) _driver;
			executor.executeScript(elementsValue);

		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	// Get giá trị text của element
	public String getText(String locator) {
		String text = "";
		try {
			text = getObject(locator).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return text;
	}

	// Compare 2 value
	public Boolean CompareString(String message, String expectedMessage) {
		boolean compare = false;
		try {
			if (message.equalsIgnoreCase(expectedMessage)) {
				compare = true;
			}
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return compare;
	}

	// Choose item from select box
	public void chooseItem(String locator, String item) {
		Select select = new Select(getObject(locator));
		select.selectByVisibleText(item);
	}

	// Mở trình duyệt
	public void openBrowser(String url) {
		// Mở trình duyệt firefox
		_driver.get(url);

		// Maximize browser
		_driver.manage().window().maximize();
	}

	// get Current page
	public String getCurrentPage() {
		return _driver.getCurrentUrl();
	}

	// In giá trị ra màn hình
	public void printLn(String message) {
		System.out.println(message);
	}

	// Lấy email ngẫu nhiên
	public String randomEmail(String email) {
		try {
			Random rand = new Random();

			int numberRand = rand.nextInt(100000);
			email = numberRand + email;
		} catch (Exception e) {
			printLn(e.toString());
		}
		return email;
	}

	// Điều hướng url
	public void navigateURL(String url) {
		_driver.navigate().to(url);
	}

	// Close browser
	public void closeBrowser() {
		_driver.close();
	}

	// get data from excel file
	public String getDataFromExcel(String excelFilePath, String sheetName,
			int rowNums, int cellNums) throws EncryptedDocumentException,
			InvalidFormatException, IOException {
		String cellValue = "";
		try {
			// get data form excel file
			FileInputStream fis = new FileInputStream(excelFilePath);
			// change file to workbook object to create a object between the
			// sheet and the eclipse
			Workbook wb = WorkbookFactory.create(fis);
			// get sheet name
			Sheet sh = wb.getSheet(sheetName);

			// get value from row
			Row row = sh.getRow(rowNums);
			// get value from cell
			Cell cell = row.getCell(cellNums);
			cell.setCellType(Cell.CELL_TYPE_STRING);
			cellValue = cell.getStringCellValue();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return cellValue;
	}
}
