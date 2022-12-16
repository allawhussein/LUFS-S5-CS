# Chapter 0: Revision

Why use DB & DBMS? mainly because of concurrency implementation compared to XML or spreadsheets.

What is the process of creating DB? usually we as students jump into the tables design (relational data model) or even SQL setup queries, however this approch is highly unreliable as it'll result in a lot of back and forth.  
Professionally we shoul start with requirements identification, then ER diagram (or any other diagram, which all are part of UML - unified modeling language).

In the ER model entities are called relations, entities' connections are called relationships, the entities attributes are called metadata as they're not part of the actual data but cruial to be able to process it. relationship cardinality (one-to-one, one-to-many, ...) can be applied through constraints.

In the third step of creating DB we develop RDM (relational data model) or schema is developed. In the fourth step SQL (or others) queries are developed to serve the initial requirements, like providing the user with the average of each student while only their individual marks are saved.

Views are virtual tables that help optimize performance by caching needed data, and optimize storage by storing the least amount of data.

## SQL Operations
- `JOIN`  
and operation that joins two tables, based on a common column, data rows from both tables that have the same value in this common column are kept, all others are discarded.
- `SELECT`  
the projection operator, which selects what attributes are to be kept in the view or table.

## Syllabus:
- Setup privileges
- setup user groups
- how to assign users to each group
- How to define these privileges on views
- indexing (binary trees)
- transaction's implementation (how to protect from data loss/corruption)
- procedural language
- db triggers

# Chapter 1: Introduction
Content:
1. Purpose of DB System
2. View of Data
3. Data Models
4. DDL
1. DML
1. Transaction Managemetn
1. Storage management
1. DB Adminstrator
1. DB Users
1. Overall System Structure

## Purpose DB System
The purpose of any system (Information system, data system, ...) is to take the correct decision at the correct time. The purpose is answered by satisfying the system requirements delivered by clients, for example a user might request an inventory manager, that's the requirement, but what is the purpose? it is to avoid stock shortage, or delays in delivery. This concept is very important to avoid the fate of others who developed very expensive softwares that have no use.

### DBMS
- a collection of interrelated data
- set of programs to access data
- provides information about a particular enterprise
- have an easy and efficient environement

### purpose
replace drawbacks of file systems, which are:
- data redeundancy adn inconsistency  
multiple file formats, duplication of information
- difficulty in accessing data  
the need to write a new program for every task
- data isolation  
- integrity problems  
missing integrity constraints, or having difficulty in adding/updating them.
- atomicty of updates  
partial updates might be present
- concurrence access of data  
managed concurrent control have a performance penalty, unmangged control lead to inconsistency.

## View of Data
### Levels of Data Abstraction
view level > logical level > physical level  
- physical level describes how a record is stored.  
- logical level describes data stored in db, and relationships among hte data.  
- view level where application hides details of data types, and can also hide some data, or customize their display.

### Instances and schemas
Schema is the sturcture design of the database. There's physical schema and logical schema.  
Physical data independence is the ability to modify the physical schema without changing the logical one.  
Instance the actual content of the database at a particular point in time.

## Data Models
A collection of tools for dscribing:
- data
- data relationships
- data sematics
- data constraints

Examples:
- Entity-relationship model  
It is the representation of the environment we wish to store and manager, through identifying objects and determing what data should be stored for each object.
- relational model  
It is a tabular represetation of an ERD diagram in a lower level (more understandable by a machine).
- object-oriented model
- semi structure data model  
example: XML, a fully structured data model is ERD and RM where unlike XML they specify relation between entities, XML only specifies attributes for every model.
- network model  
relation is modeled in a graph-like structure
- hierarchical model

It is very dangerous to have a mistake in data models, error removing can be very costly.
## DDL
```SQL
CREATE TABLE account(
            account_number CHAR(10),
            balance INTEGER)
```
## DML
Also known as query language, used for accessing and manipulating the data orgainized by the appropriate data model.  
There's two classes of languages:
- Procedural, command driven (like C, COBOL, Pascal)  
The user specifies what data he wants, and how to get it.
- Non-procedural, functional drivern (like SQL, PROLOG, LISP)  
The user only specifies the data he wants, without specifing how to get those data.  
SQL is the most used query language.

### SQL
```sql
# find the name of customer with customer_id 5680
SELECT cutomer.cutomer_name
FROM customer
WHERE cutomer.customer_id = "5680"

# find the balance of all accounts held by the customer with cutomer_id 5680
SELECT account.balance
FROM depositor, account
WHERE depositor.cusotomer_id="5680"
    AND depositor.account_number = account.account_number.
```

## DB Users
They are differntiated by ther way they expect to interact with the system:
1. application programmers  
interact with the system through DML calls (my thought they are either developers integrating DB into their software, or DB adminstrator).
2. sophisticated users  
form requests in a database query (my thought clients, they request a specific view of data, that isn't available directly from the DBMS).
3. specialized user  
write specialized database application that do not fit into the traditional data processing framework.
4. naive users  
invoke one of the permanent application programs that have been written previously (end-user of an application that abstracts the DB).

## DB Adminstrator
A person who cooridnates all the activities of the database system, who also have good understanding of the enterprise's information resourcs and needs.
### DBA duties
1. schema definition
2. storage structure and access method definition
3. schema and physical organization modification
4. granting user authority to access the database
4. specfiying integrity constraints
4. acting as a link with users (when an application asks you to revise your adminstrator)
4. monitoring performace and respoding to change in requirements.

## Transaction Management

It is a colleciton of operations that performs a single logical function in a database application, if any operation fails, the whole transaction should be canceled and reversed.  
Transaction-management componenet ensures that the database remains in a consistent state despite system failures and transaction failures.

Concurrency-control manager controls the interaction among the concurrent transation to ensure the consistency of the database.

## Storage management

Storage manager is a prgram module that provides the interface between the low-level data store in the databse and the application porgrams and queries submitted to the system.

### responsibilites
- interation with the file manager
- efficient storeing, retriveng and updating of data.

## Overall System Structure
!!!!!!!!!!!!!!!!!!!!!!!! paste an image of R-DBMS internals diagram.
### application architectures
1. two tier, user <-> app <-> db
2. three tier, like web apps user <-> frontend <-> backend <-> db

# Chapter 2: Relational Model

## Structure of Relational Database

essentially a revesion of SQL from DB1.

## Database Implementation - Case Study of University Library

Consider a typical university library to borrow books, the database-application of the librasry consider inforamtionabout books, studens, teachers, authors, pulubisher and about borrowing opeartions.  
The manager of the libarry enforce that the student wil not be allowed to borrow more than three books simultaneously.

### Database Design

check the ppt

### DDL

```SQL
CREATE TABLE Books(
    bookID CHAR(10) NOT NULL,
    publisher CHAR(10) NOT NULL,
    title CHAR(30) NOT NULL,
    PRIMARY KEY (bookID)
)
```