package me.okx.neim.token;

import lombok.Getter;
import me.okx.neim.stack.NStack;
import me.okx.neim.token.tokens.*;
import me.okx.neim.token.tokens.special.ForEach;
import me.okx.neim.token.tokens.special.Keep;
import me.okx.neim.token.types.*;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntInt;
import me.okx.neim.token.types.vectorisable.VectorisableDyadListInt;
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

    public void registerTokens(long thetaValue) {
        tokens.put("₁", new InputLine(0));
        tokens.put("₂", new InputLine(1));
        tokens.put("₃", new InputLine(2));

        special.put("Γ", new ForEach());

        tokens.put("Θ", new Variable(thetaValue));

        special.put("Λ", new Keep(1)); // keep values only equal to one
        special.put("Σ", new Keep(0)); // keep values only equal to zero

        tokens.put(" ", new Nothing());
        tokens.put(">", new Increment());
        tokens.put("<", new Decrement());
        tokens.put("D", new Duplicate());
        tokens.put("I", new Input());
        tokens.put("R", new Random());
        tokens.put("U", new DuplicateFromUnderneath());

        tokens.put("𝐀", new And());
        tokens.put("𝐁", new Substrings());
        tokens.put("𝐄", new IsPalindrome());
        tokens.put("𝐅", new Factors());
        tokens.put("𝐈", new IRange());
        tokens.put("𝐋", new NPrimes());
        tokens.put("𝐌", new IsPrime());
        tokens.put("𝐍", new PlusMinus());
        tokens.put("𝐎", new Not());
        tokens.put("𝐏", new PrimeFactors());
        tokens.put("𝐑", new Range());
        tokens.put("𝐒", new CreateSingletonList());
        tokens.put("𝐓", new Factorial());
        tokens.put("𝐔", new UniquePrimeFactors());

        tokens.put("𝐝", new Deltas());
        tokens.put("𝐠", new Largest());
        tokens.put("𝐣", new Join());
        tokens.put("𝐥", new Length());
        tokens.put("𝐦", new Smallest());
        tokens.put("𝐩", new Product());
        tokens.put("𝐬", new Sum());
        tokens.put("𝐮", new Uniquify());

        tokens.put("𝔸", new Append());
        tokens.put("ℂ", new Coprime());
        tokens.put("𝔼", new Equal());
        tokens.put("𝕄", new Modulo());
        tokens.put("𝕆", new Or());
        tokens.put("ℝ", new Repeat());
        tokens.put("𝕊", new Subtract());
        tokens.put("𝕎", new Power());
        tokens.put("𝕏", new XRange());
        tokens.put("𝕔", new ClosestTo());
        tokens.put("𝕚", new Contains());
        tokens.put("𝕞", new MultipleOf());

        tokens.put("α", new Variable(-1));
        String lowerGreek = "βγδεζηθικλμνξπρσςτυφχψω";
        for(int i = 0; i < lowerGreek.length(); i++) {
            tokens.put(String.valueOf(lowerGreek.charAt(i)), new Variable(i+10));
        }

        // 𝐥>𝐈Γ6Θℝ<)₁𝕔>
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
                stack.push(new VarInteger(Long.parseLong(integer)));
                integer = "";
                token.setLength(0);
                token.append(c);
            }
            str = token.toString();
            if (tokens.containsKey(str)) {
                handleToken(str);
                token.setLength(0);
            } else if(special.containsKey(str)) {
                token.setLength(0);
                int k = i+1;
                for(; k < chars.length; k++) {
                    if(chars[k] == ')') {
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
        if(t instanceof Nilad) {
            handleNilad((Nilad) t);
        } else if(t instanceof Monad) {
            handleMonad((Monad) t);
        } else if(t instanceof Dyad) {
            handleDyad((Dyad) t);
        }
    }

    private void handleNilad(Nilad n) {
        stack.addAll(n.nilad());
    }

    private void handleMonad(Monad m) {
        Object a = stack.pop();
        if(m instanceof Vectorisable && a instanceof IntList) {
            IntList list = (IntList) a;
            IntList ret = new IntList();
            for(VarInteger val : list) {
                ret.addAll(m.monad(val));
            }
            stack.add(ret);
        } else {
            stack.addAll(m.monad(a));
        }
    }

    private void handleDyad(Dyad d) {
        Object b = stack.pop();
        Object a = stack.pop();
        if(d instanceof VectorisableDyadIntInt && (b instanceof IntList || a instanceof IntList)) {
            IntList bList, aList;
            if(b instanceof IntList) {
                bList = (IntList) b;
                if(a instanceof IntList) {
                    aList = (IntList) a;
                } else {
                    aList = ((VarInteger) a).repeat(bList.size());
                }
            } else {
                aList = (IntList) a;
                bList = ((VarInteger) b).repeat(aList.size());
            }
            IntList list = new IntList();
            for(int i = 0; i < bList.size(); i++) {
                VarInteger bInt = bList.get(i);
                VarInteger aInt = aList.get(i);
                list.addAll(d.dyad(aInt, bInt));
            }
            stack.add(list);
            return;
        } else if(d instanceof VectorisableDyadListInt && a instanceof IntList) {
            IntList bList, aList = (IntList) a;
            if(b instanceof IntList) {
                bList = (IntList) b;
            } else {
                bList = Util.createSingletonList((VarInteger) b);
            }
            for(int i = 0; i  < bList.size(); i++) {
                VarInteger bInt = bList.get(i);
                NStack run = d.dyad(aList, bInt);
                for(Object o : run) {
                    stack.add(o);
                }
            }
            return;
        }
        stack.addAll(d.dyad(a, b));
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
