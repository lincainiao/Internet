package com.lin.inet;

import java.net.URL;

//example: https://www.baudu.com
//格式：协议://ip地址:端口号/项目名/资源
public class URL_ {
    public static void main(String[] args) throws Exception{
        URL url = new URL("http://www.baidu.com");
        System.out.println(url.getProtocol());//协议
        System.out.println(url.getHost());
        System.out.println(url.getAuthority());

    }
}
