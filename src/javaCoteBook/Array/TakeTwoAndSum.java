package javaCoteBook.Array;

import java.util.Arrays;
import java.util.HashSet;

/*
문제
정수 배열 numbers가 주어집니다. numbers에서 서로 다른 인덱스에 있는 2개의 수를 뽑아 더해
만들 수 있는 모든 수를 배열에 오름차순으로 담아 반환하는 solution( ) 함수를 완성하세요.

제약 조건
• numbers의 길이는 2 이상 100 이하입니다.
• numbers의 모든 수는 0 이상 100 이하입니다.

입출력의 예
numbers             result
[2, 1, 3, 4, 1]     [2, 3, 4, 5, 6, 7]
[5, 0, 2, 7]        [2, 5, 7, 9, 12]

의사 코드
1. 정수 배열을 받아온다.
2. 출력값을 보니 중복을 허용하지 않는다. 그러므로 먼저 정수 배열을 중복이 없는 값으로 만든다.
3. 서로 다른 인덱스에 있는 2개의 수를 뽑아 더하는 모든 경우의 수 이므로 모든 조건을 다 탐색한다.
4. 모든 조건을 다 수행한 결과를 저장한 배열을 오름차순으로 정렬한다.
5. 결과를 return 한다.

의사 코드 복기
1. 받은 정수 배열을 먼저 중복이 없는 값으로 만드니 중복된 수 끼리의 덧셈이 안된다. 이렇게 하면 틀린다.
 */
public class TakeTwoAndSum {
    public static void main(String[] args) {
        int[] numbers = {2,1,3,4,1};
        int[] answer = solution(numbers);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(int[] numbers){
        HashSet<Integer> set = new HashSet<>();
        for(int i=0; i<numbers.length; i++){
            for(int j=i+1; j<numbers.length; j++){
                set.add(numbers[i] + numbers[j]);
            }
        }
        int[] answer = set.stream().mapToInt(Integer::intValue).toArray();
        Arrays.sort(answer);
        return answer;
    }
}
