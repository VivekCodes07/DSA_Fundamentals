# L02 — Abstract Data Types (ADT)

## What Am I Going to Study in This Lesson?

In this lesson, I am going to understand **Abstract Data Types (ADT)** and how they are different from actual Data Structures.

I will study:

* What is an Abstract Data Type?
* Why do I need ADTs?
* ADT vs Data Structure
* What does "abstract" mean here?
* Operations of an ADT
* How the same ADT can have different implementations
* Examples of ADTs
* How ADTs connect with Java interfaces and classes
* Why separating **what to do** from **how to do it** is useful

The main goal of this lesson is to understand this idea:

> **ADT tells me what operations are possible, while the Data Structure tells me how those operations are implemented.**

---

# 1. First, What Does "Abstract" Mean?

Before understanding ADT, I need to understand the word **abstract**.

When something is abstract, I focus on the important behavior and hide the unnecessary implementation details.

For example, when I use:

```java
System.out.println("Hello");
```

I know that it prints something on the screen.

But I don't need to know exactly how Java internally communicates with the operating system, manages the output stream, or sends characters to the console.

I only care about:

```text
I give it data
      ↓
It prints the data
```

The implementation details are hidden from me.

This same idea is used in an **Abstract Data Type**.

---

# 2. What is an Abstract Data Type?

An **Abstract Data Type (ADT)** is a logical description of a data structure.

It defines:

* What data can be stored
* What operations can be performed
* What those operations are supposed to do

But it does **not** specify exactly how those operations are implemented.

Simple way to remember:

```text
ADT
 ↓
WHAT can I do?

Data Structure
 ↓
HOW is it implemented?
```

For example, consider a Stack.

A Stack may define operations such as:

```text
push()
pop()
peek()
isEmpty()
```

The Stack ADT tells me that these operations should exist and what they should do.

It doesn't necessarily tell me whether I should implement the Stack using:

```text
Array
```

or:

```text
Linked List
```

That implementation decision comes later.

---

# 3. ADT vs Data Structure

This is the most important concept in this lesson.

Suppose I say:

> "I need a Stack."

I am talking about the **behavior** I want.

A Stack follows:

```text
LIFO
Last In → First Out
```

And supports operations such as:

```text
push()
pop()
peek()
```

This is the **Stack ADT**.

Now I need to actually build it.

I could use:

```text
Stack ADT
    ↓
 ┌───────────────┐
 │               │
Array       Linked List
 │               │
Implementation   Implementation
```

Both implementations can follow the same Stack behavior.

So:

```text
ADT = WHAT

Data Structure = HOW
```

---

# 4. Example: Stack ADT

Let's understand this with a simple example.

Imagine I have:

```text
10
20
30
```

The Stack follows LIFO.

Therefore:

```text
push(10)
push(20)
push(30)
```

gives:

```text
30 ← TOP
20
10
```

Now:

```text
pop()
```

should remove:

```text
30
```

The Stack ADT defines this behavior.

It doesn't matter whether internally I used an array or linked list.

---

# 5. What Does the Stack ADT Define?

The Stack ADT can define operations like:

### push()

Adds an element to the top.

```text
Before:

20
10

push(30)

After:

30
20
10
```

---

### pop()

Removes the top element.

```text
Before:

30
20
10

pop()

After:

20
10
```

The removed value is:

```text
30
```

---

### peek()

Returns the top element without removing it.

```text
30 ← TOP
20
10
```

After:

```text
peek()
```

the Stack is still:

```text
30
20
10
```

---

### isEmpty()

Checks whether the Stack contains any elements.

```text
Stack = [10, 20, 30]

isEmpty()
↓
false
```

If:

```text
Stack = []
```

then:

```text
isEmpty()
↓
true
```

These operations describe the **behavior of the Stack ADT**.

---

# 6. How Can the Same ADT Have Different Implementations?

This is where ADTs become really useful.

Suppose I want to implement a Stack.

### Implementation 1 — Using Array

I could store the values in an array:

```text
Index:  0    1    2
       ┌────┬────┬────┐
       │ 10 │ 20 │ 30 │
       └────┴────┴────┘
                    ↑
                   TOP
```

---

### Implementation 2 — Using Linked List

I could instead use nodes:

```text
TOP
 ↓
30 → 20 → 10 → null
```

Both implementations behave like a Stack.

Therefore:

```text
             Stack ADT
                 │
        ┌────────┴────────┐
        ↓                 ↓
      Array          Linked List
   implementation   implementation
```

The user of the Stack doesn't necessarily need to care about the internal implementation.

---

# 7. Java Example

Java gives me a good example of this separation.

I can use the `Stack` class:

```java
import java.util.Stack;

public class StackExample {

    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack);

        System.out.println(stack.pop());

        System.out.println(stack.peek());
    }
}
```

I don't need to manually manage the internal array or nodes just to use the Stack.

I simply use its operations.

```text
push()
pop()
peek()
```

The implementation details are hidden behind the class.

