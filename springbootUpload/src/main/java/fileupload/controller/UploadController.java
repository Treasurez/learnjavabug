package fileupload.controller;


import com.example.fileupload.entiy.UploadFile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description
 * @Author lhw
 * @Date 2022-03-24
 */
@Controller
public class UploadController {
    private static final Logger LOGGER = LoggerFactory.getLogger(UploadController.class);

    @GetMapping("/upload")
    public String upload() {
        return "upload";
    }

    @GetMapping("/uploadlist")
    public String uploadlist() {
        return "uploadlist";
    }

    @PostMapping("/upload")
    //@ResponseBody
    public String upload(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return "fail";
        }

        String fileName = file.getOriginalFilename();
        System.out.println(fileName);
        String filePath = "/Users/zhangzhaochao/work/java_work/MemoryHorse/springbootUpload/src/main/webapp/WEB-INF/views/";
        File dest = new File(filePath + fileName);
        try {
            file.transferTo(dest);
            LOGGER.info("上传成功");
            return "upload_success";
        } catch (IOException e) {
            LOGGER.error(e.toString(), e);
        }
        return "fail";
    }

    @PostMapping("/uploadlist1")
    public boolean xmsj(@RequestParam("file") MultipartFile[] multipartFiles) {
        if (multipartFiles != null && multipartFiles.length > 0) {
            MultipartFile[] var2 = multipartFiles;
            int var3 = multipartFiles.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                MultipartFile multipartFile = var2[var4];
                if (multipartFile != null && !multipartFile.isEmpty()) {
                    String originalFilename = multipartFile.getOriginalFilename();
                    String fileNamePrefix = originalFilename.substring(0, originalFilename.lastIndexOf("."));
                    String newFileNamePrefix = fileNamePrefix + System.currentTimeMillis();
                    (new StringBuilder()).append(newFileNamePrefix).append(originalFilename.substring(originalFilename.lastIndexOf("."))).toString();
                    File file = new File("/tmp/" + originalFilename);
                    if (!file.getParentFile().exists()) {
                        file.getParentFile().mkdirs();
                    }

                    try {
                        multipartFile.transferTo(file);
                    } catch (IOException var12) {
                        LOGGER.error("文件上传失败，详情：" + var12.getMessage());
                        return false;
                    }
                }
            }
        }

        return true;
    }

    @PostMapping("/uploadlist")
    public static List<UploadFile> multipartToBean(MultipartFile[] files) {
//        if (String.isEmpty(files)) {
//            return Collections.emptyList();
//        } else {
            List list = (List) Arrays.stream(files).map((obj) -> {
                UploadFile file = new UploadFile();
                file.setOriginalFilename(obj.getOriginalFilename());

                try {
                    file.setBytes(obj.getBytes());
                } catch (IOException var3) {
                    var3.printStackTrace();
                }

                file.setContentType(obj.getContentType());
                file.setSize(obj.getSize());
                return file;
            }).collect(Collectors.toList());
            return list;
//        }
    }

}

