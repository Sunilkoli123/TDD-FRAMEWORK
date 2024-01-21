package genericutilities;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class consist of re-usable methods related read data from excel file
 * @author Sunil
 *
 */
public class readDataFromExcelutility {
	/**
	 * This method will read data from the excel file and return the value to caller
	 * @param sheetname
	 * @param rowno
	 * @param cellno
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public String readDataFromExcel(String sheetname,int rowno,int cellno) throws EncryptedDocumentException, IOException {
	FileInputStream fis= new FileInputStream(".\\src\\main\\resources\\TestDataSunil.xlsx");
	
	Workbook wh= WorkbookFactory.create(fis);
	Sheet sh = wh.getSheet(sheetname);
	Row r = sh.getRow(rowno);
	Cell c= r.getCell(cellno);
	String value= c.getStringCellValue();
	return value;
	
}
}
