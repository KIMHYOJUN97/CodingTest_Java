package baekjoon.Week13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class G5_20437_문자열게임2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        for (int i = 0; i < n; i++) {
            Map<Character, Integer> map = new HashMap<>();
            String s = br.readLine();
            for (int j = 0; j < s.length(); j++) {
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0) + 1);
            }
            int target = stoi(br.readLine());
            if (map.containsValue(target)) {
                int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
                for (Character character : map.keySet()) {
                    if(map.get(character)==target){
                        max = Math.max(max, s.lastIndexOf(character) - s.indexOf(character));
                        for (int x = 0; x < target - 1; x++) {
                            int now = s.indexOf(character);
                            int nxt = s.indexOf(character,now+1);
                            min = Math.min(min,(nxt-now)+1);
                        }
                    }
                }
                System.out.println(min + " " + max);
            }else{
                System.out.println(-1);
            }
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
