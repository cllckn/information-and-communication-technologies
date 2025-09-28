package cc.ku.ict.module3.collections;

// Class representing a Book object
public class Book {
    // Attributes (fields) of the Book
    private String name;        // Title of the book
    private double unitPrice;   // Price of the book

    // Constructor: initializes Book with a name and unit price
    public Book(String name, double unitPrice) {
        this.name = name;
        this.unitPrice = unitPrice;
    }

    // Getter for 'name' (accessor)
    public String getName() {
        return name;
    }

    // Setter for 'name' (mutator) – allows updating the book name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for 'unitPrice'
    public double getUnitPrice() {
        return unitPrice;
    }

    // toString method: returns a readable text representation of a Book object
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", unitPrice=" + unitPrice +
                '}';
    }
}
