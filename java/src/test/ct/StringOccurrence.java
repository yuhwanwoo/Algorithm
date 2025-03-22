package test.ct;

import java.io.*;
import java.util.*;

public class StringOccurrence {
    public static int getOccurrenceCount(String toSearch, InputStream stream) throws Exception {

        int length = toSearch.length();
        System.out.println("length = " + length);
        System.out.println("toSearch = " + toSearch);

        if (toSearch.contains(".")) {
            toSearch.replaceAll("\\.", "\\.");
        }

        if (toSearch.equals("?")) {
            toSearch = toSearch.replaceAll("\\?", "\\?");
        }

        InputStreamReader inputStreamReader = new InputStreamReader(stream);
        char[] chars = new char[58];
        inputStreamReader.read(chars);
        String inputStr = new String(chars);

        System.out.println("inputStr.replaceAll(toSearch, \"\") = " + inputStr.replaceAll(toSearch, ""));

        return (inputStr.length() - inputStr.replaceAll(toSearch, "").length()) / length;
    }

    public static void main(String[] args) throws Exception {
        String msg = "Hey! How are you?\nI am good, how about you?\nI am good too.";

        try(InputStream stream = new ByteArrayInputStream(msg.getBytes())) {
            System.out.println(StringOccurrence.getOccurrenceCount("you?", stream));
        }
    }
}
