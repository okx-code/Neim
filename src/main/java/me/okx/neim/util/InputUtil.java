package me.okx.neim.util;

import me.okx.neim.var.VarInteger;

import java.util.Scanner;

public class InputUtil {
    private static Scanner sc = new Scanner(System.in);

    public static VarInteger line() {
        String line = sc.nextLine();
        
        try {
            return new VarInteger(Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException ex) {
            System.out.println("Illegal integer parse: " + line);
            return null;
        }
    }
}
