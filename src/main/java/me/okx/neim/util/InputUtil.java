package me.okx.neim.util;

import me.okx.neim.var.VarInteger;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static VarInteger line() {
        return new VarInteger(Integer.parseInt(sc.nextLine()));
    }
}
