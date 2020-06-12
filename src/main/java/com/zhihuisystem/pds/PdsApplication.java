package com.zhihuisystem.pds;

import com.zhihuisystem.pds.exception.PDSServiceException;
import com.zhihuisystem.pds.req.DomeReqTest;
import com.zhihuisystem.pds.utils.PDSGroup;
import com.zhihuisystem.pds.utils.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.groups.Default;

@SpringBootApplication
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Controller
public class PdsApplication {

    @Autowired
    private ValidateUtils validateUtils;

    public static void main(String[] args) {
        SpringApplication.run(PdsApplication.class, args);


    }
    @GetMapping({ "/login","/index", "/","" })
    public String index(HttpServletRequest request) throws Exception {
        DomeReqTest a = new DomeReqTest();
        validateUtils.verifyParameter(a, PDSGroup.GroupV1.class, Default.class);
        return "aa";
    }

}
