package cc.ku.ict.modul4.inheritance;

// Test class inheritance
public class InheritanceMain {
    public static void main(String[] args) {
        // Instantiate Circle, Rectangle, and EquilateralTriangle subclasses
        Circle circle = new Circle(10, 20, "Red", 5);
        Rectangle rectangle = new Rectangle(15, 25, "Blue", 10, 20);
        EquilateralTriangle triangle = new EquilateralTriangle(5, 5, "Green", 7);

        // Call toString and calculateArea methods
        // Polymorphic behavior: same method name but different implementations

        System.out.println(circle.toString());
        System.out.println("Area of circle: " + circle.calculateArea());

        System.out.println(rectangle.toString());
        System.out.println("Area of rectangle: " + rectangle.calculateArea());

        System.out.println(triangle.toString());
        System.out.println("Area of equilateral triangle: " + triangle.calculateArea());
    }
}
