package programmers.tommorowCote.dictionary;

import java.util.HashMap;

/*
문제
매일 다른 옷을 조합하여 입으려고한다.
코니는 각 종류별로 최대 1가지 의상만 착용할 수 있습니다. 예를 들어 위 예시의 경우 동그란 안경과 검정 선글라스를 동시에 착용할 수는 없습니다.
착용한 의상의 일부가 겹치더라도, 다른 의상이 겹치지 않거나, 혹은 의상을 추가로 더 착용한 경우에는 서로 다른 방법으로 옷을 착용한 것으로 계산합니다.
코니는 하루에 최소 한 개의 의상은 입습니다.

제한사항
clothes의 각 행은 [의상의 이름, 의상의 종류]로 이루어져 있습니다.
코니가 가진 의상의 수는 1개 이상 30개 이하입니다.
같은 이름을 가진 의상은 존재하지 않습니다.
clothes의 모든 원소는 문자열로 이루어져 있습니다.
모든 문자열의 길이는 1 이상 20 이하인 자연수이고 알파벳 소문자 또는 '_' 로만 이루어져 있습니다.

입출력 예
clothes	                                                                                    return
[["yellow_hat", "headgear"], ["blue_sunglasses", "eyewear"], ["green_turban", "headgear"]]	5
[["crow_mask", "face"], ["blue_sunglasses", "face"], ["smoky_makeup", "face"]]	            3

의사 코드
1. 이 문제는 굳이 딕셔너리를 쓸 이유가 없어보인다.
2. 그냥 각 항목에 해당하는 옷의 종류가 몇개인지를 저장하는 변수들을 선언해서 계산하는게 좋을 것 같다.

의사 코드2
1. 문제를 잘못 이해했다. -> 옷의 종류가 4가지로 고정된다고 착각했다.
2. 옷의 종류를 key값으로 받아서 값을 1씩 올려줘야겠다.
3. 이후 key의 개수에 따라 반복문을 실행하여 결과를 쌓는다.
 */
public class Clothes {
    public static void main(String[] args) {
        String[][] clothes = {{"yellow_hat", "headgear"},{"blue_sunglasses", "eyewear"},{"green_turban", "headgear"}};
        int answer = solution(clothes);
        System.out.println("answer = " + answer);
    }

    public static int solution(String[][] clothes){
        int answer = 1;
        HashMap<String, Integer> clothesType = new HashMap<>();
        for(String[] clothe : clothes){
            if(clothesType.containsKey(clothe[1])){
                clothesType.put(clothe[1], clothesType.get(clothe[1])+1);
            }else{
                clothesType.put(clothe[1],1);
            }
        }
        for (int count : clothesType.values()) {
            answer *= (count + 1); // 입지 않는 경우 포함해서 계산
        }

        return answer-1;
    }
}
