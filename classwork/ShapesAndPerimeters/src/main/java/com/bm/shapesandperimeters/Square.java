/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: (TODO)
 */

package com.bm.shapesandperimeters;


public class Square extends Shape {    
    private double sideLength;
    public Square(double sideLength) {        
        this.sideLength = sideLength;
    }
    
    @Override
    public double getArea() {
        return this.sideLength * this.sideLength;
    }

    @Override
    public double getPerimeter() {
        return 4 * this.sideLength;
    }
}
