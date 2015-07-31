package week11;

import test.TestEngine;

public class TestHarness
{

	public static void main(String[] args)
	{
		trace("Starting test...");

		trace(" -- setup test data");
		TestEngine engine = new TestEngine();
		engine.addTest(new TestCaseBinarySearch());
		engine.addTest(new TestCaseLinearSearch());
		engine.addTest(new TestCaseSorting());

		engine.runTests();

		trace("Completed test");
		System.exit(0);
	}

	static private void trace(String msg)
	{
		System.out.println(msg);
	}

}
