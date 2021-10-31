package lesson1_review_Java;

public class Lesson1 {

    public static void main(String[] args) {
        int[] a = {55, 3, 445, 32, 2, 644, 77, 95, 555, 23, 65, 754, 24};
        System.out.printf("Count odd numbers in the array: %d%n", countOddNumbers(a));
        System.out.printf("Count even numbers in the array: %d%n", countEvenNumbers(a));
        System.out.printf("Max number in the array: %d%n", findMaxNumber(a));
        System.out.printf("Average value of numbers in the array: %.3f%n", calculateAverageValue(a));
        System.out.println("Array before sorting\n");
        printArray(a);
        System.out.printf("Array after sorting\n");
        sortMinToMax(a);
        printArray(a);
        int number = 13;
        System.out.printf("Factorial of %d: %d%n", number, factorial(number));
    }

    /*
        1-1. Count odd number in integer array
     */
    public static int countOddNumbers(int[] a) {
        int count = 0;
        for (int n : a) {
            if (n % 2 == 1) {
//                System.out.printf(n + " is odd number\n");
                count++;
            }
        }
        return count;
    }

    /*
        1-2. Count even number in integer array
     */
    public static int countEvenNumbers(int[] a) {
        int count = 0;
        if (a != null) {
            for (int n : a) {
                if (n % 2 == 0) {
//                    System.out.printf(n + " is even number\n");
                    count++;
                }
            }
        }

        return count;
    }

    /*
        2. Find max number in integer array
     */
    public static int findMaxNumber(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (a[i] > max) max = a[i];
        }
        return max;
    }

    /*
        3. Calculate average values
     */
    public static double calculateAverageValue(int[] a) {
        if (a.length > 0) {
            int sum = 0;
            for (int n : a) {
                sum += n;
            }
            return (double) sum / a.length;
        } else {
            return -1; // error
        }
    }

    /*
        4. Sort array Min -> Max
     */
    public static void sortMinToMax(int[] a) {
        if (a.length > 0) {
            for (int i = 0; i < a.length; i++) {
                for (int j = i + 1; j < a.length; j++) {
                    if (a[i] > a[j]) {
                        int temp = a[j];
                        a[j] = a[i];
                        a[i] = temp;
                    }
                }
            }
        }
    }

    /*
        Print array of integer
     */
    public static void printArray(int[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println("Item " + i + ": " + a[i]);
        }
    }

    /*
        Calculate factorial of a number
     */
    public static long factorial(int n) {
        if (n > 0) {
            long result = 1;
            for (int i = 1; i <= n; i++) {
                result *= i;
            }
            return result;
        } else {
            return -1;  // error
        }
    }
}

