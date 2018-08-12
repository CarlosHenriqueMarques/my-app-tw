package com.tw.app;

import java.util.ArrayList;
import java.util.List;

public class Track {
	
    private List<Vaga> slots;

    public Track() {
        slots = new ArrayList<Vaga>();
    }

    public void addSlot(Vaga slot) {
        slots.add(slot);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (Vaga slot : slots) {
            str.append(slot);
        }
        return str.toString();
    }

}
