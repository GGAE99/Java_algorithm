package programmers.tommorowCote.Set;
/*
문제
홍 박사님은 당신에게 자신의 연구실에 있는 총 N 마리의 폰켓몬 중에서 N/2마리를 가져가도 좋다고 했습니다.
홍 박사님 연구실의 폰켓몬은 종류에 따라 번호를 붙여 구분합니다
따라서 같은 종류의 폰켓몬은 같은 번호를 가지고 있습니다.
당신은 최대한 다양한 종류의 폰켓몬을 가지길 원하기 때문에, 최대한 많은 종류의 폰켓몬을 포함해서 N/2마리를 선택하려 합니다.

N마리 폰켓몬의 종류 번호가 담긴 배열 nums가 매개변수로 주어질 때,
N/2마리의 폰켓몬을 선택하는 방법 중, 가장 많은 종류의 폰켓몬을 선택하는 방법을 찾아,
그때의 폰켓몬 종류 번호의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums는 폰켓몬의 종류 번호가 담긴 1차원 배열입니다.
nums의 길이(N)는 1 이상 10,000 이하의 자연수이며, 항상 짝수로 주어집니다.
폰켓몬의 종류 번호는 1 이상 200,000 이하의 자연수로 나타냅니다.
가장 많은 종류의 폰켓몬을 선택하는 방법이 여러 가지인 경우에도, 선택할 수 있는 폰켓몬 종류 개수의 최댓값 하나만 return 하면 됩니다.

입출력 예
nums	        result
[3,1,2,3]	    2
[3,3,3,2,2,4]	3
[3,3,3,2,2,2]	2

의사 코드
1. 포켓몬의 중복을 제거한다.
2. N/2 가 전체 종류보다 적다면 N/2가 답이고 아니라면 전체 종류를 내보내면된다.
 */


import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class PuKeyMon {
    public static void main(String[] args) {
        int[] nums = {3,3,3,2,2,4,4,4};
        int answer = solution(nums);
        System.out.println("answer = " + answer);
    }

    public static int solution(int[] nums){
        int answer = nums.length/2;
        Set<Integer> uniqueNumbers = Set.copyOf(Arrays.stream(nums).boxed().collect(Collectors.toList()));
        return Math.min(uniqueNumbers.size(), answer);
    }
}
