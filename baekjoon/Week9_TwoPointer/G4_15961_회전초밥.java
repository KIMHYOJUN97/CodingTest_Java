package baekjoon.Week9_TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * 슬라이딩 윈도우
 * 초밥기계가 원형으로 이루어져 있기 때문에 end가 n까지의 범위가 아닌,
 * n+k까지 범위 까지 가서 가짓수를 세어주어야 한다.
 */
public class G4_15961_회전초밥 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[] sushi = new int[n+k];
        for (int i = 0; i < n; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = n; i < n + k; i++) {
            sushi[i] = sushi[i-n];
        }
        int start=0,end=0,cnt=0,ans=0;
        Map<Integer, Integer> map = new HashMap<>();
        while (end < n+k) {
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
