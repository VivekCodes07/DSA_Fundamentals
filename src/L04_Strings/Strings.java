package L04_Strings;

import java.util.Scanner;

public class Strings {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Taking String input
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.println("Hello " + name);

        // String Concatenation
        String firstName = "Michael";
        String lastName = "Jackson";

        String fullName = firstName + " " + lastName;

        System.out.println("Full name: " + fullName);

        String word = "HELLO";

        // Finding the length
        System.out.println("Length: " + word.length());

        // Accessing characters
        System.out.println("First character: " + word.charAt(0));
        System.out.println("Last character: " + word.charAt(word.length() - 1));

        // Traversing the String
        System.out.println("Characters:");

        for (int i = 0; i < word.length(); i++) {
            System.out.println("Index " + i + ": " + word.charAt(i));
        }

        // Comparing Strings using ==
        String anotherWord = "HELLO";

        System.out.println("Using ==: " + (word == anotherWord));

        // Comparing String contents using equals()
        System.out.println("Using equals(): " + word.equals(anotherWord));

        // Comparing different String objects
        String firstString = new String("HELLO");
        String secondString = new String("HELLO");

        System.out.println("Different objects using ==: " + (firstString == secondString));
        System.out.println("Different objects using equals(): " + firstString.equals(secondString));

        // Searching
        System.out.println("Index of L: " + word.indexOf("L"));

        // Checking whether text exists
        System.out.println("Contains HE? " + word.contains("HE"));

        // Extracting part of a String
        System.out.println("Substring: " + word.substring(1, 4));

        // Converting String to char array
        char[] letters = word.toCharArray();

        System.out.println("Character array:");

        for (char letter : letters) {
            System.out.println(letter);
        }

        sc.close();
    }
}