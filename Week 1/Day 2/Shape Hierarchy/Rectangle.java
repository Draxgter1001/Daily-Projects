public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height) {
        super("Rectangle");
        if(width > 0 && height > 0){
            this.width = width;
            this.height = height;
        }else throw new IllegalArgumentException("width or height cannot be negative");
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public double area(){
        return getWidth() * getHeight();
    }

    @Override
    public double perimeter() {
        return (getWidth() + getHeight()) * 2;
    }


}
