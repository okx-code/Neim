package me.okx.neim.token;

import lombok.Getter;
import me.okx.neim.stack.NStack;
import me.okx.neim.stack.NStackBuilder;
import me.okx.neim.token.tokens.dyad.*;
import me.okx.neim.token.tokens.list.*;
import me.okx.neim.token.tokens.manipulator.*;
import me.okx.neim.token.tokens.monad.*;
import me.okx.neim.token.tokens.nilad.*;
import me.okx.neim.token.tokens.nilad.Random;
import me.okx.neim.token.tokens.special.*;
import me.okx.neim.token.tokens.twochar.ThreeDigitNumber;
import me.okx.neim.token.tokens.twotoken.Assign;
import me.okx.neim.token.tokens.twotoken.ShortForEach;
import me.okx.neim.token.types.*;
import me.okx.neim.token.types.vectorisable.Vectorisable;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntInt;
import me.okx.neim.token.types.vectorisable.VectorisableDyadIntList;
import me.okx.neim.token.types.vectorisable.VectorisableDyadListInt;
import me.okx.neim.util.InputUtil;
import me.okx.neim.util.Util;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.math.BigInteger;
import java.util.*;

public class TokenManager {
    private Map<String, Token> tokens = new HashMap<>();
    private Map<String, Special> special = new HashMap<>();
    private Map<String, TwoToken> twoToken = new HashMap<>();
    private Map<String, Manipulator> manipulator = new HashMap<>();
    private Map<String, String> replace = new HashMap<>();
    private Map<String, TwoChar> twoChar = new HashMap<>();
    @Getter
    private InputUtil input;
    @Getter
    private NStack stack;
    private String code;

    private String sep = "";
    public boolean finish = false;
    public boolean finishSilent = false;

    public TokenManager() {
        input = new InputUtil();
        stack = new NStack(input);
    }

    public TokenManager(InputUtil input) {
        this.input = input;
        stack = new NStack(input);
    }

    private long thetaValue;
    private long index;

    public long getThetaValue() {
        return thetaValue;
    }

    public long getIndex() {
        return index;
    }

    public void registerTokens(long thetaValue) {
        registerTokens(thetaValue, 256);
    }

