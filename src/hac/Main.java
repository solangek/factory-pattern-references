package hac;

public class Main {

    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();
        shapeFactory.register(ShapeType.CIRCLE, Circle::new);
        shapeFactory.register(ShapeType.RECTANGLE, Rectangle::new);
        shapeFactory.register(ShapeType.TRIANGLE, Triangle::new);

        try {
            Shape shape1 = shapeFactory.getShape(ShapeType.CIRCLE);
            shape1.draw();

            Shape shape2 = shapeFactory.getShape(ShapeType.RECTANGLE);
            shape2.draw();

            Shape shape3 = shapeFactory.getShape(ShapeType.TRIANGLE);
            shape3.draw();

            // generate an exception since Polygon is not registered
            Shape shape4 = shapeFactory.getShape(ShapeType.POLYGON);
        } catch (Exception e) {
            System.out.println("Some error occured: " + e.getMessage());
        }

    }
}
