# L06 — Time & Space Complexity

## What Am I Going to Study in This Lesson?

In this lesson, I am going to understand:

* Why complexity analysis is needed
* What `n` means
* How to think about the work done by an algorithm
* What Time Complexity means
* What Space Complexity means
* What Big-O notation means
* Constant Time — `O(1)`
* Linear Time — `O(n)`
* Logarithmic Time — `O(log n)`
* Linearithmic Time — `O(n log n)`
* Quadratic Time — `O(n²)`
* Best, Average and Worst Case
* How loops affect complexity
* How nested loops affect complexity
* How input size affects Time Complexity
* How extra memory affects Space Complexity
* Auxiliary Space vs Input Space
* How to analyze both Time and Space Complexity together
* Why efficient DSA solutions care about both time and memory

---

# 1. Why Do I Need Complexity Analysis?

Suppose I write a program that searches for a number in an array.

```java
int[] numbers = {10, 20, 30, 40, 50};
```

It works.

But what happens when the array contains:

```text
10 elements
1,000 elements
1,000,000 elements
```

Now I need to ask two questions:

> How much time will my algorithm need?

and

> How much extra memory will my algorithm need?

These two questions lead to:

```text
Time Complexity
       +
Space Complexity
       ↓
Complexity Analysis
```

---

# 2. What Is Complexity Analysis?

Complexity analysis is the process of understanding how an algorithm's resource requirements grow as the input size increases.

The two main resources I care about are:

```text
                 ALGORITHM
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
     TIME COMPLEXITY       SPACE COMPLEXITY
          │                     │
          ▼                     ▼
     Running Work          Memory Usage
```

So when I analyze an algorithm, I should ask:

```text
1. How much work does it perform?
2. How much memory does it require?
```

---

# 3. What Is `n`?

In DSA, `n` usually represents the size of the input.

For an array:

```java
int[] numbers = new int[n];
```

`n` means:

```text
Number of elements
```

For a String:

```java
String word = ...
```

`n` can represent:

```text
Number of characters
```

For a linked list:

```text
n = number of nodes
```

For example:

```text
Array
[10, 20, 30, 40, 50]

n = 5
```

Whenever I see `n`, I should ask:

> **What does `n` represent in this problem?**

---

# 4. Time Complexity

Time Complexity describes how the amount of computational work grows as the input size increases.

I am not trying to calculate the exact number of seconds.

Instead, I am asking:

> **How does the amount of work grow when `n` grows?**

For example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

If:

```text
n = 5
```

The loop runs:

```text
5 times
```

If:

```text
n = 1000
```

It runs:

```text
1000 times
```

The work grows with `n`.

Therefore:

```text
O(n)
```

---

# 5. Space Complexity

Space Complexity describes how the memory requirements of an algorithm grow as the input size increases.

For example:

```java
int sum = 0;

for (int number : numbers) {
    sum += number;
}
```

I only create a few variables:

```text
sum
number
```

The amount of extra memory does not grow with `n`.

Therefore:

```text
O(1)
```

---

Now consider:

```java
int[] copy = new int[n];
```

If `n` becomes larger, the new array also becomes larger.

```text
n = 5
→ 5 extra elements

n = 1000
→ 1000 extra elements
```

Therefore:

```text
O(n)
```

---

# 6. Time vs Space Complexity

I should keep these two ideas separate.

```text
TIME COMPLEXITY
      ↓
How much computational work grows?


SPACE COMPLEXITY
      ↓
How much extra memory grows?
```

For example:

```text
Algorithm A

Time  → O(n)
Space → O(1)
```

This means:

```text
Linear running work
Constant extra memory
```

Another algorithm could be:

```text
Time  → O(n)
Space → O(n)
```

It performs the same amount of growth in time but also requires extra memory proportional to the input.

---

# 7. Big-O Notation

Big-O notation describes the growth rate of an algorithm.

Common complexities include:

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
O(2ⁿ)
O(n!)
```

For now, my main focus is:

```text
O(1)
O(log n)
O(n)
O(n log n)
O(n²)
```

I should understand Big-O as:

> **A way to describe how an algorithm scales as the input becomes larger.**

---

# 8. O(1) — Constant Time

`O(1)` means the amount of work stays approximately constant as `n` grows.

Example:

```java
int first = numbers[0];
```

Whether the array has:

```text
10 elements
```

or:

```text
10 million elements
```

I am still accessing one specific index.

Therefore:

```text
Time → O(1)
```

---

## Space Example

```java
int first = numbers[0];
```

I only create one extra variable.

Therefore:

```text
Space → O(1)
```

So:

```text
Time  → O(1)
Space → O(1)
```

---

# 9. O(n) — Linear Time

Consider:

```java
for (int i = 0; i < n; i++) {
    System.out.println(numbers[i]);
}
```

If:

```text
n = 5
```

The loop runs 5 times.

If:

```text
n = 1000
```

It runs 1000 times.

Therefore:

```text
Time → O(n)
```

---

## Space Can Still Be O(1)

The following algorithm:

```java
int sum = 0;

