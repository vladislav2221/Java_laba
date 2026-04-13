package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.HasArea;

public class Point implements Movable {

    private int x;
    private int y;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){ return x; }
    public int getY(){ return y; }

    public void setX(int x){ this.x = x; }
    public void setY(int y){ this.y = y; }

    @Override
    public void moveTo(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void moveRel(int dx, int dy){
        x += dx;
        y += dy;
    }
}