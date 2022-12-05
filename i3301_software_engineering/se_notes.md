# Chapter 0: Introduction

- software costs more than hardware
- software maintenance cost more than its development.
- software profits are mainly in maintenance not in development, especially when the customer is locked into our software.
- SE includes methodologies, techniques and tools to develop software.
- software cost is rougly 60% development and 40% testing
- software quality and software cost are inversely proportional

## Definition:

Software engineering is an organized, analytical approach to the design, development, use and maintenance of software.

It includes techqniques to avoid many lethal drawbacks. It provides us with hte flexibility to accomedate for unexpected demands, while avoiding overtime or overbudget.

## Software Products

- Generic
- Customized, accomdiate for special needs with a niche market (embbeded control systems, air traffic control software)

## Software Challenges

- HeterogeneiIssuesty, software is required to be cross-devices or cross-platform.
- Business and social change
- security and trust

## Terminologies & FAQs

- **Software**: a set of linked programs and associated docuemntation.
- **Attributes of good software**: maintainable, dependable and usable.
- **Software engineering**: already defined
- **fundamental activities**: software specification, development, validation and maintenance.
- **CS vs SE**: the first focuses on theory and fundamentals, the second on the practicalities of developing and delivering the software.
- **software engineering vs systems engineering**: the first focuses on software only, the systems take hardware engineering into consideration.
- **software process**: same as software lifecycle.

## Fundamentals Attributes of Good Software
- **Maintablity** (critical)
- **Reliablity**, should cause minimal physical or economical damage in the even of system failure
- **Security**, should prevent malicious users from accessing or damaging the system
- **Efficiency**, shouldn't be wasteful of system resources, includes responsiveness, processing time
- **Acceptability**, target uses should be able to yield the program efficiently

## Application Types:
- **Stand-alone**, runable offline on local computer.
- **Interative Transaction-based**, applications executed on remote computer, and are accessed by the user online. web application belong to this category
- **Embedded Control**
- **Batch/Collection Processing**
- **Entertainment**
- **Modelling and Simulation**
- **Data Collection Systems**
- **Systems of Systems**

## SE Crisis
Software development is a concrete system that implement the idea/requiremnts, and it is a complex one.  
A crisis where software development is sub-performing, mainly caused by:
- High demand on software
- increased software complexity
- lack of funding of SE research

Software development was divided into:
- software used as delievered
- software used after some modification
- software used after heavy modification
- software not delieverd or not used  
From $7M spend on software in 1990 case study, only $2M were spent on useful software.

The issue is to be resolved by using SE or software process, it consist mainly by breaking down the complex system of idea implementation into manageable tasks.

# Chapter 1: 
## Steps in SE
1. Requirements gathering
2.  Hight-level design
3. Low-level design
4. development
5. testing
6. deployment
7. maintenance
8. wrap-up

## Requirements Gathering
In this step we need to find out what the customer want, and what the customer need (since customers might miscommunicate). This step might be time-consuming if the user's need are vague.  
It is very crucial to validate this step to avoid recurring failure in delievery.  
This step include or lead to a feasiblity study.

### Who's the customer
1. Another part of the company, the requirements maybe very clear
2. Myself
3. someone else, where there's only a vague notion of the requirements.  
In any case we should meet the customer as much as possible.

### Requirement Document
It is the output of this stage, it will tell the client what he'll exactly get and thus avoid any misunderstanding, and it'll tell the project members what they'll be building. 

The RD is useful to get budget and schedule estimate, and to identify the milestones of the project.

From this step we need to develop well-defined test case to validate the development process, and the test cases should be developed with collaboration with the client.

The requiremnts are susciptable to change on user demand, as they underestimate the difficulty of implementing the changes, thus the design should be modular.

## High Leve Design
This step includes deciding about:
- platform
- data design
- interface, with other systems

The HLD should specify the project's architecture, and should cover every aspect of the requirements.

### Test Case: OStrich Race Manager
You need to decide about:
1. DB
2. Classes
3. UI
4. external interfaces (like sending e-mails, interact with third-party services)

we might develop during this stage a prototype to further validate the RD.

## Low Level Design
After HLD breaks the project into sub ones, LLD specifies how each subproject should work to the extent enought to guide the developer.

## Development
In addition to implementation, developers should test their software to remove as many bugs as they reasonably can.  
The main challenge of this stage is the integration.

## Testing
This step should be a standalone not a part of the development because self-testing is very hard and inaccurate.  
After we test each program we need to test the intgrability of the whole software.

Bug fixing might cover/create a new bug, due to:
1. incorrect fix
2. breaking another program that depend on the buggy behaviour

The longer the bug is undercover the harder it is to fix it.

## Deployment
This step can be difficult, time-consuming and expensive, as the user might not adopt the newly developed software.

Deployment might involve the following:
1. new servers for back-end and DB
2. new network
3. new computers for the users
4. user training
5. onsite support
6. parallel operations, where the program is adopted partially
7. special data maintenance tasks to synchronise new DB with the old DB
8. massive bug fixing due to their discovery by the users

The end-user should be ready to deal with buggy code, their first impression is very important

## Maintenance
If the application is buggy, you'll need to fix them, otherwise the users will request new features and some enhancements. Our goal for every SE project for the user to request these features and improvements.

## Wrap-up
This step is related to project management, where we benefit from the development experience to imporve furhter projects.

# Chapter 4: Requirements Engineering

## Defintion
RE is the set of activities concerned with identifying and communicating the purpose of a software-intensive system, and the context in which it will be used. Hence, RE acts as the bridge between the real world needs of users, customers, and other constituencies afforded by a software system and cpabiliites and popportunities by software-intensive technologies.  
**software intensive system** it is the collection of software, targeted hardware, and the business context it'll be used in.

## Phases of RE
1. Elicitation (Gathering)
2. Analysis
3. Specification
4. Validation
5. Management

These phases form an infinite cycle.

## Software Quality
A software is evaluated on two scales:
1. functionality  
    How good is the software at performing what is does
2. purpose  
    How much is the software serving the clients using it

## Requirement Classifications 
### Audience-Oriented Requirements
1. Business requirements  
    What's the overall purpose of the software
2. User requirements
    What exact functionalities are expected by the software users.
3. System/Implementation requirements  
    What's the hardware required to run the system, training material required to be developed.
    
**Progress of requirements** we start with business ones, move to user requiremnts and end with system requiremnts.


### Other Requirements
1. Functional Requirements  
    services the application should do
2. Non-functional requirements  
    - performance
    - reliability
    - security

We must assure that the requirements are testable. (elvator example)

## Requiremnts Properties
1. clear
2. unambiguous
3. consistent
4. prioritized
4. verifiable
4. prcisely defined and limited (use moscow method).
4. completeness
4. pertinece

### The mosow method
- M must
- S should 
- C could
- W won't