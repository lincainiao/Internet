package com.lin.inet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

//udp接收端，需要开放端口
//要等待客户端的连接
public class UDPClient2 {
    public static void main(String[] args) throws Exception{
        //建立socket，开放端口
        DatagramSocket socket = new DatagramSocket(9999);
        //接收包
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(buf,0,buf.length);
        socket.receive(datagramPacket);

        //输出内容
        System.out.println(datagramPacket.getAddress().getHostAddress());
        String msg = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(msg);
        socket.close();
    }
}
