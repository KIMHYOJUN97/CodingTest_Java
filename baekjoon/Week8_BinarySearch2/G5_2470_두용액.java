package baekjoon.Week8_BinarySearch2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class G5_2470_두용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        int l_idx = 0;
        int r_idx = n-1;
        int left = 0;
        int right = n-1;
        int min = numbers[left]+numbers[right];
        //left와 right가 같으면 안됨.
        while(left<right){
            if (Math.abs(min) >= Math.abs(numbers[left] + numbers[right])) {
                l_idx = left;
                r_idx = right;
                min = numbers[left]+numbers[right];
            }
            if(numbers[left]+numbers[right]<0)left++;
            else right--;
        }
        System.out.println(numbers[l_idx]+" "+numbers[r_idx]);
    }
}

//public class G5_2470_두용액 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int[] numbers = new int[n];
//        int minus = 0;
//        int plus = 0;
//        for (int i = 0; i < n; i++) {
//            numbers[i] = Integer.parseInt(st.nextToken());
//            if(numbers[i]>0)plus++;
//            else minus++;
//        }
//        Arrays.sort(numbers);
//        int[] minus_num = new int[minus];
//        int[] plus_num = new int[plus];
//        for (int i = 0; i < minus; i++) {
//            minus_num[i] = numbers[i];
//        }
//        for (int i = 0; i < plus; i++) {
//            plus_num[i] = numbers[plus+i];
//        }
//        if(minus==0) System.out.println(plus_num[0]+" "+plus_num[1]);
//        else if(plus==0) System.out.println(minus_num[minus - 1] + " " + minus_num[minus - 2]);
//        else{
//
//        }
//    }
//}
