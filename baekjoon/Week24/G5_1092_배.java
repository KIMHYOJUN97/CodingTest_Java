package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class G5_1092_배 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        List<Integer> crane = new ArrayList<>();
        String[] s = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            crane.add(stoi(s[i]));
        }

        int m = stoi(br.readLine());
        s = br.readLine().split(" ");
        PriorityQueue<Integer> boxes = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < m; i++) {
            boxes.add(stoi(s[i]));
        }

        crane.sort(Collections.reverseOrder());

        int answer = 0;

        if (crane.get(0) < boxes.peek()) {
            System.out.println(-1);
            return;
        }

        while (!boxes.isEmpty()) {
            answer++;
            for (int i = 0; i < n; i++) {
                if (boxes.peek() <= crane.get(i)) {
                    boxes.poll();
                }
                if (boxes.isEmpty()) break;
            }
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
