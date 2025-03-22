package programmers.lv2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class _17683_ans {
    static String[] sharp = {"C#", "D#", "E#", "F#", "G#", "A#"};
    static String[] lowercase = {"c", "d", "e", "f", "g", "a"};

    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        m = parsing(m);
        ArrayList<String[]> lists = new ArrayList<>();
        int idx =0;
        for(String musicinfo: musicinfos){
            String infos[] = musicinfo.split(",");
            infos[3] = parsing(infos[3]);
            int start = getTime(infos[0].split(":"));
            int end = getTime(infos[1].split(":"));
            int totaltime = end - start;
            String totalstr = check(totaltime, infos[3]);
            // if(totalstr.contains(m)){
            //     lists.add(new String[]{String.valueOf(totaltime), infos[2], String.valueOf(idx++)});
            // }
            if(findstr(totalstr, m)){
                lists.add(new String[]{String.valueOf(totaltime), infos[2], String.valueOf(idx++)});
            }
        }
        if(lists.size()!=0){
            Collections.sort(lists, new Comparator<String[]>(){
                public int compare(String o1[], String o2[]){
                    if(stoi(o1[0])==stoi(o2[0])){
                        return stoi(o1[2])- stoi(o2[2]);
                    }
                    return -(stoi(o1[0])-stoi(o2[0]));
                }
            });
            answer = lists.get(0)[1];
        }
        return answer;
    }
    static int stoi(String s){
        return Integer.valueOf(s);
    }
    static String parsing(String m){
        for(int i=0; i<sharp.length; i++){
            m = m.replace(sharp[i], lowercase[i]);
        }
        return m;
    }
    static boolean findstr(String totalstr, String m){
        int start = 0;
        for(int end=m.length(); end<=totalstr.length(); end++){
            String temp = totalstr.substring(start, end);
            start++;
            if(temp.equals(m)){
                return true;
            }
        }
        return false;
    }
    static int getTime(String time[]){
        int hour =Integer.valueOf(time[0])*60;
        int min = Integer.valueOf(time[1]);
        return hour+min;
    }
    static String check(int totaltime, String str){
        int size = str.length();
        int mok = totaltime/size;
        int na  = totaltime%size;
        String res = "";
        for(int i=0; i<mok; i++)
            res += str;
        res+=str.substring(0, na);
        return res;
    }
}
