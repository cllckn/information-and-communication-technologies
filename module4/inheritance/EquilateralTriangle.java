package cc.ku.ict.modul4.inheritance;

// Another subclass of Shape with unique implementation
public class EquilateralTriangle extends Shape {
    private double sideLength;

    public EquilateralTriangle(int x, int y, String color, double sideLength) {
        super(x, y, color);   // Calls parent constructor
        this.sideLength = sideLength;
    }

    // Specific behavior for Circle
    public double calculateArea() {
        return (Math.sqrt(3) / 4) * Math.pow(sideLength, 2);
    }

    // Overriding parent's toString to extend its behavior
    @Override
    public String toString() {
        return super.toString() + ", Equilateral Triangle with side length " + sideLength;
    }
}
