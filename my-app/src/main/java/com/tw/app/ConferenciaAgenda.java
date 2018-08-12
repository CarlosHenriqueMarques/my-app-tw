package com.tw.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;

import com.tw.app.util.Config;
import com.tw.app.util.Logger;

public class ConferenciaAgenda {
	public ConferenciaAgenda() {
	}

	private static Logger logger = Logger.getLogger();
	
	public Conferencia schedule(BufferedReader input) throws IOException {
        List<Event> events = new ArrayList<Event>();
        for (String line; (line = input.readLine()) != null;) {
            line = line.trim();
            Event event = parseInputLine(line);
            if (event == null) {
                continue;
            }
            events.add(event);
        }

        Conferencia conference = new Conferencia();
        while (events.size() != 0) {
        	Vaga morningSlot = new Vaga(Config.MORNING_SLOT_DURATION, Config.MORNING_SLOT_START_TIME);
            fillSlotWithEvents(morningSlot, events);
            Vaga lunchSlot = new Vaga(Config.LUNCH_SLOT_DURATION, Config.LUNCH_SLOT_START_TIME);
            lunchSlot.addEvento(new Event("Lunch", Config.LUNCH_SLOT_DURATION, Duracao.MINUTES));
            
            Vaga afternoonSlot = new Vaga(Config.AFTERNOON_SLOT_DURATION, Config.AFTERNOON_SLOT_START_TIME);
            fillSlotWithEvents(afternoonSlot, events);
            Event networkingEvent = new Event(Config.NETWORKING_EVENT_NAME, Config.NETWORKING_EVENT_DURATION,
            		Config.NETWORKING_EVENT_DURATION_UNIT);
            Vaga networkingSlot = new Vaga(networkingEvent.getDurationInMinutes(),
            		Config.NETWORKING_EVENT_MIN_START_TIME);
            networkingSlot.addEvento(networkingEvent);
            afternoonSlot.addSupplementSlot(networkingSlot);
            Track track = new Track();
            track.addSlot(morningSlot);
            track.addSlot(lunchSlot);
            track.addSlot(afternoonSlot);
            conference.addTrack(track);
        }

        return conference;
    }
	
	private static void fillSlotWithEvents(Vaga slot, List<Event> events) {
        for (Iterator<Event> iter = events.iterator(); iter.hasNext();) {
            Event event = iter.next();
            if (slot.hasRoomFor(event)) {
            	slot.addEvento(event);
                iter.remove();
            }
        }
    }

    private static Event parseInputLine(String line) {
        if (line.length() == 0) {
            return null;
        }

        Matcher match = Config.INPUT_LINE_PATTERN.matcher(line);
        if (match.find() == false) {
            logger.warn("Invalid input line: " + line);
            return null;
        }

        Duracao unit;
        if (match.group(Config.EVENT_DURATION_UNIT_INDEX).equalsIgnoreCase("min")) {
            unit = Duracao.MINUTES;
        } else {
            unit = Duracao.LIGHTENING;
        }

        String name = match.group(Config.EVENT_NAME_INDEX);
        String durationInString = match.group(Config.EVENT_DURATION_INDEX);
        if (durationInString == null) {
            durationInString = "1";
        }
        int duration = Integer.parseInt(durationInString);

        Event event = new Event(name, duration, unit);
        if (event.getDurationInMinutes() > Config.MAX_EVENT_DURATION) {
            logger.warn("Duration of event '" + name + "' is more than the maximum duration"
                    + " allowed for an event. Dropping this event for scheduling.");
            return null;
        }

        return event;
    }

}
