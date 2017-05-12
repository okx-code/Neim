package me.okx.neim;

import me.okx.neim.token.TokenManager;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String program = sc.nextLine();

        TokenManager tm = new TokenManager();
        tm.registerTokens();
        tm.handleTokens(program);
        tm.outputStack();
    }
}
