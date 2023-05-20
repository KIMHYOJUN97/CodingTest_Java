package baekjoon.Alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S1_1931_회의실배정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Node[] nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            nodes[i] = new Node(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1]));
        }

        Arrays.sort(nodes);
//        for (Node node : nodes) {
//            System.out.println("start end ="+node.start+" "+node.end);
//        }
        int ans = 0;
        int end = 0;

        for (int i = 0; i < n; i++) {
            if(end<=nodes[i].start){
                end = nodes[i].end;
                ans++;
            }
        }
        System.out.println(ans);
    }

    static class Node implements Comparable<Node>{
        int start;
        int end;

        @Override
        public int compareTo(Node node) {
            if (this.end == node.end) {
                if(this.start < node.start) return -1;
                else return 1;
            }
            else if(this.end < node.end) return -1;
            else return 1;
        }

        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
