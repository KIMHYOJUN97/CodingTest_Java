package baekjoon.Week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class S1_20922_겹치는건싫어 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> map = new HashMap<>();
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        int start=0,end=0,cnt=0;
        while (end < n) {
            if(map.getOrDefault(numbers[end],0)+1 <=k){
                map.put(numbers[end], map.getOrDefault(numbers[end], 0) + 1);
                end++;
                cnt = Math.max(cnt,end-start);
            }
            else{
                map.put(numbers[start],map.get(numbers[start])-1);
                start++;
            }
        }
        System.out.println(cnt);
    }
}
