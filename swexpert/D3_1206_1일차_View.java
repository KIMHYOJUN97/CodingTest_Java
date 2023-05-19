package swexpert;

import java.util.Scanner;

public class D3_1206_1일차_View {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int t = 1; t <= 10; t++) {
            int n = sc.nextInt();
            int[] building = new int[n];
            for (int i = 0; i < n; i++) {
                building[i] = sc.nextInt();
            }
            int sum =0;
            for (int i = 2; i < n-2; i++) {
                int left = Math.max(building[i - 1], building[i - 2]);
                int right = Math.max(building[i + 1], building[i + 2]);
                int result = Math.max(left, right);
                if(building[i]>result) sum += building[i] - result;
            }
            System.out.println("#"+t+" "+sum);
        }
    }
}
