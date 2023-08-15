package baekjoon.Week21;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S4_11399_ATM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
//        List<Person> list = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
//        for (int i = 0; i < n; i++) {
//            list.add(new Person(i, stoi(st.nextToken())));
//        }
//
//        Collections.sort(list);
//        int ans = list.get(0).minutes;
//        for (int i = 1; i < n; i++) {
//            int prev = ans;
//            ans += (list.get(i).minutes + prev);
//        }
//
//        System.out.println(ans);

        int[] preSum = new int[n + 1];
        int[] numArr = new int[n];
        for (int i = 0; i < n; i++) {
            numArr[i] = stoi(st.nextToken());
        }
        Arrays.sort(numArr);

        preSum[0] = numArr[0];
        for (int i = 1; i < n; i++) {
            preSum[i] = preSum[i - 1] + numArr[i];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += preSum[i];
        }

        System.out.println(ans);
    }
//
//    static class Person implements Comparable<Person>{
//
//        int idx;
//        int minutes;
//
//        public Person(int idx, int minutes) {
//            this.idx = idx;
//            this.minutes = minutes;
//        }
//
//        public int compareTo(Person person) {
//            if(minutes == person.minutes)return idx - person.idx;
//            else return minutes - person.minutes;
//        }
//    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