    public void registerTokens(long thetaValue, long index) {
        this.thetaValue = thetaValue;
        this.index = index;

        special.put("ͻ", new InfiniteLoop());

        manipulator.put("₁", new InputLine(0));
        manipulator.put("₂", new InputLine(1));
        manipulator.put("₃", new InputLine(2));

        replace.put("ᚫ", " 2𝕋");
        replace.put("ᚺ", " 2𝕍");

        special.put("Γ", new ForEach());

        tokens.put("\n", new Nothing());

        special.put("Δ", new InclusiveForEach());

        replace.put("ᛄ", " 2𝕄");
        replace.put("ᛖ", " 2𝔻");

        tokens.put("Θ", new Variable(thetaValue));
        tokens.put("Φ", new Variable(index));

        replace.put("ᚠ", " 2𝕊");

        special.put("Λ", new Keep(1)); // keep values only equal to one

        replace.put("ᛟ", "}𝕚");

        special.put("Ξ", new If());

        replace.put("ᛦ", " 2𝕎");

        twoToken.put("Π", new Assign());

        special.put("Σ", new Keep(0)); // keep values only equal to zero

        twoToken.put("Ψ", new ShortForEach());

        tokens.put(" ", new Nothing());

        manipulator.put("÷", new IfTrueTerminateOnce());
        manipulator.put("#", new TerminateOnce());
        manipulator.put("$", new WrapToArray());

        special.put("&", new ListConstructor());

        special.put("(", new Base255());

        tokens.put("/", new DeleteFromUnderneath());

        tokens.put("_", new Dump());
        tokens.put(">", new Increment());
        tokens.put("<", new Decrement());

        twoChar.put("'", new ThreeDigitNumber(100));
        twoChar.put("\"", new ThreeDigitNumber(356));
        twoChar.put("+", new ThreeDigitNumber(612));
        twoChar.put("*", new ThreeDigitNumber(868));

        tokens.put("B", new ToBase255());
        tokens.put("D", new Duplicate());
        tokens.put("I", new Input(input));

        manipulator.put("K", new Recur());

        special.put("N", new nTimesDo());

        manipulator.put("Q", new Terminate());

        tokens.put("R", new Random());
        tokens.put("S", new Swap());
        tokens.put("U", new DuplicateFromUnderneath());

        tokens.put("\\", new Delete());

        manipulator.put("^", new DeleteAllUnderneath());

        tokens.put("c", new Perfect());
        tokens.put("f", new Fibonacci());
        tokens.put("p", new Polygonal());
        tokens.put("t", new Triangulars());
        tokens.put("q", new Squares());

        tokens.put("𝐀", new Absolute());
        tokens.put("𝐁", new Substrings());
        tokens.put("𝐂", new Chars());
        tokens.put("𝐃", new LargestDivisorUnder());
        tokens.put("𝐄", new IsPalindrome());
        tokens.put("𝐅", new Factors());
        tokens.put("𝐈", new IRange());
        tokens.put("𝐋", new NPrimes());
        tokens.put("𝐌", new IsPrime());
        tokens.put("𝐍", new PlusMinus());
        tokens.put("𝐎", new Not());
        tokens.put("𝐏", new PrimeFactors());
        tokens.put("𝐐", new AllEqual());
        tokens.put("𝐑", new Range());
        tokens.put("𝐒", new CreateSingletonList());
        tokens.put("𝐓", new Factorial());
        tokens.put("𝐔", new UniquePrimeFactors());
        tokens.put("𝐕", new ProperDivisors());
        tokens.put("𝐗", new Prefixes());

        tokens.put("𝐚", new Transpose());
        tokens.put("𝐜", new DivisorCount());
        tokens.put("𝐝", new Deltas());
        tokens.put("𝐠", new Largest());
        tokens.put("𝐣", new Join());
        tokens.put("𝐥", new Length());
        tokens.put("𝐦", new Smallest());
        tokens.put("𝐧", new LengthRange());
        tokens.put("𝐨", new Sort());
        tokens.put("𝐩", new Product());
        tokens.put("𝐫", new ReverseToken());
        tokens.put("𝐬", new Sum());
        tokens.put("𝐭", new IsComposite());
        tokens.put("𝐮", new Uniquify());
        tokens.put("𝐱", new Suffixes());

        tokens.put("𝔸", new Append());
        tokens.put("ℂ", new Coprime());
        tokens.put("𝔻", new Add());
        tokens.put("𝔼", new Equal());
        tokens.put("𝔾", new GreaterThan());
        tokens.put("𝕀", new IndexOf());
        tokens.put("𝕃", new LessThan());
        tokens.put("𝕄", new Modulo());
        tokens.put("𝕆", new Or());
        tokens.put("ℙ", new PolygonalNumber());
        tokens.put("ℚ", new EqualIgnoreTypes());
        tokens.put("ℝ", new Repeat());
        tokens.put("𝕊", new Subtract());
        tokens.put("𝕋", new Multiply());
        tokens.put("𝕌", new KeepMutual());
        tokens.put("𝕍", new IntegerDivide());
        tokens.put("𝕎", new Power());
        tokens.put("𝕏", new XRange());
        tokens.put("𝕒", new And());
        tokens.put("𝕓", new Bifurcate());
        tokens.put("𝕔", new ClosestTo());
        tokens.put("𝕕", new NthElement());
        tokens.put("𝕖", new SelectFirst());
        tokens.put("𝕗", new SelectLast());

        manipulator.put("𝕘", new RemoveFirst());
        manipulator.put("𝕙", new RemoveLast());

        tokens.put("𝕚", new Contains());
        tokens.put("𝕞", new MultipleOf());
        tokens.put("𝕟", new Concatenate());
        tokens.put("𝕠", new Count());
        tokens.put("𝕣", new ReverseRepeat());

        tokens.put("α", new Variable(-1));
        String lowerGreek = "βγδεζηθικλμνξπρσςτυφχψω";
        int nums = 0;
        for(int i = 0; i < lowerGreek.length(); i++) {
            tokens.put(String.valueOf(lowerGreek.charAt(i)), new Variable(nums));
            nums++;
        }
        for(String s : Util.getCodepage()) {
            if(!exists(s)) {
                tokens.put(s, new Variable(nums));
                nums++;
            }
        }
    }

    public void setSeparator(String sep) {
        this.sep = sep;
    }

    public void setFinished(boolean finish) {
        this.finish = finish;
    }

    public boolean isFinished() {
        return finish;
    }

    public String outputVars() {
        StringBuilder vars = new StringBuilder();
        for(Map.Entry<String, Token> entry : tokens.entrySet()) {
            String name = entry.getKey();
            Token token = entry.getValue();

            if(!(token instanceof Variable)) {
                continue;
            }

            vars.append(name).append(" : ").append(((Variable) token).getValue()).append("\n");
        }
        return vars.toString();
    }

    public boolean exists(String name) {
        return tokens.containsKey(name)
                || twoToken.containsKey(name)
                || special.containsKey(name)
                || manipulator.containsKey(name)
                || replace.containsKey(name)
                || twoChar.containsKey(name)
                || name.matches(".*\\d+.*");
    }

