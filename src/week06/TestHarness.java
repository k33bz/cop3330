package week06;

import test.TestEngine;

/**
 * File: TestHarness.java
 */
class TestHarness
{ 
    public static void main(String[] args)
    {		
    	trace("Starting test...");

    	TestEngine engine = new TestEngine();
    	engine.addTest(new TestCaseRepetition());
    	
    	engine.runTests();

    	trace("Completed test");
    }
    
	static private void trace(String msg)
	{
		System.out.println(msg);
	}    
}