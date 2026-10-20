package cc.ku.ict.module4.polymorphism;

// Another subclass of Shape
public class Rectangle extends Shape {
    private double width;
    private double height;   // Unique attributes

    // Constructor chaining to Shape
    public Rectangle(int x, int y, String color, double width, double height) {
        super(x, y, color);
        this.width = width;
        this.height = height;
    }

    // Rectangle-specific behavior
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String draw(){
        return super.draw() + ", " + width + ", " + height;
    }

    // Overriding parent's toString to extend its behavior
    @Override
    public String toString() {
        return super.toString() + ", Rectangle with width " + width + " and height " + height;
    }
}
