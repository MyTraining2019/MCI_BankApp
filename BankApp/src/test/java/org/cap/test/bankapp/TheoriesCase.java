package org.cap.test.bankapp;

import org.junit.Assert;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

@RunWith(Theories.class)
public class TheoriesCase {
	
	@DataPoints
	public static int[] myData(){
		return new int[]{
			1,2,0,-5,7,-3	
		};
	}
	
	@Theory
	public void test_My_Theory(int a,int b){
		System.out.println(a +"," + b);
		
		Assume.assumeTrue(a>0 && b>0);
		
		Assert.assertTrue(a+b>0);
	}

}
