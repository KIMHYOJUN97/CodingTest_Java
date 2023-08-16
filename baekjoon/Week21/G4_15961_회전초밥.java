package baekjoon.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class G4_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int d = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int c = stoi(st.nextToken());
        int[] sushi = new int[n + k];
        for (int i = 0; i < n; i++) {
            sushi[i] = stoi(br.readLine());
        }
        for (int i = n; i < n + k; i++) {
            sushi[i] = sushi[i-n];
        }
        int lt = 0, rt = 0;
        //7 9 7 30 2 7 9 25 다시 7 9 7
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        while(lt<=rt && rt < n+k){
            //lt와 rt의 차이가 k이상 나면 안됨.
            if(rt-lt<k){
                //rt값 넣어줌
                map.put(sushi[rt],map.getOrDefault(sushi[rt],0)+1);
                rt++;
            }
            //k칸 이상 차이날 때
            else{
                boolean flag = false;
                //쿠폰 사용유무
                if (map.containsKey(c)) {
                    if(map.get(c)!=0)
                        flag = true;
                }
                int size = 0;
                for (int key : map.keySet()) {
                    if(map.get(key)!=0)size++;
                }
                if (flag) {
                    answer = Math.max(size, answer);
                } else answer = Math.max(size + 1, answer);
                map.put(sushi[lt], map.get(sushi[lt])-1);
                lt++;
            }
        }
        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
