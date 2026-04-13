package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class Circle extends Figure implements Colored {

    private Point center;
    private int radius;
    private Color color;

    public Circle(Point center, int radius) {
        this.center = center;
        this.radius = radius;
        this.color = Color.RED;
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
        this.color = Color.RED;
    }

    public Circle(int radius) {
        this.center = new Point(0, 0);
        this.radius = radius;
        this.color = Color.RED;
    }

    public Circle() {
        this.center = new Point(0, 0);
        this.radius = 1;
        this.color = Color.RED;
    }

    public Circle(Point center, int radius, Color color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public Circle(int xCenter, int yCenter, int radius, Color color) {
        this.center = new Point(xCenter, yCenter);
        this.radius = radius;
        this.color = color;
    }

    public Circle(int radius, Color color) {
        this.center = new Point(0, 0);
        this.radius = radius;
        this.color = color;
    }

    public Circle(Color color) {
        this.center = new Point(0, 0);
        this.radius = 1;
        this.color = color;
    }

    public Circle(Point center, int radius, String colorString) throws ColorException {
        this(center, radius, Color.colorFromString(colorString));
    }

    public Circle(int xCenter, int yCenter, int radius, String colorString) throws ColorException {
        this(xCenter, yCenter, radius, Color.colorFromString(colorString));
    }

    public Circle(int radius, String colorString) throws ColorException {
        this(radius, Color.colorFromString(colorString));
    }

    public Circle(String colorString) throws ColorException {
        this(Color.colorFromString(colorString));
    }

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    @Override
    public Color getColor() {
        return color;
    }

    public Point getCenter() {
        return center;
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void moveTo(int x, int y) {
        center = new Point(x, y);
    }

    public void moveTo(Point point) {
        moveTo(point.getX(), point.getY());
    }

    public void moveRel(int dx, int dy) {
        center.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        radius = (int) (radius * ratio);
    }

    public double getArea() {
        return Math.PI * radius * radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    public boolean isInside(int x, int y) {
        int dx = x - center.getX();
        int dy = y - center.getY();
        return dx * dx + dy * dy <= radius * radius;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Circle)) return false;

        Circle circle = (Circle) o;

        return radius == circle.radius
                && Objects.equals(center, circle.center)
                && color == circle.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, color);
    }
}