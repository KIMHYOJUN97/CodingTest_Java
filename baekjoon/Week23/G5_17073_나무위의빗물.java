package baekjoon.Week23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 자식노드가 여러 개 일 때, 1/2 확률로 자식노드에게 물이 내려감
 */
public class G5_17073_나무위의빗물 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        List<List<Integer>> trees = new ArrayList<>();
        int leafCnt = 0;
        for (int i = 0; i <= n; i++) {
            trees.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = stoi(st.nextToken());
            int v = stoi(st.nextToken());
            trees.get(u).add(v);
            trees.get(v).add(u);
        }

        for (int i = 2; i <= n; i++) {
            if (trees.get(i).size() == 1) leafCnt++;
        }
        System.out.println(String.format("%.10f", (double) m / leafCnt));
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
