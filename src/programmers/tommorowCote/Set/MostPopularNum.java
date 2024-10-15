package programmers.tommorowCote.Set;

import java.util.HashMap;
import java.util.Map;

public class MostPopularNum {
    public static int solution(int[] array) {
        // 각 숫자의 빈도를 저장할 맵
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        // 배열 순회하면서 빈도 계산
        for (int num : array) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int maxFreq = 0;    // 최빈값의 빈도
        int mode = -1;      // 최빈값
        boolean isMultiple = false; // 최빈값이 여러 개인지 여부

        // 빈도 맵을 순회하면서 최빈값 찾기
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq > maxFreq) {
                maxFreq = freq;
                mode = num;
                isMultiple = false; // 새로운 최빈값이 등장했으므로 여러 개 아님
            } else if (freq == maxFreq) {
                isMultiple = true; // 같은 빈도의 다른 값이 있으므로 여러 개임
            }
        }

        // 최빈값이 여러 개인 경우 -1 반환
        return isMultiple ? -1 : mode;
    }

    public static void main(String[] args) {
        // 테스트 케이스
        System.out.println(solution(new int[]{1, 2, 3, 3, 3, 4})); // 3
        System.out.println(solution(new int[]{1, 1, 2, 2}));       // -1
        System.out.println(solution(new int[]{1}));                // 1
    }
}
