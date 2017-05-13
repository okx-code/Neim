package me.okx.neim.util;

import lombok.Getter;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

import java.util.ArrayList;
import java.util.Arrays;

public class Util {
    @Getter
    public static char[] codepage = ("§§§§§§§ΑΒΓ\nΔΕΖΗΘ" +
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
        return new IntList(new ArrayList<>(Arrays.asList(n)));
    }

    public static boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
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
}