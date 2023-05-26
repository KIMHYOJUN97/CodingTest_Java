package baekjoon.Week12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S5_10815_숫자카드 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] lists = new int[n];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            lists[i] = Integer.parseInt(inputs[i]);
        }

        int m = Integer.parseInt(br.readLine());
        inputs = br.readLine().split(" ");
        int[] lists_2 = new int[m];
        for (int i = 0; i < m; i++) {
            lists_2[i] = Integer.parseInt(inputs[i]);
        }

        Arrays.sort(lists);
        for (int i = 0; i < m; i++) {
            lists_2[i] = binary_search(lists, lists_2[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int x : lists_2) {
            sb.append(x + " ");
        }
        System.out.println(sb);
    }

    static int binary_search(int[] arr,int target) {
        int start = 0;
        int end = arr.length-1;
        while(start<=end){
            int mid = (start+end)/2;
            if(arr[mid]>target){
                end = mid-1;
            }else if(arr[mid] <target){
                start = mid+1;
            }else return 1;
        }

        return 0;
    }
}
