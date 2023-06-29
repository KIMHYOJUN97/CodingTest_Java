package baekjoon.Week16;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 유령공 없애는 게 중요
 * node의 값들이 한계값을 넘었을 때, 체크해주기.
 */
public class G4_20056_마법사상어와파이어볼_시뮬레이션 {

    static int[] dx = {0,1,1,1,0,-1,-1,-1};
    static int[] dy = {-1,-1,0,1,1,1,0,-1};
    static int[][] board;
    static Queue<Fire> fireball;
    static int n,m,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        n = stoi(inputs[0]);
        m = stoi(inputs[1]);
        k = stoi(inputs[2]);
        board = new int[n][n];
        fireball = new LinkedList<>();
        //r c m s d
        for (int i = 0; i < m; i++) {
            inputs = br.readLine().split(" ");
            Fire fire = new Fire(stoi(inputs[0])-1, stoi(inputs[1])-1, stoi(inputs[2]), stoi(inputs[3]), stoi(inputs[4]));
            board[fire.r][fire.c]++;
            fireball.add(fire);
        }
        int answer = 0;
        for (int t = 0; t < k; t++) {
            List<Fire> fire_list = new ArrayList<>();
            answer = 0;
            //시작하면 이동.
            //q에는 모든 node들이 들어가 있다.
            while(!fireball.isEmpty()){
                int position = n;
                Fire node = fireball.poll();
                board[node.r][node.c]--;
                node.r = node.r + dy[node.d] * node.s;
                if (node.r < 0) {
                    while ((Math.abs(node.r) > position)) {
                        position += n;
                    }
                    node.r = position+node.r;
                }else node.r %= n;
                position = n;
                node.c += dx[node.d] * node.s;
                if (node.c < 0) {
                    while (Math.abs(node.c) > position) {
                        position += n;
                    }
                    node.c = position+node.c;
                }else node.c%=n;

                board[node.r][node.c]++;
                fire_list.add(node);
            }

            //1개만 존재하는 파이어볼 찾기.

            //2개이상 겹친 파이어볼 찾기.
            Queue<int[]> hap = new LinkedList<>();
            Queue<int[]> alone = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] >= 2) {
                        int[] ij = {i, j};
                        hap.add(ij);
                    } else if (board[i][j] == 1) {
                        int[] ij = {i, j};
                        alone.add(ij);
                    }
                }
            }

            //1개인것들은 전부 다시 넣어줌 ->이미 일을 마침.
            for (int[] a : alone) {
                for (int i = 0; i < fire_list.size(); i++) {
                    if (fire_list.get(i).r == a[0] && fire_list.get(i).c == a[1]) {
                        fireball.add(fire_list.get(i));
                        answer += fire_list.get(i).m;
                    }
                }
            }

            //2개 이상의 파이어볼들 합치기.
            for (int[] h : hap) {
                Queue<Fire> wait_q = new LinkedList<>();

                for (int i = 0; i < fire_list.size(); i++) {
                    if (h[0] == fire_list.get(i).r && h[1] == fire_list.get(i).c) {
                        wait_q.add(fire_list.get(i));
                    }
                }

                int m_sum=0;
                int s_sum=0;
                List<Integer> d_sum = new ArrayList<>();
                while (!wait_q.isEmpty()) {
                    Fire now = wait_q.poll();
                    m_sum += now.m;
                    s_sum += now.s;
                    d_sum.add(now.d);
                }

                m_sum /= 5;
                s_sum /= board[h[0]][h[1]];
                if(m_sum>0){
                    answer += m_sum*4;
                    int chk1 = 0;
                    int chk2 = 0;
                    int[] new_direction = new int[4];
                    for (int i = 0; i < d_sum.size(); i++) {
                        if(d_sum.get(i)%2==0) chk1++;
                        else{
                            chk2++;
                        }
                    }
                    if (chk1>0 && chk2>0) {
                        new_direction[0] = 1;
                        new_direction[1] = 3;
                        new_direction[2] = 5;
                        new_direction[3] = 7;
                    }else{
                        new_direction[0] = 0;
                        new_direction[1] = 2;
                        new_direction[2] = 4;
                        new_direction[3] = 6;
                    }

                    board[h[0]][h[1]] = 4;
                    for (int i = 0; i < 4; i++) {
                        fireball.add(new Fire(h[0], h[1], m_sum, s_sum, new_direction[i]));
                    }
                }
                //유령공 없애기
                else{
                    board[h[0]][h[1]] = 0;
                }
            }
        }
        System.out.println(answer);
    }

    static class Fire{
        int r;
        int c;
        int m;
        int s;
        int d;

        public Fire(int r, int c, int m, int s, int d) {
            this.r = r;
            this.c = c;
            this.m = m;
            this.s = s;
            this.d = d;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
