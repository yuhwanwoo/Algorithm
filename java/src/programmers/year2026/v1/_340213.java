package programmers.year2026.v1;

public class _340213 {
    private static int opStartSeconds;
    private static int opEndSeconds;

    static void main() {
        String video_len = "34:33";
        String pos = "13:00";
        String op_start = "00:55";
        String op_end = "02:55";
        String[] commands = {"next", "prev"};
//        System.out.println("solution() = " + solution(video_len, pos, op_start, op_end, commands));

        video_len = "10:55";
        pos = "00:05";
        op_start = "00:15";
        op_end = "06:55";
        String[] commands1 = {"prev", "next", "next"};
        System.out.println("solution() = " + solution(video_len, pos, op_start, op_end, commands1));

        video_len = "07:22";
        pos = "04:05";
        op_start = "00:15";
        op_end = "04:07";
        String[] commands2 = {"next"};
        System.out.println("solution() = " + solution(video_len, pos, op_start, op_end, commands2));
    }

    public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        opStartSeconds = stringToSeconds(op_start);
        opEndSeconds = stringToSeconds(op_end);
        int videoLength = stringToSeconds(video_len);
        int posSeconds = stringToSeconds(pos);
        for (String command : commands) {
            if (isOpening(posSeconds)) {
                 posSeconds = opEndSeconds;
            }
            if (command.equals("prev")) {
                if (posSeconds - 10 >= 0) {
                    posSeconds -= 10;
                } else {
                    posSeconds = 0;
                }
            }
            if (command.equals("next")) {
                if (posSeconds + 10 <= videoLength) {
                    posSeconds += 10;
                } else {
                    posSeconds = videoLength;
                }
            }
            if (isOpening(posSeconds)) {
                posSeconds = opEndSeconds;
            }
        }
        String answerMinute;
        String answerSecond;
        if (posSeconds/60 < 10) {
            answerMinute = "0" + posSeconds/60;
        } else {
            answerMinute = "" + posSeconds/60;
        }
        if (posSeconds%60 < 10) {
            answerSecond = "0" + posSeconds%60;
        } else {
            answerSecond = "" + posSeconds%60;
        }
        return answerMinute + ":" + answerSecond;
    }

    private static int stringToSeconds(String time) {
        String[] split = time.split(":");
        return Integer.parseInt(split[0]) * 60 + Integer.parseInt(split[1]);
    }

    private static boolean isOpening(int time) {
        return opStartSeconds <= time && time <= opEndSeconds;
    }

}
