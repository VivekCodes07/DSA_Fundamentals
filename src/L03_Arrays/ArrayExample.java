package L03_Arrays;

public class ArrayExample {

    public static void main(String[] args) {

        // Creating an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Accessing elements using index
        System.out.println("Element at index 0: " + numbers[0]);
        System.out.println("Element at index 2: " + numbers[2]);
        System.out.println("Element at index 4: " + numbers[4]);

        // Updating an element
        numbers[2] = 35;

        System.out.println("After updating index 2: " + numbers[2]);

        // Finding the length of the array
        System.out.println("Array length: " + numbers.length);

        // Traversing the array
        System.out.println("Array elements:");

        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Index " + i + ": " + numbers[i]);
        }

        // Enhanced for loop
        System.out.println("Using enhanced for loop:");

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}