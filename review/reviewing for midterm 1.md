---
aliases: "202402191112"
tags: 
date: 2024-02-19
created: 2024-02-19T11:12
updated: 2024-02-19T11:12
---
# [[reviewing for midterm 1]]

> [!todo]+ possible topics to review
> - [x] big o (very vaguely understand)
> - [x] linked list
> - [x] restricted strucrtures
> - [x] exceptions
> - [ ] recursion (still having a bit of trouble on this but it's fine)

___
### exceptions
#### class hierarchy
![[codingwithjohn_java-exception-class-hierarchy.png|500]]
#### types
##### unchecked: error at runtime
- error when **running** program; won't give error when *compiled*
	- can still use **try-catch** block if you want program to *run properly*
- all inherit `RuntimeException`
##### checked: error at compile time
- java makes you deal with at **compile time** - won't compile until then
	- either:
		- surround with **try-catch** block
		- add to method(s) signature
#### creating custom exceptions
- after class name
	- `extends Exception` - checked exception
	- `extends RuntimeException` - unchecked exception

### restricted structures
- restricted bc there are *limitations* imposed on their operations
	- stacks: lifo (last in first out)
	- queue: fifo (first in first out)

### linked lists
#### types
##### singly: reference to next node
##### doubly: reference to next node AND previous node

### big o
#### fastest to slowest:
1. O(1) - Constant time complexity.
2. O(log n) - Logarithmic time complexity.
3. O(n) - Linear time complexity.
4. O(n log n) - Linearithmic time complexity.
5. O(n^2) - Quadratic time complexity.
6. O(n^3) - Cubic time complexity.
7. O(2^n) - Exponential time complexity.
8. O(n!) - Factorial time complexity.
___
# references
- [Checked vs. Unchecked Exceptions in Java Tutorial - What's The Difference? (youtube.com)](https://www.youtube.com/watch?v=bCPClyGsVhc&t=1s)
- [Checked vs Unchecked Exceptions in Java - GeeksforGeeks](https://www.geeksforgeeks.org/checked-vs-unchecked-exceptions-in-java/)