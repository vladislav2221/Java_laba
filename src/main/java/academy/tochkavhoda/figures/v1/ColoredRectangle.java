package academy.tochkavhoda.figures.v1;

import java.util.Objects;

public class ColoredRectangle {

    private Point topLeft;
    private Point bottomRight;
    private int color;

    public ColoredRectangle(Point leftTop, Point rightBottom, int color) {
        this.topLeft = leftTop;
        this.bottomRight = rightBottom;
        this.color = color;
    }

    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, int color) {
        this(new Point(xLeft, yTop), new Point(xRight, yBottom), color);
    }

    public ColoredRectangle(int length, int width, int color) {
        this(new Point(0, -width), new Point(length, 0), color);
    }

    public ColoredRectangle(int color) {
        this(1, 1, color);
    }

    public ColoredRectangle() {
        this(1, 1, 1);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public int getColor() {
        return color;
    }

    public void setTopLeft(Point topLeft) {
        this.topLeft = topLeft;
    }

    public void setBottomRight(Point bottomRight) {
        this.bottomRight = bottomRight;
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

    public void moveRel(int dx, int dy) {
        topLeft.setX(topLeft.getX() + dx);
        topLeft.setY(topLeft.getY() + dy);
        bottomRight.setX(bottomRight.getX() + dx);
        bottomRight.setY(bottomRight.getY() + dy);
    }

    public void moveTo(int x, int y) {
        int length = getLength();
        int width = getWidth();
        topLeft.setX(x);
        topLeft.setY(y);
        bottomRight.setX(x + length);
        bottomRight.setY(y + width);
    }

    public void moveTo(Point p) {
        moveTo(p.getX(), p.getY());
    }

    public void resize(double ratio) {
        int newLength = (int)(getLength() * ratio);
        int newWidth = (int)(getWidth() * ratio);
        bottomRight.setX(topLeft.getX() + newLength);
        bottomRight.setY(topLeft.getY() + newWidth);
    }

    public void stretch(double xRatio, double yRatio) {
        int newLength = (int)(getLength() * xRatio);
        int newWidth = (int)(getWidth() * yRatio);
        bottomRight.setX(topLeft.getX() + newLength);
        bottomRight.setY(topLeft.getY() + newWidth);
    }

    public double getArea() {
        return getLength() * getWidth();
    }

    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() &&
                x <= bottomRight.getX() &&
                y >= topLeft.getY() &&
                y <= bottomRight.getY();
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public boolean isIntersects(ColoredRectangle r) {
        return !(r.bottomRight.getX() < topLeft.getX() ||
                r.topLeft.getX() > bottomRight.getX() ||
                r.bottomRight.getY() < topLeft.getY() ||
                r.topLeft.getY() > bottomRight.getY());
    }

    public boolean isInside(ColoredRectangle r) {
        return r.topLeft.getX() >= topLeft.getX() &&
                r.bottomRight.getX() <= bottomRight.getX() &&
                r.topLeft.getY() >= topLeft.getY() &&
                r.bottomRight.getY() <= bottomRight.getY();
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
}