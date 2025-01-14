package programmers.pccp;


/*
문제
당신은 순서대로 n개의 퍼즐을 제한 시간 내에 풀어야 하는 퍼즐 게임을 하고 있습니다.
각 퍼즐은 난이도와 소요 시간이 정해져 있습니다.
당신의 숙련도에 따라 퍼즐을 풀 때 틀리는 횟수가 바뀌게 됩니다.

현재 퍼즐의 난이도를 diff, 현재 퍼즐의 소요 시간을 time_cur, 이전 퍼즐의 소요 시간을 time_prev, 당신의 숙련도를 level이라 하면, 게임은 다음과 같이 진행됩니다.
diff ≤ level이면 퍼즐을 틀리지 않고 time_cur만큼의 시간을 사용하여 해결합니다.
diff > level이면, 퍼즐을 총 diff - level번 틀립니다.
퍼즐을 틀릴 때마다, time_cur만큼의 시간을 사용하며, 추가로 time_prev만큼의 시간을 사용해 이전 퍼즐을 다시 풀고 와야 합니다.
이전 퍼즐을 다시 풀 때는 이전 퍼즐의 난이도에 상관없이 틀리지 않습니다.
diff - level번 틀린 이후에 다시 퍼즐을 풀면 time_cur만큼의 시간을 사용하여 퍼즐을 해결합니다.

예를 들어 diff = 3, time_cur = 2, time_prev = 4인 경우, level에 따라 퍼즐을 푸는데 걸리는 시간은 다음과 같습니다.
level = 1이면, 퍼즐을 3 - 1 = 2번 틀립니다. 한 번 틀릴 때마다 2 + 4 = 6의 시간을 사용하고, 다시 퍼즐을 푸는 데 2의 시간을 사용하므로 총 6 × 2 + 2 = 14의 시간을 사용하게 됩니다.
level = 2이면, 퍼즐을 3 - 2 = 1번 틀리므로, 6 + 2 = 8의 시간을 사용하게 됩니다.
level ≥ 3이면 퍼즐을 틀리지 않으며, 2의 시간을 사용하게 됩니다.

변수 정의
퍼즐 난이도의 집합 diffs
퍼즐 소요 시간의 집합 times
제한 시간 limit
이전 퍼

입출력 예
diffs	                    times	                    limit	result
[1, 5, 3]	                [2, 4, 7]	                30	    3
[1, 4, 4, 2]	            [6, 3, 8, 2]	            59	    2
[1, 328, 467, 209, 54]	    [2, 7, 1, 4, 3]	            1723	294
[1, 99999, 100000, 99995]	[9999, 9001, 9999, 9001]	3456789012	39354
 */


import java.util.Arrays;

public class PuzzleGame340212 {
    public static void main(String[] args) {
        int[] diffs = {1, 328, 467, 209, 54};
        int[] times = {2, 7, 1, 4, 3};
        long limit = 1723;
        int result = solution(diffs, times, limit);
        System.out.println("result " + result);
    }

//    public static void main(String[] args) {
//        int[] diffs = {1, 99999, 100000, 99995};
//        int[] times = {9999, 9001, 9999, 9001};
//        long limit = 3456789012L;
//        int result = solution(diffs, times, limit);
//        System.out.println("result " + result);
//    }

//    public static int solution(int[] diffs, int[] times, long limit) {
//        int currentLevel = Arrays.stream(diffs).max().getAsInt();  // 최대 난이도
//
//        while (true) {
//            int spendTime = 0;
//            int prevTime = 0;
//
//            for (int i = 0; i < diffs.length; i++) {
//                int diff = diffs[i];
//                int cha = diff - currentLevel;
//                if (cha > 0) {
//                    spendTime += cha * prevTime;
//                }
//                spendTime += times[i];
//                prevTime = times[i];
//            }
//            if (spendTime > limit) {
//                break;
//            }
//            currentLevel --;
//        }
//        return currentLevel;
//    }


//    public static int solution(int[] diffs, int[] times, long limit) {
//        int currentLevel = Arrays.stream(diffs).max().getAsInt();  // 최대 난이도
//
//        while (true) {
//            int spendTime = 0;
//
//            for (int i = 0; i < diffs.length; i++) {
//                int diff = diffs[i];
//                int cha = diff - currentLevel;
//
//                if (cha > 0) {
//                    spendTime += cha * times[i];  // 현재 퍼즐의 시간
//                    if (i > 0) {
//                        spendTime += cha * times[i - 1];  // 이전 퍼즐의 시간
//                    }
//                }
//
//                spendTime += times[i];  // 퍼즐 해결 시간
//            }
//
//            if (spendTime > limit) {
//                break;
//            }
//            currentLevel--;
//        }
//
//        return currentLevel;
//    }

    public static int solution(int[] diffs, int[] times, long limit) {
        int maxValue = Arrays.stream(diffs).max().getAsInt();
        int minValue = 1;

        while (minValue < maxValue) {
            int level = (maxValue + minValue) / 2;
            long time = calTime(diffs, times, level);

            if (time <= limit) {
                maxValue = level;
            } else {
                minValue = level + 1;
            }
        }

        return maxValue;
    }

    private static long calTime(int[] diffs, int[] times, int level) {
        long time = 0;

        for (int i = 0; i < diffs.length; i++) {
            int levDiff = diffs[i] - level;

            if (levDiff <= 0) {
                time += times[i];
            } else {
                int preTime = (i == 0) ? 0 : times[i - 1];
                time += (preTime + times[i]) * levDiff + times[i];
            }
        }

        return time;
    }


}
