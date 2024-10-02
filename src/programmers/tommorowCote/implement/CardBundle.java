package programmers.tommorowCote.implement;

import java.util.Objects;

/*
문제
코니는 영어 단어가 적힌 카드 뭉치 두 개를 선물로 받았습니다.
코니는 다음과 같은 규칙으로 카드에 적힌 단어들을 사용해 원하는 순서의 단어 배열을 만들 수 있는지 알고 싶습니다.

원하는 카드 뭉치에서 카드를 순서대로 한 장씩 사용합니다.
한 번 사용한 카드는 다시 사용할 수 없습니다.
카드를 사용하지 않고 다음 카드로 넘어갈 수 없습니다.
기존에 주어진 카드 뭉치의 단어 순서는 바꿀 수 없습니다.

제한사항
1 ≤ cards1의 길이, cards2의 길이 ≤ 10
1 ≤ cards1[i]의 길이, cards2[i]의 길이 ≤ 10
cards1과 cards2에는 서로 다른 단어만 존재합니다.
2 ≤ goal의 길이 ≤ cards1의 길이 + cards2의 길이
1 ≤ goal[i]의 길이 ≤ 10
goal의 원소는 cards1과 cards2의 원소들로만 이루어져 있습니다.
cards1, cards2, goal의 문자열들은 모두 알파벳 소문자로만 이루어져 있습니다.

입출력 예
cards1	                cards2	        goal	                                result
["i", "drink", "water"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"Yes"
["i", "water", "drink"]	["want", "to"]	["i", "want", "to", "drink", "water"]	"No"

의사 코드
1. 두 카드에는 서로 다른 단어만 존재한다고 확실히 했기 때문에 그냥 하나씩 꺼내서 비교만 해도 괜찮겠다.
2. 각 카드의 현재 뽑은 카드 위치를 저장하는 변수를 가지고 비교하자.
3. 변수를 통해 가져온 변수가 막히는 경우에는 No를 반환하고 아닌 경우에는 Yes룰 반환하자
 */
public class CardBundle {
    public static void main(String[] args) {
        String [] cards1 = {"i", "water", "drink"};
        String [] cards2 = {"want", "to"};
        String [] goal = {"i", "want", "to", "drink", "water"};
        String answer = solution(cards1,cards2,goal);
        System.out.println("answer = " + answer);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal){
        int card1Index = 0;
        int card2Index = 0;
        int card1Length = cards1.length;
        int card2Length = cards2.length;
        for(String str : goal){
            if(card1Length > card1Index && Objects.equals(cards1[card1Index], str)){
                card1Index +=1;
            } else if (card2Length > card2Index && Objects.equals(cards2[card2Index], str)) {
                card2Index +=1;
            }else{
                return "No";
            }
        }
        return "Yes";
    }
}