for (int number : numbers) {
    sum += number;
}
```

visits every element:

```text
Time → O(n)
```

But it doesn't create another data structure proportional to `n`.

Therefore:

```text
Space → O(1)
```

Final:

```text
Time  → O(n)
Space → O(1)
```

This is an important example because **linear time does not automatically mean linear space**.

---

# 10. O(n²) — Quadratic Time

Consider nested loops:

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {

        System.out.println(i + " " + j);
    }
}
```

The outer loop runs `n` times.

For every outer iteration, the inner loop also runs `n` times.

Therefore:

```text
n × n
= n²
```

So:

```text
Time → O(n²)
```

---

## Space Complexity

If the code only uses:

```java
int i
int j
```

and doesn't create additional structures:

```text
Space → O(1)
```

Therefore:

```text
Time  → O(n²)
Space → O(1)
```

Again:

> **Time Complexity and Space Complexity are independent measurements.**

---

# 11. O(log n) — Logarithmic Time

The key idea behind `O(log n)` is:

> **The problem size is repeatedly reduced by a factor.**

For example:

```text
n
↓
n / 2
↓
n / 4
↓
n / 8
↓
...
```

Binary Search is the classic example.

Suppose:

```text
[10, 20, 30, 40, 50, 60, 70, 80]
```

Instead of checking every element, Binary Search checks the middle and eliminates half of the remaining search space.

```text
8 elements
    ↓
4 elements
    ↓
2 elements
    ↓
1 element
```

Therefore:

```text
Binary Search
Time → O(log n)
```

If Binary Search only uses a few variables such as:

```java
int low;
int high;
int mid;
```

then:

```text
Space → O(1)
```

for the iterative version.

So:

```text
Time  → O(log n)
Space → O(1)
```

---

# 12. O(n log n)

Sometimes an algorithm performs:

```text
n work
```

across:

```text
log n levels
```

which gives:

```text
O(n log n)
```

A major example is Merge Sort.

Conceptually:

```text
Array
  ↓
Divide
  ↓
Divide
  ↓
Divide
  ↓
Small pieces
  ↓
Merge
  ↓
Sorted array
```

Merge Sort has:

```text
Time → O(n log n)
```

Its auxiliary space is typically:

```text
Space → O(n)
```

because the standard implementation uses additional arrays/storage while merging.

This is a good example of an algorithm where **time and space are both important**.

---

# 13. Nested Loops

Consider:

```java
for (int i = 0; i < n; i++) {

    for (int j = 0; j < n; j++) {

    }
}
```

The loops are nested.

Therefore:

```text
n × n
= n²
```

Time:

```text
O(n²)
```

If I don't create any extra data structure:

```text
Space → O(1)
```

Mental model:

```text
Nested loops
     ↓
Multiply their work
```

---

# 14. Separate Loops

Now consider:

```java
for (int i = 0; i < n; i++) {
}

for (int j = 0; j < n; j++) {
}
```

These loops are separate.

Their work is:

```text
n + n
= 2n
```

In Big-O:

```text
O(n)
```

So:

```text
Separate loops
    ↓
Add their complexities

Nested loops
    ↓
Usually multiply their complexities
```

---

# 15. Loops That Double

Consider:

```java
for (int i = 1; i < n; i *= 2) {
    System.out.println(i);
}
```

The values are:

```text
1
2
4
8
16
32
...
```

The value doubles every iteration.

Therefore the number of iterations grows logarithmically:

```text
Time → O(log n)
```

---

# 16. Loops That Halve

Consider:

```java
for (int i = n; i > 0; i /= 2) {
    System.out.println(i);
}
```

The values become:

```text
n
n/2
n/4
n/8
...
```

Again, the problem size is repeatedly divided.

Therefore:

```text
Time → O(log n)
```

---

# 17. Best, Average and Worst Case

An algorithm can behave differently depending on the input.

Consider Linear Search:

