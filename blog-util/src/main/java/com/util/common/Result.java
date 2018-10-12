package com.util.common;

import com.util.enums.ResultCodeEnum;

/**
 * 用于封装传给前台的数据
 */
public class Result<T> {
	private T data; // 响应对象
	private Integer count; // 封装数据库的总记录数
	private String code;
	private String msg;
	
	public Result(){
		
	}
	
	public Result error(ResultCodeEnum resultCodeEnum, String msg){
    	setCode(resultCodeEnum.getValue());
    	setMsg(msg);
    	return this;
    }
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
