package com.chebdowski.katatddthecoinchangeproblem;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by Piotr Chebdowski on 14.06.2017.
 */

public class CoinChangeTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @Test
    public void printResult_numberOfResults_printResultToConsole() {
        int anyValue = 12;
        int anyCoinTypes[] = new int[]{2, 3, 5, 6};
        CoinChange coinChange = new CoinChange(anyValue, anyCoinTypes);

        coinChange.printResult(12L);

        assertThat(outContent.toString(), is("12"));
    }

    @Test
    public void getWaysCount_correctValueAndCoinTypes_returnsWaysCount() {
        CoinChange coinChange = new CoinChange(10, new int[]{5});

        long result = coinChange.compute();

        assertThat(result, is(1L));
    }

    @Test
    public void getWaysCount_valueIndivisibleByCoinType_returnsZeroWays() {
        CoinChange coinChange = new CoinChange(10, new int[]{3});

        long result = coinChange.compute();

        assertThat(result, is(0L));
    }

    @Test
    public void getWays_correctValueAndOneCoinType_returnsOneWay() {
        CoinChange coinChange = new CoinChange(10, new int[]{5});

        long result = coinChange.compute();

        assertThat(result, is(1L));
    }

    @Test
    public void getWays_twoCoinTypes_returnsTwoWays() {
        CoinChange coinChange = new CoinChange(10, new int[]{2, 5});

        long result = coinChange.compute();

        assertThat(result, is(2L));
    }

    @Test
    public void getWays_anyNumberOfParameters_returns15685693751() {
        CoinChange coinChange = new CoinChange(250, new int[]{41, 34, 46, 9, 37, 32, 42, 21, 7, 13, 1, 24, 3, 43, 2, 23, 8, 45, 19, 30, 29, 18, 35, 11});

        long result = coinChange.compute();

        assertThat(result, is(15685693751L));
    }
}
