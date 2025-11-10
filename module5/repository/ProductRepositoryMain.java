package cc.ku.ict.module5.repository;

public class ProductRepositoryMain {

    public static void main(String[] args) {
        // Swap implementations easily
        IProductRepository repository = new ProductPostgresqlImplementation();
        //IProductRepository repository = new ProductMongodbImplementation();

        ClientService service = new ClientService(repository);
        service.run();
    }
}
