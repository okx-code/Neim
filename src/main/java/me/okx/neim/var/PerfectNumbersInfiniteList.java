package me.okx.neim.var;

public class PerfectNumbersInfiniteList extends InfiniteList {
    public PerfectNumbersInfiniteList() {
        init();
    }

    @Override
    public VarInteger infGet(int index) {
        return new VarInteger(nthPerfect(++index));
    }

    // Returns true iff n is perfect, that is, if n is positive and
    // it is the sum of its proper divisors (that is, the divisors less than
    // itself.)
    // Noting that divisors come in pairs (say, for 36, we get 1*36, 2*18, 3*12,
    // 4*9, and 6*6), we can consume them in pairs, and so only iterate up to
    // the square root of n.  But we have to be careful not to count n itself
    // as a divisor and not to count a perfect square root (like 6) twice.
    public static boolean isPerfect(int n) {
        if (n < 2) return false;
        int factorSum = 1; // 1 is a factor of all numbers, so begin with it
        for (int factor=2; factor*factor<=n; factor++) {
            if (n % factor == 0) {
                // we found a factor, so add it to our sum of factors
                factorSum += factor;
                int otherFactor = n / factor;
                if (otherFactor != factor)
                    factorSum += otherFactor;
            }
        }
        return (factorSum == n);
    }

    // Returns the nth perfect number, where 1 returns 6 and 2 returns 28.
    // So there is no 0th perfect number.  Starts a counter in search of
    // perfect #'s.  Note that "perfectCount" is a tally of how many
    // perfect #'s we've found so far.  When (perfectCount == n), we're done.
    public static int nthPerfect(int n) {
        assert(n >= 1);
        int counter=2, perfectCount = 0;
        while (true) {
            if (isPerfect(counter)) {
                if (++perfectCount == n)
                    return counter;
            }
            counter++;
        }
    }
}
