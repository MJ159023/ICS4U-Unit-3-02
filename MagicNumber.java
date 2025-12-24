/*
* This program prints out
* the Magic Sqaures.
*
* @author  Michael Bruneau
* @version 1.0
* @since   2025-23-12
*/

final class Main {
    private Main() {
        // Prevent instantiation
        // Optional: throw an exception e.g. AssertionError
        // if this ever *is* called
        throw new IllegalStateException("Cannot be instantiated");
    }

    /** The top left index. */
    public static final int ZERO = 0;
    /** The top middle index. */
    public static final int ONE = 1;
    /** The top right index. */
    public static final int TWO = 2;
    /** The middle left index. */
    public static final int THREE = 3;
    /** The center index. */
    public static final int FOUR = 4;
    /** The middle right index. */
    public static final int FIVE = 5;
    /** The lower left index. */
    public static final int SIX = 6;
    /** The lower center index. */
    public static final int SEVEN = 7;
    /** The lower right index. */
    public static final int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    public static final int NINE = 9;
    /** The maximum number for magicNumbers. */
    public static final int MAGICNUM = 15;

    // Process numbers.

    /**
     * Counts numebr of permutations of array.
     */
    private static int numberOfProcess = 0;

    /**
     * counts number of magic squares generated.
     */
    private static int numberOfMagicSquares = 0;

    /**
     * Recursivley checks every single magic square possible and
     * prints the ones that are valid.
     *
     * @param currentSquare
     * @param lengthOfArray
     */
    public static void genSquare2(final int[] currentSquare,
                    final int lengthOfArray) {
        // generate the magic sqaure
        if (lengthOfArray == 1) {
            numberOfProcess += 1;
            isMagic(currentSquare);
            return;
        }

        genSquare(currentSquare, lengthOfArray, ZERO);
    }

    /**
     * This second recursive function creates each possible perumtation
     * without repeats.
     *
     * @param currentSquare
     * @param lengthOfArray
     * @param index
     */
    public static void genSquare(final int[] currentSquare,
                                 final int lengthOfArray,
                                 final int index) {
        int lastIndexValue;

        // generate the magic sqaure
        if (index == lengthOfArray) {
            return;
        }

        genSquare2(currentSquare, lengthOfArray - 1);

        // if even move i to n postion in the list
        if (lengthOfArray % 2 == 0) {
            // saves value of lengthOfArray - 1 so it can be swapped
            // with number
            lastIndexValue = currentSquare[lengthOfArray - 1];
            currentSquare[lengthOfArray - 1] = currentSquare[index];
            currentSquare[index] = lastIndexValue;
        // if odd move first index to n postion
        } else {
            // saves vlaue of lengthOfArray - 1 so it can be swapped
            // with number
            lastIndexValue = currentSquare[lengthOfArray - 1];
            currentSquare[lengthOfArray - 1] = currentSquare[0];
            currentSquare[0] = lastIndexValue;
        }

        genSquare(currentSquare, lengthOfArray, index + 1);
    }

    /**
     * Checks if array satfies the condition to make it a magic square.
     *
     * @param preSquare
     */
    public static void isMagic(final int[] preSquare) {
        // returns true or false for whether or not array is a magic square
        // this assumes there are no repeats, but that check could be added!
        int row1 = preSquare[ZERO] + preSquare[ONE] + preSquare[TWO];
        int row2 = preSquare[THREE] + preSquare[FOUR] + preSquare[FIVE];
        int row3 = preSquare[SIX] + preSquare[SEVEN] + preSquare[EIGHT];
        int col1 = preSquare[ZERO] + preSquare[THREE] + preSquare[SIX];
        int col2 = preSquare[ONE] + preSquare[FOUR] + preSquare[SEVEN];
        int col3 = preSquare[TWO] + preSquare[FIVE] + preSquare[EIGHT];
        int diag1 = preSquare[ZERO] + preSquare[FOUR] + preSquare[EIGHT];
        int diag2 = preSquare[TWO] + preSquare[FOUR] + preSquare[SIX];

        // calls print function if array is a magic square
        if (row1 == MAGICNUM) {
            if (row2 == MAGICNUM) {
                if (row3 == MAGICNUM) {
                    if (col1 == MAGICNUM) {
                        if (col2 == MAGICNUM) {
                            if (col3 == MAGICNUM) {
                                if (diag1 == MAGICNUM) {
                                    if (diag2 == MAGICNUM) {
                                        // updates magic square counter
                                        numberOfMagicSquares += 1;
                                        printMagicSquare(preSquare);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Prints out ecah valid magic square.
     *
     * @param outputSquare
     */
    public static void printMagicSquare(final int[] outputSquare) {
        // prints inputted array in a magic square format
        System.out.println("\n*****");
        for (int count = 0; count < outputSquare.length; count++) {
            if (count == THREE || count == SIX) {
                System.out.println();
                System.out.print(outputSquare[count] + " ");
            } else {
                System.out.print(outputSquare[count] + " ");
            }
        }
        System.out.println("\n*****");
    }

    /**
     * Runs main.
     *
     * @param args
     */
    public static void main(final String[] args) {
        // main stub, get user input here
        int[] magicSquare = {ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT,
                NINE};
        //int[] duplicateMagicSquare = {}
        //boolean magicSquareBool;
        System.out.println("\n");
        System.out.println("All Possible Magic Squares (3x3):\n");
        genSquare2(magicSquare, magicSquare.length);
        System.out.println("Number of processes: " + numberOfProcess);
        System.out.println("Number of Magic Squares: " + numberOfMagicSquares);
        System.out.println("\nDone.");
    }
}
