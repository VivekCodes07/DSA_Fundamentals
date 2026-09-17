# L03 — Arrays

## What Am I Going to Study in This Lesson?

In this lesson, I am going to understand **Arrays** from both the programming and internal perspective.

I will study:

* What is an Array?
* Why do I need Arrays?
* How an Array stores multiple values
* Array indexes and 0-based indexing
* How to create and initialize Arrays in Java
* How to access and update elements
* How Array length works
* How to traverse an Array
* How Array elements are arranged in memory
* What is a Base Address?
* How an element's address is calculated using its index
* Why Array access is `O(1)`
* What happens when I access an invalid index
* Advantages and limitations of Arrays
* How insertion and deletion work in an Array
* How Arrays connect with searching and sorting

The main goal is to understand not only **how to use an Array**, but also **why accessing an Array element is so fast**.

---

# 1. Why Do I Need an Array?

Suppose I want to store the marks of 5 students.

Without an Array, I could create separate variables:

```java
int marks1 = 85;
int marks2 = 90;
int marks3 = 78;
int marks4 = 92;
int marks5 = 88;
```

This works for a few values.

But imagine I have 10,000 students.

I don't want:

```text
marks1
marks2
marks3
...
marks10000
```

Instead, I want one structure that can hold all the values:

```java
int[] marks = {85, 90, 78, 92, 88};
```

Now I have:

```text
marks
  ↓
[85, 90, 78, 92, 88]
```

This is the main purpose of an Array:

> **Store multiple values under one variable in an organized structure.**

---

# 2. What is an Array?

An **Array** is a fixed-size data structure that stores multiple elements of the same declared type.

For example:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Conceptually:

```text
┌────┬────┬────┬────┬────┐
│ 10 │ 20 │ 30 │ 40 │ 50 │
└────┴────┴────┴────┴────┘
```

Each element has a position.

That position is called its **index**.

---

# 3. Array Index

One of the most important things I need to remember:

> **Array indexing starts from 0.**

For:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

the structure looks like:

```text
Index:    0     1     2     3     4
        ┌─────┬─────┬─────┬─────┬─────┐
Value:  │  10 │  20 │  30 │  40 │  50 │
        └─────┴─────┴─────┴─────┴─────┘
```

So:

```java
numbers[0] → 10
numbers[1] → 20
numbers[2] → 30
numbers[3] → 40
numbers[4] → 50
```

If the Array has `5` elements:

```text
Length = 5
```

then:

```text
First index = 0
Last index  = length - 1
           = 5 - 1
           = 4
```

This is why the last valid index is always:

```java
numbers.length - 1
```

---

# 4. Why Does Indexing Start at 0?

This becomes easier to understand when I look at how an Array is stored conceptually.

Suppose the first element starts at some memory location called the **Base Address**.

For example:

```text
Base Address = 1000
```

If each element occupies `4 bytes`, then:

```text
Index 0 → 1000
Index 1 → 1004
Index 2 → 1008
Index 3 → 1012
Index 4 → 1016
```

Notice something:

```text
Index 0
```

means:

```text
Base Address + 0
```

That's why the first element naturally corresponds to index `0`.

---

# 5. Array Elements in Memory

Let's take:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

For learning purposes, imagine:

```text
Base Address = 1000
int size = 4 bytes
```

Then conceptually:

```text
Index       Value       Address
--------------------------------
  0           10         1000
  1           20         1004
  2           30         1008
  3           40         1012
  4           50         1016
```

Visual representation:

```text
             Array

Index 0       Index 1       Index 2       Index 3       Index 4
   ↓             ↓             ↓             ↓             ↓
┌────────┬────────┬────────┬────────┬────────┐
│   10   │   20   │   30   │   40   │   50   │
└────────┴────────┴────────┴────────┴────────┘
 1000      1004      1008      1012      1016
```

The actual memory management is handled by Java, but this is the **conceptual model** I use to understand why indexed access is fast.

---

# 6. What is a Base Address?

The **Base Address** is the conceptual memory address of the first element of the Array.

If:

```text
Base Address = 1000
```

then:

```text
Index 0 → 1000
```

From there, I can calculate the location of other elements based on:

* Base address
* Index
* Size of each element

