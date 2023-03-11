package baekjoon.Week9_TwoPointer;

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
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        int start=0,end=0,cnt=0,ans=0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < n) {
            if(end-start<k){
                if(map.getOrDefault(sushi[end],0)==0){
                    map.put(sushi[end],1);
                    cnt++;
                }
                else{
                    map.put(sushi[end],map.get(sushi[end])+1);
                }
                end++;
                if(map.getOrDefault(c,0)==0){
                    ans = Math.max(ans,cnt+1);
                }
                else{
                    ans = Math.max(ans,cnt);
                }
            }
            else{
                if(map.get(sushi[start])==1)cnt--;
                map.put(sushi[start],map.get(sushi[start])-1);
                start++;
            }
        }
        System.out.println(ans);
    }
}
