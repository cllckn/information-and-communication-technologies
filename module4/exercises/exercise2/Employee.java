package cc.ku.ict.module4.exercises.exercise2;

public class Employee extends User {
    private double salary;
    private String department;

    public Employee(int id, String name, String email, String username, String password, String role, double salary, String department) {
        super(id, name, email, username, password, role);
        this.salary = salary;
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString() +
                "salary=" + salary +
                ", department='" + department + '\'' +
                '}';
    }
}
