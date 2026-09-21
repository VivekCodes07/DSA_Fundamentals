package L05_StringBuilder;

public class StringBuilderExample {

    public static void main(String[] args) {

        // Creating a StringBuilder
        StringBuilder builder = new StringBuilder("Hello World");

        System.out.println("Original: " + builder);

        // Adding text at the end
        builder.append("!");

        System.out.println("After append: " + builder);

        // Inserting text at a specific index
        builder.insert(5, ",");

        System.out.println("After insert: " + builder);

        // Changing a character
        builder.setCharAt(0, 'Y');

        System.out.println("After setCharAt: " + builder);

        // Deleting a substring
        builder.delete(5, 11);

        System.out.println("After delete: " + builder);

        // Deleting a single character
        builder.deleteCharAt(5);

        System.out.println("After deleteCharAt: " + builder);

        // Reversing the StringBuilder
        builder.reverse();

        System.out.println("After reverse: " + builder);

        // Current length and capacity
        System.out.println("Length: " + builder.length());
        System.out.println("Capacity: " + builder.capacity());

        // Converting StringBuilder to String
        String result = builder.toString();

        System.out.println("Final String: " + result);
    }
}