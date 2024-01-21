package practice;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import genericutilities.readDataFromExcelutility;

public class practicereaddatafromexcelfilefromexcelutility {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		readDataFromExcelutility re = new readDataFromExcelutility();
		String val = re.readDataFromExcel("Sheet1", 1, 1);
		System.out.println(val);
	}

}
