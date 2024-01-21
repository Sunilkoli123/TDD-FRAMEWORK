package practice;

import java.io.IOException;

import genericutilities.PropertyFileUtility;

public class Genericutilitypractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		PropertyFileUtility p = new PropertyFileUtility();
		String val = p.readDataFromPropertyFile("url");
		System.out.println(val);

	}

}
