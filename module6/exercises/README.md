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
- The API should be functional with **GET, POST, PUT, PATCH, and DELETE** routes.
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

In this exercise, you will extend the REST API developed in **Hands-On Exercise 1** that manages **customer data**,
by converting it into a **web application** with frontend to perform **CRUD (Create, Read, Update, Delete) operations**.


Before starting: 
* Copy the project folder from the GitHub lecture repository (Hands-on Exercise 1 - module6/exercises/exercise1) to your computer.
* Make sure the RESTful service  is running on your computer.

Modify the service by following the instructions below. 

Use the frontend developed in Module 6, Section 5, 'Converting a Simple RESTful API into a Web Application,' 
as the foundation.


**Use **Java Script fetch()** to handle the API interactions.**


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



## **Task 3: Test and Verify**
- Open the web pages and check if the data loads correctly.
- Perform add and delete operations.
- Verify the API responses to ensure proper functionality.
- Test the API using cURL or http client.

### **Additional Challenges (Optional)**

- Add search and update functions for the developed application.








