package academy.tochkavhoda.misc.v2;

import academy.tochkavhoda.iface.v2.*;

public class Car implements Movable, Colored {

    private int x;
    private int y;
    private int color;

    @Override
    public void moveTo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveRel(int dx, int dy) {
        x += dx;
        y += dy;
    }

    @Override
    public void setColor(int color) {
        this.color = color;
    }

    @Override
    public int getColor() {
        return color;
    }
}