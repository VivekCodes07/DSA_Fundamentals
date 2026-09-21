# L04 — Strings

I already learned about **Arrays**, where I learned how data can be stored in an indexed structure and accessed efficiently.

Now I am moving to **Strings**.

Strings are extremely important in DSA because many problems involve working with text, characters, indexes, searching, comparison, frequency counting, and patterns.

In this lesson, I want to understand Strings properly instead of treating them as just `"some text"`.

My main focus is:

> **What is a String, how does Java handle it, what happens internally, and how can I use it in DSA problems?**

---

# What Am I Going to Study in This Lesson?

In this lesson, I am going to study:

* What is a String?
* String indexing
* String vs `char[]`
* Creating Strings in Java
* String literals
* String Constant Pool
* String objects and references
* String immutability
* Why Strings are immutable
* `length()`
* `charAt()`
* Traversing a String
* Comparing Strings
* `==` vs `.equals()`
* String concatenation
* `substring()`
* `indexOf()`
* `contains()`
* Converting String to `char[]`
* Converting `char[]` to String
* String memory and internal representation
* UTF-16 and `char`
* Time complexity of common operations
* How Strings will be used in DSA problems

---

# 1. Why Do I Need Strings?

Before learning the syntax, I want to understand **why Strings are important**.

Almost every software application works with text.

For example:

```text
Names
Emails
Passwords
Usernames
Messages
URLs
File names
Search queries
```

In DSA, Strings appear in problems involving:

```text
Palindrome
Anagram
Character Frequency
String Searching
Pattern Matching
Substrings
Two Pointers
Sliding Window
Hashing
```

So Strings are not just a Java topic.

They are going to be an important part of my **problem-solving journey**.

---

# 2. What Is a String?

A String is a sequence of characters.

For example:

```java
String name = "Vivek";
```

Conceptually:

```text
String:

V  i  v  e  k
0  1  2  3  4
```

Each character has a logical index.

So:

```java
name.charAt(0)
```

gives:

```text
V
```

And:

```java
name.charAt(3)
```

gives:

```text
e
```

Just like arrays, String indexing starts from **0**.

---

# 3. String Is a Java Object

This is an important difference from primitive types.

When I write:

```java
String name = "Vivek";
```

`name` is a **reference variable** that refers to a String object.

Conceptually:

```text
name
 │
 ↓
┌─────────────────┐
│   String Object │
│                 │
│   "Vivek"       │
└─────────────────┘
```

I should remember:

```text
String → Object
```

It is not a primitive data type like:

```text
int
char
double
boolean
```

---

# 4. String vs Character Array

A String and a character array may look similar:

```text
String:
"HELLO"

char[]:
['H', 'E', 'L', 'L', 'O']
```

But they behave differently.

### String

```java
String word = "HELLO";
```

### Character Array

```java
char[] letters = {'H', 'E', 'L', 'L', 'O'};
```

The biggest difference I need to remember is:

```text
String   → Immutable
char[]   → Mutable
```

For example:

```java
char[] letters = {'H', 'E', 'L', 'L', 'O'};

letters[0] = 'Y';
```

Now:

```text
YELLO
```

But I cannot do:

```java
String word = "HELLO";

word[0] = 'Y';   // Invalid
```

A String cannot be modified character-by-character.

---

# 5. Creating a String

The most common way is using a **String literal**:

```java
String name = "Vivek";
```

I can also create a String using `new`:

```java
String name = new String("Vivek");
```

Both create/use String objects, but their memory behavior is different.

To understand this, I need to understand the **String Constant Pool**.

---

# 6. String Constant Pool

Java maintains a special area called the **String Pool** for String literals.

Consider:

```java
String a = "Hello";
String b = "Hello";
```

Conceptually:

```text
String Pool

       "Hello"
        ↑   ↑
        │   │
        a   b
```

Both references can point to the same pooled String object.

Why is this safe?

Because Strings are immutable.

Neither `a` nor `b` can modify the `"Hello"` object itself.

---

# 7. What Happens With `new String()`?

Now consider:

```java
String a = new String("Hello");
String b = new String("Hello");
```

Conceptually, I can think of:

```text
a ─────→ String Object 1
              "Hello"

b ─────→ String Object 2
              "Hello"
```

These are separate String objects.

This is one reason why I should understand the difference between:

```text
== 
```

and:

```text
.equals()
```

---

# 8. `==` vs `.equals()`

This is one of the most important things I need to remember about Java Strings.

### `==`

`==` checks whether two references refer to the **same object**.

### `.equals()`

`.equals()` checks whether two Strings contain the **same content**.

