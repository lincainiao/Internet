package com.lin.inet;

import java.net.InetAddress;

//测试IP
public class Inet_ {
    public static void main(String[] args) throws Exception{
        //不能new直接是计划
        //查询本地地址
        //127.0.0.1为本身电脑IP
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        System.out.println(inetAddress);
//        InetAddress inetAddress1 = InetAddress.getByName("localhost");
//        System.out.println(inetAddress1);
//        System.out.println(inetAddress1.getHostName());

        //查询网站Ip地址
        InetAddress inetAddressBaidu = InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddressBaidu);// www.baidu.com/14.215.177.39
//        System.out.println(inetAddressBaidu.getAddress());// [B@5fd0d5ae
        System.out.println(inetAddressBaidu.getHostAddress());//14.215.177.39
        System.out.println(inetAddressBaidu.getCanonicalHostName());//14.215.177.39
        System.out.println(inetAddressBaidu.getHostName());//www.baidu.com
    }
}
