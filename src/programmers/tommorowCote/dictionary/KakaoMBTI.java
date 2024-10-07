package programmers.tommorowCote.dictionary;

/*
## 문제
성격 유형 검사를 만들려고한다.
지표는 다음과 같은 4개 지표로 구성되어있다.
지표 번호	성격 유형
1번 지표	    라이언형(R), 튜브형(T)
2번 지표	    콘형(C), 프로도형(F)
3번 지표	    제이지형(J), 무지형(M)
4번 지표	    어피치형(A), 네오형(N)

4개의 지표가 있으므로 총 16가지의 결과가 나올 수 있다.
검사지에는 총 n개의 질문이 있고, 각 질문에는 7개의 선택지가 있다.
survey로 온 원소의 앞에 원소 기준이다.
- 매우 비동의 || 3점
- 비동의 || 2점
- 약간 비동의 || 1점
- 모르겠음 || 0점
- 약간 동의 || 반대 유형에 1점
- 동의 || 반대 유형에 2점
- 매우 동의 || 반대 유형에 3점

검사 결과는 모든 질문의 성격 유형 점수를 더하여 각 지표에서 더 높은 점수를 받은 성격 유형이 검사자의 성격 유형이라고 판단한다.
단, 하나의 지표에서 각 성격 유형 점수가 같으면, 두 성격 유형 중 사전 순으로 빠른 성격 유형을 검사자의 성격 유형이라고 판단한다.

## 제한사항
1 ≤ survey의 길이 ( = n) ≤ 1,000
    survey의 원소는 "RT", "TR", "FC", "CF", "MJ", "JM", "AN", "NA" 중 하나입니다.
    survey[i]의 첫 번째 캐릭터는 i+1번 질문의 비동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.
    survey[i]의 두 번째 캐릭터는 i+1번 질문의 동의 관련 선택지를 선택하면 받는 성격 유형을 의미합니다.

choices의 길이 = survey의 길이
    choices[i]는 검사자가 선택한 i+1번째 질문의 선택지를 의미합니다.
    1 ≤ choices의 원소 ≤ 7

choices	    뜻
1	        매우 비동의
2	        비동의
3	        약간 비동의
4	        모르겠음
5	        약간 동의
6	        동의
7	        매우 동의

## 입출력 예
survey	                        choices	            result
["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	    "TCMA"
["TR", "RT", "TR"]	            [7, 1, 3]	        "RCJA"

## 의사 코드
1. survey의 원소에서 각 유형의 순서가 바꿔서 나오는 경우도 있으니 그냥 모든 Key값을 구하자.
2. survey와 choice를 보고 판단해서 값을 더해주자.
3. 모든 연산이 끝났으면 묶여있는 유형끼리 비교하고, 같으면 사전순으로 빠른 단어를 올리자.
 */

import java.util.HashMap;

public class KakaoMBTI {
    public static void main(String[] args) {
        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5,3,2,7,5};
        String answer = solution(survey, choices);
        System.out.println("answer = " + answer);
    }

    public static String solution(String[] survey, int[] choices){
        String answer = "";
        HashMap<Character, Integer> MBTIDictionary = new HashMap<>();

        MBTIDictionary.put('R', 0);
        MBTIDictionary.put('T', 0);
        MBTIDictionary.put('C', 0);
        MBTIDictionary.put('F', 0);
        MBTIDictionary.put('J', 0);
        MBTIDictionary.put('M', 0);
        MBTIDictionary.put('A', 0);
        MBTIDictionary.put('N', 0);

        for(int i=0; i<choices.length; i++){
            int choice = choices[i];
            char firstChar = survey[i].charAt(0);
            char secondChar = survey[i].charAt(1);
            switch (choice){
                case 1:
                    MBTIDictionary.put(firstChar, MBTIDictionary.get(firstChar)+3);
                    break;
                case 2:
                    MBTIDictionary.put(firstChar, MBTIDictionary.get(firstChar)+2);
                    break;
                case 3:
                    MBTIDictionary.put(firstChar, MBTIDictionary.get(firstChar)+1);
                    break;
                case 5:
                    MBTIDictionary.put(secondChar, MBTIDictionary.get(secondChar)+1);
                    break;
                case 6:
                    MBTIDictionary.put(secondChar, MBTIDictionary.get(secondChar)+2);
                    break;
                case 7:
                    MBTIDictionary.put(secondChar, MBTIDictionary.get(secondChar)+3);
                    break;
            }
        }
        answer += (MBTIDictionary.get('R') >= MBTIDictionary.get('T')) ? 'R' : 'T';
        answer += (MBTIDictionary.get('C') >= MBTIDictionary.get('F')) ? 'C' : 'F';
        answer += (MBTIDictionary.get('J') >= MBTIDictionary.get('M')) ? 'J' : 'M';
        answer += (MBTIDictionary.get('A') >= MBTIDictionary.get('N')) ? 'A' : 'N';

        return answer;
    }
}
