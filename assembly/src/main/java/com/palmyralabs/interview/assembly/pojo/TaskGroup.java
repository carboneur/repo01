package com.palmyralabs.interview.assembly.pojo;

import java.util.List;

public class TaskGroup {
	private String group;
	private List<TaskInfo> tasks;
	
	public String getGroup() {
		return group;
	}
	public void setGroup(String group) {
		this.group = group;
	}
	public List<TaskInfo> getTasks() {
		return tasks;
	}
	public void setTasks(List<TaskInfo> tasks) {
		this.tasks = tasks;
	}
}	
