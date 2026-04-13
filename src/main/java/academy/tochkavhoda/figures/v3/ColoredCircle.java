package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class ColoredCircle extends Figure implements Colored {

    private Point center;
    private int radius;
    private Color color;

    private static Color fromString(String s) throws ColorException {
        if (s == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        return Color.colorFromString(s);
    }

    private static Color check(Color c) throws ColorException {
        if (c == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        return c;
    }

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        this.center = center;
        this.radius = radius;
        this.color = check(color);
    }

    public ColoredCircle(int x, int y, int radius, Color color) throws ColorException {
        this(new Point(x, y), radius, color);
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        this(new Point(0, 0), radius, color);
    }

    public ColoredCircle(Color color) throws ColorException {
        this(new Point(0, 0), 1, color);
    }

    public ColoredCircle() {
        this.center = new Point(0, 0);
        this.radius = 1;
        this.color = Color.RED;
    }

    public ColoredCircle(Point center, int radius, String color) throws ColorException {
        this(center, radius, fromString(color));
    }

    public ColoredCircle(int x, int y, int radius, String color) throws ColorException {
        this(x, y, radius, fromString(color));
    }

    public ColoredCircle(int radius, String color) throws ColorException {
        this(radius, fromString(color));
    }

    public ColoredCircle(String color) throws ColorException {
        this(new Point(0, 0), 1, fromString(color));
    }

    @Override
    public void setColor(Color color) {
        if (color == null) {
            throw new RuntimeException(
                    new ColorException(ColorErrorCode.NULL_COLOR)
            );
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        this.color = fromString(colorString);
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
        this.center = new Point(x, y);
    }

    public void moveTo(Point p) {
        moveTo(p.getX(), p.getY());
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

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredCircle)) return false;

        ColoredCircle that = (ColoredCircle) o;

        return radius == that.radius
                && Objects.equals(center, that.center)
                && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, radius, color);
    }
}