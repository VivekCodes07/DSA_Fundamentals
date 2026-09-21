# L05 — StringBuilder

## What Am I Going to Study in This Lesson?

In this lesson, I am going to understand:

* Why `StringBuilder` is needed
* The problem with repeated `String` modification
* What `StringBuilder` actually is
* `String` vs `StringBuilder`
* How `StringBuilder` works in memory
* How mutability changes the way modification works
* `append()`
* `insert()`
* `delete()`
* `deleteCharAt()`
* `setCharAt()`
* `reverse()`
* `length()`
* `capacity()`
* `toString()`
* Using `StringBuilder` inside loops
* Time complexity of common operations
* Why `StringBuilder` is useful in DSA
* `StringBuilder` vs `StringBuffer`

---

# 1. Why Do I Need StringBuilder?

In the previous lesson, I learned that a `String` in Java is **immutable**.

That means once a String object is created, its contents cannot be changed.

For example:

```java
String name = "Vivek";

name = name + " Das";
```

It may look like I modified `"Vivek"`.

But I didn't.

A new String value is created:

```text
"Vivek"
   +
" Das"
   ↓
"Vivek Das"
```

This becomes a problem when I repeatedly modify a String, especially inside a loop.

For example:

```java
String result = "";

for (int i = 0; i < 1000; i++) {
    result = result + i;
}
```

I am repeatedly creating new String values.

For small operations this may be fine, but for repeated modifications it can become inefficient.

This is where `StringBuilder` becomes useful.

---

# 2. What Is StringBuilder?

`StringBuilder` is a Java class used to create and modify a sequence of characters.

The important difference is:

```text
String
   ↓
Immutable

StringBuilder
   ↓
Mutable
```

**Mutable** means the existing `StringBuilder` object can be modified.

For example:

```java
StringBuilder builder = new StringBuilder("Hello");

builder.append(" World");
```

The builder itself is modified.

---

# 3. String vs StringBuilder

| Feature                      | String                                   | StringBuilder           |
| ---------------------------- | ---------------------------------------- | ----------------------- |
| Mutable                      | No                                       | Yes                     |
| Can modify existing contents | No                                       | Yes                     |
| Repeated modification        | Less suitable                            | Suitable                |
| `append()`                   | Creates new String through concatenation | Modifies builder        |
| `setCharAt()`                | Not available                            | Available               |
| `reverse()`                  | Not directly available                   | Available               |
| Typical DSA use              | Storing text                             | Building/modifying text |

The main idea I should remember is:

```text
String       → "I cannot change myself."

StringBuilder → "I can change my contents."
```

---

# 4. Memory POV

This is the most important part of this lesson for me.

I don't want to only know that StringBuilder is mutable.

I want to understand **what is happening conceptually in memory**.

---

## 4.1 String Memory POV

Suppose I write:

```java
String text = "Hello";
```

Conceptually:

```text
STACK
  │
  │ text
  ▼
String Object
  │
  ▼
"Hello"
```

The String object represents the value `"Hello"`.

Now suppose I write:

```java
text = text + " World";
```

I am not modifying `"Hello"`.

Conceptually:

```text
Before:

text
  │
  ▼
"Hello"
```

After:

```text
text
  │
  ▼
"Hello World"
```

The old `"Hello"` String is not changed.

A new String value is produced.

So repeated modification can result in multiple intermediate String objects.

---

# 5. StringBuilder Memory POV

Now consider:

```java
StringBuilder builder = new StringBuilder("Hello");
```

Conceptually, I can think of memory like this:

```text
STACK
  │
  │ builder
  ▼
StringBuilder Object
  │
  ▼
Internal Character Storage
  │
  ├── H
  ├── e
  ├── l
  ├── l
  └── o
```

The important thing is that the `StringBuilder` object has internal storage where its characters are maintained.

Now I execute:

```java
builder.append(" World");
```

Conceptually:

```text
Before:

builder
   │
   ▼
[ H ][ e ][ l ][ l ][ o ]
```

