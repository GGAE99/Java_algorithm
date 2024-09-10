package javaCoteBook.Array;

import java.util.ArrayList;
import java.util.Arrays;

/*
문제
게임 캐릭터가 지나간 길 중 캐릭터가 처음 걸어본 길의 길이를 구하여라
게임 캐릭터를 4가지 명령어를 통해 움직이려 합니다. 명령어는 다음과 같다.
- U: 위쪽으로 한 칸 가기
- D: 아래쪽으로 한 칸 가기
- R: 오른쪽으로 한 칸 가기
- L: 왼쪽으로 한 칸 가기

제약 조건
• dirs는 string형으로 주어지며, ‘U’, ‘D’, ‘R’, ‘L’ 이외의 문자는 주어지지 않습니다.
• dirs의 길이는 500 이하의 자연수입니다.

입출력의 예
dirs        answer
ULURRDLLU   7
LULLLLLLU   7

의사 코드
1.  이미 지나간 선을 받을 배열을 만든다.
2. 현재 좌표를 저장할 데이터를 만든다.
3.  명령을 하나하나 수행하며 지나간 자리를 기록한다.
4. 자리를 지나갈 때마다 이미 지나간 선이었는지 체크한다.
	1. 이미 지나간 선이었으면 다음 명령으로 넘어간다.
	2. 이미 지나간 선이 아니었다면 답에 1을 추가한다.
 */
public class WentLength {
    public static void main(String[] args) {
        String dirs = "LULLLLLLU";
        int answer = solution(dirs);
        System.out.println(answer);
    }

    public static int solution(String dirs){
        ArrayList<String> lines = new ArrayList<>();
        int currentX = 0;
        int currentY = 0;
        int afterX = 0;
        int afterY = 0;
        int count = 0;

        for(int i = 0; i < dirs.length(); i++) {
            char command = dirs.charAt(i);
            switch (command) {
                case 'U':
                    if (currentY + 1 > 5) continue;
                    afterY = currentY + 1;
                    break;
                case 'R':
                    if (currentX + 1 > 5) continue;
                    afterX = currentX + 1;
                    break;
                case 'L':
                    if (currentX - 1 < -5) continue;
                    afterX = currentX - 1;
                    break;
                case 'D':
                    if (currentY - 1 < -5) continue;
                    afterY = currentY - 1;
                    break;
            }

            // 양방향 경로를 고려
            String newLine = Integer.toString(currentX) + Integer.toString(currentY) +
                    Integer.toString(afterX) + Integer.toString(afterY);
            String reverseLine = Integer.toString(afterX) + Integer.toString(afterY) +
                    Integer.toString(currentX) + Integer.toString(currentY);

            if (!lines.contains(newLine) && !lines.contains(reverseLine)) {
                count++;
                lines.add(newLine); // 양방향이므로 한쪽만 저장하면 됨
            }

            currentX = afterX;
            currentY = afterY;
        }
        return count;
    }
}
