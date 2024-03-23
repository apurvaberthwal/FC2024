
import java.util.*;

interface Java_Array {
    int[] array_reverse(int[] arr);

    int[] array_copy(int[] arr);

    int array_max(int[] arr);
}

class ArrayOperations implements Java_Array {
    @Override
    public int[] array_reverse(int[] arr) {
        int[] reversedArray = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            reversedArray[i] = arr[arr.length - 1 - i];
        }
        return reversedArray;
    }

    public int[] array_copy(int[] arr) {
        int[] copiedArray = new int[arr.length];
        System.arraycopy(arr, 0, copiedArray, 0, arr.length);
        return copiedArray;
    }

    public int array_max(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }
}

 class Q1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input array from the user
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] inputArray = new int[size];
        System.out.println("Enter the array elements:");

        for (int i = 0; i < size; i++) {
            inputArray[i] = scanner.nextInt();
        }

        ArrayOperations arrayOperations = new ArrayOperations();

        int[] reversedArray = arrayOperations.array_reverse(inputArray);
        System.out.println("Reversed Array: " + Arrays.toString(reversedArray));

        int[] copiedArray = arrayOperations.array_copy(inputArray);
        System.out.println("Copied Array: " + Arrays.toString(copiedArray));

        int maxElement = arrayOperations.array_max(inputArray);
        System.out.println("Maximum Element: " + maxElement);

        scanner.close();
    }
}
