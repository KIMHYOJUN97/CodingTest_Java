package baekjoon.Week17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G3_2623_음악프로그램 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        int[] indegree = new int[n + 1];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        //indgree가 0인것 재방문 안하는지 체크 여부
        boolean[] visit = new boolean[n + 1];
        for (int i = 0; i < m; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j < s.length-1; j++) {
                int a = stoi(s[j]);
                int b = stoi(s[j + 1]);
                indegree[b]++;
                list.get(a).add(b);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if(indegree[i]==0) q.add(i);
        }

        //불가능할 때 조건문을 어떻게 설계할것인가?
        List<Integer> answer = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            answer.add(cur);
            for (int x : list.get(cur)) {
                indegree[x]--;
                if (indegree[x] == 0) {
                    q.add(x);
                }
            }
        }
        if (answer.size() == n) {
            for (Integer integer : answer) {
                System.out.println(integer);
            }
        }else System.out.println(0);

    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
