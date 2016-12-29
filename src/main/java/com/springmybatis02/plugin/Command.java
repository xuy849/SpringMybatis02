package com.springmybatis02.plugin;

import java.util.Map;

public class Command {
	public String getCmdName() {
		return cmdName;
	}
	public void setCmdName(String cmdName) {
		this.cmdName = cmdName;
	}
	public Map<String, String> getArgs() {
		return args;
	}
	public void setArgs(Map<String, String> args) {
		this.args = args;
	}
	private String cmdName;
	private Map<String,String> args;
	
}
