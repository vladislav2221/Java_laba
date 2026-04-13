package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Colored;
import academy.tochkavhoda.iface.v2.Stretchable;

import java.util.Objects;

public class ColoredRectangle extends Figure implements Colored, Stretchable {

    private Point topLeft;
    private Point bottomRight;
    private int color;

    public ColoredRectangle(Point topLeft, Point bottomRight, int color) {
        this.topLeft = topLeft;
        this.bottomRight = bottomRight;
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredRectangle(int length, int width, int color) {
        this(new Point(0, 0), new Point(length, width), color);
    }

    public ColoredRectangle(int color) {
        this(1, 1, color);
    }

    public ColoredRectangle() {
        this(1);
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

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    @Override
    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();

        topLeft.setX(x);
        topLeft.setY(y);

        bottomRight.setX(x + length);
        bottomRight.setY(y + width);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    @Override
    public void resize(double ratio) {
        int newLength = (int) (getLength() * ratio);
        int newWidth = (int) (getWidth() * ratio);

        bottomRight.setX(topLeft.getX() + newLength);
        bottomRight.setY(topLeft.getY() + newWidth);
    }

    @Override
    public void stretch(double xRatio, double yRatio) {
        int newLength = (int) (getLength() * xRatio);
        int newWidth = (int) (getWidth() * yRatio);

        bottomRight.setX(topLeft.getX() + newLength);
        bottomRight.setY(topLeft.getY() + newWidth);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle)) return false;

        ColoredRectangle that = (ColoredRectangle) o;

        return color == that.color &&
                Objects.equals(topLeft, that.topLeft) &&
                Objects.equals(bottomRight, that.bottomRight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, color);
    }
    public boolean isInside(int x, int y) {
        return x >= topLeft.getX()
                && x <= bottomRight.getX()
                && y >= topLeft.getY()
                && y <= bottomRight.getY();
    }
    public boolean isInside(Point point) {
        return isInside(point.getX(), point.getY());
    }
    public boolean isIntersects(ColoredRectangle r) {

        return !(r.bottomRight.getX() <= this.topLeft.getX()
                || r.topLeft.getX() >= this.bottomRight.getX()
                || r.bottomRight.getY() <= this.topLeft.getY()
                || r.topLeft.getY() >= this.bottomRight.getY());
    }
    public boolean isInside(ColoredRectangle r) {

        return r.topLeft.getX() >= this.topLeft.getX()
                && r.topLeft.getY() >= this.topLeft.getY()
                && r.bottomRight.getX() <= this.bottomRight.getX()
                && r.bottomRight.getY() <= this.bottomRight.getY();
    }
}