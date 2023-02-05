package com.dojo.kata.kata02.iteracion2;


import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Kata02Test {

    private static final Integer N = 100000;//10000000
    private static final Integer MAX_VALUE = 100000000;
    private static final Integer MIN_VALUE = -100000000;
    private static Kata02 kata02;

    @BeforeAll
    public static void init() {
        kata02 = new Kata02();
        kata02.setMaxValue(MAX_VALUE);
        kata02.setMinValue(MIN_VALUE);
        kata02.setElements(N);
        kata02.buildData();
    }

    @Test
    void when_getData_expect_NElements() {
        assertEquals(N, kata02.getData().length);
    }

    @Test
    void when_getData_expect_NElementSorted() {
        final Integer[] data = kata02.getData();
        Integer numeroAnterior = MIN_VALUE;
        for (Integer value : data) {
            assertThat(numeroAnterior).isLessThanOrEqualTo(value);
            numeroAnterior = value;
        }
    }

    @Test
    void when_searchValue_expect_0() {
        final Integer expectedIndex = 0;
        Integer firstValue = kata02.getData()[expectedIndex];
        assertEquals(expectedIndex, kata02.searchValue(firstValue));
    }

    @Test
    void when_searchValue_expect_1() {
        final Integer expectedIndex = 1;
        Integer firstValue = kata02.getData()[expectedIndex];
        assertEquals(expectedIndex, kata02.searchValue(firstValue));
    }

    @Test
    void when_searchValue_expect_lastIndex() {
        final Integer expectedIndex = N - 1;
        Integer firstValue = kata02.getData()[expectedIndex];
        assertEquals(expectedIndex, kata02.searchValue(firstValue));
    }

    @Test
    void when_searchValueWithMinValueMinusOne_expect_notFound() {
        assertEquals(-1, kata02.searchValue(MIN_VALUE - 1));
    }

    @Test
    void when_searchValueWithMaxValuePlusOne_expect_notFound() {
        assertEquals(-1, kata02.searchValue(MAX_VALUE + 1));
    }

    @Test
    void when_searchValueSomeValuePlusOne_expect_notFound() {
        assertEquals(-1, kata02.searchValue((MAX_VALUE + MIN_VALUE)/2 + 1));
    }

    @Test
    void when_searchValueAllItems_expect_correctIndexValue() {
        for (int i = 0; i < N; i++) {
            Integer valueToSearch = kata02.getData()[i];
            assertEquals(valueToSearch, kata02.getData()[kata02.searchValue(valueToSearch)]);
        }
    }

    @Test
    void when_searchValueAllItems_expect_eachIterationsAreLessThanOrEqualToLog2N() {
        Integer maxIterations = this.log2N() + 1;
        for (int i = 0; i < N; i++) {
            Integer valueToSearch = kata02.getData()[i];
            kata02.searchValue(valueToSearch);
            assertThat(kata02.getNumberOfIterationsOfLastSearch()).isLessThanOrEqualTo(maxIterations);
        }
    }


    private Integer log2N() {
        final double log2 = Math.log(N) / Math.log(2);
        return Double.valueOf(log2 - log2 % 1).intValue();
    }

}

