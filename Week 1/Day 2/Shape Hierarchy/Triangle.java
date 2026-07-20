public class Triangle extends Shape {

    private final double a;
    private final double b;
    private final double c;

    public Triangle(double a, double b, double c){
        super("Triangle");
        if(!(a > 0 && b > 0 && c > 0)){
            throw new IllegalArgumentException("All sides must be positive!");
        }else if(a + b <= c || a + c <= b || b + c <= a){
            throw new IllegalArgumentException("What you entered is not a valid triangle!");
        }else {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    public double getA(){
        return a;
    }

    public double getB(){
        return b;
    }

    public double getC(){
        return c;
    }

    @Override
    public double perimeter() {
        return (getA() + getB() + getC());
    }

    //Heron's formula
    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s* (s - getA()) * (s - getB()) * (s - getC()));
    }

    @Override
    public String toString() {
        return getName();
    }
}
