package com.dojo.kata.kata02;

import java.util.Arrays;

public class Iteracion1 {

    private Integer[] data;
    private Integer lastNumberOfIterations = 0;

    Integer[] getData() {
        return this.data;
    }

    Integer getLastNumberOfIterations() {
        return this.lastNumberOfIterations;
    }

    Iteracion1() {
        this.data = new Integer[1000];
        this.fillData();
        this.sortData();
    }

    private void fillData() {
        for (int i = 0; i < 1000; i++) {

            this.data[i] = Double.valueOf(Math.random() * 1000000).intValue();
            if (this.data[i] == 0) {
                this.data[i] = 1;
            }
        }
    }

    private void sortData() {
        Arrays.sort(this.data);
    }

    public Integer getIndexOf(Integer valorBuscado) {
        Integer middle = 500;
        Integer maxIndex = 999;
        Integer minIndex = 0;
        this.lastNumberOfIterations = 0;
        do {
            this.lastNumberOfIterations++;
            if (this.data[middle] < valorBuscado) {
                minIndex = middle + 1;
                middle = ((minIndex + maxIndex) / 2);
            } else if (this.data[middle] > valorBuscado) {
                maxIndex = middle - 1;
                middle = ((minIndex + maxIndex) / 2);
            } else {
                break;
            }
        } while (true);
        return middle;
    }

}
