package com.lin.inet;

import java.net.InetSocketAddress;
//端口
public class SocketAddress_ {
    public static void main(String[] args) {
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1",8080);
        System.out.println(inetSocketAddress);
        System.out.println(inetSocketAddress.getAddress());
        System.out.println(inetSocketAddress.getPort());//端口
        System.out.println(inetSocketAddress.getHostName());//地址
    }
}
