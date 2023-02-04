package com.dojo.kata.kata02;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class Iteracion01Test {

    @Test
    void when_GetData_expect_1000elements() {
        Iteracion1 iteracion1 = new Iteracion1();
        assertEquals(1000, iteracion1.getData().length);
    }

    @Test
    void when_getData_expect_1000ElementsWithValue() {
        Iteracion1 iteracion1 = new Iteracion1();

        for (int i = 0; i < 1000; i++) {
            assertNotEquals(0, iteracion1.getData()[i]);
        }
    }

    @Test
    void when_getData_expect_1000ElementsSorted() {
        Iteracion1 iteracion1 = new Iteracion1();

        Integer valorAnterior = -1000001;
        for (int i = 0; i < 1000; i++) {
            assertThat(valorAnterior).isLessThanOrEqualTo(iteracion1.getData()[i]);
            valorAnterior = iteracion1.getData()[i];
        }
    }

    @Test
    void when_getIndexOfValue_expect_zero() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 0;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }

    @Test
    void when_getIndexOfValue_expect_one() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 1;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }


    @Test
    void when_getIndexOfValue_expect_51() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 51;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }


    @Test
    void when_getIndexOfValue_expect_53() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 53;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }


    @Test
    void when_getIndexOfValue_expect_254() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 254;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }

    @Test
    void when_getIndexOfValue_expect_255() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 255;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }


    @Test
    void when_getIndexOfValue_expect_999() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer expectedIndex = 999;
        Integer valorBuscado = iteracion1.getData()[expectedIndex];

        assertEquals(expectedIndex, iteracion1.getIndexOf(valorBuscado));
    }


    @Test
    void worstCaseIterationsIs10() {
        //Maximas iteraciones = log2(n) = Log2(1000) = 9.96578428... = 10
        Iteracion1 iteracion1 = new Iteracion1();
        Integer maxIterations = 0;
        for (int i = 0; i < 1000; i++) {
            Integer valorBuscado = iteracion1.getData()[i];
            iteracion1.getIndexOf(valorBuscado);
            maxIterations = Math.max(maxIterations, iteracion1.getLastNumberOfIterations());
        }

        assertEquals(10, maxIterations);
    }

    @Test
    void bestCaseIs1() {
        Iteracion1 iteracion1 = new Iteracion1();
        Integer valorBuscado = iteracion1.getData()[500];
        iteracion1.getIndexOf(valorBuscado);
        assertEquals(1, iteracion1.getLastNumberOfIterations());
    }

}
