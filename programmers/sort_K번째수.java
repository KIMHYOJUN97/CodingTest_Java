package programmers;

import java.util.Arrays;

public class sort_K번째수 {
    public static void main(String[] args) {
        int[] array = {1, 5, 2, 6, 3, 7, 4};
        int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        System.out.println(solution(array, commands));
    }

    private static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        int ansIdx = 0;

        for (int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] tempArray = new int[j - i + 1];

            int cnt = 0;
            for (int x = i - 1; x < j; x++) {
                tempArray[cnt++] = array[x];
            }

            Arrays.sort(tempArray);
            answer[ansIdx++] = tempArray[k-1];
        }

        return answer;
    }
}
