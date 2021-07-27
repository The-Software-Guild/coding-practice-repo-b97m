/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: (TODO)
 */

package com.bm.shapesandperimeters;


public class ShapeTester {
    public static void main(String[] args) {
        Shape[] testShapes = {
            new Square(2),
            new Rectangle(3, 4),
            new Triangle(3, 4, Math.PI / 2.0),
            new Circle(5)
        };

        for (int i = 0; i < testShapes.length; i++) {
            System.out.format("-- Shape %2d -- %n", i);
            System.out.format("     area: %f%n", testShapes[i].getArea());
            System.out.format("perimeter: %f%n", testShapes[i].getArea());
            System.out.println();
        }
    }
}
