package cc.ku.ict.module4.polymorphism;

import cc.ku.ict.module4.inheritance.Circle;
import cc.ku.ict.module4.inheritance.Rectangle;
import cc.ku.ict.module4.inheritance.Shape;

public class ShapeRenderer {

    // Polymorphism allows client code (ShapeRenderer) to handle different shapes without modification.
    public void render1(Shape shape) {
        System.out.println(shape);
        //System.out.println("Area = " + shape.calculateArea());
    }

    // Without polymorphism, each new shape would require changes to the client code (printShape2()).
    public void render2(Shape shape) {
        if (shape instanceof Circle) {
            Circle circle = (Circle) shape;
            System.out.println(circle);
            //System.out.println("Area (without polymorphism) = " + circle.calculateArea());
        } else if (shape instanceof Rectangle) {
            Rectangle rectangle = (Rectangle) shape;
            System.out.println(rectangle);
            //System.out.println("Area (without polymorphism) = " + rectangle.calculateArea());
        }//...
    }

}
