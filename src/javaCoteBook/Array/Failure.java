package javaCoteBook.Array;

/*
문제
신규 사용자와 기존 사용자 사이에 스테이지 차이가 너무 큰 것 때문에 사용자가 급감했다.
그래서 동적으로 게임 시간을 늘려서 난이도를 조절하기로 했다.
로직 구현 중 실패율을 구하는 부분에서 위기에 빠졌다.
실패유을 구하는 코드를 완성하라

실패율은 다음과 같이 정의한다.
스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수

전체 스테이지의 개수 N
게임을 이용하는 사용자가 현재 멈춰있는 스테이지의 번호가 담긴 배열 stages

실패율이 높은 스테이지부터 내림차순으로 스테이지의 번호가 담겨있는 배열을 return 하도록 solution 함수를 완성하라.

제한사항
스테이지의 개수 N은 1 이상 500 이하의 자연수이다.
stages의 길이는 1 이상 200,000 이하이다.
stages에는 1 이상 N + 1 이하의 자연수가 담겨있다.
각 자연수는 사용자가 현재 도전 중인 스테이지의 번호를 나타낸다.
단, N + 1 은 마지막 스테이지(N 번째 스테이지) 까지 클리어 한 사용자를 나타낸다.
만약 실패율이 같은 스테이지가 있다면 작은 번호의 스테이지가 먼저 오도록 하면 된다.
스테이지에 도달한 유저가 없는 경우 해당 스테이지의 실패율은 0 으로 정의한다.

입출력의 예
N stages                    result
5 [2, 1, 2, 6, 2, 4, 3, 3]  [3, 4, 2, 1, 5]
4 [4, 4, 4, 4, 4]           [4, 1, 2, 3]

의사 코드
1. 스테이지에 도달한 배열과 스테이지 수를 받는다.
2. 각 스테이지마다 도달한 인원을 담은 데이터를 만든다.
3. 높은 스테이지에 도달한 사람 수 부터 더하면서 조회한 스테이지에 도달한 사람 수를 구한다.
4. 동시에 클리어하지 못한 사람의 수를 나눠서 실패율을 저장한다.
5. 실패율을 내림차순으로 정렬하고 return한다.
 */


import java.util.*;

public class Failure {
    public static void main(String[] args) {
        int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
        int N = 5;
        int[] answer = solution(N, stages);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int N, int[] stages){
        int[] stageUsers = new int[N+1];
        int total = 0;
        Map<Integer, Float>fails = new HashMap<Integer, Float>();
        for(int stage:stages){
            stageUsers[stage] += 1;
        }
        for(int i=N+1;i>0;i--){
            total+=stageUsers[i];
            fails.put(i,(float) stageUsers[i]/total);
        }
        // Entry 리스트로 변환
        List<Map.Entry<Integer, Float>> list = new ArrayList<>(fails.entrySet());

        // Comparator로 정렬: value 내림차순, value가 같으면 key 오름차순
        list.sort((entry1, entry2) -> {
            int valueCompare = entry2.getValue().compareTo(entry1.getValue());
            if (valueCompare == 0) {
                // value가 같을 경우 key를 기준으로 오름차순 정렬
                return entry1.getKey().compareTo(entry2.getKey());
            } else {
                return valueCompare;
            }
        });
        List<Integer> keyList = new ArrayList<>();
        for (Map.Entry<Integer, Float> entry : list) {
            keyList.add(entry.getKey());
        }
        return keyList.stream().mapToInt(i -> i).toArray();
    }
}
