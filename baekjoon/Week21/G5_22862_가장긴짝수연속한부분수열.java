package baekjoon.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class G5_22862_가장긴짝수연속한부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = stoi(st.nextToken());
        }
        int lt = 0, rt = 0;
        int answer = 0;
        int cnt = 0;
        while(lt<=rt && rt<n){
            //현재 rt가 짝수이면 cnt더하고, rt+1, k의 값 변동 없음
            //rt가 홀수일때, k가 0보다 크면 k--해주고 rt+1,
            //k가 0이면 현재 lt값이 홀수이면 k++해주고 lt+1 짝수이면 그냥 lt+1
            if(arr[rt]%2==0){
                cnt++;
                rt++;
            }else{
                if(k>0){
                    k--;
                    rt++;
                }else{
                    if(arr[lt]%2==0){
                        lt++;
                        cnt--;
                    }
                    else{
                        lt++;
                        k++;
                    }
                }
            }
            answer = Math.max(answer, cnt);
        }

        System.out.println(answer);
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
