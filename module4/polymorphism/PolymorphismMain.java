package cc.ku.ict.modul4.polymorphism;

import cc.ku.ict.modul4.inheritance.Circle;
import cc.ku.ict.modul4.inheritance.Rectangle;
import cc.ku.ict.modul4.inheritance.Shape;


public class PolymorphismMain {

    public static void main(String[] args) {
        Shape[] shapes = new Shape[] {
                new Circle(0, 0, "Yellow", 5.0),
                new Rectangle(1, 1, "Blue", 4.0, 6.0),
                //new EquilateralTriangle(2, 2, "Green", 3.0)
        };

        // To draw each shape
        ShapeRenderer shapeRenderer = new ShapeRenderer();

        // Draw each shape
        for (Shape shape : shapes) {
            // with polymorphism
            //shapeRenderer.render1(shape);

            //without polymorphism
            shapeRenderer.render2(shape);
        }
    }
}
