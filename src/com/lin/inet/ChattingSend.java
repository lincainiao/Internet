package com.lin.inet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;

//多线程实现聊天
public class ChattingSend implements Runnable{
    private int localPort;
    private String desIp;
    private int desPort;
    DatagramSocket socket = null;
    DatagramPacket packet = null;
    Scanner scanner = new Scanner(System.in);
    public ChattingSend(int localPort, String desIp, int desPort) {
        this.localPort = localPort;
        this.desIp = desIp;
        this.desPort = desPort;
        try {
            socket = new DatagramSocket(localPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag){
            try {
               String msg = scanner.nextLine();
               packet = new DatagramPacket(msg.getBytes(),msg.getBytes().length,InetAddress.getByName(desIp),desPort);
               socket.send(packet);
               if (msg.equals("bye")) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
//            socket.close();
        }
    }
}
