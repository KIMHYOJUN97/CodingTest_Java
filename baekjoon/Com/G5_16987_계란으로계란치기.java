package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * 문제를 소개하기 전, 계란으로 계란을 치게 될 경우 어떤 일이 벌어지는지를 먼저 이해하고 가자.
 * 각 계란에는 내구도와 무게가 정해져있다. 계란으로 계란을 치게 되면 각 계란의 내구도는 상대 계란의 무게만큼 깎이게 된다.
 * 그리고 내구도가 0 이하가 되는 순간 계란은 깨지게 된다.
 * 예를 들어 계란 1의 내구도가 7, 무게가 5이고 계란 2의 내구도가 3, 무게가 4라고 해보자. 계란 1으로 계란 2를 치게 되면 계란 1의 내구도는 4만큼 감소해 3이 되고 계란 2의 내구도는 5만큼 감소해 -2가 된다.
 * 충돌 결과 계란 1은 아직 깨지지 않았고 계란 2는 깨졌다.
 * <p>
 * 유현이가 인범이에게 알려준 퍼즐은 일렬로 놓여있는 계란에 대해 왼쪽부터 차례로 들어서 한 번씩만 다른 계란을 쳐 최대한 많은 계란을 깨는 문제였다. 구체적으로 계란을 치는 과정을 설명하면 아래와 같다.
 * <p>
 * 1.가장 왼쪽의 계란을 든다.
 * <p>
 * 2.손에 들고 있는 계란으로 깨지지 않은 다른 계란 중에서 하나를 친다.
 * 단, 손에 든 계란이 깨졌거나 깨지지 않은 다른 계란이 없으면 치지 않고 넘어간다.
 * 이후 손에 든 계란을 원래 자리에 내려놓고 3번 과정을 진행한다.
 * <p>
 * 3.가장 최근에 든 계란의 한 칸 오른쪽 계란을 손에 들고 2번 과정을 다시 진행한다.
 * 단, 가장 최근에 든 계란이 가장 오른쪽에 위치한 계란일 경우 계란을 치는 과정을 종료한다.
 * <p>
 * 이 과정을 통해 최대한 많은 계란을 깨는 것이 앞으로 인범이가 매일 아침마다 풀게 될 퍼즐이다.
 * 그리고 유현이는 인범이가 찾은 답이 정답이 맞는지 확인해주려고 한다.
 * 일렬로 놓인 계란들의 내구도와 무게가 차례대로 주어졌을 때 최대 몇 개의 계란을 깰 수 있는지 알아맞춰보자.
 * <p>
 * 3
 * 8 5
 * 1 100
 * 3 5
 * <p>
 * 3
 * <p>
 * 왼쪽부터 차례대로 들어 올려서 침 -> i부터 n까지 계란치기.
 */
public class G5_16987_계란으로계란치기 {

    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = stoi(br.readLine());
        List<Egg> eggs = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] s = br.readLine().split(" ");
            int p = stoi(s[0]);
            int w = stoi(s[1]);
            eggs.add(new Egg(p, w));
        }

        dfs(eggs, 0);

        System.out.println(answer);
    }

    static void dfs(List<Egg> eggs, int idx) {
        if (idx == eggs.size()) {
            answer = Math.max(answer, count(eggs));
            return;
        }

        if (eggs.get(idx).p <= 0) {
            dfs(eggs, idx + 1);
        } else {
            boolean flag = false;
            for (int i = 0; i < eggs.size(); i++) {
                if (i == idx || eggs.get(i).p <= 0) {
                    continue;
                }
                flag = true;
                eggs.get(idx).p -= eggs.get(i).w;
                eggs.get(i).p -= eggs.get(idx).w;
                dfs(eggs, idx + 1);
                eggs.get(idx).p += eggs.get(i).w;
                eggs.get(i).p += eggs.get(idx).w;
            }
            if (!flag) {
                dfs(eggs, idx + 1);
            }
        }
    }

    static int count(List<Egg> eggs) {
        int cnt = 0;
        for (Egg egg : eggs) {
            if (egg.p <= 0) {
                cnt++;
            }
        }
        return cnt;
    }

    static class Egg {
        int p;
        int w;

        public Egg(int p, int w) {
            this.p = p;
            this.w = w;
        }
    }

    static int stoi(String s) {
        return Integer.parseInt(s);
    }
}
