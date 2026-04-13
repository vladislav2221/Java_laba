package academy.tochkavhoda.figures.v3;

import java.util.Objects;

public class Rectangle extends Figure {

    private Point topLeft;
    private Point bottomRight;

    public Rectangle(Point topLeft, Point bottomRight) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
    }

    public Rectangle(int x1, int y1, int x2, int y2) {
        this(new Point(x1, y1), new Point(x2, y2));
    }

    public Rectangle(int length, int width) {
        this(new Point(0, 0), new Point(length, width));
    }

    public Rectangle() {
        this(new Point(0, 0), new Point(1, 1));
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();

        topLeft = new Point(x, y);
        bottomRight = new Point(x + length, y + width);
    }

    public void moveTo(Point p) {
        moveTo(p.getX(), p.getY());
    }

    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int length = (int) (getLength() * ratio);
        int width = (int) (getWidth() * ratio);

        bottomRight = new Point(topLeft.getX() + length,
                topLeft.getY() + width);
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX()
                && x <= bottomRight.getX()
                && y >= topLeft.getY()
                && y <= bottomRight.getY();
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public boolean isIntersects(Rectangle r) {
        return !(r.bottomRight.getX() <= topLeft.getX()
                || r.topLeft.getX() >= bottomRight.getX()
                || r.bottomRight.getY() <= topLeft.getY()
                || r.topLeft.getY() >= bottomRight.getY());
    }

    public boolean isInside(Rectangle r) {
        return isInside(r.topLeft)
                && isInside(r.bottomRight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Rectangle)) return false;

        Rectangle that = (Rectangle) o;

        return Objects.equals(topLeft, that.topLeft)
                && Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight);
    }
}