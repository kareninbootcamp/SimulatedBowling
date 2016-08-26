package ssa;

public class SimulatedBowling {
	
	static java.util.Random rnd = new java.util.Random((new java.util.Date()).getTime());
	int total=0;
	int scores [][] = new int [3][10];
	
	//Method to bowlOneFrame (generates total for a single frame of one game)
	private int bowlOneFrame(){
		int firstThrow = rollOneBall();
		int secondBall = 0;
		
		if(firstThrow == 10)
			total = 15;
		else {	
			secondBall = rollTwoBall(11-firstThrow);	
			total = firstThrow + secondBall;
			    if(total == 10)
			           total=12;
			}
		
		return total;
		
	}
	//bowl method
	//a for statement in a for statement - index, increment when to stop provide dimension
		//store scores for each frame
		//for statement to loop through something a number of times. 
	public void bowling(){
		int totalScore=0;
		for(int game = 0; game < 3; game++) { //outer for loop index//better not to hard code the 3
			for(int frame = 0; frame < 10; frame++){//inner for loop will set frame, while it's less than 10, then increment frame index
				scores[game][frame] = bowlOneFrame(); // scores is the 2 dimensional array. bowlOneFrame gives me the number of pins back for one frame
			}
		}
		//Printing the scores:
		int gameTotals [] = new int [3];
		System.out.print("Frame \t");//This line prints out the word frame for the header row
		for (int i = 0; i < 10; i++) {//this prints the numbers
			System.out.printf("  %3d", i+1);//This line formats and generates the frame numbers. 
		}
		System.out.println("\t Total");//this is to create the new line
		for(int game = 0; game < 3; game++) {
			System.out.print("Game "+ (game + 1) + "\t");
			for(int frame = 0; frame < 10; frame++){
				gameTotals[game] += scores[game][frame];
				System.out.printf("  %3d", scores[game][frame]);
				
				totalScore += scores[game][frame]; // total Score= total + scores[game][frame]
			}
			System.out.print("\t "+gameTotals[game]);
			System.out.println();
			
		}
		
		System.out.println("Total Series \t \t \t \t \t \t \t " + totalScore);
		//System.out.printf("%2d", "Total Series" + totalScore);
	}
		
	
	
	//method to generate a random number for the first bowl then call it
	private int rollOneBall(){
		return rnd.nextInt(11);
	}
	
	//method to generate a random number for the first bowl then call it
	private int rollTwoBall(int secondVal){
		return rnd.nextInt(secondVal);
	}
			
			
}
	
