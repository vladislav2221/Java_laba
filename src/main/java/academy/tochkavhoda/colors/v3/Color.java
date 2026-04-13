package academy.tochkavhoda.colors.v3;

public enum Color {
    RED, GREEN, BLUE;

    public static Color colorFromString(String s) throws ColorException {
        if (s == null) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
        try {
            return Color.valueOf(s);
        } catch (IllegalArgumentException e) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
    }
}