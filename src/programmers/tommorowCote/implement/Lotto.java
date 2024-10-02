package programmers.tommorowCote.implement;

/*

로또 6/45(이하 '로또'로 표기)는 1부터 45까지의 숫자 중 6개를 찍어서 맞히는 대표적인 복권입니다.
아래는 로또의 순위를 정하는 방식입니다.
순위	당첨 내용
1	6개 번호가 모두 일치
2	5개 번호가 일치
3	4개 번호가 일치
4	3개 번호가 일치
5	2개 번호가 일치
6(낙첨)	그 외

알아볼 수 없는 번호가 포함된 로또 번호와 당첨 번호가 주어질때, [최고 순위 번호, 최저 순위 번호]의 배열을 반환하자

제한사항
lottos는 길이 6인 정수 배열입니다.
lottos의 모든 원소는 0 이상 45 이하인 정수입니다.
0은 알아볼 수 없는 숫자를 의미합니다.
0을 제외한 다른 숫자들은 lottos에 2개 이상 담겨있지 않습니다.
lottos의 원소들은 정렬되어 있지 않을 수도 있습니다.
win_nums은 길이 6인 정수 배열입니다.
win_nums의 모든 원소는 1 이상 45 이하인 정수입니다.
win_nums에는 같은 숫자가 2개 이상 담겨있지 않습니다.
win_nums의 원소들은 정렬되어 있지 않을 수도 있습니다.

입출력 예
lottos	                    win_nums	                result
[44, 1, 0, 0, 31, 25]	    [31, 10, 45, 1, 6, 19]	    [3, 5]
[0, 0, 0, 0, 0, 0]	        [38, 19, 20, 40, 15, 25]	[1, 6]
[45, 4, 35, 20, 3, 9]	    [20, 9, 3, 45, 4, 35]	    [1, 1]

의사 코드
1. 먼저 0을 제외한 알고있는 숫자가 얼마나 맞았는지 파악한다.
2. 파악한 수가 최저 순위 이고, 거기에 0의 개수를 더한 수가 최고 순위이다.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Lotto {
    public static void main(String[] args) {
        int[] lottos = {44, 1, 0, 0, 31, 25};
        int[] winNums = {31, 10, 45, 1, 6, 19};
        int[] answer = solution(lottos, winNums);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(int[] lottos, int[] winNums) {
        int knownCorrect = 0;
        int unknown = 0;
        // 점수 매핑
        int[] rank = {6, 6, 5, 4, 3, 2, 1};  // 맞춘 개수에 따른 순위
        for(int lottoNum : lottos){
            if(lottoNum == 0){
                unknown += 1;
            }else{
                for(int winNum : winNums){
                    if(winNum == lottoNum){
                        knownCorrect += 1;
                        break;
                    }
                }
            }
        }
        // 최고 순위와 최저 순위 반환
        return new int[]{rank[knownCorrect + unknown], rank[knownCorrect]};
    }
}
