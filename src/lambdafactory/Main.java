package lambdafactory;

import hac.Shape;
import hac.ShapeType;

public class Main {

    public static void main(String[] args) {
        // Example usage of the factory
        ShapeFactoryLambda shapeFactoryLambda = new ShapeFactoryLambda();

        try {
            Shape shape1 = shapeFactoryLambda.createShape(ShapeType.CIRCLE);
            shape1.draw();

            Shape shape2 = shapeFactoryLambda.createShape(ShapeType.RECTANGLE);
            shape2.draw();

            Shape shape3 = shapeFactoryLambda.createShape(ShapeType.TRIANGLE);
            shape3.draw();

            // generate an exception since Polygon is not registered
            Shape shape4 = shapeFactoryLambda.createShape(ShapeType.POLYGON);

        } catch (Exception e) {
            System.out.println("Some error occurred: " + e.getMessage());
        }
    }
}
