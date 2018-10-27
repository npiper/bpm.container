/**
 * 
 */
package com.piperit.bpm.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Before;
import org.junit.Test;

import com.piperit.bpm.model.Depot.DepotType;

/**
 * @author neilpiper
 *
 */
public class TestDepot {
	
	Depot depot;
	
	@Before
	public void setUp()
	{
		depot = new Depot("name","notes",DepotType.NDC);
		
		//System.out.println(depot.toJSONString());
		
	}

	@Test
	public void testJSONRead() throws JsonProcessingException, IOException {
		
	    String json
	      = "{\"id\":\"50ece5e9-0455-4423-a00b-5a97640ebaf1\",\"locale\":\"GB\",\"name\":\"name\"}";
	 
	    Depot bean = new ObjectMapper().reader(Depot.class).readValue(json);
	    
	    assertEquals("name", bean.getName());

		
	}

	@Test
	public void testSerializeJSON() throws JsonGenerationException, JsonMappingException, IOException
	{
		
		String result = new ObjectMapper().writeValueAsString(depot);
		
		System.out.println(result);
		
		//{ 
		//id=50ece5e9-0455-4423-a00b-5a97640ebaf1,
		//		locale=GB,
		//		name=name,
		//		location_notes=notes
		//	}
	}
	
}
