package org.cap.test.bankapp;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class ParameterizedTestCase {
	
	private int input1;
	private int input2;
	private int expected;
	private AcccountService acccountService;
	
	public ParameterizedTestCase(int input1,int input2,int expected){
		this.input1=input1;
		this.input2=input2;
		this.expected=expected;
		
	}
	
	@Parameters
	public static List<Object[]> myData(){
		return Arrays.asList(new Object[][]{
			{1,2,3},
			{-1,-2,-3},
			{0,1,1},
			{9,4,13}
		});
	}
	
	
	@Test
	public void test_AddNumber_with_many_inputs(){
		acccountService=new AccountServiceImpl();
		assertEquals(expected, acccountService.addNumbers(input1, input2));
	}

}