After:

```text
builder
   │
   ▼
[ H ][ e ][ l ][ l ][ o ][   ][ W ][ o ][ r ][ l ][ d ]
```

The `StringBuilder` is modified instead of creating a completely new String value for every modification.

---

# 6. What Happens When Capacity Is Not Enough?

A `StringBuilder` has an internal **capacity**.

Capacity means approximately:

> How much character storage the builder currently has available before it needs to expand.

For example, conceptually:

```text
Current contents:

[ H ][ e ][ l ][ l ][ o ]

Current capacity:
[ H ][ e ][ l ][ l ][ o ][ ][ ][ ][ ][ ]
```

There is extra space available.

If I append more characters and the current capacity is not enough, the internal storage can be expanded.

Conceptually:

```text
Old storage
     ↓
Not enough space
     ↓
Larger storage created
     ↓
Existing characters copied
     ↓
New characters added
```

The exact capacity-growth implementation is a Java implementation detail, so I don't need to memorize the exact growth formula for DSA.

I only need to understand:

```text
StringBuilder
     ↓
has internal capacity
     ↓
uses that capacity for modifications
     ↓
may expand when required
```

---

# 7. Why StringBuilder Is Efficient for Repeated Modification

Suppose I want to build:

```text
Hello World from Java
```

Using String:

```java
String result = "";

result = result + "Hello";
result = result + " World";
result = result + " from";
result = result + " Java";
```

I repeatedly create new String values.

With StringBuilder:

```java
StringBuilder result = new StringBuilder();

result.append("Hello");
result.append(" World");
result.append(" from");
result.append(" Java");
```

The same mutable builder is used throughout the process.

Mental model:

```text
String:

Old String
    ↓
New String
    ↓
New String
    ↓
New String


StringBuilder:

Same Builder
     ↓
 append()
     ↓
 modify
     ↓
 append()
     ↓
 modify
     ↓
 append()
```

This is why StringBuilder is commonly preferred when I repeatedly build or modify text.

---

# 8. Creating a StringBuilder

I can create an empty StringBuilder:

```java
StringBuilder builder = new StringBuilder();
```

Or initialize it with a String:

```java
StringBuilder builder = new StringBuilder("Hello");
```

---

# 9. append()

`append()` adds data to the end.

```java
StringBuilder builder = new StringBuilder("Hello");

builder.append(" World");

System.out.println(builder);
```

Output:

```text
Hello World
```

Memory idea:

```text
Before:

[ H ][ e ][ l ][ l ][ o ]


append(" World")


After:

[ H ][ e ][ l ][ l ][ o ][ ][ W ][ o ][ r ][ l ][ d ]
```

---

# 10. insert()

`insert()` adds data at a specific index.

```java
StringBuilder builder = new StringBuilder("Hello");

builder.insert(5, " World");

System.out.println(builder);
```

Output:

```text
Hello World
```

If I insert something in the middle, existing characters after that position need to move.

For example:

```text
Before:

H E L L O


insert(1, "i")


Conceptually:

H
↓
H i E L L O
```

So insertion can require shifting characters.

---

# 11. delete()

`delete(start, end)` removes characters from `start` up to, but not including, `end`.

Example:

```java
StringBuilder builder = new StringBuilder("Hello World");

builder.delete(5, 11);

System.out.println(builder);
```

Output:

```text
Hello
```

Important:

```text
delete(start, end)

start → included
end   → excluded
```

This is similar to Java's `substring()` range behavior.

---

# 12. deleteCharAt()

`deleteCharAt()` removes one character.

```java
StringBuilder builder = new StringBuilder("Hello");

builder.deleteCharAt(1);

System.out.println(builder);
```

Output:

```text
Hllo
```

Index:

```text
H e l l o
0 1 2 3 4
```

Index `1` contains `e`.

So after deleting it:

```text
H l l o
```

---

# 13. setCharAt()

`setCharAt()` replaces a character at a specific index.

