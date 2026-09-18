# DSA Fundamentals

This repository is where I am learning and building my **Data Structures and Algorithms fundamentals using Java**.

I am following **Telusko's Data Structures and Algorithms course** as my primary course and studying the concepts **consecutively with ChatGPT** to understand them in more depth.

I am not using this repository just to store code. I am using it to document what I learn, understand the reasoning behind each concept, and build my DSA foundation step by step.

My main focus is to understand **why something works before learning how to implement it**.

---

## My Learning Resources

### 1. Telusko

I am following Telusko's Data Structures and Algorithms course as my main learning path.

**Course:** Data Structures and Algorithms
**Instructor:** Telusko
**Language:** Java

[Telusko — Data Structures and Algorithms](https://youtu.be/4_HOnhB64Dg?si=njfYZ-fBYVCi5eov)

### 2. ChatGPT

Alongside the course, I am **consecutively studying each topic with ChatGPT**.

I use ChatGPT to:

* Understand concepts in simpler terms
* Learn the internal working
* Understand the WHY before the HOW
* Break difficult concepts into smaller parts
* Dry-run algorithms
* Understand time and space complexity
* Connect one topic with another
* Clear doubts while learning
* Write and understand Java implementations
* Review my understanding before moving forward

The idea is not to replace the course, but to use both together so that I can **learn the concept and understand it deeply**.

---

## My Learning Flow

For every topic, I try to follow this process:

```text
Telusko Course
      ↓
Understand the Basic Concept
      ↓
Study the Concept with ChatGPT
      ↓
Understand WHY
      ↓
Understand HOW
      ↓
Learn Internal Working
      ↓
Implement in Java
      ↓
Dry Run
      ↓
Analyze Time & Space Complexity
      ↓
Move to the Next Concept
```

This helps me avoid simply memorizing code.

---

## What Am I Learning?

I am learning DSA from the fundamentals and gradually moving toward more advanced concepts.

The main things I focus on are:

* Data Structures
* Abstract Data Types
* Arrays
* Searching
* Sorting
* Recursion
* Divide and Conquer
* Linked Lists
* Stacks
* Queues
* Trees
* Binary Search Trees
* Algorithms
* Time Complexity
* Space Complexity
* Problem Solving

The roadmap may evolve as I continue learning.

---

## Repository Structure

I am organizing the repository lesson-wise so that I can easily track my progress.

```text
DSA_Fundamentals/
│
├── J01_DataStructures/
│   ├── L01_What_Are_Data_Structures/
│   ├── L02_Abstract_Data_Types/
│   ├── L03_Arrays/
│   ├── L04_Time_Complexity/
│   ├── L05_Searching/
│   ├── L06_Bubble_Sort/
│   ├── L07_Selection_Sort/
│   ├── L08_Insertion_Sort/
│   ├── L09_Quick_Sort/
│   ├── L10_Divide_And_Conquer/
│   ├── L11_Trees_Introduction/
│   ├── L12_Recursion/
│   ├── L13_Merge_Sort/
│   ├── L14_LinkedList/
│   ├── L15_Stack/
│   ├── L16_Queue/
│   ├── L17_Circular_Queue/
│   ├── L18_Tree_Data_Structure/
│   ├── L19_Binary_Search_Tree/
│   └── L20_Tree_Implementation/
│
└── README.md
```

The structure may change as I continue learning and add more topics.

---

## Current Progress

### J01 — Data Structures

* [x] L01 — What Are Data Structures?
* [x] L02 — Abstract Data Types
* [x] L03 — Arrays
* [ ] L04 — Time Complexity
* [ ] L05 — Searching
* [ ] L06 — Bubble Sort
* [ ] L07 — Selection Sort
* [ ] L08 — Insertion Sort
* [ ] L09 — Quick Sort
* [ ] L10 — Divide and Conquer
* [ ] L11 — Trees Introduction
* [ ] L12 — Recursion
* [ ] L13 — Merge Sort
* [ ] L14 — Linked List
* [ ] L15 — Stack
* [ ] L16 — Queue
* [ ] L17 — Circular Queue
* [ ] L18 — Tree Data Structure
* [ ] L19 — Binary Search Tree
* [ ] L20 — Tree Implementation

---

## What I Have Learned So Far

### Data Structures

I learned what data structures are and why choosing the right way to organize data matters.

```text
Data
 ↓
Organize it efficiently
 ↓
Data Structure
 ↓
Perform operations efficiently
```

### Abstract Data Types

I learned the difference between **what a data structure should do** and **how it actually does it**.

```text
ADT
 ↓
WHAT operations are available?

Data Structure
 ↓
HOW are those operations implemented?
```

### Arrays

I learned how arrays store elements of the same type and how elements are accessed using indexes.

```text
[10] [20] [30] [40] [50]
  0    1    2    3    4
```

I also learned the conceptual relationship between an array's index and its memory location:

```text
Address = Base Address + (Index × Element Size)
```

This helps explain why accessing an array element using its index is **O(1)**.

In Java, the JVM manages the actual memory, so I use this as a conceptual memory model rather than accessing raw addresses directly.

---

## Java

I am implementing the concepts I learn using **Java**.

For example:

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[2]);
```

Output:

```text
30
```

The goal is not just to write Java code that works.

I want to understand **what happens when the code runs** and why the implementation has the complexity it does.

---

## How I Study Each Lesson

For every lesson, I try to answer these questions:

### Why?

Why does this data structure or algorithm exist?

### What?

What problem does it solve?

### How?

How does it actually work?

### Internally?

What happens in memory or during execution?

### Complexity?

What are its:

```text
Time Complexity
Space Complexity
```

### When?

When should I use it, and what are the alternatives?

---

## The Bigger Goal

I am learning DSA to build a strong foundation for:

```text
DSA Fundamentals
       ↓
Problem Solving
       ↓
Coding Problems
       ↓
LeetCode
       ↓
Interview Preparation
       ↓
Strong Problem-Solving Skills
```

I also want to understand how these fundamentals connect with the software development concepts I am learning alongside DSA.

---

## Important Rule for Myself

> **Don't just memorize the code. Understand why the code works.**

If I can explain a concept, understand its internal working, dry-run the algorithm, analyze its complexity, and implement it myself in Java, then I consider that concept properly learned.

---

## Tech Used

* **Course:** Telusko — Data Structures and Algorithms
* **Additional Learning:** ChatGPT
* **Language:** Java
* **IDE:** IntelliJ IDEA
* **Version Control:** Git & GitHub

---

## Progress

This repository will keep evolving as I continue learning.

Every lesson is another step toward becoming better at **Data Structures, Algorithms, and problem solving**.

```text
Learn
  ↓
Understand
  ↓
Implement
  ↓
Dry Run
  ↓
Analyze
  ↓
Practice
  ↓
Repeat
```

This is my **DSA Fundamentals journey**.
