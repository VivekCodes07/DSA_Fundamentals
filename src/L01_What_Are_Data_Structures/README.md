# L01 — What Are Data Structures?

## What Am I Going to Study in This Lesson?

In this lesson, I am going to understand the basic idea behind **Data Structures** and why they are important in programming.

I will study:

* What is data?
* What is a Data Structure?
* Why do we need Data Structures?
* How Data Structures organize and store data
* Different types of Data Structures
* Linear vs Non-Linear Data Structures
* How choosing the right Data Structure affects a program
* The basic relationship between **Data Structures and Algorithms**

The goal is not to memorize definitions. I want to understand **why Data Structures exist and what problem they solve**.

---

# 1. What is Data?

Before understanding Data Structures, I need to understand what **data** actually means.

Data is simply information that a program needs to store and work with.

For example:

```text
Student Name → Vivek
Age → 20
Marks → 85
Roll Number → 101
```

In Java, I can store individual pieces of data like:

```java
String name = "Vivek";
int age = 20;
int marks = 85;
```

But what happens when I have **1000 students**?

Creating separate variables for everything would become difficult to manage.

This is where Data Structures become important.

---

# 2. What is a Data Structure?

A **Data Structure** is a way of organizing and storing data so that I can use and manipulate that data efficiently.

Simple definition:

> A Data Structure is a way to organize and store data so that operations on that data can be performed efficiently.

For example, if I have:

```text
10 20 30 40 50
```

I can store these values in an array:

```java
int[] numbers = {10, 20, 30, 40, 50};
```

The array gives me a structured way to store and access these values.

So:

```text
Data
 ↓
Need to organize it
 ↓
Data Structure
 ↓
Perform operations efficiently
```

---

# 3. Why Do I Need Data Structures?

Suppose I have 1,000,000 student records.

I may need to:

* Add a student
* Delete a student
* Search for a student
* Update marks
* Sort students
* Find the highest marks
* Access a particular student

If I simply throw all the data somewhere without thinking about how it is organized, these operations can become slow or difficult.

The Data Structure I choose can make a huge difference.

For example:

```text
Problem: Store students and access them by index
        ↓
Array can be useful

Problem: Frequently add/remove elements
        ↓
Linked List may be useful

Problem: Last item should be processed first
        ↓
Stack

Problem: First item should be processed first
        ↓
Queue
```

So I should not think:

> "Which Data Structure do I know?"

I should think:

> "What problem am I trying to solve, and which Data Structure fits that problem?"

---

# 4. Data Structure = Organization of Data

I can think of a Data Structure like an organization system.

Imagine I have 100 books.

If I throw them randomly on the floor:

```text
Book
     Book
Book       Book
   Book
       Book
```

Finding a particular book can be difficult.

But if I organize them properly:

```text
Shelf 1 → Programming
Shelf 2 → Mathematics
Shelf 3 → Science
Shelf 4 → History
```

Now finding and managing books becomes easier.

Data Structures do something similar with data.

They provide a structure in which data can be stored and accessed.

---

# 5. Common Data Structures

Some Data Structures that I will study are:

```text
Data Structures
│
├── Array
├── Linked List
├── Stack
├── Queue
├── Tree
└── Graph
```

Each structure organizes data differently.

For example:

### Array

```text
Index:   0    1    2    3    4
        ┌───┬───┬───┬───┬───┐
Data:   │10 │20 │30 │40 │50 │
        └───┴───┴───┴───┴───┘
```

### Stack

```text
       ┌─────┐
       │ 30  │ ← TOP
       ├─────┤
       │ 20  │
       ├─────┤
       │ 10  │
       └─────┘

Last In → First Out
```

### Queue

```text
Front                         Rear
  ↓                             ↓
┌─────┬─────┬─────┬─────┐
│ 10  │ 20  │ 30  │ 40  │
└─────┴─────┴─────┴─────┘

First In → First Out
```

Different problems require different structures.

---

# 6. Types of Data Structures

At a high level, I can divide Data Structures into two major categories:

```text
Data Structures
│
├── Linear
│
└── Non-Linear
```

## Linear Data Structures

In a linear Data Structure, elements are arranged in a sequential manner.

