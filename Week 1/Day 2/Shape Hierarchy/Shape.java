public abstract class Shape {

    private String name;

    public Shape(String name) {
        this.name = name;
        if(name == null) throw new IllegalArgumentException("name must not be null or empty!");
    }

    public String getName(){
        return name;
    }

    public abstract double area();
    public abstract double perimeter();

    public String describe(){
        return name + "  -> Area: %.2f, Perimeter: %.2f".formatted(area(), perimeter());
    }

}
