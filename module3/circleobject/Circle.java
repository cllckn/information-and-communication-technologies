package cc.ku.ict.module3.circleobject;

public class Circle
{
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
    public double calculateArea(){
        return Math.pow(radius, 2) * Math.PI;
    }

    // ============================
    // Constructors
    // ============================
    // Constructors are special methods used to initialize objects.
    // They initialize the object with given values.

    // No-parameter constructor (Default constructor)
    // This sets some default values for a new Circle object
  /*  public Circle() {
        this.x = 0;         // Default X coordinate
        this.y = 0;         // Default Y coordinate
        this.radius = 1;    // Default radius (a minimal circle)
        this.color = "Black"; // Default color
    }

    // Full constructor: initializes all attributes
    public Circle(int x, int y, int radius, String color) {
        this.x = x;          // "this" refers to the current object
        this.y = y;
        this.radius = radius;
        this.color = color;
    }

    // Overloaded constructor: initializes only coordinates
    // Radius and color can be set later using setters
    public Circle(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // ============================
    // Getters and Setters (Accessors and Mutators)
    // ============================
    // These methods provide controlled access to private fields.

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }
*/
    // ============================
    // Object Representation
    // ============================
    // This method returns a human-readable description of the object.
    // It is called automatically when we print the object.
    @Override
    public String toString() {
        return "Circle{" +
                "x=" + x +
                ", y=" + y +
                ", radius=" + radius +
                ", color='" + color + '\'' +
                '}';
    }
}
