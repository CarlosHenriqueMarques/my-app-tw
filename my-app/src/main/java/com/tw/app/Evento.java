package com.tw.app;

public class Evento {
	 private String nome;
	    private int duracao;
	    private Duracao tempo;

	    public Evento(String nome, int duracao, Duracao tempo) {
	        this.nome = nome;
	        this.duracao = duracao;
	        this.tempo = tempo;
	    }

	    @Override
	    public String toString() {
	        return nome + " - " + duracao + " " + tempo;
	    }

	    public int getDuracaoEmMinutos() {
	        return tempo.inMinutes(duracao);
	    }

	    public String getNome() {
	        return nome;
	    }
}