---

# 8. ADT and Java Interfaces

An important connection I can make with Java is the **interface**.

An interface can describe what operations a class should provide without specifying the complete implementation.

For example:

```java
interface Stack {

    void push(int value);

    int pop();

    int peek();

    boolean isEmpty();
}
```

This tells me:

```text
A Stack should have:

push()
pop()
peek()
isEmpty()
```

But the interface doesn't tell me exactly how these methods will work internally.

I could then create an implementation using an array:

```java
class ArrayStack implements Stack {

    // Array-based implementation
}
```

Or another implementation:

```java
class LinkedStack implements Stack {

    // Linked-list-based implementation
}
```

Conceptually:

```text
          Stack ADT
              │
              │
       ┌──────┴──────┐
       ↓             ↓
 ArrayStack      LinkedStack
       ↓             ↓
    Array          Linked List
```

This is the same **WHAT vs HOW** idea.

---

# 9. Another Example — Queue

The same concept applies to a Queue.

A Queue follows:

```text
FIFO
First In → First Out
```

Its ADT can define operations such as:

```text
enqueue()
dequeue()
front()
isEmpty()
```

The Queue could then be implemented using:

```text
Array
```

or:

```text
Linked List
```

So:

```text
Queue ADT
    ↓
Defines behavior
    ↓
enqueue()
dequeue()
front()
isEmpty()
    ↓
Can have multiple implementations
```

---

# 10. ADT vs Data Structure — Simple Comparison

| Abstract Data Type                    | Data Structure             |
| ------------------------------------- | -------------------------- |
| Defines what operations are available | Defines how data is stored |
| Describes behavior                    | Describes implementation   |
| Focuses on what                       | Focuses on how             |
| Implementation independent            | Actual implementation      |
| Example: Stack ADT                    | Array-based Stack          |
| Example: Queue ADT                    | Linked-list Queue          |

The easiest way to remember it:

```text
ADT
↓
WHAT

Data Structure
↓
HOW
```

---

# 11. Real-World Example

Think about a **car**.

When I drive a car, I know that I can:

```text
start()
accelerate()
brake()
turn()
```

I don't need to know exactly how the engine internally converts fuel or electrical energy into motion every time I press the accelerator.

I interact with the available operations.

Similarly, with an ADT:

```text
User
 ↓
Operations
 ↓
ADT
 ↓
Hidden implementation
```

The important thing is the behavior exposed to the user.

---

# 12. Why Are ADTs Useful?

ADT gives me **separation of concerns**.

I can think about:

```text
WHAT should this structure do?
```

without immediately worrying about:

```text
HOW should I implement it?
```

This makes programs easier to:

* Design
* Understand
* Modify
* Maintain
* Reuse

For example, suppose my Stack is currently implemented using an array.

Later I realize that a Linked List would be more suitable.

If the external behavior remains the same:

```text
push()
pop()
peek()
isEmpty()
```

I can change the internal implementation without changing the basic idea of how the Stack is used.

---

# 13. ADT Is Not the Actual Data Structure

I need to be careful about this.

I should not think:

```text
Stack = Array
```

That is not necessarily true.

Instead:

```text
Stack ADT
   ↓
Can be implemented using
   ↓
Array
OR
Linked List
```

Similarly:

```text
Queue ADT
   ↓
Can be implemented using
   ↓
Array
OR
Linked List
```

The ADT describes the **behavior**, while the implementation provides the actual mechanism.

---

# 14. The Important Separation

I can visualize the entire concept like this:

```text
                PROBLEM
                   ↓
          What behavior do I need?
                   ↓
                  ADT
                   ↓
          What operations exist?
                   ↓
        ┌──────────┴──────────┐
        ↓                     ↓
      Array              Linked List
        ↓                     ↓
   Implementation         Implementation
```

The ADT acts like a contract.

It says:

> "These are the operations I provide and this is how they should behave."

The implementation decides:

> "This is how I will make those operations actually work."

---

# 15. What I Should Remember

The most important distinction from this lesson is:

```text
Abstract Data Type
        ↓
     WHAT?
        ↓
What operations and behavior should exist?

Data Structure
        ↓
      HOW?
        ↓
How will the data and operations actually be implemented?
```

For example:

```text
Stack ADT
    ↓
push()
pop()
peek()
isEmpty()
    ↓
Can be implemented using
    ↓
Array / Linked List
```

---

# Connection to the Next Lesson

Now I understand:

```text
L01
What are Data Structures?
        ↓
L02
What is an Abstract Data Type?
        ↓
L03
Arrays
```

In the next lesson, I will study **Arrays** in detail.

This is important because arrays are one of the simplest and most fundamental ways of organizing data, and I will also use arrays later to understand searching, sorting, stacks, queues, and other structures.

---

# Final Mental Model

```text
ADT = WHAT

Data Structure = HOW
```

Or even simpler:

> **An ADT defines what I can do with a data type, while the Data Structure defines how those operations are implemented.**
