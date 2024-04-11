package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 동주는 항상 혼자 노느라 심심하다. 하지만 혼자 놀기의 고수가 된 동주는 매일매일 게임을 개발하여 혼자놀기의 진수를 우리에게 보여준다. 어느 날 동주는 새로운 게임을 개발하였다. 바로 점수 따먹기라는 게임인데 그다지 재밌어 보이지는 않는다.
 * <p>
 * 동주가 개발한 게임은 이렇다. 일단 N*M 행렬을 그린 다음, 각 칸에 -10,000 이상 10,000 이하의 정수를 하나씩 쓴다. 그런 다음 그 행렬의 부분행렬을 그려 그 안에 적힌 정수의 합을 구하는 게임이다.
 * <p>
 * 동주가 혼자 재밌게 놀던 중 지나가는 당신을 보고 당신을 붙잡고 게임을 하자고 한다. 귀찮은 당신은 정수의 합이 최대가 되는 부분행렬을 구하여 빨리 동주에게서 벗어나고 싶다.
 * <p>
 * input
 * 첫째 줄에 N (1 < N < 200), M (1 < M < 200)이 주어진다. 그 다음 N개의 줄에 M개씩 행렬의 원소가 주어진다.
 * <p>
 * output
 * 첫째 줄에 최대의 합을 출력하라.
 * <p>
 * 3 5
 * 2 3 -21 -22 -23
 * 5 6 -22 -23 -25
 * -22 -23 4 10 2
 * <p>
 * 16
 */
public class G4_1749_점수따먹기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int n = stoi(s[0]);
        int m = stoi(s[1]);
        int[][] graph = new int[n + 1][m + 1];
        int[][] presum = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            s = br.readLine().split(" ");
            for (int j = 1; j <= m; j++) {
                graph[i][j] = stoi(s[j - 1]);
            }
        }


    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
