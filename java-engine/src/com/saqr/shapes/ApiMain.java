
package com.saqr.shapes;

import com.saqr.shapes.models.Circle;
import com.saqr.shapes.models.Rectangle;
import com.saqr.shapes.models.Shape;

import java.util.Scanner;
import java.util.Locale;

public class ApiMain {

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            if (!scanner.hasNextLine()) {
                throw new IllegalArgumentException("No input provided.");
            }

            String input = scanner.nextLine().trim();
            String[] parts = input.split("\\|");

            Shape shape;

            if (parts[0].equalsIgnoreCase("CIRCLE")

                    && parts.length == 2) {

                double radius = Double.parseDouble(parts[1]);
                shape = new Circle(radius);

            } else if (parts[0].equalsIgnoreCase("RECTANGLE")
                    && parts.length == 3) {

                double width = Double.parseDouble(parts[1]);
                double height = Double.parseDouble(parts[2]);

                shape = new Rectangle(width, height);

            } else {
                throw new IllegalArgumentException("Invalid shape input.");
            }

            System.out.printf(
                Locale.US,
                "{\"success\":true,\"shape\":\"%s\",\"area\":%.2f}%n",
                shape.getName(),
                shape.calculateArea()
            );

        } catch (Exception error) {

            System.out.println(
                "{\"success\":false,\"message\":\"Invalid input or shape dimensions.\"}"
            );
        }
    }
}
