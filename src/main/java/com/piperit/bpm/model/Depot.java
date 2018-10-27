package com.piperit.bpm.model;

import java.util.Locale;
import java.util.UUID;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JacksonInject;

public class Depot implements Location {
	
	@JacksonInject
	private String id;
	
	private String name;
	private String locationNotes;
	private DepotType type;
	
	public Depot(String name, String locationNotes, DepotType type)
	{
		id = UUID.randomUUID().toString();
		this.name = name;
		this.locationNotes = locationNotes;
		this.type = type;

	}
	
	/** Constructor to create a JSON serialized version of a Depot
	 * 
	 * @param name String name
	 * @param locationNotes String locationNotes
	 * @param locale String representation of <a href="http://www.oracle.com/technetwork/java/javase/java8locales-2095355.html">Locale</a> 
	 */
    @JsonCreator
    public Depot(
      @JsonProperty("name") String name, 
      @JsonProperty("locationNotes") String locationNotes,
      @JsonProperty("locale") String locale) {

        this.name = name;
        this.type = DepotType.NDC;
        
    }


	public String getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public Locale getLocale() {
		// TODO Auto-generated method stub
		return Locale.UK;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	public String getLocationNotes() {
		// TODO Auto-generated method stub
		return locationNotes;
	}
	
	enum DepotType
	{
		FROZEN, NDC, RDC
	}

	public String toJSONString() {
		// TODO Auto-generated method stub
		return String.format("{ \n\tid=%s,\n\tlocale=%s,\n\tname=%s,\n\tlocation_notes=%s\n}\n", getId(),getLocale().getCountry(), getName(),getLocationNotes());
	}

}
