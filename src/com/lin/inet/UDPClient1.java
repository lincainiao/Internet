package com.lin.inet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class UDPClient1 {
    public static void main(String[] args) throws Exception{
        //udp不需要连接服务器，但要知道地址
        //建立Socket，可以开放端口
        DatagramSocket socket = new DatagramSocket(1120);
        //建立包
        //发送的内容
        String msg = "hello world!";//发送的内容要转换为byte
        //发送的目的地址
        InetAddress address = InetAddress.getByName("localhost");
        //发送的目的端口
        int port = 9999;
        //内容(byte)、内容的长度、目的IP地址，目的地址端口号
        DatagramPacket datagramPacket = new DatagramPacket(msg.getBytes(),msg.getBytes().length,address,port);

        //发送包
        socket.send(datagramPacket);
        //关闭
        socket.close();
    }
}
