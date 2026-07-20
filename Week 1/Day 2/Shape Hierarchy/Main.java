import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 Shape is an abstract class because we are using it to define the characteristic of our object types, therefore specifying
 what an object is.
 Drawable is an interface because we are defining the capabilities of our object types, in this case, capable of being
 able to be drawn itself, therefore specifying what the objects are capable do.

 If Shape was an interface, the body of describe() must be empty methods of an interface has an empty body. It also, cannot
 hold a constructor, therefore we cannot create a Shape object as interfaces cannot create objects in the first place, and
 lastly, methods and variables are all public, therefore encapsulation cannot be applied.
 */

public class Main {
    static List<Shape> shapeList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args){
        boolean exit = false;

        while(!exit){
            System.out.print("Enter Shape Name: ");
            String name = input.nextLine();

            if(name.equalsIgnoreCase("Circle")){
                System.out.print("Enter Radius: ");
                double radius = input.nextDouble();
                input.nextLine();
                shapeList.add(new Circle(radius));
            }else if(name.equalsIgnoreCase("Rectangle")){
                System.out.print("Enter width: ");
                double width = input.nextDouble();
                input.nextLine();
                System.out.print("Enter height: ");
                double height = input.nextDouble();
                input.nextLine();
                shapeList.add(new Rectangle(width, height));
            }else if(name.equalsIgnoreCase("Triangle")){
                System.out.print("Enter side a: ");
                double a = input.nextDouble();
                input.nextLine();
                System.out.print("Enter side b: ");
                double b = input.nextDouble();
                input.nextLine();
                System.out.print("Enter side c: ");
                double c = input.nextDouble();
                input.nextLine();
                shapeList.add(new Triangle(a, b, c));
            }

            System.out.print("You want to enter another shape, input y/n: ");
            String answer = input.nextLine();
            if(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")){
                printShapeList(shapeList);
                totalArea(shapeList);
                System.out.println("\n--- Drawing Circles and Rectangles ---");
                drawDrawable(shapeList);
                System.out.println("----------------------------------------");
                System.out.print("Do you want to see the shape with the highest Area, input y/n: ");
                answer = input.nextLine();
                System.out.println();
                if(answer.equalsIgnoreCase("y") || answer.equalsIgnoreCase("yes")){
                    getMaxArea(shapeList);
                }else  if(answer.equalsIgnoreCase("n") || answer.equalsIgnoreCase("no")){
                    exit = true;
                }
            }
        }
    }

    public static void getMaxArea(List<Shape> shapeList){
        double maxArea = 0;
        String shapeName = "";
        for(int i = 0; i < shapeList.size(); i++){
            if(shapeList.get(i).area() > maxArea){
                maxArea = shapeList.get(i).area();
                shapeName = shapeList.get(i).toString();
            }
        }
        System.out.println("Highest Area: " + shapeName + " is " + maxArea);
    }

    public static void printShapeList(List<Shape> shapeList){
        for(int i = 0; i < shapeList.size(); i++){
            System.out.println(shapeList.get(i).describe());
        }
    }

    public static void drawDrawable(List<Shape> shapeList){
        for(Shape shape: shapeList){
            if(shape instanceof Drawable drawable){
                drawable.draw();
            }
        }
    }

    public static void totalArea(List<Shape> shapeList){
        double totalArea = 0;
        for(Shape shape: shapeList){
            totalArea += shape.area();
        }

        System.out.println("Total Area: " + totalArea);
    }
}
