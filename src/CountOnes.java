import java.util.Arrays;

public class CountOnes {

    public static void main(String[] args) {
        int[][] inputArray = { {1, 0, 1, 1, 0}, {0, 1, 1, 1, 0}, {1, 0, 1, 0, 1}, {1, 1, 0, 0, 1}, {0, 0, 1, 1, 0} };
        int[][] outputArray = new int[5][5];

        int arrayLength = inputArray.length * inputArray.length;
        int runningTotal = 0;
        int x = 0, y = 0;
        for (int i = 0; i < arrayLength; i++) {
            outputArray[x][y] = solve(inputArray, x, y, y, runningTotal);
            y++;
            if(y == 5) { x++; y = 0; }
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
