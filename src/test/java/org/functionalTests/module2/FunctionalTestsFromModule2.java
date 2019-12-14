package org.functionalTests.module2;

import org.testng.annotations.Test;

public class FunctionalTestsFromModule2 {

	@Test(priority = 1)
	public void test1() {
		System.out.println("Test1 from module1");
	}

	@Test(priority = 3)
	public void test2() {
		System.out.println("Test2 from module1");
	}

	@Test(priority = 2)
	public void test3() {
		System.out.println("Test3 from module1");
	}

	@Test
	public void test4() {
		System.out.println("Test4 from module1");
	}
}
