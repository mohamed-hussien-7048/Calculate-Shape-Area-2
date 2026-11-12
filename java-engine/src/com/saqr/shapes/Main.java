
package com.saqr.shapes;

import com.saqr.shapes.models.Circle;
import com.saqr.shapes.models.Rectangle;
import com.saqr.shapes.models.Shape;

public class Main {

    public static void main(String[] args) {

        Shape circle = new Circle(5);
        Shape rectangle = new Rectangle(4, 6);

        Shape[] shapes = {circle, rectangle};

        for (Shape shape : shapes) {
            System.out.printf(
                "%s Area: %.2f%n",
                shape.getName(),
                shape.calculateArea()
            );
        }
    }
}
