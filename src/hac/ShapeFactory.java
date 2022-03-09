package hac;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * ShapeFactory is a factory for creating shapes.
 * Based on method references (as opposed to lambda expressions or anonymous classes).
 * see https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/function/package-summary.html
 */
public class ShapeFactory {

    final static Map<ShapeType, Supplier<Shape>> map = new HashMap<>();

    /**
     * Constructor
     * Supplier is an interface that has a get() method to execute a function.
     * in this case we register a supplier for each shape type which is a reference to the "new" method.
     * The constructors of shapes are zero-argument methods.
     */
    public static void register(ShapeType type, Supplier<Shape> shapeCreateFunction) {
        map.put(type, shapeCreateFunction);
    }

    public Shape getShape(ShapeType shapeType) {
        Supplier<Shape> shapeFunc = map.get(shapeType);
        if (shapeFunc != null) {
            return shapeFunc.get();
        }
        throw new IllegalArgumentException("No such shape in our factory: " + shapeType.name());
    }
}