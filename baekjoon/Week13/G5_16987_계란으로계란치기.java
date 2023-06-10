package baekjoon.Week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;

/**
 * Condition
 * 계란에는 내구도와 무게가 정해져있다.
 * 계란으로 계란을 치면 각 계란의 내구도는 상대 계란의 무게만큼 깎인다.
 * 내구도가 <=0이 되면 계란이 깨진다.
 * 1. 왼쪽의 계란을 든다
 * 2.
 */

public class G5_16987_계란으로계란치기 {

    static int ans = 0,n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = stoi(br.readLine());
        Node[] nodes = new Node[n];

        for (int i = 0; i < n; i++) {
            String[] inputs = br.readLine().split(" ");
            int a = stoi(inputs[0]);
            int b = stoi(inputs[1]);
            nodes[i] = new Node(a, b, i);
        }

        egg_breaking(0, 0, nodes);
        System.out.println(ans);
    }

    static void egg_breaking(int depth, int cnt, Node[] eggs) {
        if (depth == n) {
            ans = Math.max(cnt, ans);
            return;
        }

        Node now_egg = eggs[depth];

        if (now_egg.shield <= 0 || cnt == n - 1) {
            egg_breaking(depth + 1, cnt,eggs);
            return;
        }

        int now_cnt = cnt;
        for (int i = 0; i < n; i++) {
            if(i==depth) continue;
            if(eggs[i].shield <=0)continue;
            now_egg.shield -= eggs[i].weight;
            eggs[i].shield -= now_egg.weight;
            if(now_egg.shield<=0)cnt++;
            if(eggs[i].shield <=0)cnt++;
            egg_breaking(depth+1,cnt,eggs);
            now_egg.shield += eggs[i].weight;
            eggs[i].shield += now_egg.weight;
            cnt = now_cnt;
        }
    }

    static class Node implements Comparable<Node> {
        int shield;
        int weight;
        int idx;
        int flag = 0;

        public Node(int shield, int weight, int idx) {
            this.shield = shield;
            this.weight = weight;
            this.idx = idx;
        }

        @Override
        public int compareTo(Node node) {
            if (this.shield < node.shield) return -1;
            else return 1;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
