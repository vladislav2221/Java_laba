package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;
import academy.tochkavhoda.iface.v3.Stretchable;
import java.util.Objects;

public class ColoredRectangle extends Figure implements Colored {

    private Point topLeft;
    private Point bottomRight;
    private Color color;

    // ====== CONSTRUCTORS ======

    public ColoredRectangle(Point topLeft, Point bottomRight, Color color) {
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
        this.color = color;
    }

    public ColoredRectangle(Point topLeft, Point bottomRight, String color) throws ColorException {
        this(topLeft, bottomRight, Color.colorFromString(color));
    }

    public ColoredRectangle(int x1, int y1, int x2, int y2, Color color) {
        this(new Point(x1, y1), new Point(x2, y2), color);
    }

    public ColoredRectangle(int x1, int y1, int x2, int y2, String color) throws ColorException {
        this(new Point(x1, y1), new Point(x2, y2), Color.colorFromString(color));
    }

    public ColoredRectangle(int width, int height, Color color) {
        this(new Point(0, -height), new Point(width, 0), color);
    }

    public ColoredRectangle(int width, int height, String color) throws ColorException {
        this(new Point(0, -height), new Point(width, 0), Color.colorFromString(color));
    }

    public ColoredRectangle(Color color) {
        this(new Point(0, -1), new Point(1, 0), color);
    }

    public ColoredRectangle(String color) throws ColorException {
        this(Color.colorFromString(color));
    }

    public ColoredRectangle() {
        this(Color.RED);
    }
    public void setTopLeft(Point topLeft) {
        int w = getLength();
        int h = getWidth();
        this.topLeft = new Point(topLeft.getX(), topLeft.getY());
        this.bottomRight = new Point(topLeft.getX() + w, topLeft.getY() + h);
    }

    public void setBottomRight(Point bottomRight) {
        int w = getLength();
        int h = getWidth();
        this.bottomRight = new Point(bottomRight.getX(), bottomRight.getY());
        this.topLeft = new Point(bottomRight.getX() - w, bottomRight.getY() - h);
    }

    public Point getTopLeft() {
        return topLeft;
    }

    public Point getBottomRight() {
        return bottomRight;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(academy.tochkavhoda.colors.v3.ColorErrorCode.NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        if (colorString == null) {
            throw new ColorException(academy.tochkavhoda.colors.v3.ColorErrorCode.NULL_COLOR);
        }
        this.color = Color.colorFromString(colorString);
    }

    public void stretch(double xRatio, double yRatio) {
        int newWidth = (int) (getLength() * xRatio);
        int newHeight = (int) (getWidth() * yRatio);

        bottomRight = new Point(
                topLeft.getX() + newWidth,
                topLeft.getY() + newHeight
        );
    }

    public int getLength() {
        return bottomRight.getX() - topLeft.getX();
    }

    public int getWidth() {
        return bottomRight.getY() - topLeft.getY();
    }

    @Override
    public void moveTo(int x, int y) {
        int w = getLength();
        int h = getWidth();
        topLeft = new Point(x, y);
        bottomRight = new Point(x + w, y + h);
    }

    @Override
    public void moveRel(int dx, int dy) {
        topLeft.moveRel(dx, dy);
        bottomRight.moveRel(dx, dy);
    }

    public void resize(double ratio) {
        int w = (int) (getLength() * ratio);
        int h = (int) (getWidth() * ratio);
        bottomRight = new Point(topLeft.getX() + w, topLeft.getY() + h);
    }

    @Override
    public double getArea() {
        return getLength() * getWidth();
    }

    @Override
    public double getPerimeter() {
        return 2 * (getLength() + getWidth());
    }

    // ====== LOGIC ======

    public boolean isInside(int x, int y) {
        return x >= topLeft.getX() && x <= bottomRight.getX()
                && y >= topLeft.getY() && y <= bottomRight.getY();
    }

    public boolean isInside(Point p) {
        return isInside(p.getX(), p.getY());
    }

    public boolean isIntersects(ColoredRectangle r) {
        return !(r.bottomRight.getX() < this.topLeft.getX()
                || r.topLeft.getX() > this.bottomRight.getX()
                || r.bottomRight.getY() < this.topLeft.getY()
                || r.topLeft.getY() > this.bottomRight.getY());
    }

    public boolean isInside(ColoredRectangle r) {
        return isInside(r.topLeft) && isInside(r.bottomRight);
    }

    // ====== EQUALS ======

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ColoredRectangle)) return false;
        ColoredRectangle that = (ColoredRectangle) o;
        return Objects.equals(topLeft, that.topLeft)
                && Objects.equals(bottomRight, that.bottomRight)
                && color == that.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(topLeft, bottomRight, color);
    }
}