package programmers;

import java.util.*;

/**
 * 처음에는 순열로 풀었는데, 메모리 초과가 발생하였다.
 * 규칙을 세우면 메모리 초과 없이 시간 초과 없이 풀 수 있다.
 * 첫번째 숫자가 n!/n번 나오는 걸 확인할 수 있다
 * -> 1 2 3이라면 6/3 = 2 이고 1 2 3/ 1 3 2/ 2 1 3/ 2 3 1/ 3 1 2/ 3 2 1
 * 이렇게 예시로는 2번씩 나오게 된다. 이렇게 함으로써 k번째의 숫자가 무엇인지 바로 찾아낼 수 있다.
 * 즉 배열의 인덱스는 (k-1)/(n!/n) = (k-1)/(n-1)!이다
 * 중복을 제외한 요소들에서는 k = (k-1) % (n-1)!으로 수행하면 된다다 */
public class lv2_줄서는방법 {

    class Solution {
        public int[] solution(int n, long k) {
            int[] answer = new int[n];

            //숫자는 n!/n개씩 나옴
            List<Integer> list = new ArrayList<>();
            long factorial = 1;
            int idx = 0;

            for(int i=1;i<=n;i++){
                factorial *= i;
                list.add(i);
            }

            k--;

            while(n>0){
                factorial /= n;
                int val = (int) (k/factorial);
                answer[idx] = list.get(val);
                list.remove(val);
                // System.out.println("factorial = "+ factorial + " val = "+val);
                k %= factorial;
                idx++;
                n--;
                // System.out.println("k= "+k);
            }

            return answer;
        }
    }
}
