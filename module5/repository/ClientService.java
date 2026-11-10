package cc.ku.ict.module5.repository;


import java.util.List;
import java.util.Scanner;

public class ClientService {

    private final IProductRepository productRepository;

    public ClientService(IProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void run() {

        Scanner input = new Scanner(System.in);
        System.out.println("=== Starting Database Operations ===");

        System.out.println("--- Inserting a new record ---");
        Product savedProduct = productRepository.save(new Product("Laptop", 1500.0));
        if (savedProduct != null) {
            System.out.println("Saved product: " + savedProduct);
        } else {
            System.out.println("Failed to save Laptop product.");
        }


        System.out.println("--- Searching for a product---");

        System.out.println("Find product by ID :");
        System.out.println("Enter product id");
        int id = input.nextInt();
        Product found = productRepository.findById(id);
        System.out.println(found != null ? found : "Product not found.");

        System.out.println("--- Listing all products ---");
        List<Product> products = productRepository.findAll();
        products.forEach(product -> System.out.println(product));

        System.out.println("--- Updating product ---");

        System.out.println("Enter product id");
        id = input.nextInt();input.nextLine();
        System.out.println("Enter product name");
        String name = input.nextLine();
        System.out.println("Enter product price");
        double price = input.nextDouble();
        productRepository.update(new Product(id, name, price));

        System.out.println("--- Deleting product ---");
        System.out.println("Enter product id");
        id = input.nextInt();
        productRepository.deleteById(id);

        System.out.println("=== Operations completed ===");
    }
}
