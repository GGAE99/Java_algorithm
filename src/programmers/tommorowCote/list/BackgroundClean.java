package programmers.tommorowCote.list;

import java.util.Arrays;

/*
url : https://school.programmers.co.kr/tryouts/85911/challenges
문제 이름 : 바탕화면 정리

문제
바탕화면의 상태를 나타낸 문자열 배열 wallpaper가 주어진다.
바탕화면의 가장 왼쪽 위를 (0,0)으로 시작해 (세로 좌표, 가로 좌표)로 표현한다.
빈칸은 ".", 파일이 있는 칸은 "#" 값을 가진다.
드래그를 하면 파일들을 선택할 수 있고, 선택한 파일들을 삭제할 수 있다.
최소한의 이동거리를 갖는 한 번의 드래그로 모든 파일을 선택해서 지우기 위해서 어떤 x좌표, y좌표에서 시작해 어떤 x좌표, y좌표에서 끝나는지 반환하자

드래그는 바탕화면의 격자점 S(lux, luy)를 마우스 왼쪽 버튼으로 클릭한 상태로 격자점 E(rdx, rdy)로 이동한 뒤 마우스 왼쪽 버튼을 떼는 행동입니다.
이때, "점 S에서 점 E로 드래그한다"고 표현하고 점 S와 점 E를 각각 드래그의 시작점, 끝점이라고 표현합니다.
점 S(lux, luy)에서 점 E(rdx, rdy)로 드래그를 할 때, "드래그 한 거리"는 |rdx - lux| + |rdy - luy|로 정의합니다.
점 S에서 점 E로 드래그를 하면 바탕화면에서 두 격자점을 각각 왼쪽 위, 오른쪽 아래로 하는 직사각형 내부에 있는 모든 파일이 선택됩니다.

제한사항
1 ≤ wallpaper의 길이 ≤ 50
1 ≤ wallpaper[i]의 길이 ≤ 50
wallpaper의 모든 원소의 길이는 동일합니다.
wallpaper[i][j]는 바탕화면에서 i + 1행 j + 1열에 해당하는 칸의 상태를 나타냅니다.
wallpaper[i][j]는 "#" 또는 "."의 값만 가집니다.
바탕화면에는 적어도 하나의 파일이 있습니다.
드래그 시작점 (lux, luy)와 끝점 (rdx, rdy)는 lux < rdx, luy < rdy를 만족해야 합니다.

입출력 예
wallpaper	                                                                                result
[".#...", "..#..", "...#."]	                                                                [0, 1, 3, 4]
["..........", ".....#....", "......##..", "...##.....", "....#....."]	                    [1, 3, 5, 8]
[".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."] [0, 0, 7, 9]
["..", "#."]	                                                                            [1, 0, 2, 1]

의사 코드
1. 먼저 드래그 시작점(lux, luy)를 최대값으로 잡는다.
2. 드래그 끝점은 최소값으로 잡는다.
3. 파일들의 위치를 비교하며 만약 시작점보다 낮은 위치에 파일이 존재하고 있다면 시작점을 옮긴다.
4. 반대로 파일들의 위치가 드래그 끝점보다 높은 위치에 있다면 끝점을 옮긴다.
 */
public class BackgroundClean {
    public static void main(String[] args) {
//        String [] wallpaper = {"..........", ".....#....", "......##..", "...##.....", "....#....."};
        String [] wallpaper = {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."};
        int[] answer = solution(wallpaper);
        System.out.println(Arrays.toString(answer));
    }

    public static int[] solution(String [] wallpaper) {
        int [] answer = {50,50,0,0}; // lux, luy, rdx, rdy / 조건 상으로 가장 큰 값으로 설정
        for(int lineIndex=0; lineIndex< wallpaper.length; lineIndex++){
            for(int charIndex=0; charIndex<wallpaper[0].length(); charIndex++){
                char c = wallpaper[lineIndex].charAt(charIndex);
                if(c=='#'){ // 파일이 존재할때
                    if(answer[0] > lineIndex) { // 파일의 위치를 비교했을 때 시작점의 세로 위치보다 파일의 세로 위치가 작은 경우
                        answer[0] = lineIndex;
                    }
                    if(answer[1] > charIndex){ // 파일의 위치를 비교했을 때 시작점의 가로 위치보다 파일의 가로 위치가 작은 경우
                        answer[1] = charIndex;
                    }
                    if(answer[2] < lineIndex + 1){ // 파일의 위치를 비교했을 때 끝점 세로 위치보다 파일의 세로 위치가 큰 경우
                        answer[2] = lineIndex+1;
                    }
                    if(answer[3] < charIndex + 1){ // 파일의 위치를 비교했을 때 끝점 가로 위치보다 파일의 가로 위치가 큰 경우
                        answer[3] = charIndex+1;
                    }
                }
            }
        }

        return answer;
    }
}
