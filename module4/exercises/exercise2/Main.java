package cc.ku.ict.module4.exercises.exercise2;

public class Main {

    public static void main(String[] args) {

        System.out.println("test");

        User user=new User(1,"Jane","j@gmail.com","jane","123456","admin");
        System.out.println(user.toString());

        Customer customer=new Customer(2,"Jack","jack@gmail.com","jack","123456","customer",5);
        System.out.println(customer.toString());

        Employee employee=new Employee(3,"Joe","joe@gmail.com","joe","12345dd6","employee", 400.0,"IT");
        System.out.println(employee.toString());

        customer.setLoyaltyPoints(7);

        System.out.println(customer.toString());
    }

}
