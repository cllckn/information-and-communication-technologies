# Module 6: Web Applications, Web Services, and Basic User Interaction

<!-- TOC -->
* [Module 6: Web Applications, Web Services, and Basic User Interaction](#module-6-web-applications-web-services-and-basic-user-interaction)
  * [1. Fundamentals Of Web Applications And Web Services](#1-fundamentals-of-web-applications-and-web-services)
    * [1.1 Client Server Architecture](#11-client-server-architecture)
    * [1.2 Three-tier Web Architecture](#12-three-tier-web-architecture)
    * [1.3 UML Deployment Diagram](#13-uml-deployment-diagram)
    * [1.4 Web Application Architecture - Synchronous Communication](#14-web-application-architecture---synchronous-communication)
    * [1.5 Web Application Architecture - Asynchronous Communication](#15-web-application-architecture---asynchronous-communication)
    * [1.6 Scalable Web Application Architecture](#16-scalable-web-application-architecture)
    * [1.7 Service-Oriented Architecture (SOA)](#17-service-oriented-architecture-soa)
      * [Microservice Architecture](#microservice-architecture)
      * [API Communication Protocols](#api-communication-protocols)
  * [2. Introduction to Node.js](#2-introduction-to-nodejs)
    * [2.1 Node.js](#21-nodejs)
    * [2.2 NPM (Node Package Manager)](#22-npm-node-package-manager)
    * [2.3 Node.js & npm Installation](#23-nodejs--npm-installation)
    * [2.4 Sequential and Event-Driven Programming Models](#24-sequential-and-event-driven-programming-models)
      * [Traditional blocking(sequential/synchronous) operation in Node.js](#traditional-blockingsequentialsynchronous-operation-in-nodejs)
    * [2.5 Non-blocking (asynchronous) operations in Node.js](#25-non-blocking-asynchronous-operations-in-nodejs)
    * [2.6 Basic JSON Operations](#26-basic-json-operations)
  * [3. Developing Web Applications Using HTML,CSS, JS, and Node.js](#3-developing-web-applications-using-htmlcss-js-and-nodejs)
    * [3.1 HTML (HyperText Markup Language)](#31-html-hypertext-markup-language)
    * [3.2 CSS (Cascading Style Sheets)](#32-css-cascading-style-sheets)
    * [3.3 JavaScript](#33-javascript)
    * [3.4 Basic DOM Manipulation and Event Handling with JavaScript](#34-basic-dom-manipulation-and-event-handling-with-javascript)
  * [4. Developing RESTful APIs](#4-developing-restful-apis)
    * [4.1 What is a RESTful API?](#41-what-is-a-restful-api)
    * [4.2 HTTP Status Codes](#42-http-status-codes)
    * [4.3 Response Formats](#43-response-formats)
    * [4.4 Route definition in Express.js](#44-route-definition-in-expressjs)
    * [4.5 A simple Node.js-based RESTful API](#45-a-simple-nodejs-based-restful-api)
    * [4.6 REST Clients - Testing REST api using cURL and HTTP Client](#46-rest-clients---testing-rest-api-using-curl-and-http-client)
      * [curl](#curl)
      * [Jetbrains HTTP Client](#jetbrains-http-client)
  * [Hands-on Exercise 1](#hands-on-exercise-1)
  * [5. Converting a Simple RESTful API into a Web Application](#5-converting-a-simple-restful-api-into-a-web-application)
  * [Hands-on Exercise 2](#hands-on-exercise-2)
  * [Hands-on Exercise 3](#hands-on-exercise-3)
  * [6. Interconnecting Web Services](#6-interconnecting-web-services)
  * [7. Database Integration](#7-database-integration)
  * [Hands-on Exercise 4](#hands-on-exercise-4)
  * [8. Deployment of Node.js Application to a Remote Server](#8-deployment-of-nodejs-application-to-a-remote-server)
    * [Running Node.js Applications as Services with PM2](#running-nodejs-applications-as-services-with-pm2)
<!-- TOC -->

---

## 1. Fundamentals Of Web Applications And Web Services

There are several services on the Internet, and the **Web (World Wide Web)** is one of the most widely used.

The Web consists of various resources—such as websites, web pages, files, data services, and functions—that can be 
accessed through client applications like web browsers or web services.

**What is a URL?**

A **URL (Uniform Resource Locator)** is the address of a resource on the Web. It specifies 
**where to find** and **how to access** a Web resource.

**Parts of a URL:**

A URL typically consists of:
- **Protocol:** Defines how to access the resource (e.g., `https://`, `http://`).
- **Domain Name:** The website's name (e.g., `example.com`).
- **Path (Optional):** Specifies a **resource** on the server (e.g., `/about`).

**Example URL:**

`https://www.example.com/about`
- `https://` → Secure protocol
- `www.example.com` → Website domain
- `/about` → Specific resource (page, file, function etc.)

**Applications can identify and send requests to a resource using the URL.**

---

### 1.1 Client Server Architecture

A **client–server architecture** divides an application into two main components:
- The **client**, which **initiates requests** (e.g., a web browser or mobile app).
- The **server**, which **waits for incoming requests**, processes them, and sends back responses.

> **Key point:** In this model, the **server cannot initiate communication** — it only responds to requests from the client.

This design centralizes data and logic on the server, making systems easier to manage, update, and secure.


<img src="../resources/client-server.png" width="700" alt="client server architecture">

---

### 1.2 Three-tier Web Architecture

The **Three-Tier Web Architecture** is a software architecture pattern that separates an application into three logical layers:

1. **Presentation Tier (Client Layer)** – The front-end where users interact with the application (e.g., web browser, mobile app).
2. **Application Tier (Business Logic Layer)** – The back-end server that handle requests and implements business logic.
3. **Data Tier (Database Layer)** – The database that stores and retrieves data.


```plaintext
      +---------------------------+
      |   Presentation Tier       |
      |  [ HTML / CSS / JS ]      |
      +---------------------------+
                    │
                    ▼
+-------------------------------------+
|         Application Tier            |
|  [ Node.js/Spring Boot/PHP/etc.]    |
+-------------------------------------+
                    │
                    ▼
+-------------------------------------+
|             Data Tier               |
|  [PostgreSQL/ MySQL/ MongoDB etc.]  |
+-------------------------------------+

Three-Tier Web Architecture

```
---

### 1.3 UML Deployment Diagram

A UML Deployment Diagram provides information regarding the deployment of software products
(artifacts/components) onto nodes (such as devices, operating systems, virtual machines, etc.). 
It illustrates the physical topology where the software is deployed.

<img src="../resources/deployment-diagram.png" width="400">


---


### 1.4 Web Application Architecture - Synchronous Communication

In **synchronous communication**, the client sends a request and **waits** for the server to respond before continuing.
- Commonly implemented using **HTTP** (e.g., RESTful APIs).
- Used for operations where an immediate response is required.
- Example: Submitting a login form and waiting for authentication results.


![Web Application Architecture](../resources/web-application-architecture-synchronous.png)

---

### 1.5 Web Application Architecture - Asynchronous Communication

In **asynchronous communication**, the client sends a request and continues executing without waiting for a response.
- Often implemented using **message queues**, **WebSockets**, or **AJAX**.
- Enables **non-blocking** interaction and better performance for real-time updates.
- Example: Attaching a large file to an email — the upload continues in the background while the user can still compose the message.

![Web Application Architecture](../resources/web-application-architecture-asynchronous.png)


### 1.6 Scalable Web Application Architecture

A **scalable architecture** is designed to handle increasing workloads efficiently by adding more resources.  
It typically involves:
- **Load balancing** (distributing requests across multiple servers).
- **Database replication or sharding**.
- **Caching** (e.g., Redis) to reduce repeated computations.
- **Microservices** or containerized deployments for modular growth.

Scalability ensures consistent performance as user demand grows.

![Web Application Architecture](../resources/scalable-web-architecture.png)

---

### 1.7 Service-Oriented Architecture (SOA)

**Service-Oriented Architecture (SOA)** is an architectural pattern in which software components are structured as 
independent services.

Each service performs a specific business function and communicates with other services through standardized interfaces 
and language-agnostic protocols, typically over HTTP or messaging queues.

For instance; in a banking system, separate services may handle account management, fund transfers, and customer notifications, all interacting through service interfaces.

**Key Characteristics of SOA:**

- **Loose Coupling**: Services are designed to be independent, minimizing dependencies.
- **Interoperability**: Services can work across different platforms and technologies.
- **Reusability**: Services can be reused in different applications.
- **Scalability**: Services can be scaled independently based on demand.

**Simple Two-Service Communication Diagram**

```plaintext
+----------------+       HTTP / Message Queue     +----------------+
|  Service A     | -----------------------------> |  Service B     |
|                |                                |                |
| (Client)       | <----------------------------- | (Provider)     |
+----------------+                                +----------------+
```
In this diagram:

* Service A acts as a client (consumer) that sends a request to Service B.
* Service B processes the request and sends back a response to Service A.
* Communication between web services can be achieved using HTTP-based protocols such as REST and SOAP, remote procedure 
call (RPC) frameworks like gRPC or XML-RPC, or asynchronous messaging systems such as Apache Kafka or RabbitMQ.

#### Microservice Architecture

**Microservice Architecture** is a modern derivative (or evolution) of Service-Oriented Architecture (SOA).

It is an architectural pattern where an application is composed of small, independent services
that communicate over a network.

Each service is responsible for a specific business capability and can be developed,
deployed, and scaled independently.



#### API Communication Protocols

**RESTful APIs**

- Based on **REST (Representational State Transfer)** principles.
- Uses standard **HTTP methods** (GET, POST, PUT, DELETE).
- Data format: **JSON**, sometimes XML.
- Stateless, lightweight, and widely used for web applications.

**SOAP (Simple Object Access Protocol)**

- A **protocol** for exchanging structured information in web services.
- Uses **XML** for message format.
- Operates over multiple transport protocols (HTTP, SMTP, etc.).
- Supports **WS-Security** for enterprise-level security.

**XML-RPC (XML Remote Procedure Call)**

- A protocol that allows remote function execution using **XML over HTTP**.
- Simpler than SOAP but less flexible than REST.
- Mainly used for legacy systems requiring XML-based communication.

**gRPC (Google Remote Procedure Call)**

- A **high-performance** framework developed by Google.
- Uses **Protocol Buffers (protobufs)** for efficient, compact data serialization.
- Supports **bidirectional streaming** and **multiplexing**.
- Ideal for **microservices** and **high-speed communication** across distributed systems.


## 2. Introduction to Node.js

### 2.1 Node.js

Node.js is an open-source, cross-platform runtime environment that allows you to run JavaScript code on the server side.
It uses the V8 JavaScript engine, which is also used by Google Chrome, to execute code outside of a web browser.

Key Features of Node.js:

* Asynchronous and Event-Driven: Node.js uses an event-driven, non-blocking I/O model, making it efficient and 
suitable for real-time applications.

* Single-Threaded: Despite being single-threaded, Node.js can handle many connections concurrently thanks to 
its event loop.

* NPM (Node Package Manager): Node.js comes with NPM, which is the largest ecosystem of open-source libraries 
in the world.

* Scalability: Node.js is designed to build scalable network applications.


Use Cases:

* Web Servers: Building fast and scalable web servers.
* APIs: Creating RESTful APIs for web and mobile applications.
* Real-Time Applications: Developing chat applications, online gaming, and collaborative tools.

---

### 2.2 NPM (Node Package Manager)
It is a package manager for JavaScript, and it is the default package manager for Node.js.

It allows developers to install, share, and manage dependencies (libraries and tools) for their projects.

* Key Features of NPM:
  - Package Management: Easily install and manage third-party libraries and tools.
  - Version Control: Keep track of different versions of packages to ensure compatibility.
  - Dependency Management: Automatically handle dependencies required by installed packages.
  - Script Running: Define and run scripts for various tasks, such as building, testing, and deploying applications.
* Basic Commands:
  - npm init: Initialize a new Node.js project.
  - npm install <package>: Install a package and add it to the project's dependencies.
  - npm update: Update all installed packages to their latest versions.
  - npm run: Run a script defined in the package.json file.

---

### 2.3 Node.js & npm Installation

**Setting Up the Development Environment**


* Download Node.js from here (https://nodejs.org/en/download) and install it properly.

* Install WebStorm or set up Intellij for Node.js based development
  - IntelliJ IDEA -> Preferences -> Plugins -> Node.js (OSX, Linux)
  - IntelliJ IDEA -> File -> Settings -> Plugins -> Node.js (Windows)
    
* Initialize a new Node.js project
  - IntelliJ IDEA -> File -> New -> Project -> Empty Project (Give the project an appropriate name.)
  - Open the terminal in IntelliJ
  - npm init -y
  - Make a /src folder for the source code of the project

* Make a hello-world.js file and write the following code:
  - console.log('Hello world.');
        
* Run the app:
  - node hello-world.js

---

### 2.4 Sequential and Event-Driven Programming Models

Traditional programming languages often follow a sequential (blocking) model, where each statement executes one after 
another, and the program waits for each operation to complete before continuing.

In contrast, event-driven systems use non-blocking I/O. For long-running operations such as network requests or file 
reads, the system registers the operation and immediately continues executing other tasks. When the operation 
completes, an event is emitted and the callback function (or async handler) is executed.

This approach reduces CPU idle time and is ideal for I/O-intensive applications. Sequential (blocking) systems, 
however, remain more suitable for CPU-intensive workloads, where operations are computation-heavy rather than I/O-bound.

#### Traditional blocking(sequential/synchronous) operation in Node.js


**Code Example: /part1/blocking.js**

```javascript
const fs = require('fs');

// Writing messages to the console
console.log('Start');

console.log('Message 1');

console.log('Message 2');
// Reading a file (Synchronous)
try {
    const data = fs.readFileSync('sample-data.md', 'utf8');
    console.log('File content:', data);
} catch (err) {
    console.error('Error reading file:', err);
}

console.log('End');

```
---

### 2.5 Non-blocking (asynchronous) operations in Node.js

* Event Loop Example

**Code Example: /part1/non-blocking.js**

```javascript
const fs = require('fs');

// Writing messages to the console
console.log('Start');

// Wait 2 sec (asynchronous / non-blocking)
setTimeout(() => {
    console.log('Message 1');
}, 2000);

// Wait 10 ms (asynchronous / non-blocking)
setTimeout(() => {
    console.log('Message 2');
}, 10);

// Reading a file (asynchronous / non-blocking)
fs.readFile('sample-data.md', 'utf8', (err, data) => {
    if (err) {
        console.error(err);
        return;
    }
    console.log('File content:', data);
});

console.log('End');
```
**Explanation of Execution Order**

1. "Start" is printed to the console first (synchronous).
2. setTimeout is registered but executed 2 seconds later. When the time is up, the statements inside setTimeout are executed.
3. setTimeout is registered but executed 10 ms later. When the time is up, the statements inside setTimeout are executed.
4. fs.readFile is non-blocking, so the file-reading operation starts immediately, and the callback is 
executed after the operation is completed.
5. "end" is printed to the console (synchronous).
6. The event loop handles setTimeout, setTimeout, and fs.readFile callbacks after the main script execution is completed.

---

### 2.6 Basic JSON Operations

**Code Example: /part1/json.js**

```javascript
const fs = require('fs'); // Import File System module

// Sample product JSON object
const product = {
    id: 1,
    name: "SSD",
    category: "Computer",
    price: 1000,
    stock: 50
};

// Convert JSON to string and write it to a file
fs.writeFileSync('product.json', JSON.stringify(product, null, 2)); //JSON.stringify(product, null, 2) converts 
// the product object into a human-readable, pretty-printed JSON string.
console.log("JSON file has been stored successfully.");

// Read JSON data from the file
const rawData = fs.readFileSync('product.json', 'utf8');
const productData = JSON.parse(rawData); // Convert JSON string to JavaScript object
console.log("\nRead JSON from file:", productData);

// Basic JSON Operations

// 1. Access properties
console.log("Product Name:", productData.name);
console.log("Category:", productData["category"]);

// 2. Modify properties
productData.price = 1200;  // Update price
productData.stock += 10;  // Increase stock by 10

// 3. Add a new property
productData.discount = 10;

// 4. Delete a property
delete productData.stock;


// Write the updated JSON back to the file
fs.writeFileSync('product.json', JSON.stringify(productData, null, 2));
console.log("\nUpdated JSON file saved.");

```



## 3. Developing Web Applications Using HTML,CSS, JS, and Node.js

**Code Example: A Simple Web Server**

/part1/server.js

```javascript
/**
 * This is a straightforward web server built with Express.js.
 * Express.js is a lightweight and fast web framework for Node.js that simplifies building web applications and APIs.
 * It serves static HTML pages from the "public" folder.
 */

const express = require('express'); // Import the Express.js framework
const path = require('path'); // Import the built-in Node.js 'path' module

const app = express(); // Initialize an Express application
const PORT = 3000; // Define the port number where the server will listen

// Middleware to serve static files (HTML, CSS, JS) from the 'public' folder.
app.use(express.static(path.join(__dirname, 'public')));
//Registers static-file middleware.
//Makes files inside the public directory accessible directly through HTTP requests.

// Start the server
app.listen(PORT, () => {
    console.log(`Server running on http://localhost:${PORT}`);
});
```

**Code Example: /part1/public/index.html**

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
Hello World !
</body>
</html>
```
---

### 3.1 HTML (HyperText Markup Language)

- HTML (HyperText Markup Language) is the standard markup language used to structure content on web pages.
- It organizes content using elements such as headings, paragraphs, links, images, tables, and forms.
- Web browsers parse HTML documents and use the resulting Document Object Model (DOM) to represent the structure of web content.
- HTML works together with CSS for styling and JavaScript for interactivity and dynamic functionality.

**For details about HTML, refer to:** [MDN – HTML](https://developer.mozilla.org/en-US/docs/Web/HTML)

---

### 3.2 CSS (Cascading Style Sheets)

- CSS (Cascading Style Sheets) is a style sheet language used to control the presentation of HTML documents.
- CSS defines the appearance and layout of web pages, including colors, fonts, spacing, positioning, and responsive layouts.
- It enables developers to build consistent and adaptable designs that work across different devices and screen sizes.

**For details about CSS, refer to:** [MDN – CSS](https://developer.mozilla.org/en-US/docs/Web/CSS)

---

### 3.3 JavaScript

- JavaScript is a general-purpose programming language widely used to add interactivity and dynamic functionality to web pages.
- In web browsers, JavaScript can manipulate the HTML Document Object Model (DOM), modify CSS styles, and handle events such as mouse clicks and keyboard input.
- It also enables asynchronous communication with servers, allowing web pages to retrieve and update data without requiring a full page reload.
- JavaScript is also used outside web browsers, particularly for server-side development with environments such as Node.js.

**For details about JavaScript, refer to:** [MDN – JavaScript](https://developer.mozilla.org/en-US/docs/Web/JavaScript)

---

### 3.4 Basic DOM Manipulation and Event Handling with JavaScript

* querySelector() selects the first element- returns the first matching element similar to css.
  - #id – Selects an element by its ID.
  - .class – Selects the first element with the specified class.
  - tag – Selects the first element with the specified HTML tag.
* querySelectorAll() returns all matching elements.

> The DOM (Document Object Model) is a programming interface that represents an HTML or XML document as a tree of 
> objects, allowing languages like JavaScript to read and manipulate the page's structure, content, and styles.

**Code Example: Handling Form Input Fields**

/part1/public/dom-manipulation/index.html

```html

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <!--    This meta tag ensures that the web page adjusts its layout to the device's screen width, providing a 
  responsive display on mobile devices, tablets, and desktops.-->
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>DOM Manipulation with JavaScript</title>
</head>
<body>

<h2>Basic DOM Manipulation and Event Handling</h2>

<!-- 1. Hide an HTML element -->
<button id="hide-btn">Hide</button>
<p id="text">This is a paragraph.</p>

<hr>

<!-- 2. Get input value and display a message -->
<input type="text" id="name-input" placeholder="Enter your name">
<button type="button" id="get-name-btn">Get Name</button>
<p id="output">Output</p>

<hr>

<!-- 3. Change CSS styles using JavaScript -->
<button id="style-btn">Change Text Color</button>
<p id="style-text">JavaScript can modify CSS styles.</p>

<hr>

<!-- 4. Handle form submission -->
<form id="user-form">
  <input type="text" id="username" placeholder="Enter username" required>
  <input type="password" id="password" placeholder="Enter password" required>
  <button type="submit">Submit</button>
</form>

<p id="message"></p>

<script>

  // 1. Hide an HTML element
  document.querySelector("#hide-btn").addEventListener("click", function () {
    document.querySelector("#text").hidden = true;
  });


  // 2. Get input value and display a message
  document.querySelector("#get-name-btn").addEventListener("click", function () {
    const name = document.querySelector("#name-input").value;

    document.querySelector("#output").textContent = "Hello, " + name;
  });


  // 3. Change CSS styles using JavaScript
  document.querySelector("#style-btn").addEventListener("click", function () {
    const paragraph = document.querySelector("#style-text");

    paragraph.style.color = "blue";
    paragraph.style.fontSize = "20px";
    paragraph.style.fontWeight = "bold";
  });


  // 4. Handle form submission
  document.querySelector("#user-form").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent the default form submission

    const username = document.querySelector("#username").value;

    document.querySelector("#message").textContent =
            "Form submitted! Welcome, " + username;
  });

</script>

</body>
</html>
```



## 4. Developing RESTful APIs

### 4.1 What is a RESTful API?

REST (Representational State Transfer) is an architectural style (or a set of principles) for designing networked applications.

RESTful refers to web services that adhere to the principles of REST (Representational State Transfer). 

RESTful is an approach for building scalable, stateless web APIs that use standard HTTP methods and principles.

<img src="../resources/images/RESTful-anatomy.png" width="80%" alt="RESTful anatomy"></img>

**Key Characteristics**

1. **HTTP Methods**: RESTful APIs use standard HTTP methods to perform operations on resources:

   | **HTTP Method** | **Usage** |
   |---------------|---------|
   | `GET`        | Retrieve resource (Read) |
   | `POST`       | Add new resource (Insert) |
   | `PUT`        | Update existing resource (Replace) |
   | `PATCH`      | Update a specific part of resource (Modify) |
   | `DELETE`     | Remove resource |

2. **Resource-Based**: RESTful APIs use resources, which are identified by URLs.
   A resource could be a user, a product, or a function to control a heating system.

3. **JSON or XML**: Data is typically exchanged in JSON or XML format, with JSON being more common due to its 
   simplicity and ease of use.

4. **Stateless**: The server does not store any client context between requests.

**Example Endpoints**

- **GET /users**: Retrieve a list of users.
- **POST /users**: Add a new user.
- **GET /users/{id}**: Retrieve a specific user by ID.
- **PUT /users/{id}**: Replaces (or fully updates) the user representation.
- **DELETE /users/{id}**: Delete a specific user by ID.
- **GET /heating-system/state**: Retrieve the current status of the heating system.
- **PUT /heating-system/state {"power":"on", "temperature":"22"}** : Full state replacement
- **PATCH /heating-system/state {"power":"off"}**: Partially update

>***In RESTful APIs, a URI (path) must identify a resource, while the HTTP method defines the action performed on that resource.***

---

### 4.2 HTTP Status Codes
HTTP Status Codes are 3-digit numbers returned by web servers to indicate the status of a requested HTTP operation 
(successful, failed, not found, etc.).

Here are some common status codes and their meanings:

| **Status Code**       | **Meaning**                          |
|------------------------|--------------------------------------|
| **200 OK**             | The request was successful.          |
| **201 Created**        | The resource was created successfully.|
| **400 Bad Request**    | The client sent an invalid request.  |
| **401 Unauthorized**   | Authentication is required.          |
| **403 Forbidden**      | Access to the resource is denied.    |
| **404 Not Found**      | The requested resource does not exist.|
| **500 Internal Server Error** | A server-side error occurred.     |

---

### 4.3 Response Formats
APIs typically return data in one of the following formats:

1) **JSON (JavaScript Object Notation)**
- **Description**: A lightweight, human-readable, and easy-to-parse format.
- **Usage**: Commonly used in modern APIs.
- **Example**:
```json
  {
    "id": 1,
    "name": "John Doe",
    "email": "john.doe@example.com"
  }
```
2) **XML (Extensible Markup Language)**
```xml
<user>
  <id>1</id>
  <name>John Doe</name>
  <email>john.doe@example.com</email>
</user>
```

---

### 4.4 Route definition in Express.js

A **route** in Express.js defines an endpoint where clients send requests to interact with the service.

<img src="../resources/images/express-route-structure.png" alt="Express.js Route Structure Structure" width="70%"></img>

Each route consists of:

1. **An HTTP method** (GET, POST, etc.)
2. **A URL pattern** (e.g., `/api/customers/:id`)
3. **A callback function / route handler ** to handle the request

Example of a simple route in Express.js:

**Code Example**

```javascript
app.get("/api/customers", (req, res) => {
    res.json({ message: "List of customers" });
});
```

**Execution Flow**

When a request enters your Express application, it follows this sequence:

1) The server receives an incoming HTTP request.
2) Express scans your defined routes from top to bottom.
3) It looks for a match involving both the Method AND the Path.
4) Once matched, it executes the handler function.
5) The handler sends a response, "closing" the request-response cycle.

---

### 4.5 A simple Node.js-based RESTful API

**Code Example: /part2/simple-restful/server.js**

```javascript
// ───────────────────────────────────────────────────────────────
// Import Required Modules
// ───────────────────────────────────────────────────────────────
const express = require("express"); // Import the Express.js framework

// ───────────────────────────────────────────────────────────────
// Configuration & Constants
// ───────────────────────────────────────────────────────────────
const app = express(); // Initialize an Express application
const PORT = 3000; // Define the port number where the server will listen

// ───────────────────────────────────────────────────────────────
// Middleware
// ───────────────────────────────────────────────────────────────
app.use(express.json()); // Parse JSON request bodies
app.use(express.static("public")); // Serve the frontend files (HTML, CSS, JS) from the "public" folder

// ───────────────────────────────────────────────────────────────
// In-memory database: JSON array for products
// ───────────────────────────────────────────────────────────────
let products = [
  { id: 1, name: "SSD", price: 999.99 },
  { id: 2, name: "RAM", price: 499.99 },
];
let nextId = 3; // Ids are never reused, even after a product is deleted

// ───────────────────────────────────────────────────────────────
// Validation helpers
// ───────────────────────────────────────────────────────────────
const isValidName = (value) => typeof value === "string" && value.trim() !== "";
const isValidPrice = (value) => typeof value === "number" && Number.isFinite(value) && value >= 0;

// ───────────────────────────────────────────────────────────────
// Define Routes
// ───────────────────────────────────────────────────────────────
// Routes are the connection points (end points - addresses) in a web service where clients send requests to interact with the service.

// GET all products
app.get("/api/products", (req, res) => {
  res.json(products); // Respond with the list of all products
});

// GET a single product by ID
app.get("/api/products/:id", (req, res) => {
  const product = products.find((p) => p.id === Number(req.params.id)); // Find the product by ID. Number(req.params.id) converts the id from the URL into a number.
  if (!product) return res.status(404).json({ error: "Product not found" }); // If not found, respond with 404
  res.json(product); // Respond with the found product
});

// POST - Add a new product
app.post("/api/products", (req, res) => {
  const { name, price } = req.body ?? {}; // Extract name and price from the request body. "??" returns its right side only when the left side is null or undefined:

  // Validate input (a price of 0 is allowed)
  if (!isValidName(name) || !isValidPrice(price)) {
    return res.status(400).json({
      error: "name (non-empty string) and price (non-negative number) are required",
    });
  }

  const newProduct = { id: nextId++, name: name.trim(), price }; // Add a new product with a unique ID
  products.push(newProduct); // Add the new product to the list
  res.status(201).json(newProduct); // Respond with the added product
});

// PUT - Replace a product (all mutable fields are required)
app.put("/api/products/:id", (req, res) => {
  const product = products.find((p) => p.id === Number(req.params.id)); // Find the product by ID
  if (!product) return res.status(404).json({ error: "Product not found" });

  const { name, price } = req.body ?? {};

  // Unlike PATCH, PUT must receive every mutable field
  if (!isValidName(name) || !isValidPrice(price)) {
    return res.status(400).json({
      error: "name (non-empty string) and price (non-negative number) are required",
    });
  }

  product.name = name.trim(); // The id always comes from the URL, never from the body
  product.price = price;
  res.json(product); // Respond with the replaced product
});

// PATCH - Partially update a product (only the provided fields change)
app.patch("/api/products/:id", (req, res) => {
  const product = products.find((p) => p.id === Number(req.params.id)); // Find the product by ID
  if (!product) return res.status(404).json({ error: "Product not found" });

  const { name, price } = req.body ?? {};

  // Validate only the fields that were sent (undefined means "not provided")
  if (name !== undefined && !isValidName(name)) {
    return res.status(400).json({ error: "name must be a non-empty string" });
  }
  if (price !== undefined && !isValidPrice(price)) {
    return res.status(400).json({ error: "price must be a non-negative number" });
  }

  if (name !== undefined) product.name = name.trim();
  if (price !== undefined) product.price = price;
  res.json(product); // Respond with the updated product
});

// DELETE - Remove a product
app.delete("/api/products/:id", (req, res) => {
  const index = products.findIndex((p) => p.id === Number(req.params.id));
  if (index === -1) return res.status(404).json({ error: "Product not found" });

  products.splice(index, 1); // Removes one element from the products array, starting at position index.
  res.status(204).end(); // REST best practice: 204 No Content for a successful DELETE
});

// ───────────────────────────────────────────────────────────────
// Error handling
// ───────────────────────────────────────────────────────────────
// Unknown /api routes: respond with JSON instead of Express's default HTML page
app.use("/api", (req, res) => {
  res.status(404).json({ error: "Route not found" });
});

// Errors thrown by middleware (for example, malformed JSON in the request body)
app.use((err, req, res, next) => {
  if (err.type === "entity.parse.failed") {
    return res.status(400).json({ error: "Invalid JSON" });
  }
  console.error(err);
  res.status(500).json({ error: "Internal server error" });
});


// ───────────────────────────────────────────────────────────────
// Start Express HTTP Server
// ───────────────────────────────────────────────────────────────
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});

```

---

### 4.6 REST Clients - Testing REST api using cURL and HTTP Client


#### curl
    curl --version
    if not installed -> Download cURL from: https://curl.se/windows/


```sh
# Retrieves a list of all products from the database.

curl -X GET http://localhost:3000/api/products

# -i - Include response headers
# -X - Specify HTTP method
# -H - Add headers
# -d - Send data (POST/PUT)
# -u - Basic authentication
# -v - Verbose(detailed) output

---

# Fetches details of a specific product using its ID.

curl -iX GET http://localhost:3000/api/products/1

---

# Adds a new product to the database. The request body must contain name and price in JSON format.

curl -iX POST http://localhost:3000/api/products \
     -H "Content-Type: application/json" \
     -d '{"name": "HDMI Cable", "price": 50.05}'


---

# Updates the details of an existing product using its ID.

curl -X PUT http://localhost:3000/api/products/1 \
     -H "Content-Type: application/json" \
     -d '{"name": "Updated Product", "price": 1099.99}'


---

# Updates the details of an existing product using its ID. Any missing fields will retain their previous values.

curl -X PATCH http://localhost:3000/api/products/1 \
     -H "Content-Type: application/json" \
     -d '{"price": 1099.99}'
---

# Deletes a product from the database by specifying its ID.

curl -X DELETE http://localhost:3000/api/products/1


```

#### Jetbrains HTTP Client

**Code Example: /part2/simple-restful/restful-api-test.http**

```http request
###Retrieve all products
GET http://localhost:3000/api/products


### Find product by id
GET http://localhost:3000/api/products/2


### Find products by name
GET http://localhost:3000/api/products?name=SSD


###
POST http://localhost:3000/api/products
Content-Type: application/json

{"name": "SSD", "price": 500}

###
PUT http://localhost:3000/api/products/1
Content-Type: application/json

{"name": "Updated SSD", "price": 1099.99}


###
PATCH http://localhost:3000/api/products/1
Content-Type: application/json

{"price": 200}

###


DELETE http://localhost:3000/api/products/1


### Retrieve all products
GET http://localhost:4000/api/products


### Retrieve all products
GET http://localhost:3000/api/products


```



***
## [Hands-on Exercise 1](./exercises/README.md)

***

---
## 5. Converting a Simple RESTful API into a Web Application

This section explains how to convert the existing **REST API** into a **web application** by developing web pages 
(frontend) that let users interact with the API. To focus on the interaction between frontend and backend, 
the frontend uses plain **HTML, CSS, and vanilla JavaScript** (no libraries or frameworks).

The web application will provide:
- A **product list** fetched from the API.
- A **form to add new products**.
- Options to **update and delete products** dynamically, without reloading the page.
- Requests to the API made with the browser's built-in **`fetch()`** API (AJAX).

**Steps to Convert the API into a Web Application**
1. **Keep the existing REST API** as the backend, and make it serve static files (the HTML, CSS, and JavaScript). 
In Express, for example: `app.use(express.static("public"));`
2. **Develop the frontend web pages** that interact with the API.
3. **Use `fetch()`** to get, display, add, update, and delete products.
4. **Handle events** (such as button clicks and form submissions) with `addEventListener()` and call the API from the handlers.
5. **Improve the user experience**, for example with CSS transitions and by showing or hiding elements with classes.

**How user actions map to API requests**

| Action | HTTP method | Example endpoint |
|---|---|---|
| Show the product list | `GET` | `/api/products` |
| Add a product | `POST` | `/api/products` |
| Update a product | `PUT` or `PATCH` | `/api/products/:id` |
| Delete a product | `DELETE` | `/api/products/:id` |


**Step 1: Modify the API** (`/part2/simple-restful/server.js`)

We will slightly modify the existing API to serve **static HTML files** in addition to handling RESTful requests.

**Code Example: /part2/web-server/server.js**

```javascript
// ───────────────────────────────────────────────────────────────
// Import Required Modules
// ───────────────────────────────────────────────────────────────
const express = require("express"); // Import the Express.js framework
const path = require("path"); // Import the built-in Node.js 'path' module
//const cors = require("cors"); // Import CORS

// ───────────────────────────────────────────────────────────────
// Configuration & Constants
// ───────────────────────────────────────────────────────────────
const app = express(); // Initialize an Express application
const PORT = 3000; // Define the port number where the server will listen

// ───────────────────────────────────────────────────────────────
// Middlewares
// ───────────────────────────────────────────────────────────────
app.use(express.json());// Middleware to parse JSON request bodies
app.use(express.static(path.join(__dirname, 'public'))); // Middleware to serve static files (HTML, CSS, JS) from the 'public' folder
//app.use(cors()); // Enable CORS for all routes
// The browser blocks cross-origin requests unless the server explicitly allows them.
// Cross-Origin means that the protocol, domain, or port is different between the frontend and backend.
// The frontend is running on localhost:3000, and when it sends a request to the service running on localhost:4000,
// it is considered a cross-origin request.

// ───────────────────────────────────────────────────────────────
// In-memory database: JSON array for products
// ───────────────────────────────────────────────────────────────
let products = [
  { id: 1, name: "SSD", price: 999.99 },
  { id: 2, name: "RAM", price: 499.99 },
];

// ───────────────────────────────────────────────────────────────
// Define Routes
// ───────────────────────────────────────────────────────────────
// Routes are the connection points (end points - addresses) in a web service where clients send requests to interact with the service.
// GET all products
app.get("/api/products", (req, res) => {
  res.json(products); // Respond with the list of all products
});

// GET a single product by ID
app.get("/api/products/:id", (req, res) => {
  const product = products.find((p) => p.id === parseInt(req.params.id)); // Find the product by ID
  if (!product) return res.status(404).json({ error: "Product not found" }); // If not found, respond with 404
  res.json(product); // Respond with the found product
});

// POST - Add a new product
app.post("/api/products", (req, res) => {
  const { name, price } = req.body; // Extract name and price from the request body
  if (!name || !price) return res.status(400).json({ error: "Invalid input" }); // Validate input

  const newProduct = { id: products.length + 1, name, price }; // Add a new product with a unique ID
  products.push(newProduct); // Add the new product to the list
  res.status(201).json(newProduct); // Respond with the added product
});

// PUT - Replace a Product Record (full replacement)
app.put("/api/products/:id", (req, res) => {
  // 1. Destructure and extract all fields from the request body.
  // Assuming 'name', 'price' are the mutable fields.
  const { name, price } = req.body;

  // 2. Validate the Request Body (Required for PUT)
  // Check if all required fields are present.
  // Note: Unlike the original code, we do NOT use '|| product.name'
  // because PUT must overwrite all fields, or fail.
  if (!name || price == null ) {
    return res.status(400).json({
      error: "PUT /products requires ALL mutable fields (name, price) for full replacement."
    });
  }

  // 3. Find the Product
  const product = products.find((p) => p.id === parseInt(req.params.id));
  if (!product) {
    return res.status(404).json({ error: "Product not found" });
  }

  // 4. Update/Replace: Directly assign ALL new values.
  product.name = name;
  product.price = price;

  // 5. Respond with the fully updated product
  res.json(product);
});

// PATCH - Modify a product (partial or full replacement)
app.patch("/api/products/:id", (req, res) => {
  const product = products.find((p) => p.id === parseInt(req.params.id)); // Find the product by ID
  if (!product) return res.status(404).json({ error: "Product not found" }); // If not found, respond with 404

  const { name, price } = req.body; // Extract name and price from the request body
  product.name = name || product.name; // Update the product name if provided
  product.price = price || product.price; // Update the product price if provided
  res.json(product); // Respond with the updated product
});

// DELETE - Remove a product
app.delete("/api/products/:id", (req, res) => {
  const productIdToDelete = parseInt(req.params.id);

  // 1. Store the initial count of products
  const initialLength = products.length;

  // 2. Filter the array, creating a new array without the specified product ID
  products = products.filter((p) => p.id !== productIdToDelete);

  // 3. Store the final count of products
  const finalLength = products.length;

  if (finalLength < initialLength) {
    // The product was found and successfully deleted (the array length decreased).

    // REST Best Practice: 204 No Content for a successful DELETE with no response body.
    res.status(204).end();
  } else {
    // The product was NOT found (the array length remained the same).

    // REST Best Practice: 404 Not Found indicates the resource doesn't exist.
    res.status(404).json({
      error: `Product with ID ${productIdToDelete} not found.`
    });
  }
});

// ───────────────────────────────────────────────────────────────
// Start Express HTTP Server
// ───────────────────────────────────────────────────────────────
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
```


**Step 2: Develop Frontend Web Pages**

Add the following `index.html` file into the `public` folder. This will be the main page where users
can perform view, add, update, and delete functions on the products object.

**Code Example: /part2/web-server/public/index.html**

```html

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Product Management</title>
  <style>
    body { font-family: Arial, sans-serif; text-align: center; margin: 20px; }
    table { width: 50%; margin: auto; border-collapse: collapse; }
    th, td { border: 1px solid #ccc; padding: 8px; }
    .error { color: red; display: none; margin: 10px 0; }
    .error.visible { display: block; }
    button { margin: 0 4px; cursor: pointer; }
  </style>
</head>
<body>

<h2>Product List</h2>
<input type="text" id="search" placeholder="Search by name">
<p class="error" id="search-error">No products found</p>

<table>
  <thead><tr><th>ID</th><th>Name</th><th>Price</th><th>Actions</th></tr></thead>
  <tbody id="product-list"></tbody>
</table>

<h2>Add Product</h2>
<form id="add-product-form">
  <input type="text" id="name" placeholder="Product Name" required>
  <input type="number" id="price" placeholder="Price" min="0.01" step="any" required>
  <button type="submit">Add Product</button>
</form>
<p class="error" id="error-msg"></p>

<div id="updateform" hidden>
  <h2>Update Product</h2>
  <form id="update-product-form">
    <input type="number" id="update-id" readonly required>
    <input type="text" id="update-name" placeholder="New Name">
    <input type="number" id="update-price" placeholder="New Price" min="0.01" step="any">
    <button type="submit">Update Product</button>
  </form>
  <p class="error" id="update-error-msg"></p>
</div>

<script>
  const API_URL = "/api/products";
  let currentSearch = "";
  let debounceTimer;

  const showError = (id, msg) => {
    const el = document.getElementById(id);
    el.textContent = msg;
    el.classList.add("visible");
    setTimeout(() => el.classList.remove("visible"), 5000);
  };

  // Fetches and renders products, handling empty search states
  const loadProducts = async (query = "") => {
    currentSearch = query;
    try {
      const url = query ? `${API_URL}?name=${encodeURIComponent(query)}` : API_URL;
      const res = await fetch(url);
      if (!res.ok) throw new Error("Failed to load");
      const products = await res.json();

      // Toggle "No products found" message based on array length
      document.getElementById("search-error").classList.toggle("visible", products.length === 0);

      // Render rows efficiently using template literals
      document.getElementById("product-list").innerHTML = products.map(p => `
          <tr>
            <td>${p.id}</td>
            <td>${p.name}</td>
            <td>${p.price}</td>
            <td>
              <button class="edit-btn" data-id="${p.id}">Edit</button>
              <button class="delete-btn" data-id="${p.id}">Delete</button>
            </td>
          </tr>
        `).join('');
    } catch (err) {
      console.error("Error loading products:", err);
    }
  };

  // Add Product
  document.getElementById("add-product-form").addEventListener("submit", async (e) => {
    e.preventDefault();
    const name = document.getElementById("name").value.trim();
    const price = Number(document.getElementById("price").value);

    if (!name || !Number.isFinite(price) || price <= 0) {
      return showError("error-msg", "Invalid product name or price.");
    }

    try {
      const res = await fetch(API_URL, {
        method: "POST",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify({ name, price })
      });
      if (!res.ok) throw new Error("Failed to add");
      e.target.reset();
      loadProducts(currentSearch);
    } catch (err) {
      showError("error-msg", "Unable to add product.");
    }
  });

  // Live Search with Debouncing
  document.getElementById("search").addEventListener("input", (e) => {
    clearTimeout(debounceTimer);
    debounceTimer = setTimeout(() => loadProducts(e.target.value.trim()), 300);
  });

  // Combined Event Delegation for Edit and Delete actions
  document.getElementById("product-list").addEventListener("click", async (e) => {
    // Matches either button class, ignoring clicks elsewhere in the table
    const btn = e.target.closest(".edit-btn, .delete-btn");
    if (!btn) return;

    const id = btn.dataset.id;

    if (btn.classList.contains("delete-btn")) {
      try {
        const res = await fetch(`${API_URL}/${encodeURIComponent(id)}`, { method: "DELETE" });
        if (!res.ok) throw new Error("Failed to delete");
        loadProducts(currentSearch);
      } catch (err) {
        console.error("Delete error:", err);
      }
    }
    else if (btn.classList.contains("edit-btn")) {
      try {
        const res = await fetch(`${API_URL}/${encodeURIComponent(id)}`);
        if (!res.ok) throw new Error("Failed to retrieve");
        const product = await res.json();

        document.getElementById("update-id").value = product.id;
        document.getElementById("update-name").value = product.name;
        document.getElementById("update-price").value = product.price;
        document.getElementById("updateform").hidden = false;
      } catch (err) {
        console.error("Edit error:", err);
      }
    }
  });

  // Update Product
  document.getElementById("update-product-form").addEventListener("submit", async (e) => {
    e.preventDefault();
    const id = document.getElementById("update-id").value;
    const name = document.getElementById("update-name").value.trim();
    const priceVal = document.getElementById("update-price").value;
    const price = priceVal ? Number(priceVal) : null;

    if (!name && !priceVal) return showError("update-error-msg", "Enter at least one field to update.");
    if (priceVal && (!Number.isFinite(price) || price <= 0)) {
      return showError("update-error-msg", "Enter a valid price.");
    }

    // Build payload dynamically, only including provided fields
    const updatedData = {};
    if (name) updatedData.name = name;
    if (priceVal) updatedData.price = price;

    try {
      const res = await fetch(`${API_URL}/${encodeURIComponent(id)}`, {
        method: "PATCH",
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(updatedData)
      });
      if (!res.ok) throw new Error("Failed to update");

      document.getElementById("updateform").hidden = true;
      e.target.reset();
      loadProducts(currentSearch);
    } catch (err) {
      showError("update-error-msg", "Unable to update product.");
    }
  });

  loadProducts(); // Initial render
</script>
</body>
</html>


```

***
## [Hands-on Exercise 2](./exercises/README.md)

***



**Step 3: Add search and update functionalities to the web app**

**Code Example: Modify the following route in /part2/web-server/server.js**

```javascript
// GET all products
app.get("/api/products", (req, res) => {
  // Accesses the name parameter from the query string in an Express.js request object.
  const query = req.query.name?.toLowerCase() || "";

  if (query) {
    const filteredProducts = products.filter(product =>
            product.name.toLowerCase().includes(query)
    );
    return res.json(filteredProducts);
  }

  res.json(products);
});

```

**Code Example: /part2/web-server/public/index1.html**

```html



```


***
## [Hands-on Exercise 3](./exercises/README.md)

***


---

## 6. Interconnecting Web Services

**Service-Oriented Architecture (SOA)** is an architectural pattern in which software components are structured as
independent services.

```text
                                     Client
                                       | ^
        1) Sends request to Service A  | | 4)Final response
                                       v |
                            +--------------------------+
                            |        Service A         |
                            |        (4000)            |
                            +--------------------------+
                                       | ^
                             2) A → B  | | 3) B → A (sends data back)
                                       v |
                            +--------------------------+
                            |        Service B         |
                            |        (3000)            |
                            +--------------------------+
                             
```
* Run the Service B /part2/simple-restful/server.js
* Send requests to this service with the following RESTful client service (Service A)

**Code Example: /part2/restful-client-service.js**

```javascript
// ───────────────────────────────────────────────────────────────
// Import Required Modules
// ───────────────────────────────────────────────────────────────
const express = require("express"); // Import the Express.js framework
const axios = require("axios"); // Used to send HTTP requests to Service A

// ───────────────────────────────────────────────────────────────
// Configuration & Constants
// ───────────────────────────────────────────────────────────────
const app = express(); // Initialize an Express application
const PORT = 4000; // Define the port number where the server will listen

// ───────────────────────────────────────────────────────────────
// Middleware: JSON Parser
// ───────────────────────────────────────────────────────────────
// Middleware to parse JSON request bodies
app.use(express.json());


// GET all products from the related web service
app.get("/api/products", async (req, res) => {
  try {
    // Service B sends a GET request to Service A (port 3000)
    const response = await axios.get("http://localhost:3000/api/products");

    // Service B sends the data it received from Service A back to its own client
    res.json(response.data);

  } catch (error) {
    res.status(500).json({ error: "Failed to fetch products from Service A" });
  }
});


// Start server
app.listen(PORT, () => console.log(`Server running on port ${PORT}`));

```

---

## 7. Database Integration

Modern applications often need to store, retrieve, and manipulate data dynamically.
To perform these database operations from within an application, database drivers are essential.
These drivers act as a bridge between the programming language and the DBMS.


**Database Operations with Node.js and PostgreSQL**

* Setting up the PostgreSQL db
```sql
CREATE DATABASE testdb;
---------------------------
CREATE TABLE products (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    price NUMERIC(10, 2) NOT NULL
);

```
**Code Example: A simple REST API with CRUD operations**

/part3/server.js

```javascript
//npm install express pg
//Import necessary modules

const express = require("express");
const { Pool } = require("pg"); // import pg (node-postgres) library (db driver)

const app = express();

// Initialize a new PostgreSQL connection pool
// Pool is a class from the pg (node-postgres) library that instantiate and manages a pool of
// PostgreSQL database connections for efficient query execution in a Node.js application.

const pool = new Pool({
  user: 'lectureuser',
  password: 'lecturepassword',
  host: 'localhost',
  port: 5432,
  database: 'testdb',
});

/*const pool = new Pool({
    connectionString: "postgresql://postgres:LecturePassword@localhost:5432/testdb",
});*/


// Middleware to parse JSON request bodies
app.use(express.json());

// ------------------------ GET all products ------------------------
app.get("/api/products", async (req, res) => {
  try {
    // Fetch all products from the database
    const result = await pool.query("SELECT * FROM products ORDER BY id ASC");

    // Respond with JSON data
    res.json(result.rows);
  } catch (err) {
    res.status(500).json({ error: "Database error" }); // Handle errors
  }
});

// ------------------------ GET a single product by ID ------------------------
app.get("/api/products/:id", async (req, res) => {
  try {
    const { id } = req.params; // Extract product ID from URL

    // Query database for the given product ID
    const result = await pool.query("SELECT * FROM products WHERE id = $1", [id]);
    //$1 is placeholders for parameterized queries, preventing SQL injection.

    if (result.rows.length === 0)
      return res.status(404).json({ error: "Product not found" });

    // Respond with the found product
    res.json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: "Database error" });
  }
});

// ------------------------ POST - Add a new product ------------------------
app.post("/api/products", async (req, res) => {
  try {
    const { name, price } = req.body; // Extract product details from request body

    // Validate input (ensure name and price are provided)
    if (!name || !price)
      return res.status(400).json({ error: "Invalid input" });

    // Insert new product into the database
    const result = await pool.query(         //executes the query asynchronously using the PostgreSQL connection pool.
            "INSERT INTO products (name, price) VALUES ($1, $2) RETURNING *", //$1, $2 are placeholders for parameterized
            // queries, preventing SQL injection. // RETURNING * makes PostgreSQL return the newly inserted row.
            [name, price] //name, price] is an array of values that replaces $1 and $2 in the query.
    );

    // Respond with the newly added product
    res.status(201).json(result.rows[0]);
  } catch (err) {
    res.status(500).json({ error: "Database error" });
  }
});

// ------------------------ PUT - Update a product ------------------------
// FULL update (replace the entire product)
app.put("/api/products/:id", async (req, res) => {
  try {
    const { id } = req.params;
    const { name, price } = req.body;

    // Validate required fields
    if (!name || !price) {
      return res.status(400).json({ error: "All fields are required for PUT" });
    }

    const result = await pool.query(
            "UPDATE products SET name = $1, price = $2 WHERE id = $3 RETURNING *",
            [name, price, id]
    );

    if (result.rows.length === 0)
      return res.status(404).json({ error: "Product not found" });

    res.json(result.rows[0]);

  } catch (err) {
    res.status(500).json({ error: "Database error" });
  }
});


// ------------------------ PUT - Modify a product ------------------------
// PARTIAL update (only provided fields)
app.patch("/api/products/:id", async (req, res) => {
  try {
    const { id } = req.params;
    const { name, price } = req.body;

    const result = await pool.query(
            `UPDATE products
       SET name  = COALESCE($1, name),
           price = COALESCE($2, price)
       WHERE id = $3
       RETURNING *`,
            [name, price, id]
    );

    if (result.rows.length === 0)
      return res.status(404).json({ error: "Product not found" });

    res.json(result.rows[0]);

  } catch (err) {
    res.status(500).json({ error: "Database error" });
  }
});


// ------------------------ DELETE - Remove a product ------------------------
app.delete("/api/products/:id", async (req, res) => {
  try {
    const { id } = req.params;

    // Delete the product from the database and use RETURNING * to check if any row was affected
    const result = await pool.query("DELETE FROM products WHERE id = $1 RETURNING *", [id]);

    if (result.rows.length === 0) {
      // 1. Resource Not Found: If the database reports no rows were deleted
      // (because the ID didn't exist), return 404.
      return res.status(404).json({ error: "Product not found" });
    }

    // 2. Successful Deletion: If a row was deleted, return 204 No Content.
    // This is the RESTful standard for a successful DELETE that sends no body data.
    res.status(204).end();
  } catch (err) {
    // 3. Server Error: For database connection or query execution errors.
    console.error(err); // Log the error for debugging
    res.status(500).json({ error: "Database error during deletion" });
  }
});

// ------------------------ Start server ------------------------
const PORT = 3000;
app.listen(PORT, () => console.log(`Server running on http://localhost:${PORT}`));

```

***
## [Hands-on Exercise 4](./exercises/README.md)

***

---

## 8. Deployment of Node.js Application to a Remote Server

    Intellij -> Tools -> Deployment -> Configuration 
    Provide protocol -> sftp, socket address -> 192.2.2.1:22, credentials ->username:password
    Right Click -> Deploy

### Running Node.js Applications as Services with PM2
PM2 is a widely used, open-source, production-grade process manager for Node.js (Python) applications. 
It helps you manage and keep your Node.js applications running in the background, even after system reboots or crashes.

```shell
npm install pm2@latest -g

pm2 start server.js --name web-application-server

pm2 status

pm2 monit

pm2 restart id/name

pm2 stop id/name

pm2 delete id/name

pm2 save # Freeze a process list on reboot

pm2 startup  #This command will generate a script that you can copy and paste into your terminal to enable PM2 to start on boot.
 
pm2 unstartup systemd  # Remove init script
```
