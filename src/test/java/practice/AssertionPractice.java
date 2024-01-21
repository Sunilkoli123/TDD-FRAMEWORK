package practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
@Test
public void sample()
{
	String s ="sunil";
//Assert.assertTrue(s.contains("s"));
System.out.println("step1");
System.out.println("step2");
Assert.assertEquals(1,2);
System.out.println("step3");
}
@Test
public void sample1()
{
	SoftAssert sa = new SoftAssert();
	String s ="sunil";
sa.assertTrue(false);
System.out.println("step1");
System.out.println("step2");
sa.assertEquals(1,2);
System.out.println("step3");
sa.assertAll();
}
}
