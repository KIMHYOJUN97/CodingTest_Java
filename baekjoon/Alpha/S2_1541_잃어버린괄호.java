package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * - 뒤에 +가 있으면 전부 괄호로 묶는다.
 * IntelliJ에서 오류남.->eclipse에선 정상작동
 */
public class S2_1541_잃어버린괄호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = Integer.MAX_VALUE;
        String[] subString = br.readLine().split("-");

        for (int i = 0; i < subString.length; i++) {
            int tmp = 0;
//50 - 50 - 100 + 20 + 30 - 10
            String[] addString = subString[i].split("\\+");

            for (int j = 0; j < addString.length; j++) {
                tmp += Integer.parseInt(addString[j]);
            }

            if (sum == Integer.MAX_VALUE) {
                sum = tmp;
            } else {
                sum -= tmp;
            }
        }
        System.out.println(sum);
    }
}
