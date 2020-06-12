
package com.zhihuisystem.pds.exception;
/**
 * 异常基类接口
 *
 */
public interface BaseException {

	/**
	 * 全局唯一的异常编号
	 * @return
	 */
	public String getCode();

	/**
	 * 国际化资源所需的参数
	 * @return
	 */
	public String[] getParams();
	
	/**
	 * 获取国际化消息
	 * @return
	 */
	public String getI18nMessage();

	/**
	 * 设置组国际化消息
	 * @param i18nMessage
	 */
	public void setI18nMessage(String i18nMessage);

	/**
	 * 标识是否已经被处理过
	 * @return
	 */
	public boolean isHandled();

	/**
	 * 标识是否已经被处理过
	 * @param handled
	 */
	public void setHandled(boolean handled);
	
	
}

