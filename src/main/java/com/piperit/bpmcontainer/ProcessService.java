package com.piperit.bpmcontainer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.piperit.bpm.model.AllocationRequest;

/**
 * ProcessService to control the orchestration of business process.
 * 
 * @author neilpiper
 *
 */
@Service
@Transactional
public class ProcessService {

	@Autowired
	private RuntimeService runtimeService;

	@Autowired
	private TaskService taskService;

	/** Start the allocation process 
	 * 
	 * @param message AllocationRequest
	 * @param assignee
	 * @return
	 */
	public ProcessInstance startAllocationProcess(AllocationRequest message, String assignee) {

		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("message", message);
		variables.put("person", assignee);

		return runtimeService.startProcessInstanceByMessage("allocationProcess", variables);
	}

	public List<Task> getTasks(String assignee) {
		return taskService.createTaskQuery().taskAssignee(assignee).list();
	}

	public void completeTask(String taskId) {
		taskService.complete(taskId);
	}

}
