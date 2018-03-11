package com.ibase.core.base;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ibase.core.http.ResponsePacket4;

public class BaseController {
	
	protected final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	protected ResponsePacket4 responsePacket;

	public ResponsePacket4 getResponsePacket() {
		return responsePacket;
	}

	public void setResponsePacket(ResponsePacket4 responsePacket) {
		this.responsePacket = responsePacket;
	}
	
}
