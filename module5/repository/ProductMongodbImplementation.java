package cc.ku.ict.module5.repository;

import com.mongodb.client.*;
import org.bson.Document;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.model.UpdateOptions;

import java.util.ArrayList;
import java.util.List;

public class ProductMongodbImplementation implements IProductRepository {

    private MongoClient mongoClient;
    private MongoDatabase database;
    private MongoCollection<Document> collection;

    // Connect to MongoDB Atlas or local MongoDB
    private void connect() {
        try {
            String connectionString = "mongodb+srv://LectureUser:LecturePassword@cluster0.zxbhndn.mongodb.net/?retryWrites=true&w=majority&appName=Cluster0";
            mongoClient = MongoClients.create(connectionString);
            database = mongoClient.getDatabase("ecommercedb");
            collection = database.getCollection("products");
            System.out.println("Connected to MongoDB database: " + database.getName());
        } catch (Exception e) {
            System.out.println("MongoDB connection failed!");
            e.printStackTrace();
        }
    }

    private void closeConnection() {
        try {
            if (mongoClient != null) {
                mongoClient.close();
                System.out.println("MongoDB connection closed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Product save(Product product) {
        connect();
        try {
            // Generate a random ID if not already set
            if (product.getId() == 0) {
                int randomId = (int) (Math.random() * 100000); // simple random int
                product.setId(randomId);
            }

            Document doc = new Document("id", product.getId())
                    .append("name", product.getName())
                    .append("price", product.getPrice());

            collection.insertOne(doc);

            System.out.println("Product inserted: " + product.getName() + " (ID: " + product.getId() + ")");
            return product;

        } catch (Exception e) {
            System.out.println("Failed to insert product: " + product.getName());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }


    @Override
    public Product findById(int id) {
        connect();
        try {
            Document doc = collection.find(Filters.eq("id", id)).first();
            if (doc != null) {
                Product product = new Product(
                        doc.getInteger("id"),
                        doc.getString("name"),
                        doc.getDouble("price")
                );
                System.out.println("Found product: " + product.getName());
                return product;
            } else {
                System.out.println("No product found with id: " + id);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        connect();
        List<Product> products = new ArrayList<>();
        try (MongoCursor<Document> cursor = collection.find().iterator()) {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                products.add(new Product(
                        doc.getInteger("id"),
                        doc.getString("name"),
                        doc.getDouble("price")
                ));
            }
            System.out.println("Retrieved " + products.size() + " products.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
        return products;
    }

    @Override
    public void update(Product product) {
        connect();
        try {
            collection.updateOne(
                    Filters.eq("id", product.getId()),
                    Updates.combine(
                            Updates.set("name", product.getName()),
                            Updates.set("price", product.getPrice())
                    ),
                    new UpdateOptions().upsert(false)
            );
            System.out.println("Product updated: " + product.getName());
        } catch (Exception e) {
            System.out.println("Failed to update product: " + product.getName());
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }

    @Override
    public void deleteById(int id) {
        connect();
        try {
            collection.deleteOne(Filters.eq("id", id));
            System.out.println("Product with id = " + id + " deleted (if existed).");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnection();
        }
    }
}
