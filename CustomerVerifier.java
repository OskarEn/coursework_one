//Oskar Enmalm
//SRN = 170229702

import java.util.Random;
import java.util.Scanner;

public class CustomerVerifier {
    private static int[] pins = new int[]{1234, 1111, 4321, 5555, 7777, 1010, 9876};
    private static String[] customers = new String[]{"Bob", "Rob", "Tim", "Jim", "Sam", "Jon", "Tom"};
    private static String[] memorableWords= new String[]{"fishing", "Mittens", "Arsenal", "6packYeah", "Porsche911", "puppies", "CSI4Ever"};
    private static Scanner scanner = new Scanner(System.in);


    private static boolean askUserToContinue() {
        String input = getUserInput("Verify another customer? ");
        return input.trim().toLowerCase().startsWith("y"); //see the String API for documentation of the trim() method
    }

    private static String getCustomerFromUser() {
        return getUserInput("Enter customer name: ");
    }

    private static int getPinFromUser() {
        String input = getUserInput("Enter PIN: ");
        return Integer.parseInt(input);  //see the subject guide volume 1 section 9.6 for more on the parseInt(String) method
    }

    //Helper class
    private static String getUserInput(String msg) {
        System.out.print(msg);
        return scanner.nextLine();
    }

    private static boolean isValidPin(String customer, int pin) {
        int customerIndex = -1;
        for (int i = 0; i < customers.length; i++) {
            if (customer.equals((customers[i]))) {  //see the String API for documentation of the equals(Object) method
                customerIndex = i;
            }
        }
        return pin == pins[customerIndex];
    }

    private static boolean isValidCustomer(String customer) {
        for (int i = 0; i < customers.length; i++) {
            if (customer.equals(customers[i])) {
                return true;
            }
        }
        return false;
    }


    //return random integers that are distinct from each other
    private static int[] getDiscreteRandomInts(int quantity, int bound) {
        Random random = new Random();
        int[] store = new int[quantity];
        int r;
        int i = 0;
        while (i < quantity) {
            r = random.nextInt(bound);
            boolean insert = true;
            for (int j = 0; j < i; j++) {
                if (store[j] == r) {
                    insert = false;
                }
            }
            if (insert) {
                store[i] = r;
                i++;
            }
        }
        return store;
    }

    private static String charsAt(String word, int[] indexes) {
        String result = "";
        for (int i = 0; i < indexes.length; i++) {
            result += word.charAt(indexes[i]);
        }
        return result;
    }

    private static String getMemorableWordCharsFromUser(int[] chars) {
        String result = "";
        //computers start counting characters in a string from 0 but humans start at 1 so we add 1 to every number shown to the user
        for (int i = 0; i < chars.length; i++) {
            result += getUserInput("Enter character " + (chars[i]+1) + " from your memorable word: ");
        }
        return  result;
    }

    private static String getMemorableWord(String customer) {
        for (int i = 0; i < customers.length; i++) {
            if (customer.equals(customers[i])) {
                return memorableWords[i];
            }
        }

        //won't get here if the customer exists
        return "";
    }

    private static void verifiedCustomer(String customer, int pin, String memorableWord) {
        System.out.println("Verified customer " + customer + " with pin " + pin + " and memorable word " + memorableWord);
    }

    private static void incorrectPin(String customer, int pin) {
        System.out.println("Incorrect PIN (" + pin + ") for customer " + customer);
    }

    private static void invalidMemorableWord(String customer) {
        System.out.println("Invalid memorable word for " + customer);
    }

    private static void invalidCustomer(String customer) {
        System.out.println("Invalid customer " + customer);
    }

    //1.a (+ b) *** three staments including calls to other methods, plus a return call.
    //It asks a customer for two different random characters from their memorable word
    //Method should return true if both characters given by the user match the memorable word characters asked for,
    //and false otherwise.
    private static boolean userKnowsRandomCharsFromMemorableWord(String customerName){

        String memorableWord = getMemorableWord(customerName);

        //Used to find what positions the random chars should be taken from
        int[] positionOfCharacter = getDiscreteRandomInts(2, customerName.length() + 1); //Bound set to customer word length + 1

        //Saving the correct answer as string to make the .equals more readable
        String correctResponse = charsAt(memorableWord, positionOfCharacter);
        return correctResponse.equals(getMemorableWordCharsFromUser(positionOfCharacter));


    }

    //2. a (+b)
    //The while loop could be cleaned up by having less nesting of if else loops, but it is still readable
    private static void verify() {

        //When the user no longer wants to verify customers this will be false and the while loop will end
        boolean verifyMode = true;

        while (verifyMode) {
            //Asks customer name
            String name = getCustomerFromUser();

            //Step 2: If the customer name is not in the array
            if (!isValidCustomer(name)) {
                if (askUserToContinue()) {
                    //break;
                } else {
                    verifyMode = false;
                    break;
                }
            } else {
                //Step 3: Ask for pin
                int customerPin = getPinFromUser();

                //Step 4: If the pin is not valid
                if (!isValidPin(name, customerPin)) {
                    incorrectPin(name, customerPin);
                    if (askUserToContinue()) {
                       // break;
                    } else {
                        verifyMode = false;
                        break;
                    }
                } else {
                    //Step 5 is removed as the getMemorableWordCharsFromUser() method is used in the
                    // userKnowsRandomCharsFromMemorableWord method created in question one
                    if (!userKnowsRandomCharsFromMemorableWord(name)) {
                        invalidMemorableWord(name);
                        if (askUserToContinue()) {
                           // break;
                        } else {
                            verifyMode = false;
                            break;
                        }
                    } else {
                        verifiedCustomer(name, customerPin, getMemorableWord(name));
                        if (askUserToContinue()) {
                            //break;
                        } else {
                            verifyMode = false;
                            break;
                        }
                    }
                }
            }

        }//end of while loop

        System.out.println("Thank you for using the customer verifier. Please direct any technical issues to: " +
                "ome7@student.london.ac.uk");

    }//end of verify method

    public static void main(String[] args){verify();}

}//end of class
