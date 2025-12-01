# Hands-on Exercise 1 : In-Memory REST API Development in Node.js

##  Objective
In this exercise, students will develop a **RESTful API** in **Node.js** using **Express.js** and an
**in-memory database** for managing customer data.

## Tasks

### **Setup a Basic Express Server**
- Initialize a new **Node.js project**.
- Install **Express.js**.
- Set up a basic Express server.

### **Define an In-Memory Database**
- Instead of using a database, store customer data in a **JavaScript array**.
- Each customer should have:
    - `id` (integer)
    - `name` (string)
    - `email` (string)
    - `phone` (string)
    - `city` (string)

### **Implement API Endpoints**
Develop the following RESTful routes:

#### **GET /api/customers**
- Return the list of all customers.

#### **GET /api/customers/:id**
- Retrieve a specific customer by ID.
- If the ID is not found, return a **404 error**.

#### **POST /api/customers**
- Accept a **JSON request body** with customer details.
- Add the new customer to the in-memory array.
- Respond with the added customer.

#### **PUT /api/customers/:id**
- Update an existing customer by ID.
- Only modify the provided fields.
- If the ID is not found, return a **404 error**.

#### **DELETE /api/customers/:id**
- Remove a customer by ID.
- Respond with a success message.

### **Test API Using cURL or IntelliJ http client**
- Use **cURL commands** and **IntelliJ http client** to test each endpoint.
- Verify that customer data updates correctly.

## **Completion Criteria**
- The API should be functional with **GET, POST, PUT, and DELETE** routes.
- The in-memory database should correctly store and modify customer data.
- API should handle errors properly.


### **Additional Challenges (Optional)**
These tasks are for students to implement at home:

- Try using Postman or Insomnia API clients for testing APIs, as it provides an intuitive interface for making HTTP requests and analyzing responses.
- Add validation for **email format** and **phone number** before adding a customer.
- Implement a **search feature** (`GET /api/customers?city=Astana`) to filter customers by city.

---



# **Hands-On Exercise 2: Extending REST API to a Web Application**

## **Objective**
In this exercise, you will extend the REST API developed in **Hands-On Exercise 1**, which manages **customer data**,
by developing a **web application** with **jQuery-based web pages** to perform **CRUD (Create, Read, Update, Delete) operations**.

Each customer should have:
- `id` (integer)
- `name` (string)
- `email` (string)
- `phone` (string)
- `city` (string)


**Use **jQuery AJAX** to handle the API interactions.**


## **Task 1: Develop the Customer List Page**
This page displays all customers and allows users to **delete a customer**.

### **Steps**
- Retrieve the customer list from the REST API using an asynchronous request.
- Display the customers in a structured format.
- Provide a delete option for each customer, allowing users to remove them.

---

## **Task 2: Implement Add Customer Page**
This page contains a **form to add a new customer**.

### **Steps**
- Capture user input for customer details.
- Send the input data to the REST API.
- Ensure the customer is added and update the displayed list accordingly.

---

## **Task 3: Implement Delete Customer Page**

---


## **Task 5: Test and Verify**
- Open the web pages and check if the data loads correctly.
- Perform add and delete operations.
- Verify the API responses to ensure proper functionality.
- Test the API using cURL or http client.







# **Hands-on Exercise 3**

Add search and update functions for the developed app in Exercise 2.



# **Hands-on Exercise 4:  REST API Development With Database Support**

Integrate PostgreSQL into the application developed in hands-on exercise 3.

You are required to initialize a new database and define the regarding table.

```sql
CREATE DATABASE customerdb;

CREATE TABLE customers (
  id SERIAL PRIMARY KEY,
  name VARCHAR(100),
  email VARCHAR(100),
  phone VARCHAR(30),
  city VARCHAR(50)
);
```

