package programmers.tommorowCote.Set;
/*
문제
두 문자열 s와 skip, 그리고 자연수 index가 주어질 때, 다음 규칙에 따라 문자열을 만들려 합니다.
암호의 규칙은 다음과 같습니다.
- 문자열 s의 각 알파벳을 index만큼 뒤의 알파벳으로 바꿔줍니다.
- index만큼의 뒤의 알파벳이 z를 넘어갈 경우 다시 a로 돌아갑니다.
- skip에 있는 알파벳은 제외하고 건너뜁니다.

제한사항
5 ≤ s의 길이 ≤ 50
1 ≤ skip의 길이 ≤ 10
s와 skip은 알파벳 소문자로만 이루어져 있습니다.
skip에 포함되는 알파벳은 s에 포함되지 않습니다.
1 ≤ index ≤ 20

입출력 예
s	    skip	index	result
"aukks"	"wbqd"	5	    "happy"

의사 코드
1. 일단 알파벳 리스트를 먼저 만들자.
2. 만든 알파벳 리스트 중 skip에 포함되는건 빼자.
3. 남은 알파벳의 길이를 최대 인덱스 번호라고 치자.
4. 최대 인덱스 번호를 넘으면 넘은만큼 a부터 시작하자.
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OurPasswordOwn {
    public static void main(String[] args) {
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String answer = solution(s, skip, index);
        System.out.println("answer = " + answer);
    }

    public static String solution(String s, String skip, int index){
        StringBuilder answer = new StringBuilder();
        List<Character> useAlphabet = new ArrayList<>(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'));

        // skip에 해당하는 문자 삭제
        for (int i = 0; i < skip.length(); i++) {
            char skipWord = skip.charAt(i);
            useAlphabet.remove(Character.valueOf(skipWord));
        }

        int maxIndex = useAlphabet.size();

        // s 문자열의 각 문자를 변환
        for (int i = 0; i < s.length(); i++) {
            char currentWord = s.charAt(i);
            int check = useAlphabet.indexOf(currentWord);

            check = (check + index) % maxIndex;
            char newWord = useAlphabet.get(check);
            answer.append(newWord);
        }

        return answer.toString();
    }
}
