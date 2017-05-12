package me.okx.neim.util;

import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static VarInteger getInteger() {
        return new VarInteger(line());
    }
    public static IntList getList() {
        return getList(line());
    }
    public static IntList getList(String ss) {
        IntList list = new IntList();
        for(String s : ss.split(" ")) {
            list.add(new VarInteger(s));
        }
        return list;
    }
    public static Object getSomething() {
        String s = line();
        if(s.contains(" ")) {
            return getList(s);
        } else {
            return new VarInteger(s);
        }
    }

    public static String line() {
        return sc.nextLine();
    }

}
