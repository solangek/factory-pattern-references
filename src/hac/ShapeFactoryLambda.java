package hac;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class ShapeFactoryLambda {
    final static Map<ShapeType, Supplier<Shape>> map = new HashMap<>();

    public Shape getShape(ShapeType shapeType) {
        Supplier<Shape> shape = map.get(shapeType);
        if (shape != null) {
            return shape.get();
        }
        throw new IllegalArgumentException("No such shape " + shapeType.name());
    }
}