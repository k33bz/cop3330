package week07;

import java.io.File;
import test.TestEngine;

/**
 * File: TestHarness.java
 */
class TestHarness
{ 
    public static void main(String[] args)
    {		
    	trace("Starting test...");
    	File f = new File(".");
		trace(f.getAbsolutePath());
		trace(" -- setup test data");
    	TestEngine engine = new TestEngine();
    	engine.addTest(new TestCaseDataAccess());
    	engine.addTest(new TestCaseBook());
    	
    	engine.runTests();

    	trace("Completed test");
    }
    
	static private void trace(String msg)
	{
		System.out.println(msg);
	}    
}