//Oskar Enmalm
//SRN = 170229702

import java.util.Random;

public class PartA {

	static String greetings[] = {"hello", "hallo", "bok", "bonjour", "zdravstvuyte", "namaskaar", "hai", "nee how", "ne ho"};//see loop12()

	    //loop 20 times

        //PROBLEM: Infinite loop
        //REASON: Variable i is being decremented by 1 instead of incremented every time the for loop runs
        //SOLUTION: Change the increment condition from i-- to i++

		private static void loop1() {
	        for(int i = 0; i < 20; i--) {
	            System.out.println("In loop " + i);
	        }
	        System.out.println("Out of loop");
		}


		//loop 10 times

		//PROBLEM: The out of loop statement is never reached.
        //REASON: There are no initaliatisations and no bounds for the loop. If it compiles "In loop" will print without limit
        /*SOLTION: Fill in the parameters of the for loop, wrap the statements that are to be executed when the
                   loop is run into "{}"*/

		private static void loop2() {
	        for(;;) System.out.println("In loop");
	        System.out.println("Out of loop");
	    }


		//loop 10 times

        //PROBLEM: The do will constantly run
        //REASON: i is never incremented, it is only printed
        //SOLUTION: add "i++;" statement within the do block
		private static void loop3() {
			int i = 0;
			do {
				System.out.println("In loop " + i);
			} while(i < 10);
			System.out.println("Out of loop");
		}


		//loop 5 times

        //PROBLEM: Infinite loop
        /*REASON: The while condition does not evaluate a changing variable. 5 will always be less that 10, meaning
        while will continously run*/
        //SOLUTION: Change to while(i < 10)

		private static void loop4() {
	        int i = 5;
	        while(5 < 10) {
	            System.out.println("In loop i = " + i);
	            i++;
	        }
	        System.out.println("Out of loop");
		}


		//loop 11 times
        //PROBLEM: The loop is exited the first time it is executed
        /*REASON: The evaluation is false. n is on the first run larger than m, with the ! opperand the condition
                  evaluates to false*/
        //SOLUTION: Remove the "!"
		private static void loop5() {
			int m = 10;
			int n = 21;
			while (!(n > m)) {
				System.out.println("In loop.");
				n--;
			}
			System.out.println("Out of loop.");
		}


		//loop until i is equal to j
        //PROBLEM: The while loop never runs
        //REASON: The while loop's inital value is false
        //SOLUTION: Make the evaluation of the while loop while (i!=j)
		private static void loop6(){
			Random r = new Random();
			int i = 0;
			int j = 10;
			while (false){
				i = r.nextInt(10);
				j = r.nextInt(1000);
				System.out.println("i = " + i + " and j = " + j);
				if (i==j)break;
			}
			System.out.println("out of loop");
		}


		//loop until i is equal to j
        //PROBLEM: There is an endless
        //REASON: The nextInt() method will produce a pseduorandom number inbetween 0 (inclusive) and the parameter
		// (exlusive), this means that the value the result of r.nextInt, will never == j
        //SOLUTION: change the parameter of next int to  j + 1 i.e. i = r.nextIn(j +1);
		private static void loop7(){
			Random r = new Random();
			int i = 0;
			int j = 10;
			while (true){
				i = r.nextInt(j);
				if (i==j)break;
				System.out.println("i = "+i+" and j = "+j);
			}
			System.out.println("out of loop");
		}



		//loop until we randomly generate a 7
        //PROBLEM: The while condition evaluates constantly to true, causing an endless loop
        //REASON: When the if condition is met, stop is assigned the value false (it initiates already as false),
		// the while evaluates the inverse of the boolean, i.e. true, making it carry on executing
        //SOLUTION: within the if statement change stop = true
		private static void loop8() {
			boolean stop = false;
			Random r = new Random();
			int i;
			int count = 1;
			while(!stop) {
				i = r.nextInt(100);
				System.out.println("Random number is "+i);
				if(i == 7) {
					stop = false;
				}
				count++;
			}
			System.out.println("Took "+count+" tries");
		}



