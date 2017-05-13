package me.okx.neim.var;


import lombok.Getter;
import lombok.Setter;
import me.okx.neim.util.Util;

public class VarInteger implements Cloneable {
    @Setter
    @Getter
    private long value;

    public VarInteger() {
        this.value = 0;
    }

    public VarInteger(long value) {
        this.value = value;
    }

    public VarInteger(String str) {
        if(Util.isInteger(str)) {
            this.value = Integer.parseInt(str);
        } else {
            this.value = Util.sumString(str);
        }
    }

    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }

    @Override
    public boolean equals(Object o) {
        if(o == null) {
            return false;
        }

        if(!(o instanceof VarInteger)) {
            return false;
        }

        return ((VarInteger) o).value == this.value;
    }

    @Override
    public int hashCode() {
        return Integer.parseInt(String.valueOf(this.value % Integer.MAX_VALUE));
    }

    public IntList primeFactors() {
        long n = this.value;
        IntList factors = new IntList();
        for (int i = 2; i <= n / i; i++) {
            while (n % i == 0) {
                factors.addInt(i);
                n /= i;
            }
        }
        if (n > 1) {
            factors.addInt(n);
        }
        return factors;
    }

    public VarInteger add(VarInteger to) {
        this.setValue(this.getValue() + to.getValue());
        return this;
    }

    public VarInteger multiply(VarInteger to) {
        this.setValue(this.getValue() * to.getValue());
        return this;
    }

    public VarInteger clone() {
        return new VarInteger(this.getValue());
    }

    public VarInteger coprime(VarInteger to) {
        IntList toFactors = to.primeFactors();
        boolean coprime = true;
        for(VarInteger factor : this.primeFactors()) {
            if(toFactors.contains(factor) && factor.getValue() != 1) {
                coprime = false;
            }
        }
        return Util.booleanToNumber(coprime);
    }

    public VarInteger modulo(VarInteger to) {
        this.setValue(this.getValue() % to.getValue());
        return this;
    }

    public boolean isTruthy() {
        return this.getValue() == 1;
    }
}
