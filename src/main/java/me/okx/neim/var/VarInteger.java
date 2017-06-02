package me.okx.neim.var;


import lombok.Getter;
import lombok.Setter;
import me.okx.neim.util.Util;

import java.util.ArrayList;
import java.util.Collections;

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
            this.value = Long.parseLong(str);
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

    public boolean isPalindrome() {
        char[] word = this.toString().toCharArray();
        int i1 = 0;
        int i2 = word.length - 1;
        while (i2 > i1) {
            if (word[i1] != word[i2]) {
                return false;
            }
            ++i1;
            --i2;
        }
        return true;
    }

    public IntList getFactors() {
        long a = this.getValue();
        long upperlimit = (long)(Math.sqrt(a));
        ArrayList<Long> factors = new ArrayList<>();
        for(long i=1;i <= upperlimit; i+= 1){
            if(a%i == 0){
                factors.add(i);
                if(i != a/i){
                    factors.add(a/i);
                }
            }
        }
        Collections.sort(factors);
        return IntList.fromLongList(factors);
    }

    public IntList repeat(long times) {
        IntList list = new IntList();
        for(long i = 0; i < times; i++) {
            list.add(this);
        }
        return list;
    }

    public IntList chars() {
        IntList chars = new IntList();
        for(char c : this.toString().toCharArray()) {
            chars.add(new VarInteger(c));
        }
        return chars;
    }

    private static int popCount(int n) {
        n -= (n >>> 1) & 0x55555555;
        n = ((n >>> 2) & 0x33333333) + (n & 0x33333333);
        n = ((n >> 4) & 0x0F0F0F0F) + (n & 0x0F0F0F0F);
        return (n * 0x01010101) >> 24;
    }

    public VarInteger nthPrime() {
        long n = this.getValue();
        if (n < 2) return new VarInteger(2);
        if (n == 2) return new VarInteger(3);
        if (n == 3) return new VarInteger(5);
        int limit, root, count = 2;
        limit = (int)(n*(Math.log(n) + Math.log(Math.log(n)))) + 3;
        root = (int)Math.sqrt(limit);
        switch(limit%6) {
            case 0:
                limit = 2*(limit/6) - 1;
                break;
            case 5:
                limit = 2*(limit/6) + 1;
                break;
            default:
                limit = 2*(limit/6);
        }
        switch(root%6) {
            case 0:
                root = 2*(root/6) - 1;
                break;
            case 5:
                root = 2*(root/6) + 1;
                break;
            default:
                root = 2*(root/6);
        }
        int dim = (limit+31) >> 5;
        int[] sieve = new int[dim];
        for(int i = 0; i < root; ++i) {
            if ((sieve[i >> 5] & (1 << (i&31))) == 0) {
                int start, s1, s2;
                if ((i & 1) == 1) {
                    start = i*(3*i+8)+4;
                    s1 = 4*i+5;
                    s2 = 2*i+3;
                } else {
                    start = i*(3*i+10)+7;
                    s1 = 2*i+3;
                    s2 = 4*i+7;
                }
                for(int j = start; j < limit; j += s2) {
                    sieve[j >> 5] |= 1 << (j&31);
                    j += s1;
                    if (j >= limit) break;
                    sieve[j >> 5] |= 1 << (j&31);
                }
            }
        }
        int i;
        for(i = 0; count < n; ++i) {
            count += popCount(~sieve[i]);
        }
        --i;
        int mask = ~sieve[i];
        int p;
        for(p = 31; count >= n; --p) {
            count -= (mask >> p) & 1;
        }
        return new VarInteger(3*(p+(i<<5))+7+(p&1));
    }

    public VarInteger factorial() {
        long result = 1;
        for(long i = 2; i <= this.getValue(); i++) {
            result *= i;
        }
        return new VarInteger(result);
    }
}
