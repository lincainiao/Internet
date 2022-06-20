package com.lin.inet;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collections;

//客户端，要知道服务器的地址
public class TCPClientDemo01 {
    public static void main(String[] args) throws Exception {
        //连接服务端IP地址
        InetAddress serverAddress = InetAddress.getByName("localhost");
        //端口号
        int port = 9999;
        //创建socket连接
        Socket socket = new Socket(serverAddress,port);
        //发送消息
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("hello world".getBytes());

        if (outputStream != null) outputStream.close();
        if (socket != null) socket.close();
    }
}
