package Lession3SeleniumWebPackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * Read and write data from excel file
 * @author ThaoBTP
 * @since 29_06_2016
 */
public class DataDriven {

	static int rowcount = 0;

	public static void main(String[] args) throws IOException,
			InvalidFormatException {
		//Read data from excel file
		//get excel file path
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\ThaoBTP\\Desktop\\CSV\\username.xlsx");
		//change file to workbook object to create a object between the sheet and the eclipse
		Workbook wb = WorkbookFactory.create(fis);
		//get sheet name
		Sheet sh = wb.getSheet("Sheet1");
		
		//get value from row
		Row row = sh.getRow(1);
		//get value from cell and print to screen
		Cell cell = row.getCell(0);
		String cellval = cell.getStringCellValue();
		System.out.println(cellval);

		//Write data into excel file
		//Create new row
		Row newRow = sh.createRow(2);
		//create new cell
		Cell newCell = newRow.createCell(0);
		//set value into cell
		newCell.setCellValue("Thao");
		
		//create new cell
		newCell = newRow.createCell(1);
		//set value into cell
		newCell.setCellValue("thao123");

		//Write data into excel
		FileOutputStream fos = new FileOutputStream(
				"C:\\Users\\ThaoBTP\\Desktop\\CSV\\username.xlsx");
		wb.write(fos);
		fos.close();
	}
}
