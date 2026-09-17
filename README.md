# DSA Fundamentals

This repository is where I am learning and building my **Data Structures and Algorithms fundamentals using Java**.

I am following **Telusko's Data Structures and Algorithms course** as my primary learning resource and organizing the concepts into my own lesson-wise notes and Java implementations.

I am using this repository to understand DSA from the ground up — not just memorizing algorithms, but understanding **why they work, how they work internally, and when to use them**.

The main goal is to build a strong foundation that I can later use for **problem solving, coding interviews, competitive programming, and real-world software development**.

---

## Course I Am Following

**Course:** Data Structures and Algorithms
**Instructor:** Telusko
**Language:** Java

I am following the course step-by-step while creating my own:

* Notes
* Java implementations
* Dry runs
* Complexity analysis
* Internal working explanations

The course provides the learning path, while this repository is where I **practice, organize, and document what I learn**.

---

## What Am I Learning?

I am following a step-by-step approach where I first understand the concept and then implement it in Java.

My learning flow is:

```text
Concept
   ↓
Why do I need it?
   ↓
How does it work?
   ↓
Internal Working
   ↓
Java Implementation
   ↓
Dry Run
   ↓
Time & Space Complexity
   ↓
Connect it with the next concept
```

This helps me understand the logic behind the code instead of simply copying an implementation.

---

## Repository Structure

I am organizing the repository lesson-wise so that I can easily track my progress.

```text
DSA_Fundamentals/
│
├── src/
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

The structure may change as I continue learning and add more DSA topics.

---

## Current Progress

### src

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
Array:

[10] [20] [30] [40] [50]
  0    1    2    3    4
```

I also learned that array indexing provides direct access to an element.

Conceptually:

```text
Address = Base Address + (Index × Element Size)
```

This is why accessing an array element by index is **O(1)**.

In Java, the JVM manages the actual memory, so I use this formula as a conceptual model for understanding how indexed access works.

---

## Java

I am implementing the DSA concepts in **Java**.

For example:

```java
int[] numbers = {10, 20, 30, 40, 50};

System.out.println(numbers[2]);
```

Output:

```text
30
```

The goal is not only to know the Java syntax, but to understand what happens behind the code.

---

## My Approach to DSA

While learning each topic, I focus on these questions:

### 1. Why does this data structure or algorithm exist?

I want to understand the problem it solves before learning the implementation.

### 2. How does it work?

I break the concept into smaller steps.

### 3. What happens internally?

I try to understand things like:

* Memory
* Indexing
* References
* Traversal
* Recursion
* Comparisons
* Swapping
* Data movement

### 4. What is the complexity?

For each important operation or algorithm, I want to understand:

```text
Time Complexity
Space Complexity
```

### 5. When should I use it?

Knowing an algorithm is not enough. I also want to understand where it makes sense and what alternatives exist.

---

## The Bigger Goal

I am learning DSA as a foundation for becoming a better problem solver and software developer.

My long-term learning path looks something like:

```text
DSA Fundamentals
       ↓
Problem Solving
       ↓
More Data Structures
       ↓
Algorithms
       ↓
LeetCode / Coding Problems
       ↓
Interview Preparation
       ↓
Strong Problem-Solving Skills
```

At the same time, I am continuing my backend development journey, so I want to understand where these DSA concepts can actually become useful in software development.

---

## Important Rule for Myself

> **Don't just memorize the code. Understand why the code works.**

If I can explain an algorithm without looking at the code, dry-run it on paper, understand its complexity, and then implement it myself in Java, I consider that concept properly learned.

---

## Tech Used

* **Course:** Telusko — Data Structures and Algorithms
* **Language:** Java
* **IDE:** IntelliJ IDEA
* **Version Control:** Git & GitHub

---

## Progress

This repository will keep evolving as I continue learning.

Each lesson is a small step toward building a stronger understanding of **Data Structures, Algorithms, and problem solving**.

```text
Learn → Understand → Implement → Dry Run → Analyze → Repeat
```

This is my **DSA Fundamentals journey**.