```java
for (int i = 0; i < numbers.length; i++) {

    if (numbers[i] == target) {
        return i;
    }
}
```

Suppose:

```text
[10, 20, 30, 40, 50]
```

Searching for `10`:

```text
10
↑
Found immediately
```

Best Case:

```text
O(1)
```

Searching for `50`:

```text
10 → 20 → 30 → 40 → 50
```

Worst Case:

```text
O(n)
```

If the target doesn't exist, I may have to check every element.

So:

```text
Linear Search

Best Case  → O(1)
Worst Case → O(n)
```

---

# 18. Auxiliary Space

This is an important distinction.

When discussing Space Complexity, I often care about the **extra memory used by the algorithm**, excluding the input itself.

This is commonly called:

```text
Auxiliary Space
```

For example:

```java
int sum = 0;

for (int number : numbers) {
    sum += number;
}
```

The input array already exists.

I don't create another array.

So the extra memory is:

```text
O(1)
```

---

# 19. Input Space vs Auxiliary Space

Suppose I receive:

```java
int[] numbers = new int[n];
```

The input itself requires memory proportional to `n`.

That is:

```text
Input Space → O(n)
```

But if my algorithm only creates:

```java
int sum = 0;
```

then:

```text
Auxiliary Space → O(1)
```

So I should distinguish:

```text
Total memory involved
        ↓
Input Space + Extra/Auxiliary Space
```

In many DSA discussions, when someone says:

> "Space Complexity of this algorithm"

they are often referring to the **extra space used by the algorithm**, but I should always check the context.

---

# 20. Example — O(n) Time and O(n) Space

Consider:

```java
int[] copy = new int[n];

for (int i = 0; i < n; i++) {
    copy[i] = numbers[i];
}
```

The loop runs `n` times:

```text
Time → O(n)
```

The new array contains `n` elements:

```text
Space → O(n)
```

Therefore:

```text
Time  → O(n)
Space → O(n)
```

---

# 21. Example — O(n) Time and O(1) Space

Now consider:

```java
int sum = 0;

for (int number : numbers) {
    sum += number;
}
```

The algorithm visits all `n` elements:

```text
Time → O(n)
```

But only uses a fixed number of variables:

```text
sum
number
```

Therefore:

```text
Space → O(1)
```

Final:

```text
Time  → O(n)
Space → O(1)
```

This is an important pattern in DSA:

> **An algorithm can take linear time without taking linear extra space.**

---

# 22. Example — O(n) Time and O(n) Space

Consider:

```java
int[] result = new int[n];

for (int i = 0; i < n; i++) {
    result[i] = numbers[i] * 2;
}
```

The loop processes every element:

```text
Time → O(n)
```

The result array grows with `n`:

```text
Space → O(n)
```

So:

```text
Time  → O(n)
Space → O(n)
```

---

# 23. Time and Space Trade-Off

Sometimes I can use more memory to reduce computation.

For example, suppose I calculate something repeatedly.

I could:

```text
Recalculate every time
        ↓
Less memory
        ↓
More time
```

Or I could store previously calculated results:

```text
Store results
        ↓
More memory
        ↓
Less repeated work
```

This is called a:

```text
Time-Space Trade-Off
```

Mental model:

```text
Sometimes:

More Space
    ↓
Less Time

or

Less Space
    ↓
More Time
```

This doesn't mean more memory is always better.

The right choice depends on the problem and constraints.

---

# 24. Removing Constants

Suppose:

```java
for (int i = 0; i < n; i++) {
}

for (int i = 0; i < n; i++) {
}
```

Work:

```text
n + n
= 2n
```

Technically:

```text
O(2n)
```

But Big-O focuses on the growth rate.

Therefore:

```text
O(2n)
→ O(n)
```

The constant `2` is ignored.

---

# 25. Removing Smaller Terms

Suppose the work is:

```text
n² + n + 10
```

As `n` becomes very large:

```text
n²
```

grows much faster than:

```text
n
```

and:

```text
10
```

So:

```text
O(n² + n + 10)
→ O(n²)
```

The dominant term determines the growth.

---

# 26. Comparing Common Complexities

A useful mental model:

```text
O(1)
   ↓
Constant

O(log n)
   ↓
Very slow growth

O(n)
   ↓
Linear growth

O(n log n)
   ↓
Faster than linear

O(n²)
   ↓
Quadratic growth

O(2ⁿ)
   ↓
Exponential growth

O(n!)
   ↓
Factorial growth
```

The larger the growth rate, the more important input size becomes.

