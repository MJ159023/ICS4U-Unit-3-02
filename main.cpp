/*
* Copyright (c) 2025 St. Mother Teresa HS All rights reserved.
* This program prints out
* the Magic Sqaures.
*
* @author  Michael Bruneau
* @version 1.0
* @since   2025-23-12
*/

#include <iostream>
#include <string>

using std::cout;
using std::cin;
using std::string;

class Main {
 public:
    /** The top left index. */
    const int ZERO = 0;
    /** The top middle index. */
    const int ONE = 1;
    /** The top right index. */
    const int TWO = 2;
    /** The middle left index. */
    const int THREE = 3;
    /** The center index. */
    const int FOUR = 4;
    /** The middle right index. */
    const int FIVE = 5;
    /** The lower left index. */
    const int SIX = 6;
    /** The lower center index. */
    const int SEVEN = 7;
    /** The lower right index. */
    const int EIGHT = 8;
    /** The maximum number for magicNumbers. */
    const int NINE = 9;
    /** The maximum number for magicNumbers. */
    const int MAGICNUM = 15;
    /** 
     * array size needs to eb constant to print out using proper code format. 
     */
    static constexpr int LENGTH_OF_ARRAY = 9;

    // Process numbers.
 private:
    /**
     * Counts numebr of permutations of array.
     */
    int numberOfProcess = 0;

    /**
     * counts number of magic squares generated.
     */
    int numberOfMagicSquares = 0;

 public:
    /**
     * Get number of process.
     *
     * @return numberOfProcess
     */
    int getNumberOfProcess() {
        return numberOfProcess;
    }

    /**
     * Get number of magic squares.
     *
     * @return numberOfMagicSquares
     */
    int getNumberOfMagicSquares() {
        return numberOfMagicSquares;
    }


    /**
     * Recursivley checks every single magic square possible and
     * prints the ones that are valid.
     *
     * @param currentSquare
     * @param lengthOfArray
     */
    void genSquare2(int currentSquare[], int lengthOfArray) {
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
    void genSquare(int currentSquare[],
                                 int lengthOfArray,
                                 int index) {
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
     * @param lengthOfArry
     */
    void isMagic(int preSquare[]) {
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
                                        printMagicSquare(preSquare, 0);
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
     * @param lengthOfArray
     */
    void printMagicSquare(int outputSquare[], int index) {
        // base
        if (index == LENGTH_OF_ARRAY) {
            cout << "\n*****\n";
            return;
        }

        // creates return array using original to output magic square
        static int returnArray[LENGTH_OF_ARRAY];

        // prints top of magic square once
        if (index == ZERO) {
            cout << "\n*****";
        }

        returnArray[index] = outputSquare[index];

        // prints inputted array in a magic square format
        if (index % THREE == 0) {
            cout << "\n";
            cout << returnArray[index] << " ";
        } else {
            cout << returnArray[index] << " ";
        }

        printMagicSquare(outputSquare, index + 1);
    }
};

/**
 * Runs main.
 *
 * @param args
 */
int main() {
    // declares class for constants
    Main main;
    // main stub, get user input here
    int magicSquare[] = {main.ONE, main.TWO, main.THREE, main.FOUR, main.FIVE,
            main.SIX, main.SEVEN, main.EIGHT, main.NINE};
    cout << "\n\n";
    cout << "\nAll Possible Magic Squares (3x3):\n";
    main.genSquare2(magicSquare, main.LENGTH_OF_ARRAY);
    cout << "\nNumber of processes: " << main.getNumberOfProcess();
    cout << "\nNumber of Magic Squares: " << main.getNumberOfMagicSquares();
    cout << "\n\nDone.";
}

