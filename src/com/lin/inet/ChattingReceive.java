package com.lin.inet;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.Socket;
import java.net.SocketException;

//多线程是实现聊天
public class ChattingReceive implements Runnable{
    private int desPort;
//    private String name;
    DatagramSocket socket = null;
    DatagramPacket packet = null;

    public ChattingReceive(int desPort) {
        this.desPort = desPort;
//        this.name = name;
        try {
            socket = new DatagramSocket(this.desPort);
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        boolean flag = true;
        while (flag){
            try {
               byte[] buf = new byte[1024];
               packet = new DatagramPacket(buf,0,buf.length);
               socket.receive(packet);
               String msg = new String(packet.getData(),0,packet.getLength());
                System.out.println(msg);
               if (msg.equals("bye")) break;
            } catch (Exception e) {
                e.printStackTrace();
            }
//            socket.close();
        }
    }
}
