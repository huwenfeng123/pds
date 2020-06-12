package com.zhihuisystem.pds.req;

import com.zhihuisystem.pds.utils.PDSGroup;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Data
public class DomeReqTest implements Serializable {

    private static final long serialVersionUID = -8516893296536983661L;

    /**
     * 序号
     */
    @NotEmpty(message = "序号不可以为空", groups = PDSGroup.GroupV1.class)
    @Length(max = 10, message = "序号长度不能超过10", groups = {PDSGroup.GroupV1.class})
    private String recordId;
}
