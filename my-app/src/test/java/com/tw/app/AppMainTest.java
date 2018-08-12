package com.tw.app;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import com.tw.app.util.FileUtil;

public class AppMainTest {
	@Test
    public void testConferenceTrackManagementMultipleFullDayEvents() throws IOException {
    	testConferenceTrackManagement("/input_file");
    }

    @Test
    public void testConferenceTrackManagementMultipleDayLessEvents() throws IOException {
    	testConferenceTrackManagement("/input_file_less_events");
    }

    @Test
    public void testConferenceTrackManagementSingleDayEvents() throws IOException {
    	testConferenceTrackManagement("/input_file_single_day_events");
    }

    private void testConferenceTrackManagement(String inputFile) throws IOException {
    	Conferencia conference = new ConferenciaAgenda().schedule(
    			FileUtil.getBufferedReaderForResourceFile(inputFile, this));
    	assertTrue(FileUtil.contentEquals(getExpectedOutputFile(inputFile),
    			conference.toString(), this));
    }

    private String getExpectedOutputFile(String inputFile) {
    	return inputFile + "_expected";
    }

}