public class Circle extends Shape implements Drawable {
    private final double radius;

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

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + getName() + " with radius " + getRadius());
        int r = (int) Math.floor(getRadius());

        for(int i = -r; i <= r; i++){
            for(int j = -r; j <= r; j++){
                if(i * i + j * j <= r * r){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
