package com.zlwon.constant;

public enum IntegrationDeatilCode {
	
	INSERT_QUESTION(10001,"新增提问",3),
	INSERT_ANSWER(10002,"新增回答",5),
	INSERT_QUOTATION(10003,"新增报价单",5),
	NEW_REGISTER(10004,"新注册",10);
	
	private Integer code;
    private String message;
    private Integer num;
    
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public Integer getNum() {
		return num;
	}
	public void setNum(Integer num) {
		this.num = num;
	}
	
	private IntegrationDeatilCode(Integer code, String message,Integer num) {
		this.code = code;
		this.message = message;
		this.num = num;
	}
}
