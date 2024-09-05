package javaCoteBook.Array;

/*
문제
정수 배열을 정렬해서 반환하는 solution( ) 함수를 완성하세요.

제약 조건
• 정수 배열의 길이는 2 이상 105 이하입니다.
• 정수 배열의 각 데이터 값은 -100,000 이상 100,000 이하입니다.

입출력의 예
입력                      출력
[1, -5, 2, 4, 3]        [-5, 1, 2, 3, 4]
[2, 1, 1, 3, 2, 5, 4]   [1, 1, 2, 2, 3, 4, 5]
[6, 1, 7]               [1, 6, 7]
*/

/*
의사 코드
1. 값들을 입력받는다.
2. 값을 정렬한다.
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class BodyCheckSortArray {
//    public static void main(String[] args) {
//        int[] org = {4, 2, 3, 1, 5};
//        int[] sorted = solution(org);
//        System.out.println(Arrays.toString(org)); // [4, 2, 3, 1, 5]
//        System.out.println(Arrays.toString(sorted)); // [1, 2, 3, 4, 5]
//    }
//
//    private static int[] solution(int[] arr) {
//        Arrays.sort(arr);
//        return arr;
//    }
    public static void main(String[] args) {
        ArrayList<Integer> org = new ArrayList<>(Arrays.asList(4,2,3,1,5));
        ArrayList<Integer> sorted = solution(org);
        System.out.println(sorted.toString());
    }

    private static ArrayList<Integer> solution(ArrayList<Integer> arr) {
        Collections.sort(arr);
        return arr;
    }
}
