package cc.ku.ict.modul4.inheritance;

// Base class (parent, superclass)
public class Shape {
    protected int x;
    protected int y;             // Common coordinates for all shapes
    protected String color;      // Common color property

    // Constructor: initializes common attributes
    public Shape(int x, int y, String color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    // Common string representation
    public String toString() {
        return "Shape at (" + x + "," + y + ") with color " + color;
    }
}
