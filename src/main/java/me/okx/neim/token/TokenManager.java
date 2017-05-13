package me.okx.neim.token;

import lombok.Getter;
import me.okx.neim.stack.NStack;
import me.okx.neim.token.tokens.*;
import me.okx.neim.token.tokens.special.Keep;
import me.okx.neim.token.types.*;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.HashMap;
import java.util.Map;

public class TokenManager {
    private Map<String, Token> tokens;
    private Map<String, Special> special;
    @Getter
    private NStack stack;

    public TokenManager() {
        tokens = new HashMap<>();
        special = new HashMap<>();
        stack = new NStack();
    }

    public void registerTokens() {

        special.put("Λ", new Keep(1)); // keep values only equal to one
        special.put("Σ", new Keep(0)); // keep values only equal to zero

        tokens.put(" ", new Nothing());
        tokens.put("I", new Input());
        tokens.put("R", new Random());

        tokens.put("𝐈", new IRange());
        tokens.put("𝐍", new PlusMinus());
        tokens.put("𝐏", new PrimeFactors());
        tokens.put("𝐑", new Range());
        tokens.put("𝐔", new UniquePrimeFactors());

        tokens.put("𝐩", new Product());
        tokens.put("𝐬", new Sum());
        tokens.put("𝐮", new Uniquify());

        tokens.put("ℂ", new Coprime());
        tokens.put("𝔼", new Equal());
        tokens.put("𝕄", new Modulo());
        tokens.put("𝕞", new MultipleOf());

        tokens.put("α", new Variable(-1));
        String lowerGreek = "βγδεζηθικλμνξπρσςτυφχψω";
        for(int i = 0; i < lowerGreek.length(); i++) {
            tokens.put(String.valueOf(lowerGreek.charAt(i)), new Variable(i+10));
        }
    }

    public void handleTokens(String program) {
        StringBuilder token = new StringBuilder();
        String integer = "";
        char[] chars = program.toCharArray();
        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
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
            } else if(special.containsKey(str)) {
                System.out.println("SPECIAL: " + str);
                token.setLength(0);
                int k = i+1;
                for(; k < chars.length; k++) {
                    if(chars[k] == ')') {
                        k++;
                        break;
                    }
                    token.append(chars[k]);
                }
                i = k;
                handleSpecial(str, token.toString());
                token.setLength(0);
            }
        }
    }

    private void handleToken(String str) {
        Token t = tokens.get(str);
        run(t);
    }

    private void handleSpecial(String str, String val) {
        Special sp = special.get(str);
        runSpecial(sp, val);
    }

    private void run(Token t) {
        NStack returnedStack = new NStack();
        boolean vectorisable = t instanceof Vectorisable;
        if(t instanceof Nilad) {
            returnedStack = ((Nilad) t).nilad();
        } else if(t instanceof Monad) {
            Monad monad = (Monad) t;
            Object a = stack.pop();
            if(vectorisable && a instanceof IntList) {
                IntList list = (IntList) a;
                for(VarInteger val : list) {
                    returnedStack.addAll(monad.monad(val));
                }
            } else {
                returnedStack = monad.monad(a);
            }
        } else if(t instanceof Dyad) {
            Object b = stack.pop();
            Object a = stack.pop();
            returnedStack = ((Dyad) t).dyad(a, b);
        }
        stack.addAll(returnedStack);
    }

    private void runSpecial(Special sp, String val) {
        stack = sp.special(new SpecialData(val, stack));
    }

    public void outputStack() {
        for(Object elem : stack) {
            System.out.println(String.valueOf(elem));
        }
    }
}
