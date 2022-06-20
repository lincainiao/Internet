package com.lin.inet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class UDPChatting01 {
    public static void main(String[] args) throws Exception{
        // 发送端
        DatagramSocket socket = new DatagramSocket(1234);

        DatagramPacket sengPacket = null;
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            String msg = scanner.nextLine();
            //发送
            sengPacket = new DatagramPacket(msg.getBytes(),msg.getBytes().length, InetAddress.getByName("localhost") ,4567);
            socket.send(sengPacket);
            if (msg.toUpperCase().equals("BYE")) break;
        }


        socket.close();
    }
}
