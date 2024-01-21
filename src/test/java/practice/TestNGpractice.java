package practice;

import org.testng.annotations.Test;

public class TestNGpractice {

	@Test(priority=0)
	public void create() {
		System.out.println("create");
	}
	@Test(priority=-3)
	public void Modify() {
		System.out.println("modify");
	}
	@Test(priority=2)
	public void delete() {
		System.out.println("delete");
	}

}


