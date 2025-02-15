package org.example;


import components.Matrix;
import components.RedeNeural;

public class Main {
    public static void main(String[] args) {
        RedeNeural nn = new RedeNeural(1,3,5);
        Double[] elements = {1d, 2d};
        nn.feedForWard(elements);
    }

}