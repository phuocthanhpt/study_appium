package review_Java.Lab1_2_3;

public class Lesson2 {

    public static void main(String[] args) {

        // Exercise 1: Print * N rows in decreasing
        int rows = 9;
        printStar(rows);

        // Exercise 2: Find indices
        int targetSum = 14;
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        findIndices(arr, targetSum);
    }

    private static void printStar(int rows) {
    /*
        1. Print * N rows in decreasing
     */
        for (int i = rows; i > 0; i--) {
            for (int j = i; j > 0; j--) {
                System.out.print(" * ");
            }
            System.out.println();
        }
    }

    /*
        2. Find indices
     */
    private static void findIndices(int[] arr, int targetSum) {
        boolean hasMatched = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] + arr[j] == targetSum) {
                    System.out.printf("(Target %d - Indexes %d:%d - Values %d + %d)%n", targetSum, i, j, arr[i], arr[j]);
                    hasMatched = true;
                }
            }
        }

        if (!hasMatched) System.out.println("We don't have any pair");
    }
}
