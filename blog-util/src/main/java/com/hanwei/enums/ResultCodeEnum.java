package com.hanwei.enums;

public enum ResultCodeEnum {
	
	CODE_000("000", "请求成功"),
	
	CODE_002("002", "请求失败"),
	
	CODE_003("003", "没有数据"),

	CODE_100("100", "提交参数错误"),

	CODE_101("101", "重复提交"),
	
	CODE_102("102", "用户登录已过期"),

	CODE_103("103", "用户被拉入黑名单"),

	CODE_300("300", "服务器数据错误"),

	CODE_301("301", "服务器异常"),	
	
	CODE_302("302", "自定义异常"),

	CODE_303("303", "该部门下存在员工信息"),

	CODE_304("304", "该部门为上级部门");

	private String value;

	private String description;

	private ResultCodeEnum(String value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getValue() {
		return value;
	}

	public String getDescription() {
		return description;
	}
	
	public static ResultCodeEnum resolve(String value) {
        for (ResultCodeEnum type : values()) {
            if (type.getValue().equals(value)) {
                return type;
            }
        }
        return null;
    }
}