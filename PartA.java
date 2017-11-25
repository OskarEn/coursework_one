//Oskar Enmalm
//SRN = 170229702

import java.util.Random;

public class PartA {

	static String greetings[] = {"hello", "hallo", "bok", "bonjour", "zdravstvuyte", "namaskaar", "hai", "nee how", "ne ho"};//see loop12()

	    //loop 20 times

        //PROBLEM: Infinite loop
        //REASON: Variable i is being decremented by 1 instead of incremented every time the for block runs
        //SOLUTION: Change the increment condition from i-- to i++
    
		private static void loop1() {
	        for(int i = 0; i < 20; i--) {
	            System.out.println("In loop " + i);
	        }
	        System.out.println("Out of loop");
		}


		//loop 10 times

		//PROBLEM:

		private static void loop2() {
	        for(;;) System.out.println("In loop");
	        System.out.println("Out of loop");
	    }


		//loop 10 times
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
		private static void loop6(){
			Random r = new Random();
			int i = 0;
			int j = 10;
			while (false){
				i = r.nextInt(10);
				j = r.nextInt(1000);
				System.out.println("i = "+i+" and j = "+j);
				if (i==j)break;
			}
			System.out.println("out of loop");
		}


		//loop until i is equal to j
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
		private static void loop10() {
			int k = 10;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print("*");
				}
				System.out.println();
			}
		}


		//Draw a pyramid using asterisks, the pyramid has 7 lines, the top line has 1 star, the next row 2 more (ie 3), rows increase by 2 until the bottom row has 13 stars as follows:
		/*          *
		           ***
		          *****
		         *******
		        *********
		       ***********
              *************				*/
		private static void loop11() {
			int k = 7;
			int m = 13;
			int x = 6; int y = x;
			for (int i = 0; i < k; i++) {
				for (int j = 0; j < m; j++) {
					if (j<x) System.out.print(" ");
					if ((j>=x)&&(j<=y)) System.out.print("*");
				}
				System.out.println();
				x++;
				y++;
			}
		}


		//Search a String array for a particular String. If the search String is found return true, else return false.
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

