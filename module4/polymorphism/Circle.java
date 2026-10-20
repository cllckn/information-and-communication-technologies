package cc.ku.ict.module4.polymorphism;

// Derived class (child, subclass)
public class Circle extends Shape {
    private double radius;   // Extra attribute unique to Circle

    // Constructor: initializes inherited + specific properties
    public Circle(int x, int y, String color, double radius) {
        super(x, y, color);   // Calls parent constructor
        this.radius = radius;
    }

    // Specific behavior for Circle
    public double calculateArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    @Override
    public String draw(){
        return super.draw() + ", " + radius;
    }


    @Override
    public String toString() {
        return super.toString() + ", Circle with radius " + radius;
    }
}
