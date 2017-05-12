package me.okx.neim.token;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.tokens.*;
import me.okx.neim.token.types.Dyad;
import me.okx.neim.token.types.Monad;
import me.okx.neim.token.types.Nilad;
import me.okx.neim.token.types.Token;
import me.okx.neim.util.Util;
import me.okx.neim.var.VarInteger;

import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private Map<String, Token> tokens;
    private NStack stack;

    public TokenManager() {
        tokens = new HashMap<>();
        stack = new NStack();
    }

    public void registerTokens() {
        tokens.put(" ", new Nothing());
        tokens.put("I", new Input());

        tokens.put("𝐍", new PlusMinus());
        tokens.put("𝐏", new PrimeFactors());
        tokens.put("𝐔", new UniquePrimeFactors());

        tokens.put("𝐩", new Product());
        tokens.put("𝐬", new Sum());

        tokens.put("α", new Variable(-1));
        String lowerGreek = "βγδεζηθικλμνξπρσςτυφχψω";
        for(int i = 0; i < lowerGreek.length(); i++) {
            tokens.put(String.valueOf(lowerGreek.charAt(i)), new Variable(i+10));
        }
    }

    public void handleTokens(String program) {
        StringBuilder token = new StringBuilder();
        String integer = "";
        for(char c : program.toCharArray()) {
            token.append(c);
            String str = token.toString();
            if(Util.isInteger(str)) {
                integer = str;
            } else if(!integer.isEmpty()) {
                stack.push(new VarInteger(Integer.parseInt(integer)));
                integer = "";
                token.setLength(0);
                token.append(c);
            }
            str = token.toString();
            if (tokens.containsKey(str)) {
                handleToken(str);
                token.setLength(0);
            }
        }
    }

    private void handleToken(String str) {
        Token t = tokens.get(str);
        run(t);
    }

    public void run(Token t) {
        NStack returnedStack = new NStack();
        if(t instanceof Nilad) {
            returnedStack = ((Nilad) t).nilad();
        } else if(t instanceof Monad) {
            Object a = stack.pop();
            returnedStack = ((Monad) t).monad(a);
        } else if(t instanceof Dyad) {
            Object b = stack.pop();
            Object a = stack.pop();
            returnedStack = ((Dyad) t).dyad(a, b);
        }
        stack.addAll(returnedStack);
    }

    public void outputStack() {
        for(Object elem : stack) {
            System.out.println(String.valueOf(elem));
        }
    }

    class Holder {
        String used = "𝐔";
    }
}