    public void registerVariable(String name, Object value) {
        tokens.put(name, new Variable(value));
    }

    public void handleTokens(String program) {
        handleTokens(program, false);
    }

    public void handleTokens(String program, boolean debug) {
        code = program;

        if(program.equalsIgnoreCase("easter egg")) {
            o_O();
            return;
        }

        finish = false;
        StringBuilder token = new StringBuilder();
        String integer = "";
        char[] chars = program.toCharArray();

        StringBuilder sb = new StringBuilder();

        boolean in = false;
        for(int i = 0; i < chars.length; i++) {
            if(chars[i] == '(') {
                in = true;
            } else if(chars[i] == ')') {
                in = false;
            }

            if(!in) {
                String s = String.valueOf(chars[i]);
                for(Map.Entry<String, String> entry : replace.entrySet()) {
                    if(s.contains(entry.getKey())) {
                        s = s.replace(entry.getKey(), entry.getValue());
                        break;
                    }
                }
                sb.append(s);
            } else {
                sb.append(chars[i]);
            }
        }

        program = sb.toString();

        if(program.contains("-")) {
            String[] sides = program.split("-", 2);

            handleTokens(sides[0], debug);

            Object pop = stack.pop();
            if(pop.equals(new VarInteger(0)) ||
                    (pop instanceof IntList && !((IntList) pop).contains(new VarInteger(1)))) {
                stack.push(new VarInteger(0));
                return;
            }

            program = sides[1];
        }

        if(debug) {
            System.out.println("program >> " + program);
        }

        chars = program.toCharArray();

        for(int i = 0; i < chars.length; i++) {
            char c = chars[i];
            token.append(c);
            String str = token.toString();

            if(debug) {
                System.out.println("current >> " + str);
            }

            if(Util.isInteger(str)) {
                integer = str;
            } else if(!integer.isEmpty()) {
                stack.push(new VarInteger(new BigInteger(integer)));
                integer = "";
                token.setLength(0);
                token.append(c);
            }

            str = token.toString();

            if (tokens.containsKey(str)) {
                handleToken(str);
                token.setLength(0);
            } else if(manipulator.containsKey(str)) {
                token.setLength(0);
                NStack ns = manipulator.get(str).manipulator(stack, this);
                NStack newStack = new NStack(input);
                for(Object o : ns) {
                    newStack.push(o);
                }
                stack = newStack;
            } else if(special.containsKey(str)) {
                token.setLength(0);
                int k = i+1;
                int push = 0;
                for(; k < chars.length; k++) {
                    String at = String.valueOf(chars[k]);
                    if(special.containsKey(at) && !(special.get(str) instanceof Base255)) {
                        push++;
                    }
                    if(at.equals(")")) {
                        push--;
                        if(push < 0) {
                            break;
                        }
                    } else if(at.equals("}") && !(special.get(str) instanceof Base255)) {
                        break;
                    }
                    token.append(chars[k]);
                }
                i = k;
                handleSpecial(str, token.toString());
                token.setLength(0);
            } else if(twoToken.containsKey(str)) {
                 token.setLength(0);
                 int k = i+1;
                 sb = new StringBuilder();
                 for(; k < chars.length; k++) {
                     sb.append(chars[k]);
                     if(tokens.containsKey(sb.toString())) {
                         TwoToken tt = twoToken.get(str);
                         stack = tt.twoToken(stack, sb.toString(), this);
                         break;
                     }
                 }
                 i = k;
            } else if(twoChar.containsKey(str)) {
                StringBuilder theChar = new StringBuilder();
                List<String> codePage = Arrays.asList(Util.getCodepage());

                do {
                    i++;
                    theChar.append(chars[i]);
                } while((!codePage.contains(theChar.toString())));

                stack = twoChar.get(str).twoChar(stack, theChar.toString(), this);

                token.setLength(0);
            }

            if(debug) {
                System.out.println("stack >> " + stack);
            }

            if(finish || finishSilent) {
                break;
            }

        }
        if(!integer.isEmpty()) {
            stack.push(new VarInteger(new BigInteger(integer)));
        }
    }

    private void o_O() {
        stack.push("\t\t\t\t   .-^-.\n" +
                "\t\t\t\t .'=^=^='.\n" +
                "\t\t\t\t/=^=^=^=^=\\\n" +
                "\t\t.-~-.  :^= HAPPY =^;\n" +
                "\t  .'~~*~~'.|^ EASTER! ^|\n" +
                "\t /~~*~~~*~~\\^=^=^=^=^=^:\n" +
                "\t:~*~~~*~~~*~;\\.-*))`*-,/\n" +
                "\t|~~~*~~~*~~|/*  ((*   *'.\n" +
                "\t:~*~~~*~~~*|   *))  *   *\\\n" +
                "\t \\~~*~~~*~~| *  ((*   *  /\n" +
                "\t  `.~~*~~.' \\  *))  *  .'\n" +
                "        `~~~`    '-.((*_.-'");
    }

