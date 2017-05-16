package me.okx.neim.util;

import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputUtil {
    private static List<String> inputs = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static IntList getList(String ss) {
        IntList list = new IntList();
        for(String s : ss.split(" ")) {
            list.add(new VarInteger(s));
        }
        return list;
    }

    public static Object getSomething() {
        return getSomething(-1);
    }

    public static Object getSomething(int lineNumber) {
        String s = line(lineNumber);
        if(s.contains(" ")) {
            return getList(s);
        } else {
            return new VarInteger(s);
        }
    }

    public static String line(int lineNumber) {
        String line;
        if (lineNumber < 0) {
            line = sc.nextLine();
            inputs.add(line);
        } else {
            while(inputs.size() <= lineNumber) {
                line(-1);
            }
            line = inputs.get(lineNumber);
        }
        return line;
    }

}
