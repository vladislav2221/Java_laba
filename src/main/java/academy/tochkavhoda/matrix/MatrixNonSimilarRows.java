package academy.tochkavhoda.matrix;

import java.util.*;

public class MatrixNonSimilarRows {

    private int[][] matrix;

    public MatrixNonSimilarRows(int[][] matrix) {
        this.matrix = matrix;
    }

    public Set<int[]> getNonSimilarRows() {

        Map<Set<Integer>, int[]> uniqueRows = new LinkedHashMap<>();

        for (int[] row : matrix) {

            Set<Integer> set = new HashSet<>();

            for (int n : row) {
                set.add(n);
            }

            uniqueRows.putIfAbsent(set, row);
        }

        return new LinkedHashSet<>(uniqueRows.values());
    }

}