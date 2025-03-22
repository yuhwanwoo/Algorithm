package programmers.lv1;

public class _133499_ans {
    public int solution(String[] babbling) {
        // 발음 가능 {"aya", "ye", "woo", "ma"}
        // 연속해서 발음x
        int answer = 0; // babbling 중 발음 가능한 단어 개수

        for(int i=0; i<babbling.length; i++){
            // 연속발음될 경우 예외처리
            if(babbling[i].contains("ayaaya")
                    || babbling[i].contains("yeye")
                    || babbling[i].contains("woowoo")
                    || babbling[i].contains("mama")){
                continue;
            }

            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");

            if(babbling[i].length()  == 0) answer++;
        }

        return answer;
    }
}
