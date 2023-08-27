package baekjoon.Week22;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2_2805_나무자르기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = stoi(st.nextToken());
        int m = stoi(st.nextToken());
        st = new StringTokenizer(br.readLine());

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = stoi(st.nextToken());
        }
        Arrays.sort(nums);


        int lt = 0;
        int rt = nums[n-1];
        int answer = 0;

        while(lt<=rt){
            int mid = (lt + rt) / 2;
            int cutMeter = cutting(nums, mid);
            if (cutMeter < m) {
                rt = mid-1;
            } else {
                answer = mid;
                lt = mid+1;
            }
        }

        System.out.println(answer);
    }

    static int cutting(int[] nums,int cutMeter) {
        int totalMeter = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cutMeter) {
                totalMeter += nums[i]-cutMeter;
            }
        }
        return totalMeter;
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
