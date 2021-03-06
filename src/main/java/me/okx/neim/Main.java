package me.okx.neim;

import me.okx.neim.token.TokenManager;
import me.okx.neim.util.Util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws UnsupportedEncodingException {
        boolean input = false;
        boolean utf8 = true;
        boolean vars = false;
        boolean newlineSeparated = false;
        boolean debug = false;
        if(args.length == 0) {
            System.out.print("Usage:\n" +
                    "    java -jar Neim-1.0-SNAPSHOT.jar <FLAGS> <FILE>\n" +
                    "Available flags:\n" +
                    "    -i Read a line from STDIN as the program\n" +
                    "    -e Read the file in Neim's encoding\n" +
                    "    -v Don't actually do anything, just print\n" +
                    "         all the preset variables\n" +
                    "    -d Activate debug mode\n" +
                    "    (note: flags must be combined. '-ab' is valid but '-a -b' is not)");
            return;
        } if((args.length == 1 || args.length == 2) && args[0].startsWith("-")) {

            List<Character> flags = args[0].substring(1).chars().mapToObj(c -> (char) c).collect(Collectors.toList());

            if(flags.contains('i')) {
                input = true;
            } if(flags.contains('e')) {
                utf8 = false;
            } if (flags.contains('v')) {
                vars = true;
            } if(flags.contains('n')) {
                newlineSeparated = true;
            } if(flags.contains('d')) {
                debug = true;
            }
        }

        String program = null;

        if(input) {
            Scanner sc = new Scanner(System.in);
            program = sc.nextLine();
        } else if(!vars) {
            String file = args[args.length-1];
            byte[] contents;
            try {
                contents = Files.readAllBytes(new File(file).toPath());
            } catch (IOException e) {
                System.out.println("An error occured reading the file");
                return;
            }
            if(utf8) {
                program = new String(contents, "UTF-8");
            } else {
                StringBuilder sb = new StringBuilder();
                String[] codepage = Util.getCodepage();
                for(byte b : contents) {
                    int unsigned = Byte.toUnsignedInt(b);
                    sb.append(codepage[unsigned]);
                }
                program = sb.toString();
            }
        }

        TokenManager tm = new TokenManager();
        tm.registerTokens(100);

        if(!vars) {
            if(newlineSeparated) {
                tm.setSeparator("\n");
            }
            tm.handleTokens(program, debug);
            tm.outputStack();
        } else {
            System.out.println(tm.outputVars());
        }
    }
}