		//loop 60 times (outer loop 10 times plus inner loop 5 x 10 times)
        //PROBLEM: The second while loop will continuously evaluate as true, meaning that the inner loop will execute infinitely
        //REASON: The inner loop only increments the value of i, whilst the value of j does not change.
        //SOLUTION: Change the i++ inside the while(j < 5) loop to j++
        private static void loop9() {
			int i = 0;
			int j = 0;
			while(i < 10) {
				System.out.println("In loop 1 "+i);
				while(j < 5) {
					System.out.println("In loop 2 "+i);
					i++;
				}
				j=0;
				i++;
			}
			System.out.println("Out of loops");
		}



		//draw a 9 x 9 rectangle using asterisks
        //PROBLEM: The loop instead prints a 9 x 9 right-angled triange (see the "Actual output" note below)
        //REASON: The inner for loop changes depending on the current value of i in the outer loop, causing the amount
		// of times that asterik is printed in a line to be variable
        //SOLUTION: change j < i to j < k in the inner for loop
		private static void loop10() {
			int k = 10;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}

		//Actual output:
		/*

		 *
		 **
		 ***
		 ****
		 *****
		 ******
		 *******
		 ********
		 *********

		 */


		//Draw a pyramid using asterisks, the pyramid has 7 lines, the top line has 1 star, the next row 2 more (ie 3),
		// rows increase by 2 until the bottom row has 13 stars as follows:
		/*          *
		           ***
		          *****
		         *******
		        *********
		       ***********
              *************				*/

        //PROBLEM: Only one asterisk is printed in each row, with only the padding (i.e the amount of " ")
		// on the left changing
        //REASON: x and y start with the same value and for each loop of the outer for loop they are also incremented by
		// one, therefore, the evaluation ((j>=x)&&(j<=y)) is only true with one value of j. We want  ((j>=x)&&(j<=y))
		// to evaluate to true 2 more times that the previous outer loop until !(i < k). This is done by derementing the
		// value of x and incrementing the value of y for each outer loop
        //SOLUTION: decrement the value of x instead of incrementing it, i.e. x--;
		private static void loop11() {
			int k = 7; //the amount of lines
			int m = 13; //size of bottom row, here x and y are 0
			int x = 6; int y = x;
			for (int i = 0; i < k; i++) { //for all rows
				for (int j = 0; j < m; j++) { //for rows not wider than 13
					if (j<x) System.out.print(" ");
					if ((j>=x)&&(j<=y)) System.out.print("*");
				}
				System.out.println();
				x++;
				y++;
			} //end of for
		}


		//Search a String array for a particular String. If the search String is found return true, else return false.
        //PROBLEM: There is an out of bounds error in the return statement if a non-matching word is used
        //REASON: If there is not a matching name, the final run of the loop is when i = 8, the value of i is then
		// incremented once more at the end but the loop isn't done again. This means that if a word is not found, the
		// return statement is return (a[9]==find) which is out of bounds for the array
        //SOLUTION: One solution would be to have a checker to see if the value of i is equal to the value a.length
		// (indicates the whole array way checked) and have this return false i.e. at the end add .......................
		// if(i == a.length){
		//           return false;
		//        } else{return (a[i]==find);}
        private static boolean loop12(String[]a, String find) {
			int i;
			for (i=0; i<a.length && a[i]!=find; i++);
			return (a[i]==find);
		}

		private static void runLoops() {
			loop1();
			System.out.println();
			loop2();
			System.out.println();
			loop3();
			System.out.println();
			loop4();
			System.out.println();
			loop5();
			System.out.println();
			loop6();
			System.out.println();
			loop7();
			System.out.println();
			loop8();
			System.out.println();
			loop9();
			System.out.println();
			loop10();
			System.out.println();
			loop11();
			System.out.println();
			System.out.println(loop12(greetings, "zdravstvuyte"));
			System.out.println();
			System.out.println(loop12(greetings, "merhaba"));

		}


		public static void main(String[] args) {
			runLoops();
		}

}


