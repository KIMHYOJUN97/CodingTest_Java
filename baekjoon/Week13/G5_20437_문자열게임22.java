package baekjoon.Week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G5_20437_문자열게임22 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            Map<Character, Integer> map = new HashMap<>();
            int target = Integer.parseInt(br.readLine());
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }
            int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
            boolean flag = false;
            for (Character character : map.keySet()) {
                if (map.get(character) >= target) {
                    int[] list = new int[map.get(character)];
                    int start = s.indexOf(character);
                    for (int a = 0; a < map.get(character); a++) {
                        list[a] = start;
                        start = s.indexOf(character, start + 1);
                    }
                    int sta=0,end=sta+target-1;
                    while (end <= list.length - 1) {
                        min = Math.min((list[end] - list[sta] + 1), min);
                        max = Math.max((list[end] - list[sta] + 1), max);
                        sta++;
                        end++;
                    }
                    flag = true;
                }
            }
            if (flag) {
                System.out.println(min + " " + max);
            }else{
                System.out.println(-1);
            }
        }
    }
}
