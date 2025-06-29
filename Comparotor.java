import java.util.*;

class SortMatrixByColumn {
    public static void main(String args[]) {
        Integer[][] mat = { {0,5,2},{1, 3, 3}, {6, 3, 9} };

        // Sort based on the 0th column
        Arrays.sort(mat, Comparator.comparingInt(o -> o[1]));

        // Print the sorted matrix
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
