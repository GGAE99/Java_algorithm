package programmers.tommorowCote.list;

/*
url : https://school.programmers.co.kr/tryouts/85910/challenges
문제 이름 : 행렬의 덧셈

문제 설명
행렬의 덧셈은 행과 열의 크기가 같은 두 행렬의 같은 행, 같은 열의 값을 서로 더한 결과가 됩니다.
2개의 행렬 arr1과 arr2를 입력받아, 행렬 덧셈의 결과를 반환하는 함수, solution을 완성해주세요.

제한 조건
행렬 arr1, arr2의 행과 열의 길이는 500을 넘지 않습니다.

입출력 예
arr1	                arr2	                return
[[1,2],[2,3]]	        [[3,4],[5,6]]	        [[4,6],[7,9]]
[[1],[2]]	            [[3],[4]]	            [[4],[6]]
[[1,2,3,4],[2,2,3,5]],  [[3,3,4,1],[5,3,4,2]]   [[4,5,7,5],[7,5,7,7]]
 */
public class AddMul {
    public static void main(String[] args) {
//        int[][] arr1 = {{1,2},{2,3}};
//        int[][] arr2 = {{3,4},{5,6}};
//        int[][] arr1 = {{1},{2}};
//        int[][] arr2 = {{3},{5}};
        int[][] arr1 = {{1,2,3,4},{2,2,3,5}};
        int[][] arr2 = {{3,3,4,1},{5,3,4,2}};
        int[][] answer = solution(arr1, arr2);
        System.out.println("answer = " + answer);
    }

    public static int[][] solution(int[][] arr1, int[][] arr2) {
        int outLength = arr1.length;
        int inLength = arr1[0].length;
        int[][] answer = new int[outLength][inLength];
        for(int i=0; i<outLength; i++){
            int[] appendArr = new int[inLength];
            for(int j=0; j<inLength; j++){
                int appendVal = arr1[i][j] + arr2[i][j];
                appendArr[j] = appendVal;
            }
            answer[i] = appendArr;
        }
        return answer;
    }
}