package baekjoon.Week2_DataStructure;

import java.text.DecimalFormat;
import java.util.*;
import java.io.*;

public class 생태학_4358 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Map<String, Integer> hashmap = new HashMap<>();
        int defaultValue = 0;
        int cnt = 0;
        while (true) {
            String req = br.readLine();
            if (req == null || req.length() == 0) {break;}
            hashmap.put(req, hashmap.getOrDefault(req, defaultValue) + 1);
            cnt++;
        }
        Map<String, Integer> sortedMap = new TreeMap<>(hashmap);

        StringBuilder sb = new StringBuilder();
//        DecimalFormat df = new DecimalFormat("0.0000");
        for (String tree : sortedMap.keySet()) {
//            double ans = Double.parseDouble(df.format((double)(sortedMap.get(tree))/cnt*100));
            String ans = String.format("%.4f", (double)sortedMap.get(tree) / cnt * 100);
            sb.append(tree).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }
}

