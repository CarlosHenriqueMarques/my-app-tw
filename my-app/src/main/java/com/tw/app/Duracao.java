package com.tw.app;

public enum Duracao {
    MINUTOS(1, "min"), LIGHTENING(5, "lightning");

    private int factor;
    private String stringRepresentation;

    private Duracao(int factor, String stringRepresentation) {
        this.factor = factor;
        this.stringRepresentation = stringRepresentation;
    }

    public int inMinutes(int duration) {
        return factor * duration;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }
}
