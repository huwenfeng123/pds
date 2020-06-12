
package com.zhihuisystem.pds.web.base;

import com.alibaba.fastjson.JSON;
import com.zhihuisystem.pds.resp.BaseRespDTO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {


    public final static String generationResp(String code, Object obj) {
        return generationResp(code, null, obj);
    }

    public final static String generationResp(String code, String msg, Object obj) {
		BaseRespDTO baseRespDTO = new BaseRespDTO();
		baseRespDTO.setStatus_code(code);
		baseRespDTO.setResult_msg(msg);
		baseRespDTO.setData(obj);
        return JSON.toJSON(baseRespDTO).toString();
    }

}
