package programmers.tommorowCote.dictionary;
/*
문제
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 한다.
노래는 고유 번호(인덱스 번호)로 구분하며, 노래를 수록하는 기준은 다음과 같다.
- 속한 노래가 많이 재생된 장르를 먼저 수록합니다.
- 장르 내에서 많이 재생된 노래를 먼저 수록합니다.
- 장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.

입출력 예
genres	                                        plays	                    return
["classic", "pop", "classic", "classic", "pop"]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]

의사코드
1. 장르별 해쉬맵 을 만들어서 총 조회를 기록한다.
2. key값으로는 장르를 넣고 값으로는 배열을 넣는다.
3. 각 배열의 인덱스에 해당하는 값은 다음과 같다. [총 조회수, 현재 가장 높게나온 조회수, 두번째로 높게나온 조회수, 가장 높게나온 조회수의 인덱스 번호, 두번째로 높게나온 조회수의 인덱스 번호]
4. 총 조회수가 높은거부터 인덱스를 넣는다.
 */

import java.util.*;

public class BestAlbum {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        int[] answer = solution(genres, plays);
        System.out.println("answer = " + Arrays.toString(answer));
    }

    public static int[] solution(String[] genres, int[] plays){
        HashMap<String, int[]> myMap = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            String genre = genres[i];
            int play = plays[i];
            if(myMap.containsKey(genre)){ // 해당하는 장르값이 이미 맵에 있을 때
                int[] currentValue = myMap.get(genre);
                if(currentValue[2] < play){ // 뒤에 조회할 번호들은 전부 고정번호가 낮으므로 굳이 값이 같은 걸 비교하지 않음
                    if(currentValue[1] < play){ // 가장 큰 번호보다 play가 큰 경우 가장 큰 조회수를 변경
                        int save = currentValue[1];
                        int indexSave = currentValue[3];
                        currentValue[1] = play;
                        currentValue[2] = save;
                        currentValue[3] = i;
                        currentValue[4] = indexSave;
                    }else{ // 아닐경우 두번째로 큰 조회수와 그 인덱스를 변경
                        currentValue[2] = play;
                        currentValue[4] = i;
                    }
                }
                currentValue[0] = currentValue[0] + play;
                myMap.put(genre, currentValue);
            }else{ // 해당하는 장르값이 맵에 없을 때
                myMap.put(genre, new int[] {play, play, -1, i, -1});
            }
        }

        // EntrySet을 리스트로 변환
        List<Map.Entry<String, int[]>> entryList = new ArrayList<>(myMap.entrySet());

        // 0번 인덱스의 값을 기준으로 오름차순 정렬
        entryList.sort(new Comparator<Map.Entry<String, int[]>>() {
            @Override
            public int compare(Map.Entry<String, int[]> e1, Map.Entry<String, int[]> e2) {
                // e1과 e2의 값(int[])에서 0번 인덱스 값을 비교
                return Integer.compare(e2.getValue()[0], e1.getValue()[0]);
            }
        });

        // 정렬된 결과를 LinkedHashMap에 저장 (순서를 유지하기 위해)
        LinkedHashMap<String, int[]> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, int[]> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int j = 0;
        for (Map.Entry<String, int[]> entry : sortedMap.entrySet()) {
            answer.add(entry.getValue()[3]);
            if(entry.getValue()[2] != -1){
                answer.add(entry.getValue()[4]);
            }
            j+=2;
        }
        // ArrayList<Integer>를 int[]로 변환
        int[] intArray = new int[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            intArray[i] = answer.get(i); // Integer -> int 변환
        }
        return intArray;
    }
}
