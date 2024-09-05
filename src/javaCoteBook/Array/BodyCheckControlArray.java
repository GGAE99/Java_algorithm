package javaCoteBook.Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/*
문제
정수 배열을 하나 받습니다.
배열의 중복값을 제거하고 배열 데이터를 내림차순으로 정렬해서 반환하는 solution( ) 함수를 구현하세요.

제약 조건
• 배열 길이는 2 이상 1,000 이하입니다.
• 각 배열의 데이터 값은 -100,000 이상 100,000 이하입니다

입출력의 예
입력                     출력
[4, 2, 2, 1, 3, 4]      [4, 3, 2, 1]
[2, 1, 1, 3, 2, 5, 4]   [5, 4, 3, 2, 1]

의사 코드
1. 정수 배열을 받는다.
2. 배열을 중복이 사라지는 자료형에 담는다.
3. 내림차순으로 정렬한다
4. 돌려보낸다.
 */
public class BodyCheckControlArray {
//    public static void main(String[] args) {
//        int[] org = {5,5,5,5,1,2,3,4,21,5,2,3,2,4, 2, 2, 1, 3, 4};
//
//        // 배열을 리스트로 변환한 후, Set으로 변환
////      Set<Integer> set = new HashSet<>(Arrays.asList(Arrays.stream(org).boxed().toArray(Integer[]::new)));
//        Set<Integer> set = Arrays.stream(org).boxed().collect(Collectors.toSet());
//        System.out.println(set); // 출력: [1, 2, 3, 4, 5, 21]
//    }
    public static void main(String[] args) {
        int[] org = {5,5,5,5,1,2,3,4,21,5,2,3,2,4, 2, 2, 1, 3, 4};
        int[] answer = solution(org);
        System.out.println(Arrays.toString(answer));
    }


    private static int[] solution(int[] arr) {
        // 1. 중복값 제거
        Integer[] result = Arrays.stream(arr).boxed().distinct().toArray(Integer[]::new);
        Arrays.sort(result, Collections.reverseOrder()); // 2. 내림차순 정렬
        // int형 배열로 변경 후 반환
        return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
    }
}
