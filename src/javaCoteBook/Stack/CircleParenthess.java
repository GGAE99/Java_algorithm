package javaCoteBook.Stack;

import java.util.ArrayDeque;
import java.util.Map;

/*
문제
(), {}, [] 세가지 타입의 괄호 문자열이 섞여있는 문자열s를 회전시키면서 이 괄호가 올바른 괄호 문자열인지 확인하라.
예를 들어 “[ ] ( ) { }" 문자열이 주어진다면, “[ ] ( ) { }”, “] ( ) { } [”, “( ) { } [ ]”,..., “} [ ] ( ) {” 의 경우의 수에 대해 각각의 회전한 문자열이 올바른 괄호 문자열인지 판별해야한다.

제약 조건
- s의 길이는 1 이상 1,000 이하입니다.

입출력의 예
s               result
“[ ] ( ) { }”   3
“} ] ( ) [ {”   2

의사 코드
1. 문자열을 받는다.
2. 문자열을 슬라이싱한 경우의 수를 모두 확인한다.
3. 각 괄호의 스택을 활용하여 올바른 문자열인지 확인한다.
4. 올바른 문자열일때만 return값을 올린다.
 */
public class CircleParenthess {
    public static void main(String[] args) {
        String s = "}]()[{";
        int answer = solution(s);
        System.out.println("answer = " + answer);
    }

    public static int solution(String s){
        int answer = 0;
        int sLen = s.length();
        Map<Character, Character> map = Map.of(
                '}', '{',
                ']', '[',
                ')', '('
        );
        for(int i=0; i<sLen; i++){
            String check = s.substring(i) + s.substring(0, i);
            System.out.println("check = " + check);
            if(isGoodParent(check, sLen, map)){
                answer++;
            }
        }
        return answer;
    }

    public static boolean isGoodParent(String s, int sLen, Map<Character, Character> map) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < sLen; i++) {
            char parentheses = s.charAt(i);
            if (map.containsValue(parentheses)) {
                stack.push(parentheses);  // 여는 괄호를 스택에 추가
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(parentheses)) {
                    return false;  // 스택이 비어있거나 괄호의 짝이 맞지 않으면 false
                }
            }
        }
        // 최종적으로 스택이 비어있는지 확인, 비어있지 않으면 짝이 맞지 않음
        return stack.isEmpty();
    }
}
