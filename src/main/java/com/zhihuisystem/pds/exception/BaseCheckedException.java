
package com.zhihuisystem.pds.exception;

import java.io.PrintStream;

public class BaseCheckedException extends Exception implements BaseException {

	private static final long serialVersionUID = -5016990501427348792L;

	/**
	 * 异常的唯一编号,对应国际化消息KEY
	 */
	protected String code;
	/**
	 * 国际化资源所需的参数
	 */
	protected String[] params;

	/**
	 * 组装好的国际化消息,可用于打印日志信息
	 */
	protected String i18nMessage;

	/**
	 * 标识是否已经被处理过.
	 */
	protected boolean handled = false;

	/**
	 * 产生异常时,方法的参数值.注意,所有参数类型必须具备有效的toString()
	 */
	protected String[] parameters;

	/**
	 * 
	 * @param code
	 *            异常的全局唯一编号,可以作为国际化消息的KEY.不可以为NULL
	 * @param params
	 *            国际化消息中填充占位符的值,可以为NULL
	 * @param defaultMessage
	 *            默认显示的消息,当国际化消息文件中没有找到对应的条目时会显示此默认消息值,可以为NULL
	 */
	protected BaseCheckedException(String code, String[] params,
                                   String defaultMessage) {
		super(defaultMessage);
		this.code = code;
		this.params = params;
	}

	/**
	 * 
	 * @param code
	 *            异常的全局唯一编号,可以作为国际化消息的KEY.不可以为NULL
	 * @param params
	 *            国际化消息中填充占位符的值,可以为NULL
	 * @param defaultMessage
	 *            默认显示的消息,当国际化消息文件中没有找到对应的条目时会显示此默认消息值,可以为NULL
	 * @param cause
	 *            需要包装的异常对象,不可以为NULL
	 */
	protected BaseCheckedException(String code, String[] params,
                                   String defaultMessage, Throwable cause) {
		super(defaultMessage, cause);
		this.code = code;
		this.params = params;
	}

	/**
	 * 
	 * @param defaultMessage
	 *            默认显示的消息,当国际化消息文件中没有找到对应的条目时会显示此默认消息值,可以为NULL
	 * @param cause
	 *            需要包装的异常对象,可以为NULL
	 */
	protected BaseCheckedException(String defaultMessage, Throwable cause) {
		super(defaultMessage, cause);
	}

	/**
	 * 
	 * @param defaultMessage
	 *            默认显示的消息,当国际化消息文件中没有找到对应的条目时会显示此默认消息值,可以为NULL
	 */
	protected BaseCheckedException(String defaultMessage) {
		super(defaultMessage);
	}

	public String getCode() {
		return code;
	}

	public String[] getParams() {
		return params;
	}

	public String getI18nMessage() {
		return i18nMessage;
	}

	public void setI18nMessage(String i18nMessage) {
		this.i18nMessage = i18nMessage;
	}

	public boolean isHandled() {
		return handled;
	}

	public void setHandled(boolean handled) {
		this.handled = handled;
	}

	@Override
	public String getMessage() {
		String message = super.getMessage();
		Throwable cause = getCause();
		if (cause != null) {
			StringBuilder sb = new StringBuilder();
			if (message != null) {
				sb.append(message).append("; ");
			}
			sb.append("nested exception is ").append(cause);
			return sb.toString();
		}
		return message;
	}

	@Override
	public void printStackTrace(PrintStream ps) {
		if (getCause() == null) {
			super.printStackTrace(ps);
		} else {
			ps.println(this);
			getCause().printStackTrace(ps);
		}
	}

	/**
	 * 获取根异常
	 * 
	 * @return
	 */
	public Throwable getRootCause() {
		Throwable rootCause = null;
		Throwable cause = getCause();
		while (cause != null && cause != rootCause) {
			rootCause = cause;
			cause = cause.getCause();
		}
		return rootCause;
	}

	public String[] getParameters() {
		return parameters;
	}

	public void setParameters(String[] parameters) {
		this.parameters = parameters;
	}

}
