package com.lin.inet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPChatting02 {
    public static void main(String[] args) throws Exception{
        // 接收端
        DatagramSocket socket = new DatagramSocket(4567);

        DatagramPacket receivePacket = null;

        boolean flag = true;
        while (flag){
            byte[] buf = new byte[1024];
            receivePacket = new DatagramPacket(buf,0,buf.length);
            socket.receive(receivePacket);
            String remsg = new String(receivePacket.getData(),0,receivePacket.getLength());
            if (remsg.toUpperCase().equals("BYE")) {
                System.out.println("bye~");
                break;
            }
            System.out.println(remsg);
        }
        socket.close();
    }
}
