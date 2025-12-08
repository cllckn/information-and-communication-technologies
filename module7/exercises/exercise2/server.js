// ───────────────────────────────────────────────────────────────
// Import Required Modules
// ───────────────────────────────────────────────────────────────
const express = require("express"); // Import the Express.js framework
const path = require('path'); // Import the built-in Node.js 'path' module

// ───────────────────────────────────────────────────────────────
// Configuration & Constants
// ───────────────────────────────────────────────────────────────
const app = express(); // Initialize an Express application
const PORT = 3000; // Define the port number where the server will listen

// ───────────────────────────────────────────────────────────────
// Middleware: JSON Parser
// ───────────────────────────────────────────────────────────────
// Middleware to parse JSON request bodies
app.use(express.json());
app.use(express.static(path.join(__dirname, 'public')));


// ───────────────────────────────────────────────────────────────
// In-memory database: JSON array for customers
// ───────────────────────────────────────────────────────────────
let customers = [
  { "id": 1, "name": "Jane", "email": "j@mail.com", "phone":"23232", "city":"Astana" },
  { "id": 2, "name": "Alice", "email": "a@mail.com", "phone":"23445232", "city":"Petropavl" },

];

// ───────────────────────────────────────────────────────────────
// Define Routes
// ───────────────────────────────────────────────────────────────
// Routes are the connection points (end points - addresses) in a web service where clients send requests to interact with the service.
// GET all customers
app.get("/api/customers", (req, res) => {
  res.json(customers); // Respond with the list of all products
});

// GET a single customer by ID
app.get("/api/customers/:id", (req, res) => {
  const customer = customers.find((p) => p.id === parseInt(req.params.id)); // Find the product by ID
  if (!customer) return res.status(404).json({ error: "Product not found" }); // If not found, respond with 404
  res.json(customer); // Respond with the found customer
});

// POST - Add a new customer
app.post("/api/customers", (req, res) => {
  const { name, email,phone,city } = req.body; // Extract customer attributes from the request body
  if (!name || !email|| !phone || !city)
    return res.status(400).json({ error: "Invalid input" }); // Validate input

  const newCustomer = { id: customers.length + 1, name, email,phone,city }; // Add a new customer with a unique ID
  customers.push(newCustomer); // Add the new customer to the list
  res.status(201).json(newCustomer); // Respond with the added customer
});


// PUT - Replace a customer Record (full replacement)
app.put("/api/customers/:id", (req, res) => {
  const { name, email,phone,city } = req.body;

  if (!name || !email|| !phone || !city){
    return res.status(400).json({
      error: "PUT /customers requires ALL mutable fields for full replacement."
    });
  }

  // 3. Find the customer
  const customer = customers.find((p) => p.id === parseInt(req.params.id));
  if (!customer) {
    return res.status(404).json({ error: "Customer not found" });
  }

  // 4. Update/Replace: Directly assign ALL new values.
  customer.name = name;
  customer.email = email;
  customer.phone = phone;
  customer.city = city;

  // 5. Respond with the fully updated customer
  res.json(customer);
});

// PATCH - Modify a customer (partial or full replacement)
app.patch("/api/customers/:id", (req, res) => {
  const customer = customers.find((p) => p.id === parseInt(req.params.id)); // Find the customer by ID
  if (!customer) return res.status(404).json({ error: "Customer not found" }); // If not found, respond with 404

  const { name, email,phone,city } = req.body; // Extract the customer's info from the request body
  customer.name = name || customer.name; // Update the customer name if provided
  customer.email = email || customer.email;
  customer.phone = phone || customer.phone;
  customer.city = city || customer.city;

  res.json(customer); // Respond with the updated customer
});

// DELETE - Remove a customer
app.delete("/api/customers/:id", (req, res) => {
  const customerIdToDelete = parseInt(req.params.id);

  // 1. Check if the customer exists before filtering
  const initialLength = customers.length;

  // 2. Remove the customer by ID using filter
  customers = customers.filter((p) => p.id !== customerIdToDelete);

  // 3. Check if the length of the array changed
  const finalLength = customers.length;

  if (finalLength < initialLength) {
    // Customer was found and deleted

    // Status Code 204 No Content is often preferred for successful DELETE requests
    // because there is no content to return in the response body.
    res.status(204).end();
  } else {
    // Customer was NOT found

    // Status Code 404 Not Found is appropriate for an attempt to operate on a
    // resource that does not exist.
    res.status(404).json({
      error: `Customer with ID ${customerIdToDelete} not found.`
    });
  }
});

// ───────────────────────────────────────────────────────────────
// Start Express HTTP Server
// ───────────────────────────────────────────────────────────────
app.listen(PORT, () => {
  console.log(`Server running on http://localhost:${PORT}`);
});
