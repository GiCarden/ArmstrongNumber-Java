import java.util.Scanner;

/**
 * An Armstrong or narcissistic number is equal to the sum of its own digits raised
 * to the power of the number of digits.
 */
class ArmstrongNumber {
//--------------------------------------------------------------------------------------------------------------------//
    private static final int MAX  = 999;
    private static final int LOW = 0;
//--------------------------------------------------------------------------------------------------------------------//

//Constructor---------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Private Methods-----------------------------------------------------------------------------------------------------//
    /**
     * Range Checker.
     *
     * @param number to test
     * @return true if number is between range else false
     */
    private static boolean rangeChecker(int number) { return number >= LOW && number <= MAX; }

    /**
     * String-based digit counter.
     *
     * @param number to test
     * @return the number of digits in a number
     */
    private static int digitCounter_String(int number) { return String.valueOf(number).length(); }

    /**
     * logarithm-based digit counter.
     *
     * @param number to test
     * @return the number of digits in a number
     */
    private static int digitCounter_Log(int number) { return (int)(Math.log10(number)+1); }

    /**
     * repeated-division digit counter.
     *
     * @param number to test
     * @return the number of digits in a number
     */
    private static int digitCounter_Divide(int number) {

        int temp = 0;

        while (number != 0) {

            temp++;
            number = number / 10;
        }
        return temp;
    }

    /**
     * tests if a number is a armstrong number.
     *
     * @param number to test
     */
    private static void isArmstrongNumber (int number) {

        int digitCount = digitCounter_Log(number);
        int numberToTest = number;
        int temp = 0;

        while (numberToTest > 0) {

            temp += (int) Math.pow(numberToTest % 10, digitCount);
            numberToTest = numberToTest / 10;
        }

        if(number == temp) {

            System.out.printf("The number %s has %s digits\n", number, digitCount);
            System.out.printf("%s is a Armstrong Number\n", number);
        } else {

            System.out.printf("The number %s has %s digits\n", number, digitCount);
            System.out.printf("%s is not a Armstrong Number\n", number);
        }
    }
//--------------------------------------------------------------------------------------------------------------------//

//Package Private Methods---------------------------------------------------------------------------------------------//
    /**
     * test's user input to make sure they entered an integer.
     */
    static void inputProcessor() {

        Scanner cin = new Scanner(System.in);
        boolean isInt = false;
        int temp = -1;

        System.out.println("Enter an integer to check if its a Armstrong Number");

        do {
            try {

                temp = Integer.parseInt(cin.next().trim());
                isInt = true;
            } catch (NumberFormatException | NullPointerException e) {

                System.out.println("Did not enter an integer, try again");
            }
        } while (!isInt);

        isArmstrongNumber(temp);
    }
//--------------------------------------------------------------------------------------------------------------------//

//Public Methods------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Setters-------------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

//Getters-------------------------------------------------------------------------------------------------------------//
    //None
//--------------------------------------------------------------------------------------------------------------------//

}//End of Class
