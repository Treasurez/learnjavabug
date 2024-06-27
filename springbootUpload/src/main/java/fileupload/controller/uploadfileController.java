package fileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @Description
 * @Author lhw
 * @Date 2022-03-24
 */

@Controller
public class uploadfileController {
    //payload：https://www.jianshu.com/p/792940a81088
    @GetMapping("/uploadfile")
    public String uploadfile() {
        return "uploadfile";
    }

}