    public void handleToken(String str) {
        Token t = tokens.get(str);
        NStack ns = run(t);
        for(Object o : ns) {
            stack.push(o);
        }
    }

    private void handleSpecial(String str, String val) {
        Special sp = special.get(str);
        runSpecial(sp, val);
    }

    private NStack run(Token t) {
        NStack temp = (NStack) stack.clone();
        try {
            if (t instanceof Nilad) {
                return handleNilad((Nilad) t);
            } else if (t instanceof Monad) {
                return handleMonad((Monad) t);
            } else if (t instanceof Dyad) {
                return handleDyad((Dyad) t);
            } else {
                System.out.println("oops");
                return null;
            }
        } catch(ClassCastException ex) {
            stack = (NStack) temp.clone();

            if(t instanceof VectorisableDyadIntList) {
                Object b = stack.pop();
                Object a = stack.pop();

                if(b instanceof VarInteger) {
                    b = ((VarInteger) b).chars();
                }
                if(a instanceof IntList) {
                    a = ((IntList) a).join();
                }
                stack.push(a);
                stack.push(b);
            } else if(t instanceof VectorisableDyadListInt) {
                Object b = stack.pop();
                Object a = stack.pop();

                if(a instanceof VarInteger) {
                    a = ((VarInteger) a).chars();
                }
                if(b instanceof IntList) {
                    b = ((IntList) b).join();
                }
                stack.push(a);
                stack.push(b);
            } else if(t instanceof VectorisableDyadIntInt) {
                Object b = stack.pop();
                Object a = stack.pop();

                if(b instanceof VarInteger) {
                    b = ((VarInteger) b).chars();
                }
                if(a instanceof VarInteger) {
                    a = ((VarInteger) a).chars();
                }
                stack.push(a);
                stack.push(b);
            } else {
                Object pop = stack.pop();
                if (pop instanceof IntList) {
                    pop = ((IntList) pop).join();
                } else {
                    pop = ((VarInteger) pop).chars();
                }
                stack.push(pop);
            }
            return run(t);
        }
    }

    private NStack handleNilad(Nilad n) {
        return n.nilad();
    }

    private NStack handleMonad(Monad m) {
        Object a = stack.pop();
        if(m instanceof Vectorisable && a instanceof IntList) {
            IntList list = (IntList) a;
            IntList ret = new IntList();
            for(VarInteger val : list) {
                ret.addAll(m.monad(val));
            }
            return new NStackBuilder(ret).build();
        } else {
            return m.monad(a);
        }
    }

    private NStack handleDyad(Dyad d) {
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
                for(Object elem : d.dyad(aInt, bInt)) {
                    list.add(((VarInteger) elem));
                }
            }
            return new NStackBuilder(list).build();
        } else if(d instanceof VectorisableDyadListInt && b instanceof IntList) {
            IntList bList, aList = (IntList) a;
            if(b instanceof IntList) {
                bList = (IntList) b;
            } else {
                bList = Util.createSingletonList((VarInteger) b);
            }
            IntList result = new IntList();
            for(int i = 0; i  < bList.size(); i++) {
                VarInteger bInt = bList.get(i);
                NStack run = d.dyad(aList, bInt);
                for(Object o : run) {
                    result.add((VarInteger) o);
                }
            }
            return new NStackBuilder(result).build();
        } else if(d instanceof VectorisableDyadIntList && a instanceof IntList && b instanceof IntList) {
            IntList aList, bList = (IntList) b;
            if(a instanceof IntList) {
                aList = (IntList) a;
            } else {
                aList = Util.createSingletonList((VarInteger) a);
            }
            IntList result = new IntList();
            for(int i = 0; i  < aList.size(); i++) {
                VarInteger aInt = aList.get(i);
                NStack run = d.dyad(aInt, bList);
                for(Object o : run) {
                    result.add((VarInteger) o);
                }
            }
            return new NStackBuilder(result).build();
        }
        return d.dyad(a, b);
    }

    private void runSpecial(Special sp, String val) {
        NStack ns = sp.special(stack, val, this);
        stack = ns;
    }

    public void outputStack() {
        System.out.print(stackAsString());
    }

    public String stackAsString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < stack.size(); i++) {
            if(i != 0) {
                sb.append(sep);
            }
            sb.append(stack.get(i));
        }
        return sb.toString();
    }
}
