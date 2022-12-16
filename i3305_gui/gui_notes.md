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
It is implemented by the `new` keyword or by redefinitons (overriding).  
The child class can override the parent's methods.

### Polymorphism
polymorphism means "many forms", and occurs when we have amny classes that are related to each other by inheritance.

suppose there's a parent class shape, and two children circle and triangle. The following is allowed
```java
Shape a = new Shape();
Shape b = new Circle();
Shape c = new Rectangle();
```
we can say that class circle is a class shape also, and circle can invoke any method in shape's class.  
b can only access attributes defined in shape class.

**when is polymorphism useful?**   
suppose for example we have a student management software, where a student is undergraduate or gradute.  
if some operation is required to be performed on all students we need to manage two arrays for graduate and undergradute students, however with the use of polymorphism we can use a single array for all students.
```java
Person[] people = new Person[4];
people[0] = new Person("Hussein", "Allaw");
people[1] = new Student("Ali", "Hussein", 5481);
people[2] = new Undergraduate("Ibrahim", "El Darsa", 6010, 1);
```

## Java Casting
It is a way of converting data from one data type to another.  
There is two tpes of casting, upcasting and down casting, the later won't be discussed.
upcasting example: `Shape a = new Circle();`  
downcasting example: `Circle b = new Shape();`  
Upcasting is casting an object from a subclass to superclass.

```java
Animal animal = new Animal();
Cat cat = new Cat();

animal = cat; // implicit way of casting
animal = (Animal) cat; // explicit way of upcasting

// OR

Animal animal = new Cat();
```
### Overriding
replacing an inherited method with another having the same signature that allows us to make tchange in the method definition for the derived classes.  
We use it to define a child's own definition of some common method between parent and child, to unify the behaviour.

## Abstract Class vs. Interface
check Jana's notes.
why interface is used instead of abstract class? first due to multiple inheritance, second.

when to use abstract class?  
when there's a  relation between the target class.

When to use interface?  
when the to-be created classes have some similarties but no relation between them.

## Overriding Prerquisites
the method must have the same name as none mentioned in the parent class.  
the method must have the same parameter as one mentioned in the parent class.  
there must be a Is-A relation ship.

the main advantatge is that a class can give its own implementation of inherited methods.

## Dynamic Binding
an inheritance relation and in the presence of polymorhpism, the type of binding will affect the call of methods.

the sub class can override a method m of the parent class with different behaviour.

a reference r of the super class can designate an ojbect of the subclass and r can be used to call m.

If the binding is dynamic is used the methods are related to the class associated with the new keyword, otherwise we have a static binding.

Java by default applies dynamic binding (binding is resolved at run time), C++ by default applies static binding(binding is resovled at compile time). Also in java a bind can be specified to be static.

## Overloading
to or more methods with different signatures, to be achieved static binding/compile-time binding/early binding may be used.
on compile time, the compiler checks the types of the parameters passed to a method to decide which method having the given name should be invoked.

# Chapter 2: Creational Design Patterns

## Definition of Pattern

1. Each pattern describe a problem which happen over and over again in our environment.  
The same problem might occur accorss many softwares, example the ability to modify/maintain the software.

2. Then describe the core of the solution.  
should we find a pattern for every problem we encounter? No, to have a design pattern, we need a pattern and criteria, specific problems can't be generalized and solved through design patterns.  
3. This description is in such way that can be implemented over and over again.  
The nice thing about the solution provided by the design pattern's solution is the reusability as a template, all implementations have the same core, but none the same exact way.

The need for design patterns first arose in the civil engineering field, especially that civil are susceptible to problem of repeated problems.  
When orgainizing the program, it is useful to understand the wasy that people have orgainized in the past (legacy or recent code).

We can think of design patters as a toolbox, some problems have very standard tools to deal with.  
However note that we should recognize the situation we wish to integrate the design pattern into.

In a nutshell, a design pattern is a general repeatable solution to a commonly ocuring problem in the design of boject-oriented applications. For example the "visitor" pattern will permit us to define a new operation without changing the classes of the element on which it operates.  
Design patterns are independent of programming languages used. Whenever there's some OOP, design patterns are possible.

