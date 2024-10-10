package programmers.tommorowCote.dictionary;

import java.util.HashMap;

/*
문제
네오와 프로도가 숫자놀이를 하고 있습니다.
네오가 프로도에게 숫자를 건넬 때 일부 자릿수를 영단어로 바꾼 카드를 건네주면 프로도는 원래 숫자를 찾는 게임입니다.
다음은 숫자의 일부 자릿수를 영단어로 바꾸는 예시입니다.
1478 → "one4seveneight"
234567 → "23four5six7"
10203 → "1zerotwozero3"
이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다.
s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.

숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine

제한사항
1 ≤ s의 길이 ≤ 50
s가 "zero" 또는 "0"으로 시작하는 경우는 주어지지 않습니다.
return 값이 1 이상 2,000,000,000 이하의 정수가 되는 올바른 입력만 s로 주어집니다.

입출력 예
s	                    result
"one4seveneight"	    1478
"23four5six7"	        234567
"2three45sixseven"	    234567
"123"	                123

의사 코드
1. 받은 값을 for문을 돌며 확인한다.
2. 먼저 int값인지 아닌지를 확인하고, int값이라면 답에 값을 추가한다.
3. int값이 아니라면 딕셔너리를 사용해 만든 숫자와 영어의 구조를 비교하여 올바른 숫자를 뽑는다.
4. 일치하는 값이 있을 때 값을 추가해준다.
 */
public class NumberStringAndEng {
    public static void main(String[] args) {
        String s = "one4seveneight";
        int answer = solution(s);
        System.out.println("answer = " + answer);
    }

    public static int solution(String s) {
        String answer = "";
        HashMap<String, Integer> dic = new HashMap<>();

        dic.put("zero",0);
        dic.put("one",1);
        dic.put("two",2);
        dic.put("three",3);
        dic.put("four",4);
        dic.put("five",5);
        dic.put("six",6);
        dic.put("seven",7);
        dic.put("eight",8);
        dic.put("nine",9);

        String check="";
        for(int i=0; i<s.length(); i++){
            char part = s.charAt(i);
            if(Character.isDigit(part)){
                answer += part;
            }else{
                check += part;
                if(dic.containsKey(check)){
                    answer += dic.get(check);
                    check = "";
                }
            }
        }
        return Integer.parseInt(answer);
    }
}
