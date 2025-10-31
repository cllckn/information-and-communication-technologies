package cc.ku.ict.module4.exercises.exercise2;

public class Customer extends User {
    private int loyaltyPoints;

    public Customer(int id, String name, String email, String username, String password, String role, int loyaltyPoints) {
        super(id, name, email, username, password, role);
        this.loyaltyPoints = loyaltyPoints;
    }

    public void setLoyaltyPoints(int loyaltyPoints) {
        this.loyaltyPoints = loyaltyPoints;
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString() +
                "loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
