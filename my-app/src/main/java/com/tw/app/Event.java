package com.tw.app;

public class Event {
	 private String nome;
	    private int duration;
	    private Duracao unit;

	    public Event(String nome, int duration, Duracao unit) {
	        this.nome = nome;
	        this.duration = duration;
	        this.unit = unit;
	    }

	    @Override
	    public String toString() {
	        return nome + " - " + duration + " " + unit;
	    }

	    public int getDurationInMinutes() {
	        return unit.inMinutes(duration);
	    }

	    public String getName() {
	        return nome;
	    }
}
