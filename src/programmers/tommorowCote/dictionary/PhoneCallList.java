package programmers.tommorowCote.dictionary;

/*
문제
전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

구조대 : 119
박준영 : 97 674 223
지영석 : 11 9552 4421
전화번호부에 적힌 전화번호를 담은 배열 "phone_book"이 solution 함수의 매개변수로 주어진다.
어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.

제한 사항
- phone_book의 길이는 1 이상 1,000,000 이하입니다.
- 각 전화번호의 길이는 1 이상 20 이하입니다.
- 같은 전화번호가 중복해서 들어있지 않습니다.

입출력 예제
phone_book	                        return
["119", "97674223", "1195524421"]	false
["123","456","789"]	                true
["12","123","1235","567","88"]	    false

의사 코드
1. 일단 배열을 sort하고나면 길이가 작은 순서대로 되어서 앞에서부터 차례대로 비교할 수 있을 것 같다.
2. 이러면 너무 시간복잡도가 높아질 것 같긴하다 -> O(N^2)이다.
3. 일단 해보자.

의사 코드 2
1. 위에 코드는 시간복잡도가 너무 높다.
2. 해쉬맵에 담아서 key값을 찾아서 비교하는게 좋을 것 같다.
 */

import java.util.HashMap;

public class PhoneCallList {
    public static void main(String[] args) {
        String [] phone_book = {"119", "97674223", "1195524421"};
        if(solution(phone_book)){
            System.out.println("접두어 X");
        }else{
            System.out.println("접두사 O");
        }
    }

    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Boolean> phone_book_map = new HashMap<String, Boolean>();
        for(String number : phone_book){
            phone_book_map.put(number, true);
        }
        for(String number : phone_book){
            String currnet = "";
            for(int i = 0; i<number.length()-1; i++){
                currnet += number.charAt(i);
                if(phone_book_map.containsKey(currnet)){
                    return false;
                }
            }
        }
        return answer;
    }
}
