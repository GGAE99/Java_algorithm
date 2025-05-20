package programmers;

import java.util.ArrayList;
import java.util.List;

/*
* 의사코드
* 1.연결되어있는 수 = wires의 개수 = n
* 2.선을 하나씩 없애고 완전탐색한다.
* */
//public class CutWires {
//    public static void main(String[] args) {
//        int n = 9;
//        int [][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//        int answer = solution(n, wires);
//        System.out.println(answer);
//    }
//
//    public static int solution(int n, int[][] wires) {
//        int answer = 100;
//        for(int[] selected : wires){
//            int brown = calculate(selected, wires);
//            if(answer > Math.abs(n-brown)) answer = Math.abs(n-brown);
//        }
//        return answer;
//    }
//
//    public static int calculate(int[] selected, int[][]wires){
//        int brown = 0;
//        List<int[]> newWires = new ArrayList<>();
//        for(int[] wire : wires){
//            if(wire == selected){
//                continue;
//            }
//            newWires.add(wire);
//        }
//
//
//
//        return brown;
//    }
//}

public class CutWires {
    public static void main(String[] args) {
        int n = 9;
        int [][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int answer = solution(n, wires);
        System.out.println(answer);
    }

    public static int solution(int n, int[][] wires) {
        int answer = n;
        for (int i = 0; i < wires.length; i++) {
            List<List<Integer>> graph = new ArrayList<>();
            for (int j = 0; j <= n; j++) graph.add(new ArrayList<>()); // 1번부터 시작

            // 하나의 전선(i번째)를 제외한 나머지로 그래프 구성
            for (int j = 0; j < wires.length; j++) {
                if (i == j) continue;
                int a = wires[j][0];
                int b = wires[j][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            // 아무 정점(1번)에서 DFS로 연결된 송전탑 개수 계산
            boolean[] visited = new boolean[n + 1];
            int count = dfs(1, graph, visited);
            int diff = Math.abs(n - 2 * count); // 전체에서 두 그룹의 차이 계산
            answer = Math.min(answer, diff);
        }
        return answer;
    }

    public static int dfs(int node, List<List<Integer>> graph, boolean[] visited) {
        visited[node] = true;
        int count = 1;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }
        return count;
    }
}