```java
StringBuilder builder = new StringBuilder("Hello");

builder.setCharAt(0, 'Y');

System.out.println(builder);
```

Output:

```text
Yello
```

Before:

```text
H e l l o
```

After:

```text
Y e l l o
```

The length doesn't change.

---

# 14. reverse()

`reverse()` reverses the contents.

```java
StringBuilder builder = new StringBuilder("Hello");

builder.reverse();

System.out.println(builder);
```

Output:

```text
olleH
```

Before:

```text
H e l l o
```

After:

```text
o l l e H
```

This is particularly useful in DSA problems involving strings and palindromes.

---

# 15. length()

`length()` tells me the number of characters currently stored.

```java
StringBuilder builder = new StringBuilder("Hello");

System.out.println(builder.length());
```

Output:

```text
5
```

If I append something:

```java
builder.append(" World");

System.out.println(builder.length());
```

The length changes because the number of stored characters changed.

---

# 16. capacity()

`capacity()` tells me the current capacity of the builder.

```java
StringBuilder builder = new StringBuilder();

System.out.println(builder.capacity());
```

The exact default capacity is an implementation/API detail I can check in the Java version I am using.

The important distinction is:

```text
length()
   ↓
How many characters I currently have


capacity()
   ↓
How much internal storage is currently available
```

For example:

```text
StringBuilder

Length   → 5
Capacity → more than 5
```

So:

```text
length != capacity
```

---

# 17. toString()

Sometimes I need a normal `String`.

I can convert a StringBuilder using:

```java
String result = builder.toString();
```

Example:

```java
StringBuilder builder = new StringBuilder("Hello");

builder.append(" World");

String result = builder.toString();

System.out.println(result);
```

Output:

```text
Hello World
```

Mental model:

```text
StringBuilder
      ↓
toString()
      ↓
String
```

---

# 18. StringBuilder Inside a Loop

This is one of the most useful DSA applications.

Suppose I want to build a String containing numbers from `1` to `5`.

Instead of:

```java
String result = "";

for (int i = 1; i <= 5; i++) {
    result = result + i;
}
```

I can use:

```java
StringBuilder result = new StringBuilder();

for (int i = 1; i <= 5; i++) {
    result.append(i);
}

System.out.println(result);
```

Output:

```text
12345
```

The pattern I should remember is:

```text
Create Builder
      ↓
Loop
      ↓
append()
      ↓
Modify same builder
      ↓
toString()
```

---

# 19. Dry Run

Consider:

```java
StringBuilder builder = new StringBuilder("ABC");

builder.append("D");
builder.setCharAt(1, 'X');
builder.deleteCharAt(2);
builder.reverse();
```

Let's dry run it.

### Step 1

```java
new StringBuilder("ABC")
```

```text
A B C
```

### Step 2

```java
append("D")
```

```text
A B C D
```

### Step 3

```java
setCharAt(1, 'X')
```

Index `1` contains `B`.

Replace it with `X`.

```text
A X C D
```

### Step 4

```java
deleteCharAt(2)
```

Index `2` contains `C`.

Remove it:

```text
A X D
```

### Step 5

```java
reverse()
```

```text
D X A
```

Final result:

```text
DXA
```

This is the kind of step-by-step modification I should be able to visualize.

---

# 20. Time Complexity

The exact cost can depend on the amount of data affected, but the general DSA view is:

| Operation        | Typical Complexity |
| ---------------- | ------------------ |
| `length()`       | O(1)               |
| `charAt()`       | O(1)               |
| `setCharAt()`    | O(1)               |
| `append()`       | Amortized O(1)     |
| `insert()`       | O(n)               |
| `delete()`       | O(n)               |
| `deleteCharAt()` | O(n)               |
| `reverse()`      | O(n)               |
| `toString()`     | O(n)               |

### Why is append amortized O(1)?

Most of the time, `append()` can place the new characters into available capacity.

But sometimes the capacity isn't enough.

Then:

