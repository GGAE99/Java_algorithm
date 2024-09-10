package javaCoteBook.Stack;

import java.util.Stack;
/*
문제

제약 조건
• 문자열 s의 길이 : 100,000 이하의 자연수
• 문자열 s는 ‘(’ 또는 ‘)’로만 이루어져 있습니다.
입출력의 예
s           answer
“()()”      true
“(())()”    true

의사 코드
1. 받은 괄호 데이터를 순회한다.
2. `(`를 받을때는 데이터를 집어넣고 `)`를 받을때는 데이터를 뺀다.
3. 데이터를 뺄때는 스택에 데이터가 남아있는지 확인한다.
4. 받은 괄호 데이터를 무사히 순회했다면 마지막으로 스택이 비어있는지 확인한다.
 */
public class BodyRightParentheses {
    public static void main(String[] args) {
        String s = "()()(";
        boolean answer = solution(s);
        System.out.println(answer);
    }

    public static boolean solution(String s){
        Stack<Character> check = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);
            switch (parentheses){
                case '(':
                    check.push('(');
                    break;
                case ')':
                    if(!check.isEmpty()){
                        check.pop();
                    }else{
                        return false;
                    }
                    break;
            }
        }
        return check.isEmpty();
    }
}

