
package com.zhihuisystem.pds.resp;

import lombok.Data;

import java.io.Serializable;

@Data
public class BaseRespDTO implements Serializable{
	
	private static final long serialVersionUID = 3830117087239873796L;
	private String status_code;
	private String result_msg;
	private Object data;
	
	
}
