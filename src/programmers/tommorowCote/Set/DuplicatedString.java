package programmers.tommorowCote.Set;

import java.util.HashSet;
import java.util.Set;

public class DuplicatedString {
    public static void main(String[] args) {
        String my_string = "people";
        String answer = solution(my_string);
        System.out.println("answer = " + answer);
    }

    public static String solution(String my_string){
        StringBuilder result = new StringBuilder();
        Set<Character> seen = new HashSet<>();

        for (int i = 0; i < my_string.length(); i++) {
            char currentChar = my_string.charAt(i);
            if (!seen.contains(currentChar)) {
                result.append(currentChar);
                seen.add(currentChar);
            }
        }

        return result.toString();
    }
}
