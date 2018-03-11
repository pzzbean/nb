package com.ibase.core.constants;

public enum Errors {

	OK(200,"OK"),
	DATA_CHECK_FAIL(400,"数据校验失败"),
	USER_NO_EXSIT(401,"用户不存在"),
	USER_EXSITS(402,"用户已存在，不能重复注册"),
	PASSWORD_ERROR(403,"密码错误"),
	CLIENT_ERROR(404,"客户端代码错误"),
	USERNAME_NO_VALID(405,"请输入合法的帐号（由6到30位的字母数字下划线组成）"),
	PASSWORD_NO_VALID(406,"请输入至少6位数密码"),
	SESSION_EXPIRE(407,"session已过期"),
	APP_NO_EXSIT(408,"应用不存在"),
	SIGN_ERROR(409,"签名失败"),
	GET_SMS_FAILURE(410,"获取短信验证码失败"),
	SMS_VERIFY_CODE_EXPIRE(411,"短信验证码已过期"),
	SMS_VERIFY_CODE_ERROR(412,"请输入正确的验证码"),
	MOBILE_FORMAT_ERROR(413,"请输入正确的手机号"),
	MOBILE_BINDED(414,"手机号已绑定"),
	APP_NOT_EXSIT(415,"应用不存在"),
	MOBILE_UNBOUND(416,"该手机号未绑定"),
	SMS_VERIFY_CODE_SENT(417,"短信验证码已下发，请注意查收"),
	NICKNAME_NOT_NULL(418,"请输入昵称"),
	INPUT_MOBILE(419,"请输入手机号"),
	INPUT_USERNAME(420,"请输入帐号"),
	INPUT_PASSWORD(421,"请输入密码"),
	INPUT_SMS_CODE(422,"请输入6位数验证码"),
	INPUT_PRICE_ERROR(423,"输入金额错误"),
	ORDER_REPEAT_ERROR(424,"不能重复下单"),
	
	SYSTEM_ERROR(500,"系统异常"),
	;
	private int code;
	private String msg;
	private Errors(int code,String msg) {
		this.code = code;
		this.msg = msg;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}
