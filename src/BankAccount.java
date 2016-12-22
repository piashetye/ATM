/*
 * ATM program: Balance, Deposit, Withdrawal, Quit
 */
import java.util.Scanner;

public class BankAccount {
	
	public static Scanner scannerObj = new Scanner(System.in);
	
	public static void displayBalance(double currentBal)
    {
        System.out.printf("\nBalance is %.2f\n", currentBal);
    }

    public static double deposit(double currentBal, double depositAmt)
    {
        double newBalance = depositAmt + currentBal;
        System.out.printf("\nNew balance is %.2f\n",  newBalance);
        return newBalance;
    }

    public static double withdraw(double currentBal, double withdrawAmt)
    {
        double newBalance = currentBal - withdrawAmt;
        System.out.printf("\nNew balance is %.2f\n",newBalance);
        return newBalance;  
    }
    
    // Validate maximum deposit amount
    public static boolean checkDeposit(double depositAmt, double currentBal)
    {
    	double tempNewBalance = depositAmt + currentBal;
    	boolean flag = true;
    	if (depositAmt > 40000 || tempNewBalance > 150000)
    	{
    		System.out.printf("\nSorry...Either per day or per transaction limit exceeded!\n");
    		flag = false;
    	}
    	return flag;
    }
	
    // Validate maximum withdrawal amount
    public static boolean checkWithdrawal(double withdrawAmt,double totalWithdrawAmt)
    {
    	boolean flag = true; 
    	totalWithdrawAmt = totalWithdrawAmt + withdrawAmt;
    	if (withdrawAmt > 20000 || totalWithdrawAmt > 50000)
    	{
    		System.out.printf("\nSorry...Either per day or per transaction limit exceeded!\n");
    		flag = false;
    	}
    	return flag;
    }
    
    public static void main(String args[]) {
		 int menuOption = 0, depositCount = 0, withdrawalCount = 0;
		 double depositAmt = 0, withdrawAmt = 0, currentBal = 0, totalWithdrawAmt = 0; 
		 
		 do
		 {
	        System.out.println("=======================");
	        System.out.println("1. Balance");
	        System.out.println("2. Deposit");
	        System.out.println("3. Withdrawal");
	        System.out.println("4. Quit");
	        System.out.println("=======================");
	        System.out.println("Enter menu option: ");
	        while (!scannerObj.hasNextInt())
	        	scannerObj.next();
	        menuOption = scannerObj.nextInt();
	        
	        switch(menuOption)
	        {
	        	// Balance
	        	case 1:
	        		displayBalance(currentBal);
	        		break;
	        	
	        	// Deposit
	        	case 2:
	        		if (depositCount < 4)
	        		{
	        			System.out.print("\nEnter deposit amount: ");
	        			while (!scannerObj.hasNextDouble())
	        	        	scannerObj.next();
	        			depositAmt = scannerObj.nextDouble();
	        			if (checkDeposit(depositAmt, currentBal))
	        			{
	        				currentBal = deposit(depositAmt, currentBal);
	        				depositCount++;
	        			}
	        		}
	        		else
	        			System.out.print("\nSorry...Max deposit frequency is 4!\n");
	        		break;

	        	// Withdrawal
	        	case 3:
	        		if (withdrawalCount < 3)
	        		{
	        			System.out.print("\nEnter withdrawal amount: ");
	        			while (!scannerObj.hasNextDouble())
	        	        	scannerObj.next();
	        			withdrawAmt = scannerObj.nextDouble();
	        			if(withdrawAmt > currentBal)
	        				System.out.print("\nSorry...Insufficient balance!\n");
	        			else if(checkWithdrawal(withdrawAmt,totalWithdrawAmt))
	        			{
	        				currentBal = withdraw(currentBal, withdrawAmt);
	        				totalWithdrawAmt = totalWithdrawAmt + withdrawAmt;
	        				withdrawalCount++;
	        			}
	        		}
	        		else
	        			System.out.print("\nSorry...Max withdrawal frequency is 3!\n");
	        		break;
                
	        	// Quit
	        	case 4:
	        		System.out.print("\nAre you sure? (y/n): ");
	        		if(scannerObj.next().equals("y"))
	        			System.exit(0);
	        		break;
	        		
	        	default:
	        		System.out.print("\nInvalid menu selection...Try again!\n");
	        		break;	
	        	
	        }
	     } while (true); 	//continue while user quits with 'y'
	 }
}
