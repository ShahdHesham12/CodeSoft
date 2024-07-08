import java.util.Random;
import java.util.Scanner;

public class NumberGame {

	public static void main(String[] args) {
		
		Random random = new Random();
		Scanner s = new Scanner(System.in);
			
		int score = 0;
		
			while(true) {
				int generated_number = random.nextInt(100)+1; 
				int guesses = 0;
				
				
				System.out.println("Enter a number between 1 and 100. you have only 5 attempts!");
				
	            
					 while (guesses < 5 ) {
					  
						int user_guess = s.nextInt();
						if(user_guess <=0 || user_guess >100) {
							System.out.println("This number is out of range!!");
							break;
						}
						guesses++;
						
						 if(user_guess > generated_number) {
							 if(guesses<5) {
								 System.out.println("Too high, try again.");
									System.out.println("----------------------------------------");
							 }
							
						}else if(user_guess < generated_number) {
							if(guesses<5) {
								 System.out.println("Too low, try again.");
									System.out.println("----------------------------------------");
							 }
						}else {
							System.out.println("Correct!");
							System.out.println("----------------------------------------");
							score++;
							System.out.println("Do you want to play again?(yes/no)");
							 String answer1 = s.next();
						    if (answer1.equals("yes")) {
								break;
							}else if (answer1.equals("no")) {
								System.out.println("Your score is: "+score);
								return;
							}
							
							}
						
						 if (guesses == 5) {
							 System.out.println("GAME OVER! You did not guess the number!");
							 System.out.println("The random number was: "+generated_number);
							 System.out.println("Do you want to play again?(yes/no)");
							 String answer2 = s.next();
							 if (answer2.equals("yes")) {
								 break;
							 }else if(answer2.equals("no")) {
								 System.out.println("Your score is: "+score);
								 return;
							 }
						 }
			
						
					 }
					 
					 }
	
		
		 }

}
