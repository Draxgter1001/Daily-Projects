public class Rectangle {

    private float width;
    private float height;

    public Rectangle(float width, float height) {
        if(width > 0 && height > 0){
            this.width = width;
            this.height = height;
        }else throw new IllegalArgumentException("width or height cannot be negative");
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

}
