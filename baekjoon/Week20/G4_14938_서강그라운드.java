package baekjoon.Week20;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class G4_14938_서강그라운드 {
    //전부 탐색해봐야 한다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        //m이 타겟처럼 사용되어야 함
        int m = stoi(st.nextToken());
        int r = stoi(st.nextToken());

        //itemCnt ->아이템의 갯수 number는 편의상 한개씩 늘려주자.
        int[] itemCnt = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            itemCnt[i] = stoi(st.nextToken());
        }

        List<List<Node>> list = new ArrayList<>();


        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int start = stoi(st.nextToken());
            int end = stoi(st.nextToken());
            int weight = stoi(st.nextToken());
            list.get(start).add(new Node(end, weight));
            list.get(end).add(new Node(start, weight));
        }

        List<Integer> answer = new ArrayList<>();
        int INF = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            //1부터 N까지 전부 순회하면서 알아봄
            boolean[] visit = new boolean[n + 1];
//            visit[i] = true;
            int[] dis = new int[n + 1];
            for (int j = 1; j <= n; j++) {
                dis[j] = INF;
            }
            dis[i] = 0;
            //최단거리를 갱신
            PriorityQueue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(i, 0));
            while (!pq.isEmpty()) {
                Node now = pq.poll();
                int curEnd = now.end;
                if (visit[curEnd]) continue;
                visit[curEnd] = true;
                for (Node node : list.get(curEnd)) {
                    if (dis[node.end] > dis[curEnd] + node.weight) {
                        dis[node.end] = dis[curEnd] + node.weight;
                        pq.add(new Node(node.end, dis[node.end
                                ]));
                    }
                }
            }

            //갱신한 최단거리 내에 있는 것들중에서 아이템의 갯수 전부 더하기
            int sum = 0;
            for (int j = 1; j <= n; j++) {
                if (dis[j] <= m) {
                    sum += itemCnt[j];
                }
            }
            answer.add(sum);
        }

        Collections.sort(answer, Collections.reverseOrder());

        System.out.println(answer.get(0));
    }

    static class Node implements Comparable<Node> {
        int end;
        int weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        public int compareTo(Node node) {
            return weight - node.weight;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
