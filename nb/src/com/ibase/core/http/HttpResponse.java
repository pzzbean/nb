package com.ibase.core.http;

public class HttpResponse {

	public HttpResponse() {
	}

	public HttpResponse(int status, String msg) {
		this.status = status;
		this.msg = msg;
	}

	public HttpResponse(int status, String msg, String content) {
		this.status = status;
		this.content = content;
		this.msg = msg;
	}

	private int status;
	private String content;
	private String msg;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
