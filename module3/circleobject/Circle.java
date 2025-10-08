package cc.ku.ict.module3.circleobject;

public class Circle {
    // ============================
    // Fields (Attributes / Properties)
    // ============================
    // These describe the state of a Circle object.
    // They are kept private to follow the principle of "encapsulation".
    // Access is provided through getters and setters.
    private int x;        // X coordinate of the circle's center
    private int y;        // Y coordinate of the circle's center
    private int radius;   // Radius of the circle
    private String color; // Color of the circle

    // ============================
    // Methods (Behaviors)
    // ============================

    // Calculates the area of the circle using the formula: π * r^2
    public double calculateArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    //@Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
