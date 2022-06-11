package com.codekul.Spring11JuneBatch.ioc;

public class BubbleSort implements SortingTechniques{
    @Override
    public void sort() {
        System.out.println("In sort method(Bubble)");
    }

    @Override
    public void display() {
        System.out.println("In display method(Bubble)");

    }
}
