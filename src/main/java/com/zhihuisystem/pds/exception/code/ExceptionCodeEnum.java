
package com.zhihuisystem.pds.exception.code;


public enum ExceptionCodeEnum {


	PDS_0("0","成功"),//重新登录
	PDS_1("1","失败"),//
	PDS_2("2","参数校验错误:%s"),//

	PDS_9999("9999","占位，不代其他");
	private String code;
	private String msg;

	ExceptionCodeEnum(String code, String msg) {
		this.code = code;
		this.msg = msg;
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

	public void setMgs(String msg) {
		this.msg = msg;
	}
}
