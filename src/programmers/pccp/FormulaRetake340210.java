package programmers.pccp;

/*
문제
당신은 덧셈 혹은 뺄셈 수식이 여러 개 적힌 고대 문명의 유물을 찾았습니다.
이 수식들을 관찰하던 당신은 이 문명이 사용하던 진법 체계가 10진법이 아니라는 것을 알아냈습니다. (2 ~ 9진법 중 하나입니다.)
수식들 중 몇 개의 수식은 결괏값이 지워져 있으며, 당신은 이 문명이 사용하던 진법에 맞도록 지워진 결괏값을 채워 넣으려 합니다.

다음은 그 예시입니다.

<수식>
14 + 3 = 17
13 - 6 = X
51 - 5 = 44
51 - 5 = 44에서 이 문명이 사용하던 진법이 8진법임을 알 수 있습니다.
따라서 13 - 6 = X의 지워진 결괏값을 채워 넣으면 13 - 6 = 5가 됩니다.

<수식>
1 + 1 = 2
1 + 3 = 4
1 + 5 = X
1 + 2 = X
주어진 수식들에서 이 문명에서 사용한 진법이 6 ~ 9진법 중 하나임을 알 수 있습니다.
1 + 5 = X의 결괏값은 6진법일 때 10, 7 ~ 9진법일 때 6이 됩니다. 이와 같이 결괏값이 불확실한 수식은 ?를 사용해 1 + 5 = ?와 같이 결괏값을 채워 넣습니다.
1 + 2 = X의 결괏값은 6 ~ 9진법에서 모두 3으로 같습니다. 따라서 1 + 2 = X의 지워진 결괏값을 채워 넣으면 1 + 2 = 3이 됩니다.

덧셈 혹은 뺄셈 수식들이 담긴 1차원 문자열 배열 expressions가 매개변수로 주어집니다.
이때 결괏값이 지워진 수식들의 결괏값을 채워 넣어 순서대로 문자열 배열에 담아 return 하도록 solution 함수를 완성해 주세요.

제한사항
- 2 ≤ expressions의 길이 ≤ 100
- expressions의 원소는 "A + B = C" 혹은 "A - B = C" 형태의 문자열입니다. A, B, C와 연산 기호들은 공백 하나로 구분되어 있습니다.
- A, B는 음이 아닌 두 자릿수 이하의 정수입니다.
- C는 알파벳 X 혹은 음이 아닌 세 자릿수 이하의 정수입니다. C가 알파벳 X인 수식은 결괏값이 지워진 수식을 의미하며, 이러한 수식은 한 번 이상 등장합니다.
- 결괏값이 음수가 되거나 서로 모순되는 수식은 주어지지 않습니다.

입출력 예
expressions	                                                result
["14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"]	            ["13 - 6 = 5"]
["1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"]	    ["1 + 5 = ?", "1 + 2 = 3"]
["10 - 2 = X", "30 + 31 = 101", "3 + 3 = X", "33 + 33 = X"]	["10 - 2 = 4", "3 + 3 = 10", "33 + 33 = 110"]
["2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "5 - 5 = X"]	    ["2 + 2 = 4", "7 + 4 = ?", "5 - 5 = 0"]
["2 - 1 = 1", "2 + 2 = X", "7 + 4 = X", "8 + 4 = X"]	    ["2 + 2 = 4", "7 + 4 = 12", "8 + 4 = 13"]

의사 코드
1. 덧셈 혹은 뺄셈의 결과가 나와있는 것을 보고 현재 몇진법을 사용하고있는지 기록한다.
    - (핵심은 각각의 자리수가 어떤수까지 어디까지 나왔는지, 계산의 결과값이 어떻게 되었는지이다.)
2. 값을 모르는 수식의 결과를 구한다.
3. 구해진 진법을 통해 나머지 수를 채운다.
4. 현재 계산할 수 없는 수식인지 판단도 필요
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FormulaRetake340210 {
    public static void main(String[] args) {
        String[] expression = {"14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"};
        System.out.println(solution(expression));
    }

    public static String[] solution(String[] expressions) {
        String[] answer = {};
        List<String> xFrom = new ArrayList<>();
        int currnetForm = 2;
        for (String form : expressions) {
            String[] formSplit = form.split(" "); // 수식 분해해서 수, 수식, 결과로 분해

            int firstNum = Integer.parseInt(formSplit[0]); // 첫번째 수
            int firstTen = firstNum/10;
            int firstOne = firstNum%10;

            int secondNum = Integer.parseInt(formSplit[2]); // 두번째 수
            int secondTen = secondNum/10;
            int secondOne = secondNum%10;

            String formula = formSplit[1]; // 수식

            // 각 자리의 수가 어디까지 표현되어있는지 확인하고 차수계산
            if(firstTen > 0){
                currnetForm = Math.max(currnetForm, firstTen);
            }
            if(secondTen > 0){
                currnetForm = Math.max(currnetForm, secondTen);
            }
            currnetForm = Math.max(firstOne, currnetForm);
            currnetForm = Math.max(secondOne, currnetForm);

            if (Objects.equals(formSplit[4], "X")) {
                xFrom.add(form);
            }else{
                calcCurrentForm(firstNum, secondNum, formula, Integer.parseInt(formSplit[3]));
            }
        }

        return answer;
    }
    
    public static int calcCurrentForm(int firstNum, int secondNum, String formula, int result){
        int maxForm = 0;
        int tenResult = 0;
        if(formula.equals("+")){
            tenResult = firstNum + secondNum;
        }else{
            tenResult = firstNum - secondNum;
        }

        return maxForm;
    }
}
