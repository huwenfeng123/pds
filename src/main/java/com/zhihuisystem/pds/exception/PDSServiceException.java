
package com.zhihuisystem.pds.exception;


import com.zhihuisystem.pds.exception.code.ExceptionCodeEnum;

/**
 * <p> </p>
 * @ClassName: KWOServiceException
 * @Description: TODO(这里用一句话描述这个类的作用) 
 * @author:liuqing 
 * @Email:liuqing@kftpay.com.cn 
 * @version:V1.0 
 *
 */
public class PDSServiceException extends BaseCheckedException {
	/**
	 * @Fields serialVersionUID : TODO(用一句话描述这个变量表示什么)
	 */
	private static final long serialVersionUID = -9057961810587875384L;


	public PDSServiceException(ExceptionCodeEnum errorCode, Object... para) {
		super(errorCode.getCode(), null, getMsg(errorCode,para));
	}

	private static String getMsg(ExceptionCodeEnum errorCode, Object... para) {
		String msg = errorCode.getMsg();
		if(msg == null) {
			return msg;
		}
		if (para != null) {
			msg = String.format(errorCode.getMsg(), para);
		}
		if (msg.endsWith("null")) {

			msg = msg.substring(0, msg.length() - 5);
		}
		return msg;
	}



	public PDSServiceException(String code, String[] params, String defaultMessage, Throwable cause) {
		super(code, params, defaultMessage, cause);
	}

	public PDSServiceException(String code, String[] params, String defaultMessage) {
		super(code, params, defaultMessage);
	}

	public PDSServiceException(String code, String defaultMessage) {
		super(code, null, defaultMessage);
	}

	public PDSServiceException(String code, String defaultMessage, Throwable cause) {
		super(code, null, defaultMessage, cause);
	}

	/**
	 * 去掉堆栈异常
	 */
	@Override
	public synchronized Throwable fillInStackTrace() {
		return null;
	}
}