---

# 7. How is an Element's Address Calculated?

This is one of the most important concepts in this lesson.

The general formula is:

```text
Address of element
=
Base Address + (Index × Size of each element)
```

Suppose:

```text
Base Address = 1000
Index        = 3
Element size = 4 bytes
```

Then:

```text
Address
= 1000 + (3 × 4)
= 1000 + 12
= 1012
```

Therefore:

```text
numbers[3]
```

is conceptually located at:

```text
1012
```

---

# 8. Why is Array Access O(1)?

Now I can understand something very important.

Suppose I want:

```java
numbers[3]
```

I don't have to check:

```text
10 → 20 → 30 → 40
```

one by one.

The index itself gives me the information needed to calculate the location.

Conceptually:

```text
Base Address
     +
Index × Element Size
     ↓
Target location
```

For:

```text
numbers[3]
```

the calculation is:

```text
1000 + (3 × 4)
= 1012
```

This calculation takes a constant amount of work.

Therefore:

```text
Array access = O(1)
```

It doesn't matter whether the Array contains:

```text
5 elements
```

or:

```text
5,000,000 elements
```

If I already know the index, accessing that position is considered constant time.

---

# 9. Important Java Detail

Because I am learning this using Java, I need to understand one distinction.

Java does **not** give me direct access to raw memory addresses.

For example, I cannot normally do:

```text
print the actual address of numbers[3]
```

The addresses such as:

```text
1000
1004
1008
```

are being used here as a **conceptual model** to understand how indexed access works.

Java manages memory internally through the JVM.

So I should remember:

> **The address calculation is the underlying array-memory model used to understand why indexed access is O(1), not something I manually perform in normal Java code.**

---

# 10. Creating an Array in Java

I can create an Array in several ways.

## Direct Initialization

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Java automatically knows:

```text
Length = 5
```

---

## Creating an Array with a Fixed Size

```java
int[] numbers = new int[5];
```

This creates space for 5 integers.

Initially:

```text
[0, 0, 0, 0, 0]
```

Then I can assign values:

```java
numbers[0] = 10;
numbers[1] = 20;
numbers[2] = 30;
numbers[3] = 40;
numbers[4] = 50;
```

Now:

```text
[10, 20, 30, 40, 50]
```

---

# 11. Accessing Elements

I can access an element using its index.

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[2]);
```

Output:

```text
30
```

The flow is:

```text
numbers[2]
    ↓
Find index 2
    ↓
Calculate its location
    ↓
Get the value
    ↓
30
```

---

# 12. Updating an Element

Arrays are mutable, so I can change an existing element.

```java
int[] numbers = {10, 20, 30, 40, 50};

numbers[2] = 100;
```

Before:

```text
[10, 20, 30, 40, 50]
```

After:

```text
[10, 20, 100, 40, 50]
```

The index doesn't change.

Only the value stored at that index changes.

---

# 13. Array Length

Java provides the `length` property.

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers.length);
```

Output:

```text
5
```

I can use it when traversing the Array:

```java
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

Important:

For Arrays:

```java
numbers.length
```

not:

```java
numbers.length()
```

because `length` is a property.

---

# 14. Traversing an Array

Traversing means visiting every element one by one.

Example:

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}
```

The flow is:

```text
i = 0 → numbers[0] → 10
i = 1 → numbers[1] → 20
i = 2 → numbers[2] → 30
i = 3 → numbers[3] → 40
i = 4 → numbers[4] → 50
i = 5 → stop
```

Since I visit every element:

```text
Traversal = O(n)
```

---

# 15. Enhanced For Loop

Java also provides the enhanced `for` loop:

```java
int[] numbers = {10, 20, 30, 40, 50};

for (int number : numbers) {
    System.out.println(number);
}
```

Here Java gives me each value directly.

Normal `for` loop:

```java
for (int i = 0; i < numbers.length; i++)
```

is useful when I need the index.

Enhanced `for` loop:

```java
for (int number : numbers)
```

is useful when I only need the values.

---

# 16. What Happens with an Invalid Index?

Suppose:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

Valid indexes are:

```text
0 1 2 3 4
```

If I try:

```java
System.out.println(numbers[5]);
```

