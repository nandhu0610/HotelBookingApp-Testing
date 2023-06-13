package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import base.BaseTest;

public class ReadExcel extends BaseTest {

	@DataProvider(name = "test")
	public Object[][] testData() throws EncryptedDocumentException, IOException {
		FileInputStream file = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\" + filename + ".xlsx");
		Workbook work = WorkbookFactory.create(file);
		Sheet sheet = work.getSheetAt(0);
		int rownum = sheet.getLastRowNum();
		Row row = sheet.getRow(0);
		int colnum = (row.getLastCellNum());
		Object data[][] = new Object[rownum][colnum];
		for (int i = 1; i <= rownum; i++) {
			row = sheet.getRow(i);
			for (int j = 0; j < colnum; j++) {
				Cell cell = row.getCell(j);
				switch (cell.getCellType()) {
				case STRING:
					data[i - 1][j] = cell.getStringCellValue();
					break;
				case BOOLEAN:
					data[i - 1][j] = cell.getBooleanCellValue();
					break;
				case NUMERIC:
					data[i - 1][j] = cell.getNumericCellValue();
					break;
				default:
					break;
				}
			}
		}
		work.close();
		file.close();
		return data;
	}

}