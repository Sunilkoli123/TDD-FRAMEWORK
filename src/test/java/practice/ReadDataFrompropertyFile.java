package practice;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
public class ReadDataFrompropertyFile {
public static void main(String[] args) throws IOException {
	

	//Step 1: open the document in java readble format
	FileInputStream f= new FileInputStream(".\\src\\main\\resources\\CommonData.properties");
	
	//create a object of properties class from java util
	Properties p = new Properties();
	
	//load the file iputstream in to properties
	p.load(f);
	
	//provide the key and read the val
	String value = p.getProperty("url");
	System.out.println(value);
}
}
