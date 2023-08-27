package baekjoon.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2_1654_랜선자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = stoi(st.nextToken());
        int n = stoi(st.nextToken());

        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = stoi(br.readLine());
        }

        int answer = 0;
        int lt = 0;
        int rt = nums[k - 1];
        while (lt <= rt) {
            int mid = (lt+rt)/2;
            int sum = 0;
            for (int i = 0; i < k; i++) {
                sum += (nums[i] / mid);
            }
            //더 짧게 잘라야 함
            if (sum < n) {
                rt = mid - 1;
            } else {
                answer = mid;
                lt = mid+1;
            }
        }
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