## Representation and Types
### essential elements:
1. Name
2. Problem
3. Solution  
describes the elements that make up the design, their relationships, responsiblities and collaborations (UML).

In total there's 23 design patterns.
### Types of Design Patterns
1. **Creational**  
These design patterns provides a way to create objects while hiding the creation logic.  
It like ordering a pizza, we order a one then recieve it without knowing how it was prepared.  
This approach gives us more flexibility in deciding which objects need to be created for a given use case.  
Why? if a user initiated the object, and change will affect the user, otherwise any modification will be possible without the client's notice.
2. **Structural**  
    - Deal with decoupling interaface and implementation of classes and objects.
    - Composition of class or objects.  
    We'll see in this classification how we separate between layers, between the abstraction layer and the inner layers.  
3. **Behavioral**  
    - Deal with dynamic interactions among societies of classes and objects
    - How they distribute responsibility

## Design Pattern Catalog
1. Creational Pattern: concern the process of object creation
    - Factory Method
    - Builder
    - Singleton
2. Structural Pattern: deal with composition of classes or objects
    - Flyweight
    - Bridge
    - Adapter (new)
    - Composite
    - Proxy
    - Facade (new)
3. Behavioral Patterns: characterize the ways in which classes or objects interact and distribute responsibility.
    - Visitor
    - Observer MVC
    - Strategy
    - Iterator

## Factory Method

In this design pattern a "factory" will take care of object creation and delievery to client.

If we have a super class and n sub-classes, and based on input paramters, we have to return the object o one of the sub-classes.

We refer to newly created objects using a common interface.

So instead of having object creation code on client side, we encapsulate inside a "factory method".  
The `new` operator is considered harmful (inside the clients code, insider the `main()` function).

### Problem
a framework needs to standardize the architectural model for a range of applications, but allow for individual applications to define theri own domain objects and providde for their instantiation.

Imagine that you're creating a simulator to represent a bicycle race, a race consists of many bikes (i.e. bicycle for **normal** race, **road** bicycle for the tour de France and **Mountain** bicycle for cyclecorss race).  
From this example it is clear that we have superclass bicycle, and 3 subclasses.  
Race > Product > road or mountain.  

### Bad Solution
Our naive appraoch is to loop over races and using three if statements create the appropriate bicycle.

```java
public class Race {
    List<Bicycle> bikes;

    public void createRace(String type){
        if (type.equlas("normal")){
            for (int i = 0; i < n; i++)
                bikes.add(new Bicyle());
        }
        if (type.equlas("tourdefrance")){
            for (int i = 0; i < n; i++)
                bikes.add(new Bicyle());
        }
        if (type.equlas("mountain")){
            for (int i = 0; i < n; i++)
                bikes.add(new Bicyle());
        }
    }
}
```
Possible problems:
1. what if we needed to add new race bikes?
2. if an update is needed we might need to modify an existing structure, we prefer adding new classes, rather than modifying existing ones.

### Good Solution
The factory pattern suggest that you replace direct object construction calls (using the new operator) with calls to a special factory method.


```java
public abstract class RAce{
    List<Bicycle> bikes;

    //factory method
    abstract Bicyle create Bicycle();

    public void createRace(){
        for (int i = 0; i < n; i++){
            bikes.add(createBicycle());
        }
        ...
    }
}

public class CycleCross extends Race {
    @override
    Bicycle createBicycle() {
        return new MountainBicycle();
    }
}

public class NormalRace extends Race {
    @override
    Bicycle createBicycle() {
        return new Bicycle();
    }
}

public class TourDeFrance extends Race {
    @override
    Bicycle createBicycle() {
        return new RoadBicycle();
    }
}

public class Application {
    public void main(){
        Race race = new TourDeFrance();
        // polymorphism is used here if call the createRace(), the tourdefrance constructor will be launched thanks to dynamic binding.
    }
}
```

### Factory Method Structure


## Builder



## Singleton