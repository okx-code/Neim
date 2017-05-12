package me.okx.neim.flags;

import java.util.ArrayList;
import java.util.List;

public class GetFlags {
    public static List<Flag> getFlags(String from) {
        List<Flag> flags = new ArrayList<>();
        if(!from.startsWith("-")) {
            return null;
        }
        StringBuilder tot = new StringBuilder();
        for(char c : from.substring(1).toCharArray()) {
            tot.append(c);
            String strValue = tot.toString();
            for(Flag f : Flag.values()) {
                if(f.getName().equals(strValue)) {
                    flags.add(f);
                    tot.setLength(0);
                    break;
                }
            }
        }
        return flags;
    }
}