there is no index `5`.

Java throws:

```text
ArrayIndexOutOfBoundsException
```

Conceptually:

```text
Length = 5

Valid:
0 → 1 → 2 → 3 → 4

Invalid:
5
```

This is another reason I need to remember:

```text
Last valid index = length - 1
```

---

# 17. Why is the Size Fixed?

Suppose I create:

```java
int[] numbers = new int[5];
```

The Array has space for 5 elements.

After creation, its length cannot simply become 10.

I cannot do:

```java
numbers.length = 10;
```

Java Arrays have a fixed length.

If I need more space, I need another Array.

Conceptually:

```text
Old Array
[10, 20, 30, 40, 50]

        ↓

New larger Array
[10, 20, 30, 40, 50, 60, 70]
```

This limitation is one reason dynamic data structures such as `ArrayList` are useful.

---

# 18. Insertion in an Array

Suppose I have:

```text
[10, 20, 30, 40, 50]
```

and I want to insert `25` at index `2`.

I cannot simply overwrite `30`, because I would lose it.

I need to shift elements:

```text
Before:

[10, 20, 30, 40, 50]
```

Shift:

```text
[10, 20, __, 30, 40, 50]
```

Then insert:

```text
[10, 20, 25, 30, 40, 50]
```

So inserting in the middle can require moving multiple elements.

Therefore, insertion at an arbitrary position is generally:

```text
O(n)
```

---

# 19. Deletion in an Array

The same idea applies to deletion.

Suppose:

```text
[10, 20, 30, 40, 50]
```

I want to delete `30`.

I remove it:

```text
[10, 20, __, 40, 50]
```

Then elements may need to shift:

```text
[10, 20, 40, 50]
```

Again, multiple elements may need to move.

Therefore:

```text
Deletion from the middle = O(n)
```

---

# 20. Searching in an Array

Suppose:

```text
[10, 20, 30, 40, 50]
```

I want to find `40`.

If I don't know its index, I may need to check elements one by one:

```text
10 → no
20 → no
30 → no
40 → found
```

This is **Linear Search**.

Example:

```java
int[] numbers = {10, 20, 30, 40, 50};

int target = 40;

for (int i = 0; i < numbers.length; i++) {

    if (numbers[i] == target) {
        System.out.println("Found at index: " + i);
        break;
    }
}
```

Output:

```text
Found at index: 3
```

Worst-case time complexity:

```text
O(n)
```

I will study searching in more detail later.

---

# 21. Arrays and Sorting

Arrays are also heavily used in sorting algorithms.

For example:

```text
Before:

[50, 20, 40, 10, 30]

After:

[10, 20, 30, 40, 50]
```

The sorting algorithms I will study later include:

```text
Bubble Sort
Selection Sort
Insertion Sort
Quick Sort
Merge Sort
```

Most of these algorithms will operate directly on Arrays.

So understanding Arrays properly is essential before moving forward.

---

# 22. Array Operations and Complexity

Now I can connect Arrays with complexity:

| Operation              | Complexity |
| ---------------------- | ---------: |
| Access by index        |       O(1) |
| Update by index        |       O(1) |
| Traverse               |       O(n) |
| Search                 |       O(n) |
| Insert at a position   |       O(n) |
| Delete from a position |       O(n) |

The exact cost of insertion and deletion depends on where the operation occurs.

The important idea is:

```text
Known index
    ↓
Direct access
    ↓
O(1)
```

But:

```text
Unknown position
    ↓
May need to check many elements
    ↓
O(n)
```

---

# 23. Simple Java Example

```java
package L03_Arrays;

public class ArrayExample {

    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("First element: " + numbers[0]);

        numbers[2] = 100;

        System.out.println("Updated element: " + numbers[2]);

        System.out.println("Array length: " + numbers.length);

        System.out.println("All elements:");

        for (int number : numbers) {
            System.out.println(number);
        }
    }
}
```

Output:

```text
First element: 10
Updated element: 100
Array length: 5
All elements:
10
20
100
40
50
```

---

# 24. Complete Internal Dry Run

Consider:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

For understanding, assume:

```text
Base Address = 1000
int size = 4 bytes
```

Then:

