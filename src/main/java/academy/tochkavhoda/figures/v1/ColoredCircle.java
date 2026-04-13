package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredCircle {

    private Point center;
    private int radius;
    private int color;

    public ColoredCircle(Point center, int radius, int color) {
        this.center = center;
        this.radius = radius;
        this.color = color;
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, int color) {
        this(new Point(xCenter, yCenter), radius, color);
    }

    public ColoredCircle(int radius, int color) {
        this(new Point(0,0), radius, color);
    }

    public ColoredCircle(int color) {
        this(1, color);
    }

    public ColoredCircle() {
        this(1,1);
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void moveRel(int dx, int dy) {
        center.setX(center.getX() + dx);
        center.setY(center.getY() + dy);
    }

    public void moveTo(int x, int y) {
        center.setX(x);
        center.setY(y);
    }

    public void moveTo(Point p) {
        moveTo(p.getX(), p.getY());
    }

    public void resize(double ratio) {
        radius = (int)(radius * ratio);
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
        return dx*dx + dy*dy <= radius*radius;
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredCircle)) return false;
        ColoredCircle that = (ColoredCircle) o;
        return radius == that.radius &&
                color == that.color &&
                Objects.equals(center, that.center);
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, color);
    }
}
