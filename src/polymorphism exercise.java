  class Shape {
    String name;

    Shape(String name) {
        this.name = name;

    }
    double calculateArea() {
        return 0;
    }

    
}

class Circle extends Shape {
    double radius;

    Circle(double radius) {
        super ("Circle");
        this.radius = radius;
 }

 @Override 
 double calculateArea() {
    return radius * radius * Math.PI;
 }
}
class Rectangle extends Shape {
    double length, width;

    Rectangle(double length, double width) {
        super ("Rectangle");
        this.length = length;
        this.width = width;

    }

    @Override 
    double calculateArea() {
        return length * width;
    }
}
public class main {
    public static void main(String[] args) {
        Shape s1 = new Shape ("Generic shape");
        Shape s2 = new Circle(5);
        Shape s3 = new Rectangle(4, 6);

System.out.println(s1.name + "area:" + s1. calculateArea());
System.out.println(s2.name + "area:" + s2. calculateArea());
System.out.println(s3.name + "area:" + s3. calculateArea());
    }
}