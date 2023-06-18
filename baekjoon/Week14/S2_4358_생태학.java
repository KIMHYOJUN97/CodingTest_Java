package baekjoon.Week14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S2_4358_생태학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new HashMap<>();
        int cnt = 0;
        while(true){
            String tree = br.readLine();
            if(tree.length()==0 || tree == null)break;
            map.put(tree, map.getOrDefault(tree, 0) + 1);
            cnt++;
        }
        List<String> trees = new ArrayList<>();
        for (String tree : map.keySet()) {
            trees.add(tree);
        }
        StringBuilder sb = new StringBuilder();
        Collections.sort(trees);
        for (String tree : trees) {
            String ans = String.format("%.4f", (double) map.get(tree) / cnt * 100);
            sb.append(tree).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
