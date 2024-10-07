package programmers.tommorowCote.dictionary;

/*
문제
로그인하려고 하는 아이디와 비밀번호가 주어진다.
회원의 정보가 담겨져있는 db가 주어진다.
아이디와 비밀번호가 모두 일치하는 회원정보가 있으면 "login"을 return한다.
로그인이 실패했을 때 아이디가 일치하는 회원이 없다면 “fail”를, 아이디는 일치하지만 비밀번호가 일치하는 회원이 없다면 “wrong pw”를 return 한다.

제한사항
회원들의 아이디는 문자열입니다.
회원들의 아이디는 알파벳 소문자와 숫자로만 이루어져 있습니다.
회원들의 패스워드는 숫자로 구성된 문자열입니다.
회원들의 비밀번호는 같을 수 있지만 아이디는 같을 수 없습니다.
id_pw의 길이는 2입니다.
id_pw와 db의 원소는 [아이디, 패스워드] 형태입니다.
1 ≤ 아이디의 길이 ≤ 15
1 ≤ 비밀번호의 길이 ≤ 6
1 ≤ db의 길이 ≤ 10
db의 원소의 길이는 2입니다.

입출력 예
id_pw	                    db	                                                                                result
["meosseugi", "1234"]	    [["rardss", "123"], ["yyoom", "1234"], ["meosseugi", "1234"]]	                    "login"
["programmer01", "15789"]	[["programmer02", "111111"], ["programmer00", "134"], ["programmer01", "1145"]]	    "wrong pw"
["rabbit04", "98761"]	    [["jaja11", "98761"], ["krong0313", "29440"], ["rabbit00", "111333"]]	            "fail"

의사 코드
1. 키와 값을 가지고있는 딕셔너리를 생성해서 db의 배열들을 집어넣는다.
2. 받아온 아이디가 딕셔너리에 있는지 확인하고, 없다면 "fail"을 리턴한다.
3. 키가 있다면 비밀번호도 일치하는지 확인한다.
4. 비밀번호가 일치한다면 "login"을 그렇지 않다면 "wrong pw"를 리턴한다.
 */

import java.util.HashMap;

public class LoginConfirm {
    public static void main(String[] args) {
//        String[] id_pw = {"meosseugi", "1234"};
//        String [][] db = {{"rardss", "123"}, {"yyoom", "1234"}, {"meosseugi", "1234"}};
        String[] id_pw = {"programmer01", "15789"};
        String [][] db = {{"programmer02", "111111"}, {"programmer00", "134"}, {"programmer01", "1145"}};
        String answer = solution(id_pw, db);
        System.out.println("answer = " + answer);
    }

    public static String solution(String[] id_pw, String[][] db){
        HashMap <String, String> dictionaryDb = new HashMap<>();
        for(String[] idAndPw : db){
            dictionaryDb.put(idAndPw[0], idAndPw[1]);
        }
        if(dictionaryDb.containsKey(id_pw[0])){
            if(dictionaryDb.get(id_pw[0]).equals(id_pw[1])){
                return "login";
            }else{
                return "wrong pw";
            }
        }else{
            return "fail";
        }
    }
}
