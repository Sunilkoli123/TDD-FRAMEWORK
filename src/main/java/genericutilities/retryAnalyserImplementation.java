package genericutilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;


/*
 * This class provides implemnetation to IRetryAnalyser interface of testNG
 * author Sunil 
 */
public class retryAnalyserImplementation implements IRetryAnalyzer {
int count =0;
int retrycount =3;
	@Override
	public boolean retry(ITestResult result) {
		
		
		while(count<retrycount) {
			count++;
			return true;
		}
		return false; // stop retrying
	}

}
