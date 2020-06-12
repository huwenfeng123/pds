
package com.zhihuisystem.pds.intercept;

import com.alibaba.fastjson.JSON;
import com.zhihuisystem.pds.exception.PDSServiceException;
import com.zhihuisystem.pds.exception.code.ExceptionCodeEnum;
import com.zhihuisystem.pds.resp.BaseRespDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * <p>
 * 全局统一异常处理
 * </p>
 * 
 * @ClassName: PDSHandlerExceptionResolver
 * @author:liuqing
 *
 */
@ControllerAdvice
@Slf4j
@ResponseBody
public class PDSHandlerExceptionResolver {

	
	/**
	 * 
	 * <p> 系统异常捕获处理 </p>
	 * @Title: defaultException 
	 * @param request
	 * @param e
	 * @return
	 *
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public String defaultException(HttpServletRequest request, Exception e) {
		log.error("处理返回Exception.class 异常信息:",e);
		BaseRespDTO errorResp = new BaseRespDTO();
		errorResp.setStatus_code(ExceptionCodeEnum.PDS_1.getCode());
		errorResp.setResult_msg(ExceptionCodeEnum.PDS_1.getMsg());
		errorResp.setData("");
		return JSON.toJSONString(errorResp);
	}
	
	/**
	 * <p> 自定义异常捕获处理 </p>
	 * @Title: defaultKWOServiceException 
	 * @param request
	 * @param e
	 * @return
	 *
	 */
	@ExceptionHandler(value = PDSServiceException.class)
	@ResponseBody
	public String defaultKWOServiceException(HttpServletRequest request, PDSServiceException e) {
		log.warn("处理返回PDSServiceException.class 异常信息",e);
		BaseRespDTO errorResp = new BaseRespDTO();
		errorResp.setStatus_code(e.getCode());
		errorResp.setResult_msg(e.getMessage());
		errorResp.setData("");
		return JSON.toJSONString(errorResp);
	}

}
