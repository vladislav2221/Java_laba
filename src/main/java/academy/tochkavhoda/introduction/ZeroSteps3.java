package academy.tochkavhoda.introduction;
public class ZeroSteps3 {
    public int sum(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int total = 0;
        for (int num : array) {
            total += num;
        }
        return total;
    }
    public int mul(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int product = 1;
        for (int num : array) {
            product *= num;
        }
        return product;
    }
    public int min(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MAX_VALUE;
        }
        int minValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
    public int max(int[] array) {
        if (array == null || array.length == 0) {
            return Integer.MIN_VALUE;
        }
        int maxValue = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxValue) {
                maxValue = array[i];
            }
        }
        return maxValue;
    }
    public double average(int[] array) {
        if (array == null || array.length == 0) {
            return 0.0;
        }
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        return (double) sum / array.length;
    }
    public boolean isSortedDescendant(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }

        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] <= array[i + 1]) {
                return false;
            }
        }
        return true;
    }
    public void cube(int[] array) {
        if (array == null) {
            return;
        }
       for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * array[i] * array[i];
        }
    }
    public boolean find(int[] array, int value) {
        if (array == null) {
            return false;
        }
        for (int element : array) {
            if (element == value) {
                return true;
            }
        }
        return false;
    }
    public void reverse(int[] array) {
        if (array == null || array.length <= 1) {
            return;
        }
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            // Меняем местами элементы
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;
            // Переходим к следующей паре
            left++;
            right--;
        }
    }
    public boolean isPalindrome(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    public void replaceBySquare(int[] array) {
        if (array == null) {
            return;
        }

        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                break; // Прекращаем при встрече нулевого элемента
            }
            array[i] = array[i] * array[i];
        }
    }
    public int mulNonZero(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }
        int product = 1;
        boolean hasNonZero = false;

        for (int num : array) {
            if (num != 0) {
                product *= num;
                hasNonZero = true;
            }
        }
        return hasNonZero ? product : 0;
    }
    public boolean allPositive(int[] array) {
        if (array == null || array.length == 0) {
            return false;
        }
        for (int num : array) {
            if (num <= 0) {
                return false;
            }
        }
        return true;
    }
    public boolean allEqual(int[] array) {
        if (array == null || array.length <= 1) {
            return true;
        }
        int first = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] != first) {
                return false;
            }
        }
        return true;
    }
    public int greaterThanNeighbours(int[] array) {
        if (array == null || array.length < 3) {
            return -1;
        }

        for (int i = 1; i < array.length - 1; i++) {
            if (array[i] > array[i - 1] && array[i] > array[i + 1]) {
                return i;
            }
        }
        return -1;
    }
    public boolean neighboursAverage(double[] array) {
        if (array == null || array.length < 3) {
            return false;
        }
        for (int i = 1; i < array.length - 1; i++) {
            double average = (array[i - 1] + array[i + 1]) / 2.0;
            if (Math.abs(array[i] - average) < 1e-10) { // учет погрешности вычислений с double
                return true;
            }
        }
        return false;
    }
    public int sumBetween2Zeros(int[] array) {
        if (array == null || array.length < 2) {
            return 0;
        }
        int firstZeroIndex = -1;
        int secondZeroIndex = -1;
        // Находим первый нулевой элемент
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                firstZeroIndex = i;
                break;
            }
        }
        // Находим второй нулевой элемент
        for (int i = firstZeroIndex + 1; i < array.length; i++) {
            if (array[i] == 0) {
                secondZeroIndex = i;
                break;
            }
        }
        // Если не нашли два нуля, возвращаем 0
        if (firstZeroIndex == -1 || secondZeroIndex == -1) {
            return 0;
        }
        // Суммируем элементы между двумя нулями
        int sum = 0;
        for (int i = firstZeroIndex + 1; i < secondZeroIndex; i++) {
            sum += array[i];
        }
        return sum;
    }
    public int sameAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return 0;
        }
        int minLength = Math.min(array1.length, array2.length);
        int count = 0;
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == array2[i]) {
                count++;
            }
        }
        return count;
    }
    public boolean bothZeroAtPosition(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return false;
        }
        int minLength = Math.min(array1.length, array2.length);
        for (int i = 0; i < minLength; i++) {
            if (array1[i] == 0 && array2[i] == 0) {
                return true;
            }
        }
        return false;
    }
    public void accumulatedSum(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int sum = array[0]; // начинаем с первого элемента
        for (int i = 1; i < array.length; i++) {
            sum += array[i]; // добавляем текущий элемент к сумме
            array[i] = sum;  // заменяем текущий элемент накопленной суммой
        }
    }
    public int[] mergeArrays(int[] array1, int[] array2) {
        if (array1 == null || array2 == null) {
            return new int[0];
        }
        int[] result = new int[array1.length + array2.length];
        int i = 0, j = 0, k = 0;
        // Слияние пока есть элементы в обоих массивах
        while (i < array1.length && j < array2.length) {
            if (array1[i] <= array2[j]) {
                result[k++] = array1[i++];
            } else {
                result[k++] = array2[j++];
            }
        }
        // Добавляем оставшиеся элементы из array1
        while (i < array1.length) {
            result[k++] = array1[i++];
        }
        // Добавляем оставшиеся элементы из array2
        while (j < array2.length) {
            result[k++] = array2[j++];
        }
        return result;
    }
    public int insideCircle(int[] x, int[] y, int radius) {
        if (x == null || y == null || x.length != y.length) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < x.length; i++) {
            // Вычисляем квадрат расстояния от центра (0,0) до точки (x[i], y[i])
            double distanceSquared = x[i] * x[i] + y[i] * y[i];
            double radiusSquared = radius * radius;
            // Проверяем, находится ли точка внутри или на границе круга
            if (distanceSquared <= radiusSquared) {
                count++;
            }
        }
        return count;
    }
    public double scalarProduct(double[] array1, double[] array2) {
        if (array1 == null || array2 == null || array1.length != array2.length) {
            return 0.0;
        }
        double product = 0.0;
        for (int i = 0; i < array1.length; i++) {
            product += array1[i] * array2[i];
        }
        return product;
    }
}
