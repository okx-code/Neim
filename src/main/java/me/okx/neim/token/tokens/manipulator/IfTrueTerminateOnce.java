package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class IfTrueTerminateOnce implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        Object o = stack.pop();
        boolean terminate = false;
        if(o instanceof VarInteger) {
            terminate = o.equals(new VarInteger(1));
        } else if(o instanceof IntList) {
            terminate = ((IntList) o).contains(new VarInteger(1));
        }
        if(terminate) {
            tm.finishSilent = true;
        }
        return stack;
    }
}
