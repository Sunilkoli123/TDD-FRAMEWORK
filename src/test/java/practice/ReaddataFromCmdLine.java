package practice;

import org.testng.annotations.Test;

public class ReaddataFromCmdLine {
	@Test
public void sample() {
	String un = System.getProperty("username");
	System.out.println(un);
	String pwd= System.getProperty("password");
	System.out.println(pwd);
}
}
