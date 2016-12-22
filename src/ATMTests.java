/*
 * Test class for ATM program
 */
import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ATMTests extends BankAccount{
	
	// Verify deposit
	@Test
	public void Test1() {
		System.out.println("=======================================================");
		System.out.println("Test1: Verify deposit of 1000, Current Balance: 10000");
		double total = BankAccount.deposit(1000,10000);	
		assertEquals(total,11000.00,2);
	}
	
	// Verify withdrawal 
	@Test
	public void Test2() {
		System.out.println("=======================================================");
		System.out.println("Test2: Verify withdrawal of 4000, Current Balance: 10000");
		double total = BankAccount.withdraw(10000,4000);
		assertEquals(total,6000.00,2);
	}	

	// Verify Max deposit per transaction < 40K 
	@Test
	public void Test3() {
		System.out.println("=======================================================");
		System.out.println("Test3: Verify deposit of 10000, Current Balance: 10000");	
		assertEquals(true, BankAccount.checkDeposit(10000,10000));
	}
	
	// Verify Max deposit per transaction > 40K
	@Test
	public void Test4() {
		System.out.println("=======================================================");
		System.out.println("Test4: Verify deposit of 50000, Current Balance: 10000");
		assertEquals(false, BankAccount.checkDeposit(50000,10000));
	}
	
	// Verify Max deposit for the day = 150K
	@Test
	public void Test5() {
		System.out.println("=======================================================");
		System.out.println("Test5: Verify deposit of 10000, Current Balance: 150000");
		assertEquals(false, BankAccount.checkDeposit(10000,150000));	
	}
	
	// Verify Max withdrawal per transaction = 20K
	@Test
	public void Test6() {
		System.out.println("=======================================================");
		System.out.println("Test6: Verify withdrawal of 20000, Total Withdrawal today: 10000");
		assertEquals(true, BankAccount.checkWithdrawal(20000,10000));	
	}
	
	// Verify Max withdrawal per transaction > 20K
	@Test
	public void Test7() {
		System.out.println("=======================================================");
		System.out.println("Test6: Verify withdrawal of 30000, Total Withdrawal today: 10000");
		assertEquals(false, BankAccount.checkWithdrawal(30000,10000));	
	}
	
	// Verify Max withdrawal for the day = 50K
	@Test
	public void Test8() {
		System.out.println("=======================================================");
		System.out.println("Test6: Verify withdrawal of 5000, Total Withdrawal today: 50000");
		assertEquals(false, BankAccount.checkWithdrawal(5000,50000));	
	}
}
