package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import java.util.Objects;

public class Ellipse extends Figure implements Colored {

    private Point center;
    private int xAxis;
    private int yAxis;
    private Color color;

    // =====================
    // Constructors (Color)
    // =====================

    public Ellipse(Point center, int xAxis, int yAxis, Color color) {
        this.center = center;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.color = color;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis, Color color) {
        this.center = new Point(xCenter, yCenter);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.color = color;
    }

    public Ellipse(int xAxis, int yAxis, Color color) {
        this.center = new Point(0, 0);
        this.xAxis = xAxis;
        this.yAxis = yAxis;
        this.color = color;
    }

    public Ellipse(Color color) {
        this.center = new Point(0, 0);
        this.xAxis = 1;
        this.yAxis = 1;
        this.color = color;
    }

    public Ellipse() {
        this.center = new Point(0, 0);
        this.xAxis = 1;
        this.yAxis = 1;
        this.color = Color.RED;
    }

    // =====================
    // Constructors (String)
    // =====================

    public Ellipse(Point center, int xAxis, int yAxis, String color) throws ColorException {
        this(center, xAxis, yAxis, Color.colorFromString(color));
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis, String color) throws ColorException {
        this(xCenter, yCenter, xAxis, yAxis, Color.colorFromString(color));
    }

    public Ellipse(int xAxis, int yAxis, String color) throws ColorException {
        this(xAxis, yAxis, Color.colorFromString(color));
    }

    // =====================
    // Colored interface
    // =====================

    @Override
    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }

    // =====================
    // Getters / Setters
    // =====================

    public Point getCenter() {
        return center;
    }

    public int getXAxis() {
        return xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    // =====================
    // Geometry
    // =====================

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
        xAxis = (int) (xAxis * ratio);
        yAxis = (int) (yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (xAxis * xRatio);
        yAxis = (int) (yAxis * yRatio);
    }

    public double getArea() {
        return Math.PI * (xAxis / 2.0) * (yAxis / 2.0);
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((xAxis * xAxis + yAxis * yAxis) / 8.0);
    }

    public boolean isInside(int x, int y) {
        double dx = x - center.getX();
        double dy = y - center.getY();
        double a = xAxis / 2.0;
        double b = yAxis / 2.0;
        return (dx * dx) / (a * a) + (dy * dy) / (b * b) <= 1;
    }

    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }

    // =====================
    // equals / hashCode
    // =====================

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ellipse)) return false;

        Ellipse ellipse = (Ellipse) o;

        return xAxis == ellipse.xAxis
                && yAxis == ellipse.yAxis
                && Objects.equals(center, ellipse.center)
                && color == ellipse.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(center, xAxis, yAxis, color);
    }
}