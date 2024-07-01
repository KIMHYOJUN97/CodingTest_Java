package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 세계적인 도둑 상덕이는 보석점을 털기로 결심했다.
 *
 * 상덕이가 털 보석점에는 보석이 총 N개 있다.
 *
 * 각 보석은 무게 Mi와 가격 Vi를 가지고 있다. 상덕이는 가방을 K개 가지고 있고, 각 가방에 담을 수 있는 최대 무게는 Ci이다. 가방에는 최대 한 개의 보석만 넣을 수 있다.
 *
 * 상덕이가 훔칠 수 있는 보석의 최대 가격을 구하는 프로그램을 작성하시오.
 *
 *
 *
 * 첫째 줄에 N과 K가 주어진다. (1 ≤ N, K ≤ 300,000)
 *
 * 다음 N개 줄에는 각 보석의 정보 Mi와 Vi가 주어진다. (0 ≤ Mi, Vi ≤ 1,000,000)
 *
 * 다음 K개 줄에는 가방에 담을 수 있는 최대 무게 Ci가 주어진다. (1 ≤ Ci ≤ 100,000,000)
 *
 * 모든 숫자는 양의 정수이다.
 *
 *
 * 첫째 줄에 상덕이가 훔칠 수 있는 보석 가격의 합의 최댓값을 출력한다.
 *
 *
 * 2 1
 * 5 10
 * 100 100
 * 11
 *
 * 10
 *
 * 3 2
 * 1 65
 * 5 23
 * 2 99
 * 10
 * 2
 *
 * 164
 */
public class _1202_보석도둑 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = stoi(s[0]);
        int K = stoi(s[1]);

        List<Node> jewelry = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            s = br.readLine().split(" ");
            jewelry.add(new Node(stoi(s[0]), stoi(s[1])));
        }

        Collections.sort(jewelry);

        List<Integer> bags = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            bags.add(stoi(br.readLine()));
        }

        Collections.sort(bags);
        PriorityQueue<Integer> pq =  new PriorityQueue<>(Collections.reverseOrder());
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while(j < N && jewelry.get(j).weight <= bags.get(i)){
                pq.add(jewelry.get(j).value);
                j++;
            }
            if(!pq.isEmpty()){
                ans += pq.poll();
            }
        }

        System.out.println(ans);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }

    static class Node implements Comparable<Node>{
        int weight;
        int value;

        public Node(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Node o) {
            if(this.weight == o.weight) return o.value - this.value;
            return this.weight - o.weight;
        }
    }
}
