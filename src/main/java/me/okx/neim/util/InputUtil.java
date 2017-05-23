package me.okx.neim.util;

import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class InputUtil {
    private List<String> inputs = new ArrayList<>();
    private InputStream inputStream = System.in;
    private Scanner sc = new Scanner(inputStream);
    private int len = 10000;

    public void setInputStream(InputStream is) {
        inputStream = is;
        this.sc = new Scanner(inputStream);
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    public List<String> getInputs() {
        return inputs;
    }

    public IntList getList(String ss) {
        IntList list = new IntList();
        for(String s : ss.split(" ")) {
            list.add(new VarInteger(s));
        }
        return list;
    }

    public Object getSomething() {
        return getSomething(-1);
    }

    public Object getSomething(int lineNumber) {
        String s = line(lineNumber);
        if(s.contains(" ")) {
            return getList(s);
        } else {
            return new VarInteger(s);
        }
    }

    public String line(int lineNumber) {
        String line;
        if (lineNumber < 0) {
            try {
                line = sc.nextLine();
                inputs.add(line);
            } catch(NoSuchElementException e) {
                try {
                    return inputs.get(0);
                } catch(Exception e1) {
                    return "0";
                }
            }
        } else {
            while(inputs.size() < (lineNumber)+1) {
                if(sc.hasNextLine()) {
                    line(-1);
                    len = inputs.size();
                }
            }
            line = inputs.get(((lineNumber) % (len)));
        }
        return line;
    }

}
