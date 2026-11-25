const express = require("express");

const app = express();
const PORT = 3000;

app.use(express.json()); // parse JSON request bodies into req.body

// In-memory database
let customers = [
  { id: 1, name: "Jane", email: "j@mail.com", phone: "23232", city: "Astana" },
  { id: 2, name: "Alice", email: "a@mail.com", phone: "23445232", city: "Petropavl" },
];
let nextId = 3; // separate counter: customers.length + 1 can repeat an ID after a delete

// ── Validation ──────────────────────────────────────────────────
// Helpers: a value is valid if it is a non-empty string / looks like an email
const isText = (v) => typeof v === "string" && v.trim().length > 0;
const isEmail = (v) => typeof v === "string" && /^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(v);

// Returns an error message string, or null when the input is valid.
//   partial = false → POST / PUT: every field must be present and valid.
//   partial = true  → PATCH: a field is only checked if the client sent it
//                     (undefined means "not sent", so it is skipped).
function validate({ name, email, phone, city }, partial = false) {
  if ((!partial || name !== undefined) && !isText(name)) return "name is required";
  if ((!partial || email !== undefined) && !isEmail(email)) return "a valid email is required";
  if ((!partial || phone !== undefined) && !isText(phone)) return "phone is required";
  if ((!partial || city !== undefined) && !isText(city)) return "city is required";
  return null;
}

// ── Routes ──────────────────────────────────────────────────────
// GET /api/customers → list all
app.get("/api/customers", (req, res) => {
  res.json(customers);
});

// GET /api/customers/:id → read one (404 if missing)
app.get("/api/customers/:id", (req, res) => {
  const customer = customers.find((c) => c.id === Number(req.params.id));
  if (!customer) return res.status(404).json({ error: "Customer not found" });
  res.json(customer);
});

// POST /api/customers → create (all fields required)
app.post("/api/customers", (req, res) => {
  const error = validate(req.body);
  if (error) return res.status(400).json({ error }); // 400 = bad input

  const { name, email, phone, city } = req.body;
  const newCustomer = { id: nextId++, name, email, phone, city }; // server assigns the ID
  customers.push(newCustomer);
  res.status(201).json(newCustomer); // 201 = created
});

// PUT /api/customers/:id → FULL replacement
// The client must send ALL fields; any field left out is an error, not "keep the old value".
app.put("/api/customers/:id", (req, res) => {
  const customer = customers.find((c) => c.id === Number(req.params.id));
  if (!customer) return res.status(404).json({ error: "Customer not found" });

  const error = validate(req.body); // strict: every field required
  if (error) return res.status(400).json({ error });

  const { name, email, phone, city } = req.body;
  Object.assign(customer, { name, email, phone, city }); // overwrite all fields; id is untouched
  res.json(customer);
});

// PATCH /api/customers/:id → PARTIAL update
// The client sends only the fields to change; everything else stays as is.
app.patch("/api/customers/:id", (req, res) => {
  const customer = customers.find((c) => c.id === Number(req.params.id));
  if (!customer) return res.status(404).json({ error: "Customer not found" });

  const error = validate(req.body, true); // lenient: only validate fields that were sent
  if (error) return res.status(400).json({ error });

  const { name, email, phone, city } = req.body;
  // `cond && { field }` adds the field only when it was sent; spreading `false` adds nothing
  Object.assign(customer, {
    ...(name !== undefined && { name }),
    ...(email !== undefined && { email }),
    ...(phone !== undefined && { phone }),
    ...(city !== undefined && { city }),
  });
  res.json(customer);
});

// DELETE /api/customers/:id → remove (404 if missing)
app.delete("/api/customers/:id", (req, res) => {
  const index = customers.findIndex((c) => c.id === Number(req.params.id));
  if (index === -1) return res.status(404).json({ error: "Customer not found" });

  customers.splice(index, 1);
  res.status(204).end(); // 204 = success, no body
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