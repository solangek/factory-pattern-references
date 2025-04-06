package lambdafactory;

import hac.*;

import java.util.HashMap;
import java.util.Map;

/**
 * ShapeFactoryLambda is a factory class that uses lambda expressions to create
 * different shapes. It uses a map to associate shape types with their respective
 * creation logic.
 * Note that in order to pass a lambda function to the map, we need to use a functional interface,
 * see the example in the hac package for a more complete example.
 */
public class ShapeFactoryLambda {

    /**
     * This is where we register new classes of shapes.
     * the lambda expression is a reference to the constructor of the shape
     * and is mapped to the shape type. Because we are using a functional interface,
     * we can use a lambda expression to create the shape.
     */
    private static Map<ShapeType, ShapeCreator> map = new HashMap<>();
    static {
        map.put(ShapeType.CIRCLE, () -> new Circle());
        map.put(ShapeType.RECTANGLE, () -> new Rectangle());
        map.put(ShapeType.TRIANGLE, () -> new Triangle());
    }

    /**
     * The factory main method creates a shape based on the type.
     * @param shapeType the type of shape to create
     * @return the shape - throws an IllegalArgumentException if the shape type is not supported
     */
    public Shape createShape(ShapeType shapeType) {
        // get the supplier for the shape type: a reference to the "new" method
        // this is equivalent to calling the constructor of the shape
        Shape shape = map.get(shapeType).create();
        if (shape == null) {
            throw new IllegalArgumentException("Shape type not supported: " + shapeType);
        }
        return shape;
    }

    /**
     * This is a functional interface that defines a single method to create a shape.
     * It is used to pass the creation logic of shapes to the factory.
     */
    private interface ShapeCreator {
        Shape create();
    }

}
