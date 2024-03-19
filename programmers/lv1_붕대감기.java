package programmers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * t초 동안 붕대를 감으면서 1초마다 x만큼의 체력 회복
 * t초 연속으로 붕대를 감는데 성공하면 y만큼 추가 체력 회복
 * 현재 체력이 최대 체력보다 커지면 안됨.(X)
 * <p>
 * 도중에 몬스터에게 공격당하면 기술 취소 -> 당하는 순간에는 체력을 회복할 수 없음
 * 취소당하거나 기술이 끝나면 즉시 붕대감기 사용하여 연속 성공시간 0으로 초기화
 * <p>
 * 공격 받으면 정해진 피해량만큼 체력이 줄어듬.
 * 0 이하가 되면 더 이상 체력을 회복할 수 없습니다.
 * <p>
 * 캐릭터가 끝까지 생존할 수 있는 지 확인.
 */

/**
 * bandage
 * 시전 시간, 초당 회복량, 추가 회복량
 * <p>
 * attack
 * 공격 시간, 피해량
 * <p>
 * 공격 끝난 후 남은 체력 return
 * 죽으면 -1 return
 */
public class lv1_붕대감기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] bandage = {5, 1, 5};
        int health = 30;
        int[][] attacks = {{2, 10}, {9, 15}, {10, 5}, {11, 5}};
        System.out.println(solution(bandage, health, attacks));
    }

    static int solution(int[] bandage, int health, int[][] attacks) {
        int lastTime = attacks[attacks.length - 1][0];
        int currentHP = health;
        int sequenceSuccess = 0;
        int attackTime = 0;
        for (int currentTime = 1; currentTime <= lastTime; currentTime++) {
            if (attacks[attackTime][0] == currentTime) {
                currentHP -= attacks[attackTime++][1];
                sequenceSuccess = 0;
                if (currentHP <= 0) {
                    return -1;
                }
            } else {
                sequenceSuccess++;
                currentHP += bandage[1];
                if (sequenceSuccess % bandage[0] == 0) {
                    currentHP += bandage[2];
                }

                if (currentHP > health) currentHP = health;
            }

        }
        return currentHP;
    }

}
