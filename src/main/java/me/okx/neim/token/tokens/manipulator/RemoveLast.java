package me.okx.neim.token.tokens.manipulator;

import me.okx.neim.stack.NStack;
import me.okx.neim.token.TokenManager;
import me.okx.neim.token.types.Manipulator;
import me.okx.neim.var.IntList;
import me.okx.neim.var.VarInteger;

public class RemoveLast implements Manipulator {

    @Override
    public NStack manipulator(NStack stack, TokenManager tm) {
        Object b = stack.pop();

        if(b instanceof VarInteger) {
            VarInteger ib = (VarInteger) b;
            IntList la = stack.popList();

            for(int x = 0; x < ib.getValue(); x++) {
                la.remove(la.size() - 1);
            }

            stack.push(la);
        } else {
            IntList lb = (IntList) b;

            if(lb.size() > 0) {
                lb.remove(lb.size() - 1);
            }
            stack.push(lb);
        }

        return stack;
    }
}