```text
Index     Value     Address
--------------------------------
  0         10        1000
  1         20        1004
  2         30        1008
  3         40        1012
  4         50        1016
```

Now suppose I execute:

```java
System.out.println(numbers[3]);
```

Conceptually:

```text
Step 1:
Index = 3

Step 2:
Base Address = 1000

Step 3:
Element Size = 4 bytes

Step 4:
Address = Base + (Index × Element Size)

Step 5:
Address = 1000 + (3 × 4)

Step 6:
Address = 1012

Step 7:
Read value stored there

Step 8:
40
```

So:

```text
numbers[3]
     ↓
1000 + (3 × 4)
     ↓
1012
     ↓
40
```

This is the key internal idea behind constant-time indexed access.

---

# 25. Important Java Memory Note

I should not assume that the simple diagram above is literally how a Java `int[]` is laid out in physical memory.

Java runs on the JVM, which manages memory automatically.

There can be:

* Object headers
* References
* JVM implementation details
* Alignment
* Garbage collection
* Different memory layouts depending on the JVM

Therefore, the formula:

```text
Base Address + (Index × Element Size)
```

is the **conceptual model** I use to understand array indexing and why random access is constant time.

The important DSA idea is:

> **The index gives the JVM enough information to locate the requested array element without scanning all previous elements.**

---

# 26. Advantages of Arrays

### 1. Fast Random Access

```java
numbers[500]
```

can be accessed directly.

```text
O(1)
```

### 2. Simple

Arrays are one of the easiest data structures to understand.

### 3. Useful for Algorithms

Searching and sorting algorithms commonly operate on Arrays.

### 4. Predictable Size

When I know exactly how many elements I need, a fixed-size Array can be useful.

---

# 27. Limitations of Arrays

### 1. Fixed Size

The size cannot be changed after creation.

### 2. Insertion Can Be Expensive

Elements may need to be shifted.

```text
O(n)
```

### 3. Deletion Can Be Expensive

Elements may need to be shifted.

```text
O(n)
```

### 4. Same Declared Element Type

For example:

```java
int[] numbers = {10, 20, 30};
```

is intended to store integers.

---

# 28. Array vs Individual Variables

Without an Array:

```java
int mark1 = 80;
int mark2 = 90;
int mark3 = 85;
int mark4 = 95;
```

With an Array:

```java
int[] marks = {80, 90, 85, 95};
```

Now I can use:

```java
marks[0]
marks[1]
marks[2]
marks[3]
```

and traverse all of them using a loop.

The Array gives me a **single structured collection of related values**.

---

# 29. What I Should Remember

The most important concepts from this lesson are:

```text
Array
 ↓
Fixed-size collection
 ↓
Elements have indexes
 ↓
Index starts at 0
 ↓
Last index = length - 1
 ↓
Elements can be accessed using index
 ↓
Conceptually:
Address = Base + (Index × Element Size)
 ↓
Direct access = O(1)
```

And:

```text
Access by index → O(1)
Search          → O(n)
Traversal       → O(n)
Insertion       → O(n)
Deletion        → O(n)
```

---

# Connection to the Next Lesson

So far, my learning flow is:

```text
L01 — What Are Data Structures?
             ↓
L02 — Abstract Data Types
             ↓
L03 — Arrays
             ↓
L04 — Time Complexity
```

In this lesson, I saw:

```text
Access → O(1)
Search → O(n)
```

But what exactly does `O(1)` or `O(n)` mean?

How do I compare two algorithms?

How do I know whether an algorithm is efficient?

These questions lead directly to:

# L04 — Time Complexity

---

# Final Mental Model

```text
                 ARRAY
                   │
          ┌────────┴────────┐
          ↓                 ↓
      Fixed Size        Same Type
          │
          ↓
      Index Based
          │
          ↓
    Index starts at 0
          │
          ↓
   Direct Element Access
          │
          ↓
        O(1)
```

The most important thing I learned:

> **An Array stores elements in an indexed structure. Because the index can be used to directly locate an element, accessing an element by index takes constant time, O(1).**

And the internal idea I should remember is:

```text
Address = Base Address + (Index × Element Size)
```

This formula is the bridge between **how I use Arrays in Java** and **why Arrays have O(1) random access**.
