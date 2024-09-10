package javaCoteBook.Stack;
/*
문제
10진수를 입력받아 2진수로 변환해 반환하는 solution( ) 함수를 구현하세요

제약 조건
• decimal은 1이상 10억 미만의 자연수

입출력의 예
decimal 반환값
10      1010
27      11011
12345   11000000111001
 */
public class BodyTenToTwo {
    public static void main(String[] args) {
        int decimal = 12345;
        String s = solution(decimal);
        System.out.println(s);
    }

    public static String solution(int decimal){
        StringBuilder answer = new StringBuilder();
        while (decimal>0) {
            int s = decimal % 2;
            decimal = decimal / 2;
            answer.append(Integer.toString(s));
        }
        return answer.reverse().toString();
    }
}