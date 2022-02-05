import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountOnes {

    public static void main(String[] args) {
        int[][] inputArray = {
                {1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 1, 0}
        };
        int[][] outputArray = new int[5][5];

        List<Integer> addArray = new ArrayList<Integer>();

        int arrayLength = inputArray.length;
        int runningTotal = 0;
        for (int i = 0; i < arrayLength; i++)
        {
            for(int j = 0; j < arrayLength; j++) {
                //build up boxes, 1x1, 1x2, 2x1, 2x2, 3x1, 3x2, 1x3, 2x3, 3x3 etc.
                //1x1 = 1x1
                //1x2 = 1x1 + 1x2
                //1x3 = 1x1 + 1x2 + 1x3
                //2x1 = 1x1 + 2x1
                //2x2 = 1x1 + 1x2 + 2x1

                outputArray[i][j] = solve(inputArray, i, j, j, runningTotal);
            }
        }
        for (int[] array : outputArray) {
            System.out.println(Arrays.toString(array));
        }

    }

    public static int solve(int[][] inputArray, int x, int y, int originalY, int runningTotal){

        if(x == 0 && y == 0) {
            return runningTotal + inputArray[x][y];
        }
        else if(y > 0) {
            return solve(inputArray, x, y - 1, originalY, runningTotal + inputArray[x][y]);
        }
        else if(x > 0) {
            return solve(inputArray, x - 1, originalY,  originalY,runningTotal + inputArray[x][y]);
        }

        return 0;
    }
}
