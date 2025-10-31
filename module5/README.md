# Module 5: Database Management Systems (DBMS)

<!-- TOC -->
* [Module 5: Database Management Systems (DBMS)](#module-5-database-management-systems-dbms)
  * [Introduction to Database Management Systems](#introduction-to-database-management-systems)
  * [Database System](#database-system)
  * [Essential Features of a Database Management System (DBMS)](#essential-features-of-a-database-management-system-dbms)
  * [Database Development Lifecycle](#database-development-lifecycle)
    * [1. Requirement Analysis](#1-requirement-analysis)
    * [2. Design](#2-design)
    * [3. Implementation](#3-implementation)
    * [4. Maintenance](#4-maintenance)
    * [Business Rules](#business-rules)
    * [Data Model: Entity–Relationship (ER) Model](#data-model-entityrelationship-er-model)
    * [Advantages of Data Modeling](#advantages-of-data-modeling)
    * [The Data Modeling Process](#the-data-modeling-process)
    * [Key Components of a Data Model](#key-components-of-a-data-model)
  * [Relational Databases and Basic SQL](#relational-databases-and-basic-sql)
    * [**Setting Up the Working Environment**](#setting-up-the-working-environment)
      * [**Installing PostgreSQL**](#installing-postgresql)
      * [**Installing pgAdmin**](#installing-pgadmin)
      * [**Importing and Exporting Sample Databases**](#importing-and-exporting-sample-databases)
    * [Basic SQL](#basic-sql)
      * [CREATE DATABASE](#create-database)
      * [CREATE TABLE](#create-table)
      * [SELECT](#select)
      * [INSERT INTO](#insert-into)
      * [**UPDATE**](#update)
      * [**DELETE**](#delete)
  * [Using a Programming Language to Interact With a Database](#using-a-programming-language-to-interact-with-a-database)
    * [Database Drivers – Core Functions](#database-drivers--core-functions)
    * [Database Operations with Java and PostgreSQL](#database-operations-with-java-and-postgresql)
    * [Example Workflow (Conceptual)](#example-workflow-conceptual)
  * [Hands-on Exercise 1](#hands-on-exercise-1)
  * [NoSQL Databases](#nosql-databases)
  * [Hands-on Exercise 2](#hands-on-exercise-2)
<!-- TOC -->




## Introduction to Database Management Systems
- A **database** is a collection of related data designed for efficient storage, retrieval, management, and manipulation.
- A **Database Management System (DBMS)** is specialized software that controls and manages databases and 
provides interfaces for database clients to store, retrieve, and manipulate data efficiently.


## Database System
A **Database System** consists of three main parts:
- **Database** = Raw Data + Metadata (used to define relationships and data characteristics, forming the logical 
structure of the database).
- **DBMS (Database Management System)** 
- **Database clients** = Application software or database client tools that interact with the DBMS.

<img src="../resources/db-integration.png" width="400" alt="Database System">


## Essential Features of a Database Management System (DBMS)

- **Data Integration**:  
  Efficiently manages and organizes data to avoid unnecessary duplication.  
  *Relational DBMSs* enforce structured relationships, while *NoSQL systems* focus on flexible data organization.

- **Data Integrity**:  
  Ensures data remains accurate and consistent.  
  *Relational DBMSs* enforce integrity through schemas and constraints (e.g., primary and foreign keys),  
  whereas *NoSQL systems* often relax these rules to achieve higher performance and scalability.

- **Data Security**:  
  Protects data from unauthorized access, system failures, and attacks.  
  Both SQL and NoSQL systems implement authentication, authorization, and backup mechanisms, though methods differ.

- **Data Abstraction**:  
  Provides a logical view of data, hiding the complexity of storage structures.  
  *Relational DBMSs* use tables, while *NoSQL systems* use alternative models like key-value pairs, documents, or graphs.


## Database Development Lifecycle

The **Database Development Lifecycle** is a structured process used to design and build high-quality databases in a 
systematic and efficient way. It breaks database development into distinct phases, each with specific goals and 
deliverables. 

The Database Development Lifecycle typically consists of four fundamental phases.


### 1. Requirement Analysis
- Identify and document **business needs**, **processes**, and **data requirements**.
- Define **business rules** that govern how data should be used and constrained.

**Roles Involved:** Business Analysts, Project Managers, Stakeholders/Clients  
**Output:** Requirements Specification Document



### 2. Design
- Develop the **data model** to represent entities, attributes, and relationships (ER Diagram).
- Convert the conceptual model into a **logical schema** with **tables, columns, primary/foreign keys, and constraints**.
- Ensure that the design supports business rules, normalization, and integrity requirements.

**Roles Involved:** Data Architects, Database Designers, Data Modelers  
**Output:** Database Design Document (ER Diagram + Logical Schema)



### 3. Implementation
- Build and configure the database using **DBMS tools and SQL (or NoSQL commands)**.
- Populate the database with initial data and test for **structural integrity and performance**.

**Roles Involved:** Database Developers, Database Administrators (DBAs)  
**Output:** Operational Database



### 4. Maintenance
- Monitor database performance and ensure **availability, security, and reliability**.
- Apply **updates, optimizations, and patches** as needed.
- Handle **data backup, recovery, and tuning** tasks over time.

**Roles Involved:** Database Administrators (DBAs), System Administrators  
**Output:** Stable, Optimized, and Secure Database System


![Database System](../resources/db-development-lifecycle.png)



### Business Rules

Business rules can be seen as a summarized version of the requirements list, focusing on data.
**Business rules** summarize and formalize the data-related aspects of business requirements.  
They are **statements that define or constrain** how a business operates, guiding how data is structured and
managed within a database.

**Sources of Business Rules**

- **End users**
- **Managers and policymakers**
- **Written documentation** such as standards, regulations, and procedures

Directly consulting **end users** is often the most effective approach, as it provides practical insights into real-world data needs.

**Examples of Business Rules**

- An employee can belong to only one department.
- A customer must provide a valid email.
- A student can enroll in many courses, and a course can have many students.
- An order must include at least one product.
- A customer can place multiple orders, but each order is placed by only one customer.

Business rules help identify **entities, attributes, relationships, and constraints** when developing the **Entity-Relationship (ER) model**.  
Once these rules are defined, the next step is to **model the database** to implement them effectively.




### Data Model: Entity–Relationship (ER) Model

A **data model** is a conceptual tool used to represent complex real-world data structures in a simplified, often **graphical**, form.

### Advantages of Data Modeling
1. **Improved Communication**
  - Facilitates clear communication between database designers, application developers, and end users.
  - Ensures everyone understands and agrees on the database structure **before implementation**.

2. **Simplified Implementation**
  - Provides a **blueprint** for database design, making development and configuration more straightforward.

### The Data Modeling Process
Data modeling is an **iterative** process:
1. A **basic model** is designed first.
2. **Details** are gradually added.
3. The model evolves into a **complete blueprint** for database design.

### Key Components of a Data Model

![ER Model](../resources/ER-diagram.png)

- **Entities** – Represent real-world objects about which data is collected (e.g., `Student`, `Course`, `Employee`).
- **Attributes** – Describe properties or characteristics of entities (e.g., `Name`, `ProductCode`, `UnitPrice`).
- **Relationships** – Define associations between entities. Common types include:
  - **One-to-Many (1:M)**
  - **Many-to-Many (M:N)**
  - **One-to-One (1:1)**
- **Constraints** – Define rules that preserve data accuracy and consistency, for example:
  - An employee’s age must be between 18 and 65.
  - A phone number must follow the format `(XXX) XXX-XXXX`.
  - Each email address must be unique in the system.

> **In summary:**  
> Business rules drive the data model, and the ER model visualizes these rules to form the logical structure of the database.


## Relational Databases and Basic SQL
- **Relational Database**: Organizes data into **tables** (rows = records, columns = attributes).
- Relationships established using **keys**:
  - **Primary Key** → unique identifier of a row.
  - **Foreign Key** → links rows between tables.
- **SQL (Structured Query Language)** is the standard language for relational databases.



### **Setting Up the Working Environment**

To work with SQL databases efficiently, a proper working environment is required.

#### **Installing PostgreSQL**
PostgreSQL is an open-source and powerful relational database management system.
- **Download Link**: [Download PostgreSQL](https://www.postgresql.org/download)
- Supports Windows, macOS, and Linux.
- Complies with SQL standards and offers extensive plugin support.

#### **Installing pgAdmin**
pgAdmin is the most commonly used graphical management tool for PostgreSQL.
- It is distributed along with PostgreSQL.
- Provides a user-friendly interface for managing databases, executing queries, and visualizing schemas.

#### **Importing and Exporting Sample Databases**

* **Northwind Sample Database**
  - A well-known example database that simulates a trading company's operations.
  - Can be imported using **pgAdmin**.
  - [Download](../resources/dbs/northwind.backup)


### Basic SQL


| Command             | Description                             |
|---------------------|-----------------------------------------|
| **CREATE DATABASE** | Constructs a new database.              |
| **CREATE TABLE**    | Defines a new table.                    |
| **SELECT**          | Retrieves data from one or more tables. |
| **INSERT**          | Adds new data into a table.             |
| **UPDATE**          | Modifies existing records in a table.   |
| **DELETE**          | Removes specific records from a table.  |


#### CREATE DATABASE

Constructs a new database.

```sql
CREATE DATABASE "ShoppingApplicationDB"
```

#### CREATE TABLE

Defines a new table.

```sql
CREATE TABLE "Products" (  
    "productID" SERIAL,
    "code" CHAR(6) NOT NULL,
    "name" VARCHAR(40) NOT NULL,
    "date" DATE DEFAULT '2019-01-01',
    "unitPrice" MONEY,
    "quantity" SMALLINT DEFAULT 0,
    CONSTRAINT "productsPK" PRIMARY KEY("productID"),
    CONSTRAINT "productsUnique" UNIQUE("code"),
    CONSTRAINT "productsCheck" CHECK("quantity" >= 0)
);

```
#### SELECT

Retrieves data from one or more tables.

```sql
SELECT * FROM "customers" WHERE "Country"='Spain' OR "Country"='Türkiye'
ORDER BY "CustomerID";
```


**INNER JOIN**
Returns only the records that have matching values in both tables.
- Only products with a valid `CategoryID` in the **Categories** table are included.
- Any product with a `NULL` `CategoryID` is excluded.

```sql
SELECT Products.ProductID, Products.ProductName, Categories.CategoryName
FROM Products
INNER JOIN Categories ON Products.CategoryID = Categories.CategoryID;
```

#### INSERT INTO

Add new records to a table.
- **Data integrity constraints** are enforced during the insertion process.
- It is possible to insert values into only specific columns.
- Columns that are not explicitly assigned a value will be set to **NULL** (empty).

```sql
INSERT INTO "customers" 
("CustomerID", "CompanyName", "ContactName", "Address", "City", "Country") 
VALUES ('X1', 'ABC', 'Jane', 'Address1', 'Astana', 'Kazakhstan');
```


#### **UPDATE**

The **UPDATE** statement is used to modify existing records in a table.
- **Data integrity constraints** are enforced during the update process.
- The `WHERE` clause is used to specify which records should be updated.
- If the `WHERE` clause is **not** included, **all rows** in the table are updated.


```sql
UPDATE "customers"
SET "ContactName" = 'Jane Lee',
    "City" = 'Astana'
WHERE "CustomerID" = '1';

```

#### **DELETE**

The **DELETE** statement is used to remove one or more records from a table.
- **Data integrity constraints** are enforced during the deletion process.
- The `WHERE` clause specifies which records should be deleted.
- If the `WHERE` clause is **not** included, **all records** in the table are deleted.


```sql
DELETE FROM "customers"
WHERE "CustomerID" = '1';
```


## Using a Programming Language to Interact With a Database

Modern applications often need to store, retrieve, and manipulate data dynamically.  
To perform such database operations from within an application, **database drivers** are essential.  
These drivers facilitate communication between the **programming language** and the **database system**.

### Database Drivers – Core Functions
Database drivers typically provide the following core capabilities:
- **Establishing a connection** to the database.
- **Executing queries** (e.g., `SELECT`, `INSERT`, `UPDATE`, `DELETE`).
- **Retrieving results** and processing query outputs.
- **Managing transactions** to ensure data consistency.
- **Closing the connection** after operations are completed.


### Database Operations with Java and PostgreSQL

Java applications can seamlessly interact with PostgreSQL databases using **JDBC** (Java Database Connectivity).  
JDBC is a **standard API** that defines a set of interfaces and classes for connecting to relational databases, 
sending SQL statements, and processing results.

It provides:
- **Connection management**
- **Statement execution**
- **Result retrieval**
- **Error handling and transaction control**

The **PostgreSQL JDBC driver** implements this API and allows Java programs to work directly with PostgreSQL databases.

You can download the PostgreSQL JDBC driver from:  
 [https://jdbc.postgresql.org/download/](https://jdbc.postgresql.org/download/)


### Example Workflow (Conceptual)
1. **Load the driver**(library or JAR file) in the project environment so that the Java application can 
communicate with the database.
2. **Establish a connection** to the PostgreSQL database using a connection string (URL(socket address), username, and password).
3. **Define and execute SQL statements**.
4. **Process the results** returned by the query.
5. **Close** the statement and connection to free resources.


***The Repository Pattern abstracts the logic of data access and storage from the business logic of an application.
It provides a clean separation between the domain layer and the data access layer.
Repositories act as mediators between the business logic and the data source (e.g., database, API, or file).
This abstraction improves maintainability, testability, and supports dependency inversion.***


**Code Example**

```sql
CREATE DATABASE ecommercedb;
```

```sql
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    price DOUBLE PRECISION CHECK (price >= 0)
);
```


![DB Class Diagram](../resources/db-class-diagram.png)

>[ProductRepositoryMain.java](./repository/ProductRepositoryMain.java) | [IProductRepository.java](./repository/IProductRepository.java) | [ClientService.java](./repository/ClientService.java) | [Product.java](./repository/Product.java) | [ProductPostgresqlImplementation.java](./repository/ProductPostgresqlImplementation.java) | [ProductMongodbImplementation.java](./repository/ProductMongodbImplementation.java)


***
## Hands-on Exercise 1
1. Define the `ecommercedb` database and `products` table in `PostgreSQL`.
2. Run the program given above that performs operations on the  PostgreSQL database (Check the db connection parameters).
3. Define `findByName(String name)` and `findByPrice(double price)` methods and modify main method to test them.
***



## NoSQL Databases
- **NoSQL** = “Not Only SQL”, designed for scalability and flexibility.
- Useful for large-scale, unstructured, or rapidly changing data.
- Types of NoSQL databases:
  - **Document-based** (e.g., MongoDB)
  - **Key-Value Stores** (e.g., Redis)
  - **Column Stores** (e.g., Cassandra)
  - **Graph Databases** (e.g., Neo4j)
- Comparison with Relational DB:
  - Relational → structured, schema-based, strong consistency.
  - NoSQL → flexible schema, horizontal scaling, often eventual consistency.


**Code Example**

![DB Class Diagram](../resources/db-class-diagram.png)

>[ProductRepositoryMain.java](./repository/ProductRepositoryMain.java) | [IProductRepository.java](./repository/IProductRepository.java) | [ClientService.java](./repository/ClientService.java) | [Product.java](./repository/Product.java) | [ProductPostgresqlImplementation.java](./repository/ProductPostgresqlImplementation.java) | [ProductMongodbImplementation.java](./repository/ProductMongodbImplementation.java)




***
## Hands-on Exercise 2
1. Construct MongoDB database `ecommercedb` and define collection `products` with the following structure:

```json
{"id":{"$numberInt":"3581"},"name":"Laptop","price":{"$numberDouble":"1500.0"}}
```
2. Run the program given above that performs operations on the  MongoDB database.
3. Define `findByName(String name)` and `findByPrice(double price)` methods and modify main method to test them.
***