Examples:

```text
Array
Linked List
Stack
Queue
```

Example:

```text
10 → 20 → 30 → 40 → 50
```

The elements follow a linear sequence.

---

## Non-Linear Data Structures

In a non-linear Data Structure, data is not organized in a single sequential line.

Examples:

```text
Tree
Graph
```

A tree can look like:

```text
        10
       /  \
      20   30
     / \
    40  50
```

Here, one element can connect to multiple elements.

---

# 7. Data Structure vs Data Type

These two concepts are related but different.

A **Data Type** tells Java what kind of value I am storing.

Examples:

```java
int age = 20;
double price = 99.99;
char grade = 'A';
String name = "Vivek";
```

A **Data Structure** tells me how multiple pieces of data are organized and managed.

Example:

```java
int[] marks = {85, 90, 78, 92, 88};
```

Here:

```text
int       → Data Type
int[]     → Data Structure
```

The array is organizing multiple integer values.

---

# 8. Data Structures and Algorithms

Data Structures and Algorithms are closely connected.

A **Data Structure** is mainly concerned with:

> How should I organize and store the data?

An **Algorithm** is mainly concerned with:

> How should I solve a problem using that data?

For example:

```text
Data:
10 20 30 40 50

Data Structure:
Array

Problem:
Find 40

Algorithm:
Searching
```

So I can think of it as:

```text
Data
 ↓
Data Structure
 ↓
Algorithm
 ↓
Result
```

Both work together.

---

# 9. Choosing the Right Data Structure

There is no single Data Structure that is best for every problem.

Suppose I need to store 100 student marks and frequently access them using their index.

An array could be a suitable choice:

```java
int[] marks = {85, 90, 78, 92, 88};

System.out.println(marks[2]);
```

Output:

```text
78
```

But if my problem requires a **Last In, First Out** behavior, an array by itself does not represent that behavior directly.

A Stack is designed for that:

```text
10
20
30 ← remove this first
```

Therefore:

```text
Problem
   ↓
Required operations
   ↓
Choose suitable Data Structure
   ↓
Choose suitable Algorithm
```

This is one of the most important ideas I need to remember.

---

# 10. Real-World Examples

I can connect Data Structures with things I already use.

### Stack

Browser back history:

```text
Google
 ↓
YouTube
 ↓
GitHub
```

If I press Back, the most recently visited page is handled first.

This follows:

```text
LIFO
Last In → First Out
```

---

### Queue

People waiting in a line:

```text
Person A → Person B → Person C → Person D
   ↑
First
```

Usually, the person who arrives first is served first.

This follows:

```text
FIFO
First In → First Out
```

---

### Tree

A file system can be represented hierarchically:

```text
Computer
│
├── Documents
│   ├── Resume
│   └── Assignment
│
├── Pictures
│   ├── Photo1
│   └── Photo2
│
└── Videos
```

This is a hierarchical structure, which is why trees are useful for representing such relationships.

---

# 11. The Main Idea I Need to Remember

I should not learn Data Structures as a list of definitions.

Instead, I should ask:

```text
What data do I have?
        ↓
What operations do I need?
        ↓
How should the data be organized?
        ↓
Which Data Structure fits?
        ↓
Which Algorithm can solve the problem efficiently?
```

That is the foundation of DSA.

---

# 12. Connection to the Next Lessons

Now that I understand what Data Structures are, the next question is:

> "How do I describe the operations that a Data Structure should support without worrying about its implementation?"

That leads to:

```text
L01 — What Are Data Structures?
                ↓
L02 — Abstract Data Types
                ↓
L03 — Arrays
                ↓
L04 — Time Complexity
                ↓
Searching & Sorting
```

So **Abstract Data Types (ADT)** will build on what I learned here.

---

# Final Mental Model

```text
DATA
 ↓
Need to organize data
 ↓
DATA STRUCTURE
 ↓
Need to perform operations
 ↓
ALGORITHM
 ↓
Efficient solution
```

The most important thing I learned in this lesson:

> **Data Structures are ways of organizing and storing data so that I can efficiently perform the operations I need.**

And the real DSA skill is not just knowing different Data Structures.

It is knowing **when and why to use them**.
