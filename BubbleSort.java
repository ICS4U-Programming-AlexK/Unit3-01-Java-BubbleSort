import java.util.Random;
import java.util.Arrays;
import java.io.FileWriter;
/**
 * This program bubblesorts an array of random numbers.
 * @author Alex Kapajika
 * @version 1.0
 * @since 2025-03-18
 */
public final class BubbleSort {
    /** Defining MAX_SIZE. */
    private static final int MAX_SIZE = 6;
    /** Defining MAX_VALUE. */
    private static final int MAX_VALUE = 100;

    private static final int MAX_ARRAYS = 100;
    /**
     * This is to satisfy the style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private BubbleSort() {
        throw new IllegalStateException("Utility Class");
    }
    /**
     * This is the main method.
     *
     * @param args Unused.
     * @throws Exception - IO Exception
     */
    public static void main(final String[] args) throws Exception {
        FileWriter inputFile = new FileWriter("input.txt");
        FileWriter outputFile = new FileWriter("output.txt");
        Random random = new Random();
        for (int counterArray = 0; counterArray < MAX_ARRAYS; counterArray++) {
            int[] numArray = new int[MAX_SIZE];
            for (int counter = 0; counter < MAX_SIZE; counter++) {
                int randomNum = random.nextInt(MAX_VALUE);
                numArray[counter] = randomNum;
            }
            inputFile.write("Array " + (counterArray + 1) + " Unsorted: " + Arrays.toString(numArray) + "\n\n");
            bubbleSort(numArray);
            outputFile.write("Array " + (counterArray + 1) + " Sorted:   " + Arrays.toString(numArray) + "\n\n");
        }
        inputFile.close();
        outputFile.close();
    }
    public static void bubbleSort(final int numArray[]) {
        for (int counter = 0; counter < numArray.length - 1; counter++) {
            for (int innCounter = 0; innCounter < numArray.length - counter - 1; innCounter++) {
                if (numArray[innCounter] > numArray[innCounter + 1]) {
                    int temp = numArray[innCounter];
                    numArray[innCounter] = numArray[innCounter + 1];
                    numArray[innCounter + 1] = temp;
                }
            }
        }
    }
}