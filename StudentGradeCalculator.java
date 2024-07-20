import java.util.InputMismatchException;
import java.util.Scanner;


public class StudentGradeCalculator {

	public static void main(String[] args) {
		
       Scanner s = new Scanner (System.in);
		
		
		do {	
		try {
       
		System.out.println("Enter the number of subjects: ");
		int num_subjects = s.nextInt();
		
		if(num_subjects<=0) {
			System.out.println("Invalid number!!");
			continue;
		}

		double[] subjects = new double[num_subjects];
		
		double sum =0;
		
		
		for(int i=0; i<num_subjects; i++) {
			
		    System.out.println("Enter grade of subject number "+(i+1));
		    try {
			subjects[i] = s.nextDouble();
			sum += subjects[i];
		    }
		    catch(InputMismatchException e) {
				System.out.println("Invalid input!");
				s.nextLine();
				i--; //to re-enter the correct input
				
				}			
		}
		
		
		
		
		System.out.println("Total marks: "+sum);
		
		double average = sum/num_subjects;
		
		System.out.println("Average marks: "+ average+"%");
		
		if(average<=100 && average>=90) {
			System.out.println("Your grade is A!");
		}
		else if(average<=89 && average>=80) {
			System.out.println("Your grade is B!");
		}
		else if(average<=79 && average>=70) {
			System.out.println("Your grade is C!");
		}
		else if(average<=69 && average>=60) {
			System.out.println("Your grade is D!");
		}
		else if(average<=60) {
			System.out.println("Your grade is F!");
		}
		 break;
		
		}
		catch(InputMismatchException e) {
			System.out.println("Invalid input!");
			s.nextLine();
			}
	}
		while(true);
		
		
		
		
		}
			
		
	}


