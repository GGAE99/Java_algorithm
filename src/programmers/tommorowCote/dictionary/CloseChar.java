package programmers.tommorowCote.dictionary;

import java.util.Arrays;
import java.util.HashMap;

/*
문제
문자열 s가 주어졌을 때, s의 각 위치마다 자신보다 앞에 나왔으면서, 자신과 가장 가까운 곳에 있는 같은 글자가 어디 있는지 알고 싶습니다.
예를 들어, s="banana"라고 할 때,  각 글자들을 왼쪽부터 오른쪽으로 읽어 나가면서 다음과 같이 진행할 수 있습니다.

b는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
n은 처음 나왔기 때문에 자신의 앞에 같은 글자가 없습니다. 이는 -1로 표현합니다.
a는 자신보다 두 칸 앞에 a가 있습니다. 이는 2로 표현합니다.
n도 자신보다 두 칸 앞에 n이 있습니다. 이는 2로 표현합니다.
a는 자신보다 두 칸, 네 칸 앞에 a가 있습니다. 이 중 가까운 것은 두 칸 앞이고, 이는 2로 표현합니다.
따라서 최종 결과물은 [-1, -1, -1, 2, 2, 2]가 됩니다.

제한사항
1 ≤ s의 길이 ≤ 10,000
s은 영어 소문자로만 이루어져 있습니다.

입출력 예
s	        result
"banana"	[-1, -1, -1, 2, 2, 2]
"foobar"	[-1, -1, 1, -1, -1, -1]

의사 코드
1. 모든 알파벳의 최근 위치를 저장하고 있는 dictionary를 만들어둔다. -1로 초기화할거다.
2. 받은 문자열을 for문 돌면서 for문의 인덱스와 가장 최근 위치를 비교한다.
3. 만약 비교한 값이 -1이면 반환값에 -1을 내놓고, 아니라면 저장되어있는 값과 현재 값을 비교한 수치를 넣는다.
 */
public class CloseChar {
    public static void main(String[] args) {
        String s = "foobar";
        int[] answer = solution(s);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(String s){
        int[] answer = new int[s.length()];
        HashMap<Character, Integer> alphabetMap = new HashMap<>();

        // 'a'부터 'z'까지의 소문자 알파벳을 키로 하고, 값을 -1로 설정
        for (char ch = 'a'; ch <= 'z'; ch++) {
            alphabetMap.put(ch, -1);
        }
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(alphabetMap.get(c) == -1){
                answer[i] = -1;
            }else{
                answer[i] = i - alphabetMap.get(c);
            }
            alphabetMap.put(c,i);
        }
        return answer;
    }
}
