package org.cap.test.bankapp;

import static org.junit.Assert.*;

import org.cap.dao.AccountDao;
import org.cap.dto.Account;
import org.cap.dto.Address;
import org.cap.dto.Customer;
import org.cap.exception.InsufficientBalanceException;
import org.cap.exception.InvalidInitialAmountException;
import org.cap.service.AcccountService;
import org.cap.service.AccountServiceImpl;
import org.hamcrest.core.AllOf;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class AccountServiceTestCase {
	
	@Mock
	private AccountDao accountDao;
	
	private AcccountService accountService;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		//accountService=new AccountServiceImpl();
		accountService=new AccountServiceImpl(accountDao);
		//System.out.println("Before Method");
	}
	
	@BeforeClass
	public static void before_Class(){
		//System.out.println("Before Class Method");
	}
	
	@AfterClass
	public static void after_Class(){
		//System.out.println("After Class Method");
	}
	
	@After
	public void tearDown(){
		accountService=null;
		//System.out.println("After Method");
	}

	@Category(GoodTestCategory.class)
	@Test
	public void test_addNumbers_with_valid_inputs() {
		//accountService=new AccountServiceImpl();
		assertEquals(22, accountService.addNumbers(10, 12));
		
	}
	
	@Category(BadTestCategory.class)
	@Test(expected=IllegalArgumentException.class)
	public void test_addNumber_with_null_customer() throws InvalidInitialAmountException{
		//accountService=new AccountServiceImpl();
		
		Customer customer=null;
		accountService.addAccount(customer, 2000);
		
		
	}
	
	@Category(GoodTestCategory.class)
	@Test(expected=InvalidInitialAmountException.class)
	public void test_with_invalid_initial_amount_in_addAccount() throws InvalidInitialAmountException{
		
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		
		accountService.addAccount(customer, 100);
		
	}
	
	@Category(GoodTestCategory.class)
	//@Ignore
	@Test(timeout=10)
	public void test_MyLoop_with_timeout(){
		accountService.myLoop();
	}
	
	@Test
	public void test_FindByAccountId(){
		
		Account account=new Account();
		account.setAccountNo(1005);
		account.setAmount(10000);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		
		
		//declaration
		Mockito.when(accountDao.findAccountById(1005)).thenReturn(account);
		
		//Actual Method Call
		Account actualAccount= accountService.findAccountById(1005);
		
		
		Mockito.verify(accountDao).findAccountById(1005);
		
		assertEquals(10000, actualAccount.getAmount(),0.0);
	}
	
	@Test
	public void test_addAccount_with_Mock() throws InvalidInitialAmountException{
		Account account=new Account();
		//account.setAccountNo(1);
		account.setAmount(1000);
		Customer customer=new Customer();
		customer.setCustName("Tom");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		
		
		
		//declaration
		Mockito.when(accountDao.createAccount(account)).thenReturn(true);
		
		//Actual Method Call
		Account insertedAccount=accountService.addAccount(customer, 1000);
				
		//verification
		Mockito.verify(accountDao).createAccount(account);
		
		assertEquals(account.getAmount(), insertedAccount.getAmount(),0.0);
		
	}
	
	@Test
	public void test_withdraw_method_with_mock() throws InsufficientBalanceException{
		Account account=new Account();
		account.setAccountNo(1005);
		account.setAmount(10000);
		Customer customer=new Customer();
		customer.setCustName("Jack");
		customer.setCustAddress(new Address());
		account.setCustomer(customer);
		
		
		//declaration
		Mockito.when(accountDao.findAccountById(1005)).thenReturn(account);
		
		//Actual Method Call
		Account actualAccount= accountService.withdraw(1005, 1000);
		
		
		Mockito.verify(accountDao).findAccountById(1005);
		
		assertEquals(9000, actualAccount.getAmount(),0.0);
		
	}
	
	
	
	
	

}
