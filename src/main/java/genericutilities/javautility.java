package genericutilities;

import java.util.Date;

/**
 * This class consist of java related reusable method
 * 
 * @author Sunil
 *
 */
public class javautility {
	public String getSystemDate() {
		/**
		 * This method will return the currentdate in particular format
		 */
		Date d = new Date();
		System.out.println(d.toString());

		String[] dArr = d.toString().split(" ");
		String currentDate = dArr[2] + "-" + dArr[1] + "-" + dArr[5] + "_" + dArr[3].replace(":", "-");
		return currentDate;

	}
}
