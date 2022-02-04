import java.util.Arrays;

public class CountOnes {

    public static void main(String[] args) {
        int[][] InputArray = {
                {1, 0, 1, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 0, 1, 0, 1},
                {1, 1, 0, 0, 1},
                {0, 0, 1, 1, 0}
        };
        int[][] OutputArray = new int[5][5];

        int ArrayLength = InputArray.length;
        for (int i = 0; i < ArrayLength; i++)
        {
            for(int j = 0; j < ArrayLength; j++)
            {
                OutputArray[i][j] += InputArray[i][j];

            }

        }

        System.out.println(Arrays.deepToString(OutputArray));
    }
}
