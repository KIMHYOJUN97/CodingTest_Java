package baekjoon.Com;

/**
 * 비내림차순으로 정렬된 수열이 주어질 때, 다음 조건을 만족하는 부분 수열을 찾으려고 합니다.
 * <p>
 * 기존 수열에서 임의의 두 인덱스의 원소와 그 사이의 원소를 모두 포함하는 부분 수열이어야 합니다.
 * 부분 수열의 합은 k입니다.
 * 합이 k인 부분 수열이 여러 개인 경우 길이가 짧은 수열을 찾습니다.
 * 길이가 짧은 수열이 여러 개인 경우 앞쪽(시작 인덱스가 작은)에 나오는 수열을 찾습니다.
 * 수열을 나타내는 정수 배열 sequence와 부분 수열의 합을 나타내는 정수 k가 매개변수로 주어질 때, 위 조건을 만족하는 부분 수열의 시작 인덱스와 마지막 인덱스를 배열에 담아 return 하는 solution 함수를 완성해주세요. 이때 수열의 인덱스는 0부터 시작합니다.
 * <p>
 * <p>
 * 5 ≤ sequence의 길이 ≤ 1,000,000
 * 1 ≤ sequence의 원소 ≤ 1,000
 * sequence는 비내림차순으로 정렬되어 있습니다.
 * 5 ≤ k ≤ 1,000,000,000
 * k는 항상 sequence의 부분 수열로 만들 수 있는 값입니다.
 * <p>
 * sequence	        k	result
 * [1, 2, 3, 4, 5]	7	[2, 3]
 * [1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
 * [2, 2, 2, 2, 2]	6	[0, 2]
 */
public class lv2_연속된부분수열의합 {
    public static void main(String[] args) {
        int[] sequence = {1, 2, 3, 4, 5};
        int k = 7;
        int[] result = new int[2];
        int len = Integer.MAX_VALUE;
        int left = 0, right = 0;
        int sum = sequence[left];

        while (left <= right && right < sequence.length) {
            if (left == right) sum = sequence[left];
            if (sum == k) {
                if (right - left < len) {
                    result[0] = left;
                    result[1] = right;
                    len = Math.abs(left - right);
                }

                if (right + 1 < sequence.length) {
                    sum += sequence[right + 1];
                }

                right++;

                // 최적화
                if (left == right) break;
            }
            if (sum < k) {
                if (right + 1 < sequence.length) {
                    sum += sequence[right + 1];
                }
                right++;
            } else {
                sum -= sequence[left];
                left++;
            }
        }

        System.out.println(result[0] + ", " + result[1]);
    }
}
