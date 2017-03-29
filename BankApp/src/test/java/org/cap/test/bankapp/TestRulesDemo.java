package org.cap.test.bankapp;

import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.matchers.JUnitMatchers;
import org.hamcrest.*;
import org.junit.rules.ExpectedException;
import org.junit.rules.Timeout;
import org.mockito.internal.matchers.Contains;

public class TestRulesDemo {
	
	private AcccountService acccountService;
	
	@Before
	public void setUp(){
		acccountService=new AccountServiceImpl();
	}
	
	@Rule
	public ExpectedException thrown=ExpectedException.none();
	
	@Test
	public void test_addAccount_with_invalid_initial_Amount() throws InvalidInitialAmountException{
		
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		thrown.expect(InvalidInitialAmountException.class);
		//thrown.expectMessage("Initial Amount Should be greater than 500.");
		//thrown.expectMessage("Not Null!");
		thrown.expectMessage("Initial Amount");
		acccountService.addAccount(customer, 100);
		
	}
	
	@Rule
	public Timeout timeout=new Timeout(100);
	@Test
	public void test_myLoop(){
		
		acccountService.myLoop();
	}

}
