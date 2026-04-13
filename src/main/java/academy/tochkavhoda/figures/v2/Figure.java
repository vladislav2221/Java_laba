package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Movable;

public abstract class Figure implements Movable {

    public abstract double getArea();

    public abstract double getPerimeter();
    public abstract boolean isInside(int x, int y);
}