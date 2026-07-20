public class Rectangle extends Shape implements Drawable {

    private final double width;
    private final double height;

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

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void draw() {
        System.out.println("Drawing a " + getName() + " [" + getWidth() + " x " + getHeight() + "]");

        int w = (int) getWidth();
        int h = (int) getHeight();

        for(int i = 0; i < h; i++){
            for(int j = 0; j < w; j++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}
