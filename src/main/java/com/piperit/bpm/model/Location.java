package com.piperit.bpm.model;

import java.util.Locale;

public interface Location {

	public String getId();
	
	public Locale getLocale();
	
	public String getName();
	
	public String getLocationNotes();
	
	public String toJSONString();
}
