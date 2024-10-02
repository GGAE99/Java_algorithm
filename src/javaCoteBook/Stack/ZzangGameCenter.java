package javaCoteBook.Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/*
문제
인형뽑기를 진행한다.
인형을 뽑는 순서가 담긴 배열이 주어지고, 뽑을때는 위에 있는 인형부터 뽑는다.
뽑은 인형은 바구니에 넣고 차곡차곡 쌓는다.
쌓는 과정 중 같은 인형끼리 만나면 펑~ 터진다.
애니팡된 인형의 수를 구하여라

제약 조건
• board는 2차원 배열, 크기는 5 × 5 이상 30 × 30 이하입니다.
• board의 각 칸에는 0 이상 100 이하인 정수가 담겨 있습니다.
- 0은 빈 칸을 나타냅니다.
- 1 ~ 100의 각 숫자는 각기 다른 인형의 모양을 의미하며 같은 숫자는 같은 모양의 인형을
나타냅니다.
• moves 배열 크기는 1 이상 1,000 이하입니다.
• moves 배열 각 원소들의 값은 1 이상이며 board 배열의 가로 크기 이하인 자연수입니다.

입출력의 예
board                                                                                 moves                     result
[[0, 0, 0, 0, 0], [0, 0, 1, 0, 3], [0, 2, 5, 0, 1], [4, 2, 4, 4, 2], [3, 5, 1, 3, 1]] [1, 5, 3, 5, 1, 2, 1, 4]  4

의사 코드
1. 보드와 움직이는 순서를 받는다.
2. 먼저 필요없는 0 값들을 지운다.
3. 움직이는 순서에따라 차례대로 인형을 뽑고 바구니(스택)에 넣는다.
4. 가장 최근에 넣은 인형이 같다면 pop하고 아니면 쌓는다.
5. 이 과정에서 만약 뽑으려는 곳에 인형이 비어있다면 다음 차례로 넘긴다.
 */
public class ZzangGameCenter {
    public static void main(String[] args) {
        int [][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };
        int [] moves = {1, 5, 3, 5, 1, 2, 1, 4};
        // 4 3 1 1 3 2 4
        int answer = solution(board, moves);
        System.out.println(answer);
    }

    public static int solution(int[][] boards, int[] moves){
        int answer = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        List<List<Integer>> result = new ArrayList<>();

        // 각 내부 리스트에 [0]을 추가
        for (int i = 0; i < boards.length; i++) {
            List<Integer> innerList = new ArrayList<>();
            innerList.add(0); // 각 내부 리스트에 0 추가
            result.add(innerList); // 내부 리스트를 외부 리스트에 추가
        }

        for (int i = 0; i < boards.length; i++) {
            for (int j = boards.length-1; j > -1; j--) {
                int value = boards[j][i];
                if (value == 0) {
                    break; // 값이 0이면 건너뜀
                }
                result.get(i).add(value); // 리스트에 값 추가
            }
        }
        stack.push(0);
        for(int move : moves){
            List<Integer> check = result.get(move-1);
            if(check.get(check.size()-1).equals(0)) {
                continue;
            }
            int value = check.remove(check.size()-1);

            if(stack.peek() != value){
                stack.push(value);
            }else{
                stack.pop();
                answer +=2;
            }
        }
        return answer;
    }
}