Example:

```java
String a = "Hello";
String b = "Hello";

System.out.println(a == b);
System.out.println(a.equals(b));
```

Conceptually:

```text
a ──┐
    ├──→ "Hello"
b ──┘
```

Output:

```text
true
true
```

Now:

```java
String a = new String("Hello");
String b = new String("Hello");

System.out.println(a == b);
System.out.println(a.equals(b));
```

Output:

```text
false
true
```

Because:

```text
==       → Same object?
.equals  → Same content?
```

For comparing String values, I should normally use:

```java
a.equals(b)
```

---

# 9. String Immutability

One of the most important concepts in Java Strings is:

> **Strings are immutable.**

Immutable means:

> Once a String object is created, its contents cannot be changed.

Consider:

```java
String name = "Vivek";

name = "Rahul";
```

It may look like I changed `"Vivek"` into `"Rahul"`.

But that is not what happened.

Conceptually:

```text
Before:

name
 ↓
"Vivek"
```

Then:

```text
name = "Rahul";
```

Now:

```text
name
 ↓
"Rahul"
```

The reference `name` now refers to another String.

The original `"Vivek"` object was not modified.

---

# 10. Why Are Strings Immutable?

I want to understand the reason, not just memorize the fact.

### 1. String Pool

Because Strings cannot change, Java can safely reuse the same String object.

```text
"Hello"
  ↑
  ├── a
  ├── b
  └── c
```

If Strings were mutable, changing one reference could unexpectedly affect all the others.

### 2. Security

Strings are commonly used for things such as:

```text
File paths
URLs
Class names
Database information
Configuration values
```

Immutability makes these values safer to share.

### 3. Thread Safety

Immutable objects are naturally safer to share between multiple threads because their state cannot be changed.

---

# 11. String Memory — What Is Actually Happening?

This is where I need to be careful.

I already learned the conceptual memory formula for arrays:

```text
Address = Base Address + (Index × Element Size)
```

I should **not directly apply that formula to Java Strings**.

A Java String is a **Java object**, and its exact physical memory layout is managed by the JVM.

Modern Java implementations use an internal representation involving a **`byte[]` backing array** and information describing how that data is encoded.

So I can build this conceptual model:

```text
String variable
      │
      ↓
┌─────────────────────┐
│     String Object   │
│                     │
│  internal data      │
│  encoding info      │
└──────────┬──────────┘
           │
           ↓
        byte[]
```

This is a **conceptual model**, not a promise about the exact physical memory layout of every JVM.

The important thing for me is:

```text
String ≠ simply char[]
```

---

# 12. Then How Does `charAt()` Work?

Suppose I write:

```java
String word = "HELLO";

char ch = word.charAt(2);
```

I am logically asking Java:

```text
Give me the character at index 2.
```

Conceptually:

```text
String:  H   E   L   L   O
Index:   0   1   2   3   4
                  ↑
                  │
             charAt(2)
                  │
                  ↓
                  L
```

I should think of this as **logical indexed access**.

I should not assume that Java is literally calculating:

```text
Base Address + (Index × Character Size)
```

for every String access.

That formula was useful for understanding arrays.

Java hides the actual String memory representation from me.

---

# 13. Why Is `charAt()` O(1)?

For normal Java String access:

```java
word.charAt(index)
```

provides constant-time access.

Conceptually:

```text
index
  ↓
String's internal representation
  ↓
character at that position
```

So I generally consider:

```text
charAt(index) → O(1)
```

for DSA analysis.

---

# 14. An Important Unicode Detail

There is another important detail.

Java's `char` represents a **UTF-16 code unit**.

It does not always represent one complete human-visible character.

For common characters:

```text
'A' → one char
'B' → one char
'中' → one char
```

But some Unicode characters, including certain emoji, require **two UTF-16 code units**.

Because of this:

```java
String text = "...";

text.length();
```

does not always mean:

> Number of human-visible characters.

It means the number of **UTF-16 code units**.

For most beginner DSA problems involving normal English letters, I don't need to worry about this distinction yet.

But I should know that it exists.

---

# 15. Finding String Length

For an array:

```java
numbers.length
```

For a String:

```java
word.length()
```

Example:

```java
String word = "HELLO";

System.out.println(word.length());
```

Output:

```text
5
```

So I should remember:

```text
Array  → length
String → length()
```

---

# 16. Accessing Characters

I use:

```java
charAt(index)
```

Example:

```java
String word = "HELLO";

System.out.println(word.charAt(0));
System.out.println(word.charAt(2));
System.out.println(word.charAt(4));
```

Output:

```text
H
L
O
```