```text
Current storage
      ↓
Not enough space
      ↓
Expand storage
      ↓
Copy existing characters
      ↓
Append new characters
```

That particular operation can take O(n).

But across many append operations, the average cost is generally considered **amortized O(1)**.

For basic DSA, I mainly need to remember:

```text
append() → amortized O(1)
```

---

# 21. StringBuilder vs StringBuffer

Java also has another class:

```java
StringBuffer
```

Both are mutable character sequences.

The important difference for my current learning is:

```text
StringBuilder
     ↓
Not synchronized
     ↓
Generally preferred for normal DSA / single-threaded code


StringBuffer
     ↓
Synchronized
     ↓
Designed with thread-safety considerations
```

For the DSA problems I am solving, `StringBuilder` is usually the one I will use.

---

# 22. Where Will I Use StringBuilder in DSA?

StringBuilder becomes useful whenever I repeatedly build or modify text.

Common examples:

### Building a String

```java
StringBuilder result = new StringBuilder();

for (char ch : characters) {
    result.append(ch);
}
```

### Reversing a String

```java
String reversed = new StringBuilder(text)
        .reverse()
        .toString();
```

### Constructing an answer

Many DSA problems ask me to construct a result step-by-step.

Instead of repeatedly doing:

```java
result = result + value;
```

I can use:

```java
result.append(value);
```

### Removing or modifying characters

```java
builder.deleteCharAt(index);
builder.setCharAt(index, 'x');
```

### Palindrome-related problems

I can reverse a StringBuilder and compare the result with the original String.

---

# 23. Important Memory Mental Model

I should not think:

```text
StringBuilder = just a String that can change
```

A better mental model is:

```text
String
  │
  ├── Java Object
  ├── Immutable
  └── Modification produces another String value


StringBuilder
  │
  ├── Java Object
  ├── Mutable
  ├── Has internal character storage
  ├── Has capacity
  └── Can modify its contents
```

Conceptually:

```text
                STRINGBUILDER
                     │
                     ▼
              Mutable Object
                     │
                     ▼
           Internal Character Storage
                     │
          ┌──────────┴──────────┐
          ▼                     ▼
      Characters             Capacity
          │                     │
          └──────────┬──────────┘
                     ▼
                Modification
                     │
       ┌─────────────┼─────────────┐
       ▼             ▼             ▼
    append()      insert()      delete()
       │             │             │
       └─────────────┼─────────────┘
                     ▼
              Updated contents
```

---

# 24. Final Mental Model

After this lesson, I should remember:

```text
STRING
  ↓
Immutable
  ↓
Cannot directly modify existing contents
  ↓
Repeated modification can create new String values


STRINGBUILDER
  ↓
Mutable
  ↓
Can modify existing builder
  ↓
Uses internal character storage
  ↓
Has capacity
  ↓
Useful for repeated modifications
  ↓
Very useful in DSA
```

The most important difference:

```text
String
   → immutable

StringBuilder
   → mutable
```

And the most important DSA pattern:

```java
StringBuilder result = new StringBuilder();

for (...) {
    result.append(...);
}

String answer = result.toString();
```

### What I Should Be Able to Explain Now

By the end of this lesson, I should be able to explain:

1. Why StringBuilder exists.
2. Why String is immutable.
3. What mutable means.
4. What happens conceptually in memory when I modify a String.
5. What happens conceptually when I modify a StringBuilder.
6. The difference between length and capacity.
7. How `append()`, `insert()`, `delete()`, `setCharAt()` and `reverse()` work.
8. Why repeated String modification can be inefficient.
9. Why StringBuilder is useful in DSA.
10. Why `append()` is considered amortized O(1).

---

## Connection to the Next Lesson

Now I know how data structures and operations work.

But I need a way to answer an important question:

> **How efficient is my code?**

For example:

```java
for (int i = 0; i < n; i++) {
    System.out.println(i);
}
```

How does the running time change when `n` becomes larger?

That leads to the next topic:

**L06 — Time Complexity**
