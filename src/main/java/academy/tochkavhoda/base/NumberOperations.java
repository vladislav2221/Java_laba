package academy.tochkavhoda.base;

import java.math.BigInteger;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class NumberOperations {

    // 1. Ищет в массиве array первый элемент, значение которого равно value.
    public static Integer find(int[] array, int value) {
        if (array == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }

        return null;
    }

    // 2. Ищет в массиве array первый элемент, значение которого по модулю не отличается от value более чем на eps.
    public static Integer find(double[] array, double value, double eps) {
        if (array == null || eps < 0) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (Math.abs(array[i] - value) <= eps) {
                return i;
            }
        }

        return null;
    }

    // 3. Вычисляет плотность вещества по формуле weight / volume.
    public static Double calculateDensity(double weight, double volume, double min, double max) {
        if (volume == 0 || min > max) {
            return null;
        }

        double density = weight / volume;

        if (density >= min && density <= max) {
            return density;
        }

        return null;
    }

    // 4. Ищет в массиве array первый элемент, значение которого равно value.
    public static Integer find(BigInteger[] array, BigInteger value) {
        if (array == null || value == null) {
            return null;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] != null && array[i].equals(value)) {
                return i;
            }
        }

        return null;
    }

    // 5. Вычисляет плотность вещества по формуле weight / volume.
    public static BigDecimal calculateDensity(BigDecimal weight, BigDecimal volume, BigDecimal min, BigDecimal max) {
        if (weight == null || volume == null || min == null || max == null) {
            return null;
        }

        if (volume.compareTo(BigDecimal.ZERO) == 0 || min.compareTo(max) > 0) {
            return null;
        }

        try {
            // Используем масштаб 1 знак после запятой вместо 10
            BigDecimal density = weight.divide(volume, 1, RoundingMode.HALF_UP);

            if (density.compareTo(min) >= 0 && density.compareTo(max) <= 0) {
                return density;
            }
        } catch (ArithmeticException e) {
            return null;
        }
        return null;
    }
}