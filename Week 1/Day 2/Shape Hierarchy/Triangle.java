public class Triangle extends Shape {

    private double a;
    private double b;
    private double c;

    public Triangle(double a, double b, double c){
        super("Triangle");
        if(!(a + b > c)){
            throw new IllegalArgumentException("What you entered is not a valid triangle!");
        }else if(a > 0 && b > 0 && c > 0){
            this.a = a;
            this.b = b;
            this.c = c;
        }else throw new IllegalArgumentException("All sides must be positive!");
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
        return (getA() + getB() + getC()) / 2;
    }

    //Heron's formula
    @Override
    public double area() {
        double s = perimeter() / 2;
        return Math.sqrt(s* (s - getA()) * (s - getB()) * (s - getC()));
    }


}
