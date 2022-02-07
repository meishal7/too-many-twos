/** 
* TITLE: MainTooManyTwos.java 
* AUTHOR: Elena Mudrakova   
* COURSE: CS 112 Intro to CS II - Java  
* MODULE: 4
* PROJECT: Lab 09_HackerChallenge
* LAST MODIFIED: 10/05/2020
* DESCRIPTION: this program accepts an integer parameter n and prints an expression composed of a single 
* odd number multiplied by twos that is equal to n recursively. The twos should surround the odd number with 
* an equal number of twos on either side if possible. Several calls and their output are shown below.
* If the expression has an odd number of twos, then the "extra" two should appear at the front of 
* the expression, as shown in the output from passing 96 and 32. If the number is odd to begin with, 
* it should simply be printed. It is possible that the odd number to print will be 1, as shown in the output 
* from passing 32, 1, and 2.

Call 	            Output
tooManyTwos(80); 	2 * 2 * 5 * 2 * 2
tooManyTwos(68); 	2 * 17 * 2
tooManyTwos(96); 	2 * 2 * 2 * 3 * 2 * 2
tooManyTwos(32); 	2 * 2 * 2 * 1 * 2 * 2
tooManyTwos(1); 	1
tooManyTwos(2); 	2 * 1
* 
* 
* ALGORITHM: 
* declare public class MainTooManyTwos
* declare public static int finalMiddleN = 0;
    public static int numberOfTwos = 0;
    public static String twos = "";
    public static String left = "";
    public static String right = "";
* declare public static void tooManyTwos(int n)
* if (n < 1) throw new IllegalArgumentException
* if (n == 1) print 1 and exit the program
* if n is odd  number > print n
* if n is even number > finalMiddleN = n / 2 and twos += "2 * " and numberOfTwos++
* if finalMiddleN is even after first dividing > call recursive tooManyTwos(finalMiddleN)
* recursive function will divide n by 2 till our final number is odd number
* in main() call tooManyTwos(int n)
* if (numberOfTwos == 1) print twos + finalMiddleN
* if (numberOfTwos is even) > left = twos.substring(0, twos.length() / 2);
                            right = twos.substring(twos.length() / 2, twos.length() - 2);
                            print (left + finalMiddleN + " * " + right);
* if (numberOfTwos is odd) >  left = twos.substring(0, twos.length() / 2 + 2);
                            right = twos.substring(twos.length() / 2, twos.length() - 2);
                            print (left + finalMiddleN + " " + right);
* 
* 
* 
*
* PACKAGES INCLUDED: no 
*/ 
public class MainTooManyTwos {
    /**
     * Name for the odd number that we need to surround with "2"
     * It's our final number, after we got odd number, we stop dividing by 2
     */
    public static int finalMiddleN = 0;
    /**
     * Name for the counter that counts how many "2" we have
     * It increases every time dividing by 2 happens
     */
    public static int numberOfTwos = 0;
    /**
     * Name for the string that displays all twos we have together
     * Example: "2 * 2 * 2 * "
     */
    public static String twos = "";
    /**
     * Name for the substring we have on the left from finalMiddleN
     */
    public static String left = "";
    /**
     * Name for the substring we have on the right from finalMiddleN
     */
    public static String right = "";
    /**
     * Accepts an integer parameter n and prints an expression composed of a single 
     * odd number multiplied by twos that is equal to n recursively. The twos should surround the odd number with 
     * an equal number of twos on either side if possible. 
     * If the expression has an odd number of twos, then the "extra" two should appear at the front of 
     * the expression. If the number is odd to begin with, it should simply be printed. 
     * It is possible that the odd number to print will be 1.
     * 
     * @param n integer has to be >= 1
     * @throws IllegalArgumentException if n < 1
     */
    public static void tooManyTwos(int n) throws IllegalArgumentException {
        if (n < 1)
            throw new IllegalArgumentException("Number has to be equal or more then 1.");
        if (n == 1) {
            System.out.print("1");
            System.exit(0);
        }
        //If n is odd number
        if (n % 2 != 0)
            System.out.print("number is " + n);
        //If n is even number
        else {
            finalMiddleN = n / 2;
            twos += "2 * ";
            numberOfTwos++;
            //If number after first dividing by 2 is still even number
            //we call recursively tooManyTwos(finalMiddleN) but pass 
            //finalMiddleN as an argument. Recursive works till eventualli it has 
            //odd number which is what we need
            if (finalMiddleN % 2 == 0) {
                tooManyTwos(finalMiddleN);
            }
        }

    }

    public static void main(String[] args) {
        tooManyTwos(32);
        if (numberOfTwos == 1)
            System.out.println(twos + finalMiddleN);
        //If we have even number of twos
        if (numberOfTwos % 2 == 0) {
            //We divide String twos on two substrings
            //because we need to surround final odd number in the middle
            //with twos
            left = twos.substring(0, twos.length() / 2);
            right = twos.substring(twos.length() / 2, twos.length() - 2);
            System.out.println(left + finalMiddleN + " * " + right);
        //If we have odd number of twos
        } else {
            //We divide String twos on two substrings
            //because we need to surround final odd number in the middle
            //with twos
            left = twos.substring(0, twos.length() / 2 + 2);
            right = twos.substring(twos.length() / 2, twos.length() - 2);
            System.out.println(left + finalMiddleN + " " + right);
        }
    }

}
