import java.util.HashMap;
import java.util.Map;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.Before;
import org.junit.Test;

import com.piperit.bpm.model.AllocationRequest;

public class TestProcessService {
	
	RuntimeService rsvc;
	
	@Before
	public void setUp()
	{
		ProcessEngine pe = ProcessEngineConfiguration.createStandaloneInMemProcessEngineConfiguration().buildProcessEngine();
		
		rsvc = pe.getRuntimeService();
		
		RepositoryService repsvc = pe.getRepositoryService();
		
		repsvc.createDeployment().addClasspathResource("processes/AllocationProcess.bpmn").deploy();
		
	}

	@Test
	public void test() {
		
		AllocationRequest req = new AllocationRequest();
		
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", "allocationRequest { id: 1232131 }");
		variables.put("person", "USER");
		
		ProcessInstance pi = rsvc.startProcessInstanceByMessage("allocation_message", variables);	
		
		pi.getActivityId();
	}

}
