public class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        if(radius > 0){
            this.radius = radius;
        }else throw new IllegalArgumentException("Radius must be positive");

    }

    public double getRadius() {
        return radius;
    }

    @Override
    public double area() {
        return getRadius() * getRadius() * Math.PI;
    }

    @Override
    public double perimeter() {
        return 2 * Math.PI * getRadius();
    }

}
