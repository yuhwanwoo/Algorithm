package programmers.lv1;

public class _133499 {
    private static String[] possibleWords = {"aya", "ye", "woo", "ma"};

    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};
        solution(babbling);
        System.out.println("========");
        String[] babbling1 = {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        solution(babbling1);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        for (String word : babbling) {
            if (dfs(word, "")) {
                answer += 1;
            }
        }
        return answer;
    }

    private static boolean dfs(String word, String prevWord) {
        if (word.isEmpty()) {
            return true;
        }

        for (String possibleWord : possibleWords) {
            if (word.startsWith(possibleWord) && !possibleWord.equals(prevWord)) {
                return dfs(word.substring(possibleWord.length()), possibleWord);
            }
        }
        return false;
    }
}
