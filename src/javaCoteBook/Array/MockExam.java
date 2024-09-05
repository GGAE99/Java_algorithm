package javaCoteBook.Array;

import java.util.ArrayList;
import java.util.Arrays;

/*
문제
수포자는 수학을 포기한 사람을 줄인 표현입니다.
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다.
수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

• 1번 수포자가 찍는 방식 : 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
• 2번 수포자가 찍는 방식 : 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
• 3번 수포자가 찍는 방식 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5,

1번 문제부터 마지막 문제까지의 정답이 순서대로 저장된 배열 answers가 주어졌을 때
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 반환하도록 solution 함수를 작성하시오

제약 조건
• 시험은 최대 10,000 문제로 구성되어 있습니다.
• 문제의 정답은 1, 2, 3, 4, 5 중 하나입니다.
• 가장 높은 점수를 받은 사람이 여럿이라면 반환하는 값을 오름차순으로 정렬하세요.

입출력의 예
answers             return
[1, 2, 3, 4, 5]     [1]
[1, 3, 2, 4, 2]     [1, 2, 3]

의사 코드
1. 수포자 3명의 정답 찍는 패턴을 파악한다
2. 패턴과 정답을 비교하며 맞춘 숫자를 각각 구한다
3. 가장 높은 점수를 얻은 사람의 번호를 보낸다.
 */
public class MockExam {
    public static void main(String[] args) {
        int[] numbers = {1,2,3,4,5};
        int[] numbers2 = {2,3,1,4,2,2,2,1,2,5,5,3,2,1,2,3,4,1,2,3,4,1,2,3,1,2,3,3,1,1,2,3,5,5,5};
        int[] answer = solution(numbers);
        int[] answer2 = solution(numbers2);
        System.out.println(Arrays.toString(answer));
        System.out.println(Arrays.toString(answer2));
    }

    public static int[] solution(int[] answers){
        int[] neverMathOne = {1,2,3,4,5};
        int[] neverMathTwo = {2,1,2,3,2,4,2,5};
        int[] neverMathThree = {3,3,1,1,2,2,4,4,5,5};
        int[] counts = new int[3];
        ArrayList<Integer> answer = new ArrayList<>();

        for(int i=0; i<answers.length; i++){
            if(answers[i] == neverMathOne[i%neverMathOne.length]){
                counts[0] += 1;
            }
            if(answers[i] == neverMathTwo[i%neverMathTwo.length]){
                counts[1] += 1;
            }
            if(answers[i] == neverMathThree[i%neverMathThree.length]){
                counts[2] += 1;
            }
        }
        int maxNum = 0;
        // 최고 점수 찾기
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > maxNum) {
                maxNum = counts[i];
                answer.clear(); // 새로운 최고 점수 등장 시 리스트 초기화
                answer.add(i + 1);
            } else if (counts[i] == maxNum) {
                answer.add(i + 1);
            }
        }
        // ArrayList를 int 배열로 변환하여 반환
        int[] result = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }
}
