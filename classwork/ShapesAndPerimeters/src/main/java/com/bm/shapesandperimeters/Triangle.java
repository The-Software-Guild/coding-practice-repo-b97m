/**
 *
 * @author Benjamin Munoz
 * email: driver396@gmail.com
 * date: Jul 27, 2021
 * purpose: (TODO)
 */

package com.bm.shapesandperimeters;


public class Triangle extends Shape {

    private double sideA, sideB, angle;
    
    public Triangle(double sideA, double sideB, double angle) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.angle = angle;
    }
    
    @Override
    public double getArea() {
        return 0.5 * this.sideA * this.sideB * Math.sin(this.angle);
    }

    @Override
    public double getPerimeter() {
        // using law of cosines to compute the remaining side length
        // C^2 = A^2 + B^2 - 2ABcos(theta)
        double c = this.sideA * this.sideA;
        c += this.sideB * this.sideB;
        c -= 2 * this.sideA * this.sideB * Math.cos(this.angle);
        c = Math.sqrt(c);
        
        return this.sideA + this.sideB + c;
    }

}
