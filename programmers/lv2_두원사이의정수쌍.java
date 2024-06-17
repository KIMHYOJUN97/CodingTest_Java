package programmers;

import java.io.BufferedReader;
import java.io.IOException;

public class lv2_두원사이의정수쌍 {
    public static void main(String[] args) throws IOException {
        System.out.println(solution(2, 3));
    }

    private static long solution(int r1, int r2) {
        long answer = 0;
        for (int i = 1; i <= r2; i++) {
            int start = (int) Math.ceil(Math.sqrt((long) r1 * r1 - (long) i * i));
            int end = (int) Math.floor(Math.sqrt((long) r2 * r2 - (long) i * i));
            answer += (end - start + 1);
        }

        return answer * 4;
    }
}
