package com.chebdowski.katatddthecoinchangeproblem;

import java.util.Arrays;

/**
 * Created by Piotr Chebdowski on 14.06.2017.
 */

public class CoinChange {
    private final int value;
    private final int coinTypes[];

    public CoinChange(int value, int coinTypes[]) {
        this.value = value;
        this.coinTypes = coinTypes;
        Arrays.sort(this.coinTypes);
    }

    public long compute() {
        long ways[] = new long[value + 1];
        ways[0] = 1;

        for (int i = 0; i < coinTypes.length; i++) {
            for (int j = coinTypes[i]; j <= value; j++) {
                ways[j] += ways[j - coinTypes[i]];
            }
        }

        return ways[value];
    }

    public void printResult(long result) {
        System.out.print(result);
    }
}
