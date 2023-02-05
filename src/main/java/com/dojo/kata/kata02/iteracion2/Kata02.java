package com.dojo.kata.kata02.iteracion2;

import java.util.Arrays;

//Recursivo
public class Kata02 {

    private Integer minValue;
    private Integer maxValue;
    private Integer elements;
    private Integer[] data;

    private Integer numberOfIterationsOfLastSearch;

    public void setMinValue(Integer minValue) {
        this.minValue = minValue;
    }

    public void setMaxValue(Integer maxValue) {
        this.maxValue = maxValue;
    }

    public void setElements(Integer elements) {
        this.elements = elements;
    }

    public Integer[] getData() {
        return this.data;
    }

    public void buildData() {
        this.data = new Integer[this.elements];
        for (int i = 0; i < this.elements; i++) {
            this.data[i] = Double.valueOf(Math.random() * (maxValue - minValue)).intValue() + minValue;
        }
        this.sortData();
    }

    private void sortData() {
        Arrays.sort(this.data);
    }

    public Integer searchValue(Integer valueToSearch) {
        this.numberOfIterationsOfLastSearch = 0;
        return getIndex(0, elements - 1, elements / 2, valueToSearch);
    }

    private Integer getIndex(Integer minIndex, Integer maxIndex, Integer middle, Integer valueToSearch) {
        this.numberOfIterationsOfLastSearch++;
        if (maxIndex < minIndex) {
            return -1;
        } else if (this.data[middle].equals(valueToSearch)) {
            return middle;
        } else if (this.data[middle] > valueToSearch) {
            return getIndex(minIndex, maxIndex = middle - 1, minIndex + (maxIndex  - minIndex) / 2, valueToSearch);
        } else {
            return getIndex(minIndex = middle + 1, maxIndex, minIndex + (maxIndex  - minIndex) / 2, valueToSearch);
        }
    }

    public Integer getNumberOfIterationsOfLastSearch() {
        return this.numberOfIterationsOfLastSearch;
    }

}
