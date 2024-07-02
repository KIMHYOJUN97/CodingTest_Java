package baekjoon.Com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class _test_ever {

    // 클래스 정의: 아이템
    static class Item {
        int weight;
        int value;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }

    // 최대값 저장
    static int maxProfit = 0;

    public static void main(String[] args) {
        // 아이템 리스트 초기화
        Item[] items = {
                new Item(2, 3),
                new Item(3, 4),
                new Item(4, 5),
                new Item(5, 8)
        };

        // 배낭 용량 배열 초기화
        int[] capacities = {10, 15};

        // 백트래킹 시작
        backtrack(items, capacities, 0, new int[capacities.length], 0);

        // 결과 출력
        System.out.println("Maximum profit: " + maxProfit);
    }

    // 백트래킹 함수
    static void backtrack(Item[] items, int[] capacities, int currentItem, int[] currentWeights, int currentProfit) {
        if (currentItem == items.length) {
            // 모든 아이템을 확인한 경우 최대값 갱신
            maxProfit = Math.max(maxProfit, currentProfit);
            return;
        }

        // 현재 아이템을 각 배낭에 넣어보는 경우를 시도
        for (int i = 0; i < capacities.length; i++) {
            if (currentWeights[i] + items[currentItem].weight <= capacities[i]) {
                // 현재 배낭에 아이템을 추가할 수 있는 경우
                currentWeights[i] += items[currentItem].weight;
                backtrack(items, capacities, currentItem + 1, currentWeights, currentProfit + items[currentItem].value);
                // 백트래킹: 상태 복원
                currentWeights[i] -= items[currentItem].weight;
            }
        }

        // 현재 아이템을 어느 배낭에도 넣지 않는 경우
        backtrack(items, capacities, currentItem + 1, currentWeights, currentProfit);
    }

}
