
package com.saqr.shapes.models;

public class Rectangle extends Shape {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (!Double.isFinite(width) || width <= 0) {
            throw new IllegalArgumentException(
                "Width must be a positive finite number."
            );
        }

        if (!Double.isFinite(height) || height <= 0) {
            throw new IllegalArgumentException(
                "Height must be a positive finite number."
            );
        }

        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double calculateArea() {
        return width * height;
    }

    @Override
    public String getName() {
        return "Rectangle";
    }
}
