import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class ATM_machine {
	
	public static void main(String[] args) {
		
		
		Scanner s = new Scanner (System.in);
		
		System.out.println("Enter your balance: ");
        int balance = 0;
        
        boolean balanceInputValid = false;
        
        while (!balanceInputValid) {
        	
            try {
                balance = s.nextInt();
                if(balance<=0) {
                	System.out.println("Error: please enter a positive number!");
                	continue;
                }
                balanceInputValid = true;
                
            } catch (InputMismatchException e) {
                System.out.println("Error: Please enter a valid integer.");
                s.nextLine(); 
            }
        }
		
		Bank_Account account = new Bank_Account(balance);
		
		boolean exitFlag = false;
		
		while(!exitFlag) {
		
			System.out.println("choose from the options:\n1-withdraw\n2-deposite\n3-check the balance");
			int choice=0;
			boolean choiceInputvalid = false;
			while(!choiceInputvalid) {
				try {
					choice= s.nextInt();
					choiceInputvalid= true;
				}
				catch(InputMismatchException e) {
					System.out.println("Error: please enter a numeric value");
					s.nextLine();
				}
			}
			
			
			
			if(choice == 1) {
				
				System.out.println("Enter the amount of money you want to withdraw: ");
				
				int amount=0;
				boolean withdrawInputvalid= false;
				
				while(!withdrawInputvalid) {
					try {
						amount = s.nextInt();
						 if(amount<=0) {
			                	System.out.println("Error: please enter a positive number!");
			                	continue;
			                }
						withdrawInputvalid= true;
					}
					catch(InputMismatchException e) {
						System.out.println("Error: please enter a numeric value");
						s.nextLine();
					}
					
				}
				
				
				if(amount<=account.getbalance()) {
					withdraw(amount,account);
					System.out.println("would you like to check your new balance?(yes,no)");
					
					String answer =null;
					boolean answerInputvalid= false;
					
					while(!answerInputvalid) {
						try {
							answer = s.next();
							answerInputvalid= true;
						}
						catch(InputMismatchException e) {
							System.out.println("Error: please choose between 'yes' and 'no'");
							s.nextLine();
						}
					}
					
					
					if(answer.equals("yes")) {
						System.out.println("your current balance is "+account.getbalance());
					}
					if(answer.equals("no")) {
						System.out.println("thank you");
					}
				}
				else {
					System.out.println("Sorry! You don't have enough money!");
				
					
				}
						
			}
			else if(choice == 2) {
			    System.out.println("Enter the amount of money you want to add to your bank account: ");
			    
			    int amount=0;
				boolean depositeInputvalid= false;
				
				while(!depositeInputvalid) {
					try {
						amount = s.nextInt();
						 if(amount<=0) {
			                	System.out.println("Error: please enter a positive number!");
			                	continue;
			                }
						depositeInputvalid= true;
					}
					catch(InputMismatchException e) {
						System.out.println("Error: please enter a numeric value");
						s.nextLine();
					}
					
				}
				
				Deposite(amount,account);
				
				System.out.println("Would you like to check your new balance?(yes,no)");
				
				String answer =s.next();
				
				if(answer.equals("yes")) {
					System.out.println("your current balance is "+account.getbalance());
	
				}
				if(answer.equals("no")) {
					System.out.println("thank you");
				}
				
			}
			else if(choice == 3) {
				CheckingBalance(account);
			}
			System.out.println("-------------------------------");
			System.out.println("Do you want to exit?(yes,no)");
			
			String answer =s.next();
			
			if(answer.equals("yes")) {
				exitFlag= true;
			}
			else if(answer.equals("no")) {
				continue;
			}
		
	
		
		
	}
		
		
		
	}
	
	public static  int withdraw(int amount,Bank_Account account) {
		
			int new_balance = account.getbalance()-amount;
			System.out.println("successful withdrawl!");
			account.setbalance(new_balance);
            return amount;
	
	
	}
	
	public static  int Deposite(int amount,Bank_Account account) {
		int new_balance = account.getbalance() + amount;
		System.out.println("Successful Deposite!");

		
		account.setbalance(new_balance);
		return amount;
	}
	
	public static void CheckingBalance(Bank_Account account) {
		System.out.println("your current balance is "+account.getbalance());

	}
	

}
