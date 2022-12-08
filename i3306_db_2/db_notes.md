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

# Chapter 1: DB Privileges Management
