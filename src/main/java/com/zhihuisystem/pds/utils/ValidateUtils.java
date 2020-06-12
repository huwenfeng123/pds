
package com.zhihuisystem.pds.utils;

import com.zhihuisystem.pds.exception.PDSServiceException;
import com.zhihuisystem.pds.exception.code.ExceptionCodeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

@Component
@Slf4j
public class ValidateUtils {
    @Autowired
    private Validator validator;

    /**
     * 判断参数是否全为空
     *
     * @param object
     * @param groups
     * @throws PDSServiceException
     */
    public <T> void validateFailCount(final T object, int validatedNum, final Class<?>... groups) throws PDSServiceException {
        verifyNotEmpty(object);
        final Set<ConstraintViolation<T>> validateResult = validator.validate(object,
                groups == null ? new Class[]{} : groups);
        if (validateResult.size() != validatedNum) {
            throw new PDSServiceException(ExceptionCodeEnum.PDS_2);
        }
    }

    /**
     * 校验所有需校验参数有效性.
     *
     * @param object 参数对象
     * @param groups 用来标识须额外校验的参数所属分组
     * @throws PDSServiceException
     */
    public <T> void verifyParameter(final T object, final Class<?>... groups) throws PDSServiceException {
        verifyNotEmpty(object);
        final Set<ConstraintViolation<T>> validateResult = validator.validate(object,
                groups == null ? new Class[]{} : groups);
        if (!validateResult.isEmpty()) {
            String errorMsg = validatePropertyDetailAndRtnErrorMsg(validateResult);
            log.warn("无效的入参信息【{}】", errorMsg);
            throw new PDSServiceException(ExceptionCodeEnum.PDS_2, "无效的入参信息【" + errorMsg + "】");
        }
    }

    /**
     * 校验参数非空
     *
     * @param object
     * @throws PDSServiceException
     */
    @SuppressWarnings("rawtypes")
    public static <T> void verifyNotEmpty(final T object) throws PDSServiceException {
        boolean isNull = false;
        if (object == null) {
            isNull = true;

        } else {
            if (object instanceof Map) {
                if (((Map) object).size() < 1) {
                    isNull = true;
                }
            } else if (object instanceof Collection) {
                if (((Collection) object).size() < 1) {
                    isNull = true;
                }
            }
        }
        if (isNull) {
            log.warn("无效的入参信息【null】");
            throw new PDSServiceException(ExceptionCodeEnum.PDS_2, "无效的入参信息【null】");
        }
    }

    /**
     * <p> 验证对象明细并且把错误信息返回给调用方(与validateDetailAndRtnErrorMsg区别为: 返回的错误信息中存在验证Bean的字段名称) </p>
     *
     * @param vals
     * @return
     */
    private static String validatePropertyDetailAndRtnErrorMsg(final Set<?> vals) {
        final StringBuilder result = new StringBuilder();
        for (final Object violation : vals) {
            if (!(violation instanceof ConstraintViolation)) {
                continue;
            }
            final String errorMsg = ((ConstraintViolation<?>) violation).getPropertyPath().toString() + ":"
                    + ((ConstraintViolation<?>) violation).getMessage() + "、";
            result.append(errorMsg);
        }
        final String resultStr = result.substring(0, result.length() - 1).toString();
        if (log.isDebugEnabled()) {
            log.debug("【参数校验失败】，错误如下:【" + resultStr + "】");
        }
        return resultStr;
    }
}