The indexes are:

```text
H   E   L   L   O
0   1   2   3   4
```

---

# 17. Traversing a String

Since a String is a sequence of characters, I can traverse it using a loop.

```java
String word = "HELLO";

for (int i = 0; i < word.length(); i++) {
    System.out.println(word.charAt(i));
}
```

Output:

```text
H
E
L
L
O
```

The flow is:

```text
i = 0 → H
i = 1 → E
i = 2 → L
i = 3 → L
i = 4 → O
i = 5 → stop
```

The traversal takes:

```text
O(n)
```

because I visit each character once.

---

# 18. String Concatenation

I can combine Strings using `+`.

```java
String firstName = "Vivek";
String lastName = "Das";

String fullName = firstName + " " + lastName;

System.out.println(fullName);
```

Output:

```text
Vivek Das
```

Conceptually:

```text
"Vivek"
   +
" "
   +
"Das"
   ↓
"Vivek Das"
```

Because Strings are immutable, concatenation does not modify the existing Strings.

It results in another String value.

---

# 19. `substring()`

I can extract a part of a String using:

```java
substring()
```

Example:

```java
String word = "HelloWorld";

System.out.println(word.substring(5));
```

Output:

```text
World
```

I can also specify a range:

```java
System.out.println(word.substring(0, 5));
```

Output:

```text
Hello
```

The ending index is **exclusive**.

```text
H E L L O W O R L D
0 1 2 3 4 5 6 7 8 9

substring(0, 5)
↑           ↑
included    excluded
```

Result:

```text
Hello
```

---

# 20. Searching in a String

### `indexOf()`

```java
String word = "HELLO";

System.out.println(word.indexOf("L"));
```

Output:

```text
2
```

It gives the position of the first occurrence.

### `contains()`

```java
String sentence = "I am learning DSA";

System.out.println(sentence.contains("DSA"));
```

Output:

```text
true
```

This becomes useful when I need to check whether a particular sequence exists inside another String.

---

# 21. Converting String to `char[]`

Sometimes a DSA problem becomes easier if I work directly with characters.

I can convert:

```java
String word = "HELLO";

char[] letters = word.toCharArray();
```

Conceptually:

```text
"HELLO"
   ↓
toCharArray()
   ↓
['H', 'E', 'L', 'L', 'O']
```

Now I can modify the array:

```java
letters[0] = 'Y';
```

Result:

```text
YELLO
```

The original String itself was not modified.

---

# 22. Converting `char[]` Back to String

I can convert the character array back:

```java
char[] letters = {'H', 'E', 'L', 'L', 'O'};

String word = new String(letters);

System.out.println(word);
```

Output:

```text
HELLO
```

This gives me a useful flow for problems where I need to modify characters:

```text
String
  ↓
char[]
  ↓
Modify
  ↓
String
```

---

# 23. Updating Characters

I cannot directly do:

```java
String word = "HELLO";

word[0] = 'Y';
```

This is invalid.

Instead:

```java
String word = "HELLO";

char[] letters = word.toCharArray();

letters[0] = 'Y';

word = new String(letters);

System.out.println(word);
```

Output:

```text
YELLO
```

This works because I modified the **character array**, not the original String.

---

# 24. Common String Operations

| Operation   | Java Method     | Purpose                     |
| ----------- | --------------- | --------------------------- |
| Find length | `length()`      | Number of UTF-16 code units |
| Access      | `charAt()`      | Get character at an index   |
| Compare     | `equals()`      | Compare String contents     |
| Search      | `indexOf()`     | Find position               |
| Check       | `contains()`    | Check whether text exists   |
| Extract     | `substring()`   | Get part of a String        |
| Convert     | `toCharArray()` | String → `char[]`           |
| Replace     | `replace()`     | Replace characters/text     |
| Lowercase   | `toLowerCase()` | Convert to lowercase        |
| Uppercase   | `toUpperCase()` | Convert to uppercase        |

I don't want to memorize these blindly.

I want to understand **what operation I need and why**.

---

# 25. Time Complexity

For DSA, I need to care about how much work each operation performs.

Some common operations can be considered:

| Operation             |               Typical Complexity |
| --------------------- | -------------------------------: |
| `charAt()`            |                             O(1) |
| `length()`            |                             O(1) |
| Traversal             |                             O(n) |
| `equals()`            |                  O(n) worst case |
| Character `indexOf()` |                             O(n) |
| `toCharArray()`       |                             O(n) |
| `substring()`         | Depends on operation/JDK details |

Here:

```text
n = length of the String
```

The important habit is:

> **Whenever I use a String operation in a DSA problem, I should think about its complexity.**

---

# 26. Dry Run

Consider:

```java
String word = "CODE";

for (int i = 0; i < word.length(); i++) {
    System.out.println(word.charAt(i));
}
```

Initial state:

```text
word = "CODE"
length = 4
```

### Iteration 1

```text
i = 0
charAt(0)
   ↓
C
```

### Iteration 2

```text
i = 1
charAt(1)
   ↓
O
```

### Iteration 3

```text
i = 2
charAt(2)
   ↓
D
```

### Iteration 4

```text
i = 3
charAt(3)
   ↓
E
```

### Stop

```text
i = 4

4 < 4 → false
```

Final output:

```text
C
O
D
E
```

Time complexity:

```text
O(n)
```

Space complexity of the loop itself:

```text
O(1)
```

---

# 27. Complete Java Example

```java
package L04_Strings;

public class StringExample {

    public static void main(String[] args) {

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

        // Comparing Strings
        String anotherWord = "HELLO";

        System.out.println("Are the Strings equal? " + word.equals(anotherWord));

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
    }
}
```

---

# 28. Strings and Arrays — What Is the Connection?

I learned Arrays before Strings, so I want to connect the two.

### Array

```text
Indexed collection
       ↓
Access using index
       ↓
array[index]
```

### String

```text
Sequence of characters
       ↓
Logical indexing
       ↓
string.charAt(index)
```

So Arrays helped me understand the basic idea of **indexed access**.

Strings now let me apply similar thinking specifically to **text and characters**.

---

# 29. Why Strings Matter in DSA

Now I can see how this knowledge will be useful later.

### Palindrome

```text
"madam"

Forward  → madam
Backward → madam
```

### Character Frequency

```text
"banana"

b → 1
a → 3
n → 2
```

### Anagram

```text
"listen"
"silent"
```

Both contain the same characters with the same frequencies.

### Two Pointers

```text
H E L L O
↑       ↑
L       R
```

I can move two indexes toward each other.

### Sliding Window

```text
H E L L O W O R L D
←───────→
  window
```

A String gives me a sequence over which I can move and maintain a window.

These are concepts I will use later when solving actual DSA problems.

---

# 30. What I Should Remember

The most important things from this lesson are:

### String

```text
String
 ↓
Java Object
 ↓
Sequence of text
```

### Indexing

```text
H E L L O
0 1 2 3 4
```

### Access

```text
word.charAt(index)
```

### Length

```text
word.length()
```

### Comparison

```text
==       → reference comparison
.equals  → content comparison
```

### Immutability

```text
String
 ↓
Immutable
 ↓
Existing contents cannot be modified
```

### Modification

```text
String
 ↓
toCharArray()
 ↓
Modify char[]
 ↓
new String(...)
```

### Memory

```text
String
 ↓
Java Object
 ↓
Internal representation managed by JVM
 ↓
Modern Java commonly uses byte[] + encoding information
```

I should **not** treat a String as simply a `char[]`.

---

# 31. Connection With My Previous Lesson

My learning so far looks like:

```text
L01
Data Structures
      ↓
L02
Abstract Data Types
      ↓
L03
Arrays
      ↓
L04
Strings
```

Arrays taught me:

```text
Index
Access
Traversal
Memory concepts
Complexity
```

Strings build on some of these ideas:

```text
Index
  ↓
Character Access
  ↓
Traversal
  ↓
Searching
  ↓
String Algorithms
```

So Strings are not completely separate from Arrays.

They build on many of the same fundamental ideas.

---

# Final Mental Model

When I think about a Java String, I should think:

```text
                         STRING
                            │
                            ↓
                       Java Object
                            │
                 ┌──────────┴──────────┐
                 ↓                     ↓
          Immutable Value       Internal Representation
                                       │
                                       ↓
                               Modern Java uses
                                  byte[] + coder
                                       │
                                       ↓
                              Logical Character Access
                                       │
                                       ↓
                                  charAt(index)
                                       │
                                       ↓
                                  Traversal
                                       │
                    ┌──────────────────┼──────────────────┐
                    ↓                  ↓                  ↓
                Searching          Comparison        Substrings
                    │                  │                  │
                    └──────────────────┼──────────────────┘
                                       ↓
                                  DSA Problems
```

The main thing I want to remember is:

> **A Java String is an immutable Java object representing a sequence of text. I can logically access its characters using indexes, but its actual memory representation is managed internally by the JVM.**

I don't want to just memorize String methods.

I want to understand **how Strings behave, what happens internally, how their operations work, and how I can use them to solve DSA problems.**
