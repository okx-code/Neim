package me.okx.neim.util;

import lombok.Getter;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Util {
    @Getter
    public static String[] codepage = {"§", "¶", "÷", "ͻ", "₁", "₂", "₃", "ᚫ", "ᚺ", "Γ", "\n", "Δ", "ᛄ", "ᛖ", "ᛘ", "Θ", "Φ", "ᚠ", "Λ", "ᛟ", "ᚳ", "Ξ", "ᛦ", "Π", "ᚢ", "Σ", "ᛃ", "ᛂ", "ᚕ", "ᛝ", "Ψ", "Ω", " ", "!", "\"", "#", "$", "%", "&", "'", "(", ")", "*", "+", ",", "-", ".", "/", "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", ":", ";", "<", "=", ">", "?", "@", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z", "[", "\\", "]", "^", "_", "`", "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "{", "|", "}", "~", "𝐀", "𝐁", "𝐂", "𝐃", "𝐄", "𝐅", "𝐆", "𝐇", "𝐈", "𝐉", "𝐊", "𝐋", "𝐌", "𝐍", "𝐎", "𝐏", "𝐐", "𝐑", "𝐒", "𝐓", "𝐔", "𝐕", "𝐖", "𝐗", "𝐘", "𝐙", "𝐚", "𝐛", "𝐜", "𝐝", "𝐞", "𝐟", "𝐠", "𝐡", "𝐢", "𝐣", "𝐤", "𝐥", "𝐦", "𝐧", "𝐨", "𝐩", "𝐪", "𝐫", "𝐬", "𝐭", "𝐮", "𝐯", "𝐰", "𝐱", "𝐲", "𝐳", "𝔸", "𝔹", "ℂ", "𝔻", "𝔼", "𝔽", "𝔾", "ℍ", "𝕀", "𝕁", "𝕂", "𝕃", "𝕄", "ℕ", "𝕆", "ℙ", "ℚ", "ℝ", "𝕊", "𝕋", "𝕌", "𝕍", "𝕎", "𝕏", "𝕐", "ℤ", "𝕒", "𝕓", "𝕔", "𝕕", "𝕖", "𝕗", "𝕘", "𝕙", "𝕚", "𝕛", "𝕜", "𝕝", "𝕞", "𝕟", "𝕠", "𝕡", "𝕢", "𝕣", "𝕤", "𝕥", "𝕦", "𝕧", "𝕨", "𝕩", "𝕪", "𝕫", "α", "β", "γ", "δ", "ε", "ζ", "η", "θ", "ι", "κ", "λ", "μ", "ν", "ξ", "π", "ρ", "σ", "ς", "τ", "υ", "φ", "χ", "ψ", "ω", "£"};


    public static IntList createSingletonList(VarInteger n) {
        IntList list = new IntList();
        list.add(n);
        return list;
    }

    public static boolean isInteger(String str) {
        return str.matches("[0-9]+");
    }

    public static int sumString(String str) {
        int ret = 0;
        for(char c: str.toCharArray()) {
            ret += c;
        }
        return ret;
    }

    public static VarInteger booleanToNumber(boolean b) {
        return b ? new VarInteger(1) : new VarInteger(0);
    }

    public static IntList range(long a) {
        IntList list = new IntList();
        for(long i = 0; i < a; i++) {
            list.add(new VarInteger(i));
        }
        return list;
    }

    public static IntList irange(long a) {
        IntList list = new IntList();
        for(int i = 1; i <= a; i++) {
            list.add(new VarInteger(i));
        }
        return list;
    }

    public static IntList xrange(long a, long b) {
        IntList list = new IntList();
        for(long i = a; i < b; i++) {
            list.add(new VarInteger(i));
        }
        return list;
    }
}