---

# 27. A Simple Comparison

Suppose:

```text
n = 1,000
```

Approximately:

```text
O(1)       → 1
O(log n)   → ~10
O(n)       → 1,000
O(n log n) → ~10,000
O(n²)      → 1,000,000
```

The exact operation counts are not the point.

The point is how differently these functions grow.

---

# 28. Complexity Analysis Flow

Whenever I analyze a DSA algorithm, I can follow this flow:

```text
Read the algorithm
       ↓
Identify the input
       ↓
Determine what n represents
       ↓
Analyze the loops / recursion
       ↓
Count how the work grows
       ↓
Analyze extra memory
       ↓
Identify the dominant terms
       ↓
Remove constants and smaller terms
       ↓
Write Time Complexity
       ↓
Write Space Complexity
```

For example:

```text
Nested loop
     ↓
n × n
     ↓
n²
     ↓
Time = O(n²)

No extra data structure
     ↓
Space = O(1)
```

---

# 29. Connecting This With Previous Lessons

Now I can analyze some of the code I've already written.

## Array Access

```java
numbers[index]
```

Time:

```text
O(1)
```

Because the index gives direct access.

---

## Array Traversal

```java
for (int number : numbers) {
    System.out.println(number);
}
```

Time:

```text
O(n)
```

Space:

```text
O(1)
```

if no additional data structure is created.

---

## String Traversal

```java
for (int i = 0; i < word.length(); i++) {
    System.out.println(word.charAt(i));
}
```

Time:

```text
O(n)
```

---

## StringBuilder Reversal

My previous lesson used:

```java
for (int i = 0; i < word.length() / 2; i++) {

    int targetIndex = word.length() - 1 - i;

    char frontChar = word.charAt(i);
    char backChar = word.charAt(targetIndex);

    word.setCharAt(i, backChar);
    word.setCharAt(targetIndex, frontChar);
}
```

The loop runs approximately:

```text
n / 2
```

times.

Ignoring the constant:

```text
O(n / 2)
→ O(n)
```

Because I modify the same StringBuilder instead of creating another structure:

```text
Time  → O(n)
Space → O(1)
```

Now I can actually explain **why** my previous code has that complexity.

---

# 30. Final Mental Model

I should think about complexity like this:

```text
                    ALGORITHM
                        │
                        ▼
                  INPUT SIZE = n
                        │
              ┌─────────┴─────────┐
              ▼                   ▼
            TIME                SPACE
              │                   │
              ▼                   ▼
        Amount of work       Extra memory
              │                   │
              ▼                   ▼
            Big-O               Big-O
```

For Time:

```text
Direct access
→ O(1)

Process everything once
→ O(n)

Repeatedly divide the problem
→ O(log n)

n work across log levels
→ O(n log n)

Nested n × n work
→ O(n²)
```

For Space:

```text
Fixed number of variables
→ O(1)

Extra array / structure of size n
→ O(n)
```

---

# 31. Final Takeaway

Time Complexity answers:

> **How does the amount of computational work grow as the input gets larger?**

Space Complexity answers:

> **How does the extra memory requirement grow as the input gets larger?**

Together:

```text
Time Complexity
      +
Space Complexity
      ↓
Complexity Analysis
```

The habit I want to build from this lesson is:

> **Whenever I write or analyze an algorithm, I should always ask two questions: "How much time does this take?" and "How much extra space does this use?"**

That is the foundation I will use throughout DSA.

---

# 32. What I Should Be Able to Explain Now

After completing this lesson, I should be able to:

* Explain why complexity analysis is needed.
* Explain what `n` represents.
* Explain Time Complexity.
* Explain Space Complexity.
* Understand Big-O notation.
* Identify `O(1)`, `O(log n)`, `O(n)`, `O(n log n)` and `O(n²)`.
* Analyze simple loops.
* Analyze nested loops.
* Understand separate vs nested loops.
* Understand best and worst cases.
* Understand auxiliary space.
* Distinguish input space from extra space.
* Explain basic time-space trade-offs.
* Analyze both Time and Space Complexity of my own DSA code.

---

# Connection to the Next Lesson

Now I know how to measure the efficiency of an algorithm.

The next question is:

> **How can I actually find an element inside a data structure efficiently?**

That leads to:

**L07 — Searching**

where I will learn:

```text
Linear Search
     ↓
O(n)

Binary Search
     ↓
O(log n)
```

This will give me my first practical comparison between two algorithms that solve the same type of problem but have very different growth rates.
