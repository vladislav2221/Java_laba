package academy.tochkavhoda.figures.v3;

public abstract class Figure {

    public void moveTo(int x, int y) {}

    public void moveTo(Point p) {
        moveTo(p.getX(), p.getY());
    }

    public void moveRel(int dx, int dy) {}

    public abstract double getArea();

    public abstract double getPerimeter();

    public boolean isInside(int x, int y) {
        return false;
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }
}