package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
public class G4_13975_파일합치기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = stoi(br.readLine());
        for (int t = 0; t < T; t++) {
            PriorityQueue<Long> pq = new PriorityQueue<>();
            int n = stoi(br.readLine());
            long answer = 0;
            String[] s = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pq.add(stol(s[i]));
            }

            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                answer += (a + b);
                pq.add(a + b);
            }
            System.out.println(answer);
        }
    }


    static long stol(String s) {
        return Long.parseLong(s);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

}
