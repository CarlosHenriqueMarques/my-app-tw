/**
 * 
 */
package com.tw.app;

import java.util.ArrayList;
import java.util.List;

import com.tw.app.util.Constant;

/**
 * @author carlo
 *
 */
public class Conferencia {
	private List<Track> tracks;

    public Conferencia() {
        tracks = new ArrayList<Track>();
    }

    public void addTrack(Track track) {
        tracks.add(track);
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        
        str.append("Conference Schedule:" + Constant.NEW_LINE + Constant.NEW_LINE);
        for (int i = 0; i < tracks.size(); i++) {
            str.append("Track " + (i + 1) + ":" + Constant.NEW_LINE);
            str.append(tracks.get(i));
            str.append(Constant.NEW_LINE);
        }
        return str.toString();
    }
}
