# Chapter 1: Introduction

## Course Overview
This course is composed of two parts:  
1. Design Patterns (66%)  
a. OOP  
b. Design Patterns
2. Java Front-end (35%)  
a. JavaFX 8
b. JavaFX Scene Builder

There's a special attention paid to MVC concept (some consider it a design patterns, other an architecture).  

This course contains a project providing 25% of the overall grade.  
The course's assisted by a google classroom.

There's criteria for any software developement, one of them is the modularity to facilitate the software's maintenance.

## Modularity

The degree to which a system's componenets may be separated and recombined. The concept is applicable to both hardware and software.

### Modularity in Programming and Design

It is breaking down a complex system in to smaller parts of componenets. First we split according to the three-tier architecture (MVC) or according to OOP.

### Goals of Modularity
provide the following:  
1. develop extendable, readable, reliable, reusable, maintainable components
2. facilitate problem understanding by dividing it
3. facilitate testing and debugging
4. facilitate software upgradability
5. facilitate team work

### Importance of Modularity
1. avoid cost overruns
1. prevent project stall if some problem is encountered
1. being flexible with user requirements change (most significant).
1. being flexible with system change.

### How to Identify Modular Code
any piece of code can be considered a module. for OOP programming language a module is a class, in non-OOP programming languages, a function is a module.

### How to start architecting modules
1. what exact piece should be the module (the class).
2. How do modules share information
3. what should the module know about other modules or the rest of the systems
4. How is control orgainzed in the system.

### Properties of Good Module
1. Incapsulate one system task or function (shrink the module as much as possible).
2. relieble
3. testable
4. hides design decision of the system
5. can be modified internally without affecting the rest of the system

### Criteria of Modular Architecture
1. decomposiblity
2. composability
3. understandablility  
    How can each module be understandable without knoweledge of other modules
3. countinuity   
Any small change should tirgger the change of only one module
4. protection  
any runtime error should confined to the module producing it only.
5. Information Hiding  
    the primary goal is to prevent extensive modification to clients whenever the implementation details of a module or program are changed (like the client shouldn't ideally change anything on his/her side or the clients shouldn't).
5. Uniform access  
    not allowing the user to access object's data to avoid random data modification, the concept is enforced by using getters and setters methods.
6. Open-Closed prinicple  
    a module is said to be so, if it is extensible but immutable (unmodifiable).  
    In classes parent is closed on modification, and children are open for modification thus they achieve parent extension.

## Object Oriented
the concept of class combines:
- data type (attributes)
- set of operations applicable onto the data type. 

A class is the fundamental element:
- that allows you to build sofware modules  
- a sufficient set of usable types in the language.

A class doesn't exist in memory at runtime, only its instances. The class is the source code written by the software.

### Top-Down Approach (Functional Decomposition)
This approach was the dominant one before OOP, the idea is to decompose the problem into sub-problems, and divide the sub-problems into smaller sub ones.  

Problems:
- there's a cycle in this decomposition, when feature can't be separated absolutely.
- in real projects the top-down approach might lead to not very resuable decomposed modules.

These problems lead to the down-top approach which is OOP, which as stated earlier offer exendiblity and resuability.

### OOP Issues
1. How to find the relevant object types (How big or how small the class is in terms of encapsulated data?)  
    This problem may be solved by many approaches  
    1. encapsulate data that have some similar types or structure
    2. expertise in OOP
    3. use a ready library (that might be outdated or insufficient to solve the problem)
2. How to describe the realtions between object types? possibly by:
    1. Inhertance

### Coordinate System Example
This example is used to better explain some OOP concepts. There are two major representation, cartesian and polar.
```java
class Point {
    double x, y;

    double rho() {
        return Math.sqrt(x * x + y * y);
    }

    double theta(){
        return Math.atan(y / x);
    }
}
```

```java
Point p;
p = new Point();
p.x = 3.14;
p.y = 42.0;

System.out.println("Rho: " + p.rho());
System.out.println("Theta: " + p.theta());
```

### Object
An instance of the class, created by an operator or a special function of the language

### Overloading
It allows different methods to have the same name bu tdifferent signature where the signature can differ by the number of inout parameter or type of input pararmter or both. The use of overloading might dictate the use of the `this` keyword to distinguish between local and non-local variables.

### Constructor
It is a special method used to initialize the object, it is called upon object creation. In java the constructor should:
- have no return type
- have the same name of the class.
- called implicitly by the `new` keyword or explicitly by the `this` keyword
- even when no class is defined by the user, there's an empty consturctor that is implicitly created.

### Criteria Compliance
This class doesn't comply with the criteria of modularity, the internal data are accessible by the user, and the user is forced to access them, a possible problem is implemntation design, the class might treat `x` and `y` as cartesian paramters and the user might treat them as cartesian.

If implementation hiding is applied, the user will submit the point in whatever format he wants, and we're then free to implement the point in any format we want.

A better example is:
```java
class Point {
    double x, y;

    double x() {
        return x;
    }

    double y() {
        return y;
    }

    double rho() {
        return Math.sqrt(x * x + y * y);
    }

    double theta(){
        return Math.atan(y / x);
    }

    double setX(double x){
        this.x = x;
    }

    double setY(double y){
        this.y = y;
    }

    double setPolar(double theta, double rho){

    }
}
```
### Access Levels
Modifier|Class|Package|SubClass|World
---|---|---|---|---
public|y|y|y|y|
protected|y|y|y|n|
modifier|y|y|n|n|
private|y|n|n|n|

### Inheritance
Java only allows single inheritance unlike C++. Java implements the interface to compensate for the abscense of multiple inheritance.

### Polymorphism
suppose there's a parent class shape, and two children circle and triangle. The following is allowed
```java
Shape a = new Shape();
Shape a = new Circle();
Shape a = new Rectangle();
```
This polymorphism can also be called upcasting.
