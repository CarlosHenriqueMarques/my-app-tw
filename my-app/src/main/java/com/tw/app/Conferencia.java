/**
 * 
 */
package com.tw.app;

import java.util.ArrayList;
import java.util.List;

import com.tw.app.util.Constant;

/**
 * @author carlos
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
        
        str.append("Conference Schedule:" + Constant.NOVA_LINHA + Constant.NOVA_LINHA);
        for (int i = 0; i < tracks.size(); i++) {
            str.append("Track " + (i + 1) + ":" + Constant.NOVA_LINHA);
            str.append(tracks.get(i));
            str.append(Constant.NOVA_LINHA);
        }
        return str.toString();
    }
}
