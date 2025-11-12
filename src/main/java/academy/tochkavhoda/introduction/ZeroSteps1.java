package academy.tochkavhoda.introduction;

public class ZeroSteps1 {
    public int sum(int x, int y) {
        return x + y;
    }

    public int mul(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {

        return x / y;
    }

    public int mod(int x, int y) {
        return x - (x / y) * y;
    }

    public boolean isEqual(int x, int y) {
        if (x == y) {
            return true;
        } else {
            return false;
        }
    }
    public boolean isGreater(int x, int y) {
        if (x > y) {
            return true;
        } else {
            return false;
        }
    }
    public double calculateTriangleSquare(int side1, int side2)
    {
        return (side1 * side2) / 2.0;
    }
    public double calculateTrianglePerimeter(int side1, int side2) {
        double hypotenuse = Math.sqrt(side1 * side1 + side2 * side2);
        return side1 + side2 + hypotenuse;
    }
    public int reverseNumber(int number) {
        int hundreds = number / 100;        // первая цифра
        int tens = (number / 10) % 10;      // вторая цифра
        int units = number % 10;            // третья цифра

        return units * 100 + tens * 10 + hundreds;
    }
    public long calculate15Degree(int number) {
        long n2 = number * number;      // n^2 (1 умножение)
        long n4 = n2 * n2;              // n^4 (2 умножения)
        long n8 = n4 * n4;              // n^8 (3 умножения)
        long n12 = n8 * n4;             // n^12 (4 умножения)
        long n15 = n12 * n2 * number;   // n^15 (5 умножений)
        return n15;
    }
    public boolean isInsideRect(int xLeft, int yTop, int xRight, int yBottom, int x, int y) {
        boolean insideX = x >= xLeft && x <= xRight;
        boolean insideY = y >= yTop && y <= yBottom;
        return insideX && insideY;
    }
    public double sqrtAbs(int number) {
        return Math.sqrt(Math.abs(number));
    }
    public boolean isTriangleExist(int side1, int side2, int side3) {
        return side1 + side2 > side3 &&
                side1 + side3 > side2 &&
                side2 + side3 > side1;
    }
        public int getDigitsProduction(int number) {
        int digit1 = number / 1000;        // тысячи
        int digit2 = (number / 100) % 10;  // сотни
        int digit3 = (number / 10) % 10;   // десятки
        int digit4 = number % 10;          // единицы
        return digit1 * digit2 * digit3 * digit4;
    }
    public boolean isCircleInsideSquare(int radius, int side) {
        if (radius < 0 || side < 0) {
            throw new IllegalArgumentException("Radius and side must be non-negative");
        }
        return 2 * radius < side;
    }
    public char getCharByCode(short code) {
        return (char) code;
    }
    public short getCodeByChar(char character) {
        return (short) character;
    }
    public char getCharByCodeAndOffset(char ch, short offset) {
        return (char) (ch + offset);
    }
    public boolean isGreaterOrEqual(char ch1, char ch2) {
        return ch1 >= ch2;
    }
    public char getAverageChar(char ch1, char ch2) {
        return (char) ((ch1 + ch2) / 2);
    }
}
