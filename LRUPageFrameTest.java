//Code by Jonathan Melis
import java.util.ArrayList;
import java.util.Random;

public class LRUPageFrameTest {

	static Random rando = new Random();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int MAX_REQUESTS = 100;   // the amount of randomized numbers
		final int MIN = 0; // lowest digit of randomized numbers (inclusive)
		final int MAX = 9; // the highest number of page frames as well as (highest random digit + 1)
		int[] numberArr = new int[MAX_REQUESTS];

		int thisPage = 0;
		int faultNum;
		int[] saveFault = new int[MAX+1];

		// The counter for how many times we have ran
		for (int runCount = 0; runCount < 10; runCount++) {
		//for (int runCount = 0; runCount < 10; runCount++) {
			// creates a random array of numbers
			for (int count = 0; count < MAX_REQUESTS; count++) {
				int x = rando.nextInt(MAX - MIN);
				numberArr[count] = x;
				// System.out.println(numberArr[count] + " is in spot " + count
				// + " of the array");
			}
			// Adds one more frame to the total each run
			for (int frameNum = 1; frameNum <= MAX; frameNum++) {  /*****/
				String[] pageR = new String[frameNum];
				// ^page replacement array
				int[] lruSpot = new int[frameNum];
				int spot = 0;
				for (int count = 0; count < frameNum; count++) {
					pageR[count] = "-";
					lruSpot[count] = frameNum - count;
					//initially sets each frame to empty
				}
				for (int insertNum = 0; insertNum < numberArr.length; insertNum++) {
					System.out.println();
					thisPage = numberArr[insertNum];
					
					
					System.out.print(thisPage + ":   ");
					String convoToString = "" + thisPage;
					// Because I used '-' for an empty frame, I needed to make
					// it a String array instead of an integer array. This
					// converts the integer into a String
					boolean foundIt = false;
					// boolean used to see if the page was found in a frame
					for (int count2 = 0; count2 < frameNum; count2++) {
						// this for loop looks for the given integer within the frame array
						//System.out.println(convoToString + " " + pageR[count2]);
						if (convoToString.equals(pageR[count2])) {
							// checks if the given number is in the array, had
							// to use .equals() because it is a String array
							foundIt = true;
							//increase the counter for how long all numbers less than 
							//spot have been sitting in frames by 1
							for (int count10 = 0; count10 < pageR.length; count10++) {												
								lruSpot[count10] += 1;
							}
							lruSpot[count2] = 0;
							pageR[count2] = convoToString;
							// if it is found, set to true
							break;
						}
					}
					//finds the spot in the LRU Array that has been there the longest
					if (foundIt == false) {
						int highNum = 0;
						for (int count = 0; count<lruSpot.length; count++){
							if (highNum < lruSpot[count]){
									highNum = lruSpot[count];
									spot = count;
							}
						}
						// if the number wasnt found within the array, put it in
						// the correct spot, add one to the number of faults
						// tally, move to the next spot
						for (int count10 = 0; count10 < pageR.length; count10++) {												
							lruSpot[count10] += 1;
						}
						//replaces the page in the frame and sets its counter to 0
						pageR[spot] = convoToString;
						lruSpot[spot] = 0;
						//spot++;
						saveFault[frameNum]++;
					}

					for (int count3 = 0; count3 < frameNum; count3++) {
						// displays what occupies the frames
						System.out.print(" " + pageR[count3] + " ");
					}

					if (foundIt == false) {
						System.out.print(" *");
						// if there was a page fault, tell the user
					}

					if (foundIt == true) {
						foundIt = false;
						// now that the search is over, set it back to false by
						// default before the loop runs again
					}
					if (spot > frameNum) {
						spot = 0;
						// if the spot pointer gets to the end of the array,
						// move back to the front
					}

				}
			}
		}
		//Calculates and prints the average number of page faults per number of frames
		System.out.println();
		for (int count = 1; count < saveFault.length; count++) {
			System.out.println("There were an average of " + saveFault[count]
					/10 + " Page faults for " + count + " frames");
		}
	}

}
