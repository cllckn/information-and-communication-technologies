package cc.ku.ict.module3.collections;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionsMain {

    public static void main(String[] Args) {

        // ------------------------------
        // Static Array Initialization
        // ------------------------------
        // Fixed size determined at compile-time.
        // Cannot be resized during execution.
        int[] numbers = {10, 20, 30, 40, 50};

        // A static array with predefined size (8).
        double[] decimals = new double[8];
        System.out.println("Length of decimals array = " + decimals.length);

        // ------------------------------
        // Dynamic Array Initialization (ArrayList)
        // ------------------------------
        // Unlike static arrays, dynamic arrays can grow/shrink as needed.
        List<Book> books = new ArrayList<>(4);

        // Create Book objects
        Book book1 = new Book("Database Management Systems", 100.00);
        Book book2 = new Book("Object Oriented Programming", 125.00);
        Book book3 = new Book("Data Structures", 250.00);
        Book book4 = new Book("Network Programming", 350.00);

        // Add Book objects into the ArrayList
        books.add(book1);
        books.add(book2);
        books.add(new Book("UML", 160.00));
        books.add(book3);
        books.add(book4);

        // Print using default toString() of ArrayList
        System.out.println("All books (using ArrayList toString): " + books);

        //Remove Book objects from the ArrayList
        books.remove(book4);

        // ------------------------------
        // Traversing the Collection
        // ------------------------------

        // Traditional for loop (index-based access)
        for (int i = 0; i < books.size(); i++) {
            System.out.println("Index " + i + ": " + books.get(i));
        }

        // Enhanced for-each loop
        for (Book book : books) {
            System.out.println("Book name (for-each): " + book.getName());
        }

        // ------------------------------
        // Functional Programming (Lambda Expressions)
        // ------------------------------

        // forEach with lambda expression (prints each book)
        System.out.println("************* Lambda forEach - Full Objects *************");
        books.forEach(book -> System.out.println(book));

        // forEach with lambda expression (prints only book names)
        System.out.println("************* Lambda forEach - Book Names *************");
        books.forEach(book -> System.out.println(book.getName()));

        // ------------------------------
        // Summation Example
        // ------------------------------

        // Using traditional for loop
        double sum = 0;
        for (int i = 0; i < books.size(); i++) {
            sum += books.get(i).getUnitPrice();
        }
        System.out.println("Total unit price (for loop) = " + sum);

        // Using streams (Functional Programming (Lambda Expressions))
        sum = books
                .stream() // Convert collection to a stream
                .mapToDouble(item -> item.getUnitPrice()) // Extract unit price
                .sum(); // Compute total
        System.out.println("Total unit price (stream) = " + sum);

        // Using parallel streams (multi-threaded, may improve performance for large collections)
        sum = books
                .stream()
                .parallel()
                .mapToDouble(item -> item.getUnitPrice())
                .sum();
        System.out.println("Total unit price (parallel stream) = " + sum);

        // ------------------------------
        // Filtering Example
        // ------------------------------

        // Keep only books whose names start with "D"
        List<Book> filteredBooks = books
                .stream()
                .filter(item -> item.getName().startsWith("D"))
                .toList(); // Collect results into a new List
        System.out.println("Filtered books (names start with D): " + filteredBooks);

        // ------------------------------
        // Sorting Example
        // ------------------------------

        // Sort books alphabetically by name
        List<Book> sortedAndFilteredBooks = books
                .stream()
                .sorted(Comparator.comparing(Book::getName)) // Ascending order
                //.sorted(Comparator.comparing(Book::getName).reversed()) // Uncomment for descending
                .toList();
        System.out.println("Books sorted by name: " + sortedAndFilteredBooks);
    }
}
