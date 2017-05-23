package me.okx.neim.util;

import lombok.Getter;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class Util {
    @Getter
    public static char[] codepage = ("§§§§₁₂₃ΑΒΓ\nΔΕΖΗΘ" +
            "ΙΚΛΜΝΞΟΠΡΣΤΥΦΧΨΩ" +
            " !\"#$%&'()*+,-./" +
            "0123456789:;<=>?" +
            "@ABCDEFGHIJKLMNO" +
            "PQRSTUVWXYZ[\\]^_" +
            "`abcdefghijklmno" +
            "pqrstuvwxyz{|}~𝐀" +
            "𝐁𝐂𝐃𝐄𝐅𝐆𝐇𝐈𝐉𝐊𝐋𝐌𝐍𝐎𝐏𝐐" +
            "𝐑𝐒𝐓𝐔𝐕𝐖𝐗𝐘𝐙𝐚𝐛𝐜𝐝𝐞𝐟𝐠" +
            "𝐡𝐢𝐣𝐤𝐥𝐦𝐧𝐨𝐩𝐪𝐫𝐬𝐭𝐮𝐯𝐰" +
            "𝐱𝐲𝐳𝔸𝔹ℂ𝔻𝔼𝔽𝔾ℍ𝕀𝕁𝕂𝕃𝕄" +
            "ℕ𝕆ℙℚℝ𝕊𝕋𝕌𝕍𝕎𝕏𝕐ℤ𝕒𝕓𝕔" +
            "𝕕𝕖𝕗𝕘𝕙𝕚𝕛𝕜𝕝𝕞𝕟𝕠𝕡𝕢𝕣𝕤" +
            "𝕥𝕦𝕧𝕨𝕩𝕪𝕫αβγδεζηθι" +
            "κλμνξπρσςτυφχψω£"
    ).toCharArray();

    public static IntList createSingletonList(VarInteger n) {
        IntList list = new IntList();
        list.add(n);
        return list;
    }

    public static boolean isInteger(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch(Exception ex) {
            return false;
        }
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