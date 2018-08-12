package com.tw.app;

import java.util.ArrayList;
import java.util.List;

public class Track {
	
    private List<Vaga> sessoes;

    public Track() {
        sessoes = new ArrayList<Vaga>();
    }

    public void addSessao(Vaga slot) {
        sessoes.add(slot);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Vaga sessao : sessoes) {
            str.append(sessao);
        }
        return str.toString();
    }

}
