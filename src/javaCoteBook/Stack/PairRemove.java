package javaCoteBook.Stack;

import java.util.ArrayDeque;
/*
문제
알파벳 소문자로 구성된 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다.
짝을 찾은 다음에는 그 둘을 제거한 뒤 앞뒤로 문자열을 이어 붙입니다.
이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다.
문자열 S가 주어졌을 때 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성하시오.

제약 조건
• 문자열의 길이 : 1,000,000 이하의 자연수
• 문자열은 모두 소문자로 이루어져 있습니다.

입출력의 예
s           result
“baabaa”    1
“cdcd”      0

의사 코드
1. 받은 문자열을 사용해 반복적인 로직을 수행한다.
2. 그 로직은 스택을 활용한 로직이다.
3. 스택이 비어있다면 스택에 값을 넣고, 만약 스택에 가장 최근에 넣은 값이 현재 넣으려는 값과 같다면 그냥 값을 뽑는다.
4. 그 두 경우 모두 아니라면 스택에 값을 넣는다.
5. 로직을 모두 수행하고 난 이후에도 스택이 비어있지 않다면 틀린 값이라고 본다.
 */

public class PairRemove {
    public static void main(String[] args) {
        String s = "cdcd";
        int answer = solution(s);
        System.out.println("answer = " + answer);
    }

    public static int solution(String s){
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!stack.isEmpty() && stack.peek().equals(c)){
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        if(stack.isEmpty())
            return 1;
        else
            return 0;
    }
}
