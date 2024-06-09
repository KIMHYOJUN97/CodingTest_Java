package baekjoon.Week27;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S2_6236_용돈관리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        int[] money = new int[n];
        int maxMoney = 0;
        for (int i = 0; i < n; i++) {
            money[i] = stoi(br.readLine());
            maxMoney += money[i];
        }
        int start = 0;
        int end = maxMoney;
        int answer = maxMoney;
        while (start <= end) {
            // 한번에 인출할 돈
            int mid = (start + end) / 2;
            // 인출한 횟수
            int drawCnt = 0;
            // 현재 돈
            int nowMoney = 0;
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                // 돈이 부족하면 인출
                if (nowMoney < money[i]) {
                    // 인출할 돈(mid)가 부족하면 인출할 돈의 크기 늘려야 함
                    if (mid < money[i]) {
                        start = mid + 1;
                        flag = true;
                        break;
                    } else {
                        //인출할 돈이 충분히 크다면 인출을 시작함.
                        nowMoney = mid - money[i];
                        drawCnt++;
                    }
                } else {
                    // 현재 돈으로 충분히 가능하다면
                    nowMoney -= money[i];
                }
            }
            if (flag) continue;

            // 인출횟수가 m보다 작거나 같다면
            if (drawCnt <= m) {
                // 인출할 돈을 줄여본다.
                answer = mid;
                end = mid - 1;
            } else {
                //인출횟수가 너무 많다면
                start = mid + 1;
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
