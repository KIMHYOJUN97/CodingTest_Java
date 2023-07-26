package baekjoon.Week19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_5568_카드놓기 {

    static List<int[]> lists = new ArrayList<>();
    static List<int[]> p_lists = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        int k = stoi(br.readLine());
        int[] result = new int[k];
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            int num = stoi(br.readLine());
            numbers[i] = num;
        }

        combi(n,k,0,0,numbers,result);
        Set<String> set = new HashSet<>();

        for (int[] list : lists) {
            boolean[] visit = new boolean[list.length];
            int[] results = new int[list.length];
            perm(list.length,0,list,results,visit);
            for (int[] p_list : p_lists) {
                String tmp = "";
                for (int i : p_list) {
                    tmp += i;
                }
                set.add(tmp);
            }
            p_lists.clear();
        }

        System.out.println(set.size());
    }

    static void perm(int n,int cnt, int[] list, int[] result,boolean[] visit) {
        if (cnt == n) {
            int[] copy = result.clone();
            p_lists.add(copy);
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[cnt] = list[i];
                perm(n, cnt + 1, list, result, visit);
                visit[i] = false;
            }
        }
    }

    static void combi(int n,int r, int start, int cnt,int[] list,int[] result) {
        if (cnt == r) {
            int[] copy = result.clone();
            lists.add(copy);
            return;
        }

        for (int i = start; i < n; i++) {
            result[cnt] = list[i];
            combi(n,r,i+1,cnt+1,list,result);
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
