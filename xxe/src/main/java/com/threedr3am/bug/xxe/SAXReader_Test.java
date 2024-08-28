package com.threedr3am.bug.xxe;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.List;

public class SAXReader_Test {
    public static void main(String[] args) throws Exception{
        File f = new File("/Users/zhangzhaochao/work/vulhubWork/learnjavabug/xxe/user.xml");
        saxReader(f);
    }

    public static void saxReader(File f) throws DocumentException {
        SAXReader saxReader = new SAXReader();
        org.dom4j.Document d = saxReader.read(f);
        Element root = d.getRootElement();
        List<Element> childs = root.elements();
        for (Element child : childs){
            String name = child.getName();
            String text = child.getText();
            System.out.println(name + ":" + text);
        }
    }
}
