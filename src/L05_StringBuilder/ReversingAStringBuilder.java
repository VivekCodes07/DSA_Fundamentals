package L05_StringBuilder;

import java.util.Scanner;

public class ReversingAStringBuilder {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            StringBuilder word = new StringBuilder();

            System.out.print("Enter the word you want to reverse: ");
            String input = sc.nextLine();
            word.append(input);

            for(int i = 0; i < word.length() / 2; i ++) {
                int targetIndex = word.length() - 1 - i;

                char frontChar = word.charAt(i);
                char backChar = word.charAt(targetIndex);

                word.setCharAt(i, backChar);
                word.setCharAt(targetIndex, frontChar);
            }

            System.out.println("Reversed word: " + word);
            sc.close();
        }
}





/*
 * Logic:
   First, take the word as input and store it in a StringBuilder because
   StringBuilder allows us to modify individual characters.

   The loop runs only until half of the StringBuilder because every iteration
   swaps two characters — one from the front and its corresponding character
   from the back. Once we reach the middle, all characters are already reversed.

   For every iteration:
   1. 'i' represents the current index from the front.
   2. 'targetIndex' represents the matching index from the back and is
      calculated as length - 1 - i.
   3. Store both characters in temporary variables before swapping them.
   4. Use setCharAt() to place the back character at the front and the
      front character at the back.

   Example for "HELLO":
   H ↔ O
   E ↔ L
 * L stays in the middle

   This reverses the same StringBuilder in-place without creating another
   StringBuilder or String to store the reversed word.
 */