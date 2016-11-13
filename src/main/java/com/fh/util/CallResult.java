package com.fh.util;


public class CallResult {
	public static final Integer SUCCESS=0; //成功  
	public static final Integer PARAM_ERROR=101; //参数错误
	public static final Integer BIZ_ERROR=201; //参数错误
	public static final Integer UNEXPECTED_ERROR=500; //未知异常
	
	private Integer code=CallResult.SUCCESS;
	private Object result;
	private String errmsg;
	
	//是否是正常返回
	public Boolean isNormalReturn(){
		return CallResult.SUCCESS==code;
	}

	//Getters and Setters
	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

	@Override
	public String toString() {
		return "CallResult [code=" + code + ", result=" + result + ", errmsg="
				+ errmsg + "]";
	}
}

