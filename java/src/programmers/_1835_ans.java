package programmers;

public class _1835_ans {
    private static final String[] NAMES = { "A", "C", "F", "J", "M", "N", "R", "T" };
    private int answer;

    public int solution(int n, String[] data)
    {
        answer = 0;

        int count = NAMES.length;

        String[] output = new String[count];

        boolean[] isVisit = new boolean[count];

        permutation(output, isVisit, 0, n, data);

        return answer;
    }

    /**
     * 순열 메서드
     *
     * @param output: [String[]] 결과 저장 배열
     * @param isVisit: [boolean[]] 방문 여부 배열
     * @param depth: [int] 카운팅
     * @param data: [String[]] 조건
     * @param n: [int] 조건의 갯수
     */
    private void permutation(String[] output, boolean[] isVisit, int depth, int n, String[] data)
    {
        // 마지막에 도달했을 경우
        if (depth == NAMES.length)
        {
            answer += isValidate(n, data, output) ? 1 : 0;

            return;
        }

        for (int i = 0; i < NAMES.length; i++)
        {
            // 방문하지 않았을 경우
            if (!isVisit[i])
            {
                isVisit[i] = true;

                output[depth] = NAMES[i];

                permutation(output, isVisit, depth + 1, n, data);

                isVisit[i] = false;
            }
        }
    }

    /**
     * 조건 검증결과 반환 메서드
     *
     * @param n: [int] 조건의 갯수
     * @param data: [String[]] 조건
     * @param output: [String[]] 결과 저장 배열
     *
     * @return [boolean] 조건 검증결과
     */
    private boolean isValidate(int n, String[] data, String[] output)
    {
        StringBuilder builder = new StringBuilder();

        for (String out : output)
        {
            builder.append(out);
        }

        String text = builder.toString();

        for (int i = 0; i < n; i++)
        {
            String[] temp = data[i].split("");

            String name1 = temp[0];
            String name2 = temp[2];
            String operation = temp[3];

            int distance = Integer.parseInt(temp[4]);

            int realDistance = Math.abs(text.indexOf(name1) - text.indexOf(name2)) - 1;

            // > 조건과 일치하지 않을 경우
            if (operation.equals(">") && realDistance <= distance)
            {
                return false;
            }

            // = 조건과 일치하지 않을 경우
            else if (operation.equals("=") && realDistance != distance)
            {
                return false;
            }

            // < 조건과 일치하지 않을 경우
            else if (operation.equals("<") && realDistance >= distance)
            {
                return false;
            }
        }

        return true;
    }
}
