package com.tw.app;

import java.util.ArrayList;
import java.util.List;

import com.tw.app.util.Constant;
import com.tw.app.util.Time;

public class Vaga {
	
	  private List<Event> Eventos;
	    private int remainingDuration;
	    private int startTime;
	    private Vaga supplement;

	    public Vaga(int duration, int startTime) {
	        this.remainingDuration = duration;
	        this.startTime = startTime;
	        Eventos = new ArrayList<Event>();
	    }

	    public void addEvento(Event Evento) {
	        if (remainingDuration < Evento.getDurationInMinutes()) {
	            throw new IllegalStateException("Not enough room in this slot to fit the Evento: '"
	                    + Evento.getName() + "'");
	        }
	        Eventos.add(Evento);
	        remainingDuration -= Evento.getDurationInMinutes();
	    }

	    public boolean hasRoomFor(Event Evento) {
	        return remainingDuration >= Evento.getDurationInMinutes();
	    }

	    public void addSupplementSlot(Vaga slot) {
	        this.supplement = slot;
	    }

	    @Override
	    public String toString() {
	        StringBuilder str = new StringBuilder();
	        int nextEventoStartTime = addEventosSchedule(Eventos, startTime, str);
	        if (supplement != null) {
	            int supplementStartTime = supplement.startTime;
	            if (nextEventoStartTime > supplement.startTime) {
	                supplementStartTime = nextEventoStartTime;
	            }
	            nextEventoStartTime = addEventosSchedule(supplement.Eventos, supplementStartTime, str);
	        }
	        return str.toString();
	    }

	    /**
	     * Adds Eventos to be added to the StringBuilder with their starting time and their duration.
	     *
	     * @param Eventos the Eventos to be added to the StringBuilder.
	     * @param startTime the start time of the first Evento.
	     * @param str the StringBuilder object to which the schedule must be added.
	     * @return the time at which the Eventos end.
	     */
	    private int addEventosSchedule(List<Event> Eventos, int startTime, StringBuilder str) {
	        int nextEventoStartTime = startTime;
	        for (Event Evento : Eventos) {
	            str.append(Time.minutesToDisplayTime(nextEventoStartTime) + " " + Evento + Constant.NEW_LINE);
	            nextEventoStartTime += Evento.getDurationInMinutes();
	        }

	        return nextEventoStartTime;
	    }

}
