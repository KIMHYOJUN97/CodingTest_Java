package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class bs_입국심사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] times = new int[2];
        times[0] = 1;
        times[1] = 1;

        int n = 59;

        int answer = solution(n, times);
        System.out.println(answer);
    }

    private static int solution(int n, int[] times) {
        // 한 심사관이 전부 했을 때를 최대로 잡는다. -> 규칙 중, 다른 사람이 기다리고 심사를 받을 수 있으니까.
        Arrays.sort(times);

        long answer = 0;

        long min = (long) times[0];
        long max = (long) times[0] * n;

        /**
         * min == max 가 처음부터 같을 경우 시작도 하지 않고 while 문 종료되어버림.
         */
        while (min <= max) {
            long mid = (min + max) / 2;
            long tmp = n;
            for (int i = 0; i < times.length; i++) {
                tmp -= (int)(mid / times[i]);
            }

            // 이 경우가 가장 근접한 경우
            if(min==max) return (int) min;
            if(tmp==0)answer = mid;

            if (tmp > 0) {
                min = mid+1;
            } else {
                max = mid;
            }
        }

        return (int)answer;
    }

}
