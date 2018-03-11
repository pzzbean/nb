package com.ibase.web.log.domain;

import com.ibase.web.user.domain.User;

public class LogUser {
	private User testEngineer;
	private User projectLeader;
	public LogUser(User testEngineer, User projectLeader) {
		super();
		this.testEngineer = testEngineer;
		this.projectLeader = projectLeader;
	}
	public LogUser() {
		super();
	}
	public User getTestEngineer() {
		return testEngineer;
	}
	public void setTestEngineer(User testEngineer) {
		this.testEngineer = testEngineer;
	}
	public User getProjectLeader() {
		return projectLeader;
	}
	public void setProjectLeader(User projectLeader) {
		this.projectLeader = projectLeader;
	}
	@Override
	public String toString() {
		return "LogUser [testEngineer=" + testEngineer + ", projectLeader=" + projectLeader + "]";
	}
	
}
