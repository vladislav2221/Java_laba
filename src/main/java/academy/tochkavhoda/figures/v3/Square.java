package academy.tochkavhoda.figures.v3;

import java.util.Objects;

public class Square extends Figure {

    private Point topLeft;
    private int size;

    public Square(Point p, int size) {
        this.topLeft = new Point(p.getX(), p.getY() - size);
        this.size = size;
    }

    public Square(int x, int y, int size) {
        this.topLeft = new Point(x, y - size);
        this.size = size;
    }

    public Square(int size) {
        this.topLeft = new Point(0, -size);
        this.size = size;
    }

    public Square() {
        this.topLeft = new Point(0, -1);
        this.size = 1;
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return new Point(topLeft.getX() + size, topLeft.getY() + size);
    }

    public int getLength() {
        return size;
    }

    public void setTopLeft(Point p) {
        this.topLeft = new Point(p.getX(), p.getY());
    }

    @Override
    public void moveTo(int x, int y) {
        this.topLeft = new Point(x, y - size);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        size = (int) Math.round(size * ratio);
    }

    @Override
    public double getArea() {
        return size * size;
    }

    @Override
    public double getPerimeter() {
        return 4 * size;
    }

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX()
                && x <= topLeft.getX() + size
                && y >= topLeft.getY()
                && y <= topLeft.getY() + size;
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public boolean isIntersects(Square s) {
        return !(s.topLeft.getX() + s.size < topLeft.getX()
                || s.topLeft.getX() > topLeft.getX() + size
                || s.topLeft.getY() + s.size < topLeft.getY()
                || s.topLeft.getY() > topLeft.getY() + size);
    }

    public boolean isInside(Square s) {
        return isInside(s.topLeft) && isInside(s.getBottomRight());
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Square)) return false;
        Square s = (Square) o;
        return size == s.size && Objects.equals(topLeft, s.topLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, size);
    }
}