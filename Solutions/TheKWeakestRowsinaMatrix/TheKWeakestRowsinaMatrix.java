package Solutions.TheKWeakestRowsinaMatrix;

import java.util.Arrays;

/**
 * 2023/9/17
 *
 * @author Daniel Atlas
 */
public class TheKWeakestRowsinaMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1,1,0,0,0},
                        {1,1,1,1,0},
                        {1,0,0,0,0},
                        {1,1,0,0,0},
                        {1,1,1,1,1}};
        int k = 3;
        System.out.println(Arrays.toString(kWeakestRows(mat, k)));
    }

    public static int[] kWeakestRows(int[][] mat, int k) {
        int[][] rowStrengths = new int[mat.length][2];

        for (int i = 0; i < mat.length; ++i) {
            int strength = 0;
            for (int val : mat[i]) {
                strength += val;
            }
            rowStrengths[i][0] = strength;
            rowStrengths[i][1] = i;
        }

        Arrays.sort(rowStrengths, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int[] result = new int[k];
        for (int i = 0; i < k; ++i) {
            result[i] = rowStrengths[i][1];
        }

        return result;
    }
}
