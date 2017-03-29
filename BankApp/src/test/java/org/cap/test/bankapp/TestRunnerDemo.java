package org.cap.test.bankapp;

import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;

public class TestRunnerDemo {

	public static void main(String[] args) {
		JUnitCore jUnitCore=new JUnitCore();
		jUnitCore.addListener(new TextListener(System.out));
		jUnitCore.run(AccountServiceTestCase.class);
		
	}

}
