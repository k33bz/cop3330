package week07;

import test.TestEngine;

public class FractionTestHarness
{

	public static void main(String[] args)
	{
		trace("Starting test...");

		trace(" -- setup test data");
		TestEngine engine = new TestEngine();
		engine.addTest(new TestCaseFraction());

		engine.runTests();

		//engine.runTests();

		trace("Completed test");
	}

	static private void trace(String msg)
	{
		System.out.println(msg);
	}
}
