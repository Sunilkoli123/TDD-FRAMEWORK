package practice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReasDataFromExcelFile {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
//step 1 = Open the document in Java readle format
		FileInputStream fis = new FileInputStream(".\\src\\main\\resources\\TestDataSunil.xlsx");
//step 2= Create a workbook
		Workbook wb = WorkbookFactory.create(fis);
//Step 3 = navigate to required sheet
		// Sheet sh=wb.getSheet("contact");
		Sheet sh = wb.getSheet("Sheet1");
// step 4= navigate to required row
		Row rw = sh.getRow(0);
//step 5= navigate to requires cell
		Cell cl = rw.getCell(1);
//step 6= capture the required data 
		String val = cl.getStringCellValue();
		System.out.println(val);
	}

}
