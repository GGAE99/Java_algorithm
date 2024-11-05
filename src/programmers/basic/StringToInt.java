package programmers.basic;

public class StringToInt {
    public static void main(String[] args) {
        String n_str = "10";
        System.out.println(solution(n_str));
    }

    public static int solution(String n_str) {
        return Integer.parseInt(n_str);
    }
}
