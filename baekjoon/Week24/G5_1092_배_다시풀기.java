package baekjoon.Week24;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;


/**
 * 시간초과 남!
 */
public class G5_1092_배_다시풀기 {
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
        List<Integer> boxes = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            boxes.add(stoi(s[i]));
        }

        crane.sort(Collections.reverseOrder());
        boxes.sort(Collections.reverseOrder());

        int answer = 0;

        if (crane.get(0) < boxes.get(0)) {
            System.out.println(-1);
            return;
        }

        boolean[] visit = new boolean[m];

        while (true) {
            if (checkVisitAll(visit)) break;
            answer++;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if(visit[j])continue;
                    else{
                        if(boxes.get(j) <= crane.get(i)){
                            visit[j] = true;
                            break;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }

    static boolean checkVisitAll(boolean[] visit) {
        for (int i = 0; i < visit.length; i++) {
            if (visit[i] == false) return false;
        }

        return true;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
