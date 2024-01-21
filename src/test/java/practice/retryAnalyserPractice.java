package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class retryAnalyserPractice {
@Test(retryAnalyzer=genericutilities.retryAnalyserImplementation.class)
public void sample() {
	Assert.fail();
	System.out.println("Hi");
}
}
