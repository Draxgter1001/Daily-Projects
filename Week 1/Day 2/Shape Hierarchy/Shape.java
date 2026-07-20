public abstract class Shape {

    private String name;

    public Shape(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException("name must not be null or empty!");
        this.name = name;
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
